package org.example.ktigerstudybe.service.exercise;


import org.example.ktigerstudybe.model.Exercise;

import java.util.List;
import java.util.Optional;

public interface ExerciseService {
    List<Exercise> getAllExercises();
    Optional<Exercise> getExerciseById(Long id);
    Exercise createExercise(Exercise exercise);
    Exercise updateExercise(Long id, Exercise exercise);
    void deleteExercise(Long id);
}

