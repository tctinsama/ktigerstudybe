package org.example.ktigerstudybe.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "class")
public class ClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ClassID")
    private Long classId;

    @Column(name = "ClassName")
    private String className;

    @Column(name = "Description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "CreatedBy")
    private User createdBy;

    @Column(name = "CreatedAt")
    private LocalDate createdAt;
}
