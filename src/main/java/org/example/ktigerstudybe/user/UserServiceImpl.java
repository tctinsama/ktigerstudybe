package org.example.ktigerstudybe.user;

import java.util.List;
import java.util.Optional;

import org.example.ktigerstudybe.model.User;
import org.example.ktigerstudybe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  @Autowired private UserRepository userRepository;

  @Override
  public List<User> getAllUser() {
    return (List<User>) userRepository.findAll();
  }

  @Override
  public void saveUser(User user) {
    userRepository.save(user);
  }

  @Override
  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }

  @Override
  public Optional<User> findUserById(Long id) {
    return userRepository.findById(id);
  }
}
