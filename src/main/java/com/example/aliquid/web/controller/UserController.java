package com.example.aliquid.web.controller;

import com.example.aliquid.web.models.User;
import com.example.aliquid.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/users")
    public String allUsers(Model model) {
        model.addAttribute("users", userService.allUsers());
        return "users";
    }

    @GetMapping("/users/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "show";
    }

    @GetMapping("users/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("users/new")
    public String newUser(@ModelAttribute("user") User user) {
        userService.newUser(user);
        return "redirect:/users";
    }

    @GetMapping("users/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        User user = userService.show(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("users/edit")
    public String editShow(@ModelAttribute("user") User user) {
        userService.edit(user);
        return "redirect:/users";
    }

    @GetMapping("users/delete")
    public String delete(@RequestParam(name = "id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String deleteShow(@RequestParam(name = "id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editShow(@PathVariable("id") int id, Model model) {
        User user = userService.show(id);
        model.addAttribute("user", user);
        return "edit";

    }
}
