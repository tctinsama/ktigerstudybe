package org.example.ktigerstudybe.repository;

import org.example.ktigerstudybe.model.UserProgress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProgressRepository extends JpaRepository<UserProgress, Long> {
}
