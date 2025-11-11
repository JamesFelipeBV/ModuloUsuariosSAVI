package com.savi.usermodule.controller;

import com.savi.usermodule.model.User;
import com.savi.usermodule.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller

public class UserController {

	 @Autowired
	    private UserRepository userRepository;

	    @GetMapping("/users")
	    public String listUsers(Model model) {
	        model.addAttribute("users", userRepository.findAll());
	        return "user_list";
	    }

	    @GetMapping("/users/new")
	    public String showForm(User user) {
	        return "user_form";
	    }

	    @PostMapping("/users")
	    public String saveUser(@Valid User user, BindingResult result) {
	        if (result.hasErrors()) {
	            return "user_form";
	        }
	        userRepository.save(user);
	        return "redirect:/users";
	    }
}
