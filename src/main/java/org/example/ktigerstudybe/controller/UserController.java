package org.example.ktigerstudybe.controller;

import java.util.List;

import org.example.ktigerstudybe.model.User;
import org.example.ktigerstudybe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/")
public class UserController {
  @Autowired private UserService userService;

  @RequestMapping("/")
  public String index(Model model) {

    return "dd";
  }

}
