package com.digitalacademy.monetab.services.impl;

import com.digitalacademy.monetab.models.Student;
import com.digitalacademy.monetab.repositories.StudentRepository;
import com.digitalacademy.monetab.security.AuthorityConstant;
import com.digitalacademy.monetab.services.*;
import com.digitalacademy.monetab.services.Mapping.StudentMapping;
import com.digitalacademy.monetab.services.dto.*;
import com.digitalacademy.monetab.services.mapper.StudentMapper;
import com.digitalacademy.monetab.utils.SlugGifyUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final ModelMapper modelMapper;
    private final AdressService adressService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final RoleUserService roleUserService;
    private final FileStorageService fileStorageService;

    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        Student student = studentMapper.DtoToEntity(studentDTO);
        return studentMapper.ToDto(studentRepository.save(student));
    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        final String SLUG = SlugGifyUtils.generateSlug(studentDTO.getFirstName());
        studentDTO.setSlug(SLUG);
        return save(studentDTO);
    }

    @Override
    public StudentDTO update(StudentDTO studentDTO) {
        return findById((studentDTO.getIdPerson())).map(existingStudent -> {
            existingStudent.setAdress(studentDTO.getAdress());
            existingStudent.setFirstName(studentDTO.getFirstName());
            return save(existingStudent);
        }).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public StudentDTO update(StudentDTO studentDTO, Long id) {
        StudentDTO student = findById(id).orElseThrow(() -> new RuntimeException("Student not found"));

        if (student != null) {
            student.setFirstName(studentDTO.getFirstName());
            student.setLastName(studentDTO.getLastName());
        }
        return save(student);
    }

    @Override
    public StudentDTO partialUpdate(StudentDTO studentDTO, Long id) {
        return studentRepository.findById(id).map(student -> {
            StudentMapping.partialUpdate(student, studentDTO);
            return student;
        }).map(studentRepository::save).map(studentMapper::ToDto).orElse(null);
    }

    @Override
    public Optional<StudentDTO> findById(Long id) {
        return studentRepository.findById(id).map(studentMapper::ToDto);
    }

    @Override
    public Optional<StudentDTO> findBySlug(String slug) {
        return studentRepository.findBySlug(slug).map(studentMapper::ToDto);
    }


    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream().map(student -> {
            return studentMapper.ToDto(student);
        }).toList();
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<StudentDTO> findByLastNameOrGenderOrMatricule(String query, String gender) {
        List<Student> students = studentRepository.findByLastNameIgnoreCaseOrMatriculeIgnoreCaseAndGender(query, query, Gender.valueOf(gender));
        return students.stream().map(studentMapper::ToDto).toList();
    }

    @Override
    @Transactional
    public ResponseRegisterStudentDTO registerStudent(RegistrationStudentDTO registrationStudentDTO) {
        log.debug("request to register student {}", registrationStudentDTO);

        AdressDTO adress = modelMapper.map(registrationStudentDTO, AdressDTO.class);
        adress = adressService.save(adress);

        List<RoleUserDTO> roleUsers = roleUserService.findByRole(AuthorityConstant.ROLE_USER);

        UserDTO user = modelMapper.map(registrationStudentDTO, UserDTO.class);
        String password = UUID.randomUUID().toString();
        user.setPassword(passwordEncoder.encode(password));
        user.setRoleUser(roleUsers);
        user = userService.save(user);

        StudentDTO student = modelMapper.map(registrationStudentDTO, StudentDTO.class);
        student.setUser(user);
        student.setAdress(adress);

        ResponseRegisterStudentDTO response = new ResponseRegisterStudentDTO();
        response.setStudent(student);
        response.setAdress(adress);

        return response;
    }

    @Override
    public StudentDTO uploadStudentPicture(MultipartFile file, Long id) throws IOException {
        StudentDTO student = findById(id).orElse(null);

        if (student != null) {
            String upload = fileStorageService.upload(file);
            student.setUrlPicture(upload);
            save(student);
        }
        return student;
    }


}
