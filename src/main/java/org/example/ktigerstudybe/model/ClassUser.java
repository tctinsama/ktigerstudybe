package org.example.ktigerstudybe.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "class_user")
public class ClassUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ClassUserID")
    private Long classUserId;

    @Column(name = "JoinedAt")
    private LocalDate joinedAt;

    @ManyToOne
    @JoinColumn(name = "AddBy")
    private User addBy;

    @ManyToOne
    @JoinColumn(name = "ClassID")
    private ClassEntity classEntity;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

    @Column(name = "Role")
    private String role;
}
