package com.digitalacademy.monetab.models;




import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;

    @Column(name = "pseudo" , unique = true , nullable = false)
    private String pseudo;

    @Column(name = "password" , nullable = false)
    private String password;

    @Column(name = "creation_date" , nullable = false)
    private Instant createdDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_adress")
    private Adress adress;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_role_user")
    private RoleUser roleUser;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_school")
    private School school;


}
