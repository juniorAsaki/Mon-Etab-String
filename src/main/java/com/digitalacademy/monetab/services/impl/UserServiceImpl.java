package com.digitalacademy.monetab.services.impl;

import com.digitalacademy.monetab.models.User;
import com.digitalacademy.monetab.repositories.UserRepository;
import com.digitalacademy.monetab.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    //private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User save(User user) {
        log.debug("Saving user {}", user);
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        log.debug("Updating user {}", user);
//        return userRepository.findById(user.getId())
//                .map(existingUser ->{
//                    existingUser.setPassword(user.getPassword());
//                    existingUser.setPseudo(user.getPseudo());
//                    return existingUser;
//                }).map(existingUser ->{
//                    return save(existingUser);
//                }).orElseThrow(()-> new IllegalArgumentException());

        Optional<User> optionalUser = userRepository.findById(user.getId());

        if(optionalUser.isPresent()){
            User userUpdate = optionalUser.get();
            userUpdate.setPseudo(user.getPseudo());
            userUpdate.setPassword(user.getPassword());

            return userRepository.save(userUpdate);
        }else{
            throw new IllegalArgumentException();
        }

    }

    @Override
    public Optional<User> findById(Long id) {
        log.debug("Finding user by id {}", id);
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        log.debug("Finding all users");
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        log.debug("Deleting user by id {}", id);
        userRepository.deleteById(id);
    }
}
