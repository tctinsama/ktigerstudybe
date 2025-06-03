package org.example.ktigerstudybe.controller;

import org.example.ktigerstudybe.model.Exercise;
import org.example.ktigerstudybe.service.exercise.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @GetMapping
    public List<Exercise> getAllExercises() {
        return exerciseService.getAllExercises();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exercise> getExerciseById(@PathVariable Long id) {
        return exerciseService.getExerciseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Exercise createExercise(@RequestBody Exercise exercise) {
        return exerciseService.createExercise(exercise);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exercise> updateExercise(@PathVariable Long id, @RequestBody Exercise exercise) {
        try {
            Exercise updated = exerciseService.updateExercise(id, exercise);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable Long id) {
        exerciseService.deleteExercise(id);
        return ResponseEntity.noContent().build();
    }
}
