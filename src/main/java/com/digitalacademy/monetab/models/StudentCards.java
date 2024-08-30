package com.digitalacademy.monetab.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_cards")
public class StudentCards {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_student_card;

    @Column(nullable = false , name = "reference")
    private String reference;

    @Column(nullable = false , name = "issue_date")
    private Date issueDate;

    @Column(nullable = false , name = "expiry_date")
    private Date expiryDate;

    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;
}
