package com.example.myapp.controller;

import com.example.myapp.entity.User;
import com.example.myapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class UserController {

    @Autowired
    private UserRepository helloMessageRepository;

    @GetMapping("/hello")
    public String sayHello(Model model) {
        // Save "Hello, World!" message to MySQL
        User message = new User("Hello, World!");
        helloMessageRepository.save(message);

        // Retrieve the latest message
        User latestMessage = helloMessageRepository.findTopByOrderByIdDesc();

        // Add message to the model
        model.addAttribute("message", latestMessage.getMessage());

        return "hello"; // Refers to hello.html
    }
}
