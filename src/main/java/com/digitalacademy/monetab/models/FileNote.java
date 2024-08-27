package com.digitalacademy.monetab.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "file_note")
public class FileNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_file_note;

    @Column(name = "note" , nullable = false)
    private Double note ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_teacher")
    private Teacher teacher ;
}
