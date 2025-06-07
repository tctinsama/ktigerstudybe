package org.example.ktigerstudybe.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "level")
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LevelID")
    private Long levelId;

    @Column(name = "LevelName")
    private String levelName;

    @Column(name = "LevelDescription")
    private String levelDescription;
}
