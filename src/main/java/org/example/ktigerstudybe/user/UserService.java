package org.example.ktigerstudybe.user;

import java.util.List;
import java.util.Optional;

import org.example.ktigerstudybe.model.User;



public interface UserService {
	  List<User> getAllUser();

	  void saveUser(User user);

	  void deleteUser(Long id);

	  Optional<User> findUserById(Long id);
}
