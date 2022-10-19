package com.example.demo;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "StudentIdCard")
@Table(name = "student_id_card",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "student_id_card_number_unique",
                        columnNames = "card_number")
        })
public class StudentIdCard {
    @Id
    @SequenceGenerator(
            name = "student_cad_id_sequence",
            sequenceName = "student_cad_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "student_cad_id_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "card_number",
            nullable = true,
            length = 15
    )
    private String cardNumber;

    @OneToOne(cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "student_id_card_id_fk"
            )
    )
    private Student student;

    public Long getId() {
        return id;
    }

    public String getCardNumber() {
        return cardNumber;
    }


    public StudentIdCard(String cardNumber, Student student) {
        this.cardNumber = cardNumber;
        this.student = student;
    }

    public StudentIdCard() {
    }

    public StudentIdCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "StudentIdCard{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", student=" + student +
                '}';
    }
}
