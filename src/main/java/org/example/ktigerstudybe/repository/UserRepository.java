package org.example.ktigerstudybe.repository;

import org.example.ktigerstudybe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    // Search users by name, email or username
    List<User> findByFullNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrUserNameContainingIgnoreCase(
            String fullName, String email, String userName);

    long countByUserStatus(int status);

    long countByJoinDateAfter(java.time.LocalDate date);
}
