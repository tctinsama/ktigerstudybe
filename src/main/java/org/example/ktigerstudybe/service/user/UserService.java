package org.example.ktigerstudybe.service.user;

import org.example.ktigerstudybe.dto.req.UserRequest;
import org.example.ktigerstudybe.dto.resp.UserResponse;

import java.util.List;

public interface UserService {
	List<UserResponse> getAllUsers();
	UserResponse getUserById(Long id);
	UserResponse createUser(UserRequest request);
	UserResponse updateUser(Long id, UserRequest request);
	void deleteUser(Long id);
}