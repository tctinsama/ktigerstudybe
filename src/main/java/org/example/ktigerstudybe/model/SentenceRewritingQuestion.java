package org.example.ktigerstudybe.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sentence_rewriting_question")
public class SentenceRewritingQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QuestionID")
    private Long questionId;

    @ManyToOne
    @JoinColumn(name = "ExerciseID")
    private Exercise exercise;

    @Column(name = "OriginalSentence")
    private String originalSentence;

    @Column(name = "RewrittenSentence")
    private String rewrittenSentence;

    @Column(name = "LinkMedia")
    private String linkMedia;
}
