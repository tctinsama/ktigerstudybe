package org.example.ktigerstudybe.service.exercise;

import org.example.ktigerstudybe.model.Exercise;
import org.example.ktigerstudybe.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Override
    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    @Override
    public Optional<Exercise> getExerciseById(Long id) {
        return exerciseRepository.findById(id);
    }

    @Override
    public Exercise createExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    @Override
    public Exercise updateExercise(Long id, Exercise exercise) {
        return exerciseRepository.findById(id)
                .map(existingExercise -> {
                    existingExercise.setLesson(exercise.getLesson());
                    existingExercise.setTitle(exercise.getTitle());
                    existingExercise.setExerciseType(exercise.getExerciseType());
                    existingExercise.setDescription(exercise.getDescription());
                    return exerciseRepository.save(existingExercise);
                })
                .orElseThrow(() -> new RuntimeException("Exercise not found with id " + id));
    }

    @Override
    public void deleteExercise(Long id) {
        exerciseRepository.deleteById(id);
    }
}

