package org.example.ktigerstudybe.controller;

import org.example.ktigerstudybe.dto.req.UserRequest;
import org.example.ktigerstudybe.dto.resp.UserResponse;
import org.example.ktigerstudybe.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping
  public List<UserResponse> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
    try {
      UserResponse resp = userService.getUserById(id);
      return ResponseEntity.ok(resp);
    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public UserResponse createUser(@RequestBody UserRequest request) {
    return userService.createUser(request);
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRequest request) {
    try {
      UserResponse updated = userService.updateUser(id, request);
      return ResponseEntity.ok(updated);
    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/{id}/freeze")
  public ResponseEntity<UserResponse> freezeUser(@PathVariable Long id) {
    try {
      UserResponse resp = userService.freezeUser(id);
      return ResponseEntity.ok(resp);
    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/{id}/unfreeze")
  public ResponseEntity<UserResponse> unfreezeUser(@PathVariable Long id) {
    try {
      UserResponse resp = userService.unfreezeUser(id);
      return ResponseEntity.ok(resp);
    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/search")
  public List<UserResponse> searchUsers(@RequestParam String keyword) {
    return userService.searchUsers(keyword);
  }
}
