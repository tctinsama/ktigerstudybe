package org.example.ktigerstudybe.service.user;

import org.example.ktigerstudybe.dto.req.UserRequest;
import org.example.ktigerstudybe.dto.resp.UserResponse;
import org.example.ktigerstudybe.model.User;
import org.example.ktigerstudybe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  // Convert entity -> response DTO
  private UserResponse toResponse(User user) {
    UserResponse resp = new UserResponse();
    resp.setUserId(user.getUserId());
    resp.setFullName(user.getFullName());
    resp.setEmail(user.getEmail());
    resp.setGender(user.getGender());
    resp.setDateOfBirth(user.getDateOfBirth());
    resp.setAvatarImage(user.getAvatarImage());
    resp.setJoinDate(user.getJoinDate());
    resp.setRole(user.getRole());
    resp.setUserStatus(user.getUserStatus());
    resp.setUserName(user.getUserName());
    return resp;
  }

  // Convert request DTO -> entity (cho create)
  private User toEntity(UserRequest req) {
    User user = new User();
    user.setFullName(req.getFullName());
    user.setEmail(req.getEmail());
    user.setPassword(req.getPassword());
    user.setGender(req.getGender());
    user.setDateOfBirth(req.getDateOfBirth());
    user.setAvatarImage(req.getAvatarImage());
    user.setJoinDate(req.getJoinDate());
    user.setRole(req.getRole());
    user.setUserStatus(req.getUserStatus());
    user.setUserName(req.getUserName());
    return user;
  }

  @Override
  public List<UserResponse> getAllUsers() {
    return userRepository.findAll().stream()
            .map(this::toResponse)
            .collect(Collectors.toList());
  }

  @Override
  public UserResponse getUserById(Long id) {
    User user = userRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
    return toResponse(user);
  }

  @Override
  public UserResponse createUser(UserRequest request) {
    User user = toEntity(request);
    user = userRepository.save(user);
    return toResponse(user);
  }

  @Override
  public UserResponse updateUser(Long id, UserRequest request) {
    User user = userRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
    user.setFullName(request.getFullName());
    user.setEmail(request.getEmail());
    user.setGender(request.getGender());
    user.setDateOfBirth(request.getDateOfBirth());
    user.setAvatarImage(request.getAvatarImage());
    user.setJoinDate(request.getJoinDate());
    user.setRole(request.getRole());
    user.setUserStatus(request.getUserStatus());
    user.setUserName(request.getUserName());
    user = userRepository.save(user);
    return toResponse(user);
  }

  @Override
  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }
}
