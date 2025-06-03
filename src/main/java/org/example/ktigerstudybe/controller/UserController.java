package org.example.ktigerstudybe.controller;

import org.example.ktigerstudybe.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {
  @Autowired private UserService userService;

  @RequestMapping("/")
  public String index(Model model) {

    return "index";
  }

}
