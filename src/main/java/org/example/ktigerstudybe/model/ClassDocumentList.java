package org.example.ktigerstudybe.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "class_document_list")
public class ClassDocumentList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ClassDocumentListID")
    private Long classDocumentListId;

    @ManyToOne
    @JoinColumn(name = "ClassID")
    private ClassEntity classEntity;

    @ManyToOne
    @JoinColumn(name = "ListID")
    private DocumentList documentList;

    @Column(name = "AssignedAt")
    private LocalDate assignedAt;
}
