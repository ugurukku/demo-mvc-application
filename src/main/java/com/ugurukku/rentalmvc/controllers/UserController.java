package com.ugurukku.rentalmvc.controllers;

import com.ugurukku.rentalmvc.entities.User;
import com.ugurukku.rentalmvc.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping
public class UserController {

    private final PasswordEncoder encoder;
    private final UserRepository userRepository;

    public UserController(PasswordEncoder encoder, UserRepository userRepository) {
        this.encoder = encoder;
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public RedirectView register(@ModelAttribute User user){
       user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return new RedirectView("/");
    }

    @GetMapping("/users")
    @ResponseBody
    public List<User> retrieveUsers(){
        return userRepository.findAll();
    }

    @PostConstruct
    public void addUsers(){
        User user = new User(null,"user", encoder.encode("user"),null,null);
        User user2 = new User(null,"user2", encoder.encode("user2"),null,null);
        User user3 = new User(null,"user3", encoder.encode("user3"),null,null);

        userRepository.saveAll(List.of(user,user2,user3));
    }


}
