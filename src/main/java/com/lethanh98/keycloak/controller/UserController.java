package com.lethanh98.keycloak.controller;

import com.lethanh98.keycloak.entity.*;
import com.lethanh98.keycloak.repo.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import javax.transaction.*;
import java.util.*;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    UserRepo userRepo;

    @GetMapping()
    public List<User> get() {
        return (List<User>) userRepo.findAll();
    }

    @PostMapping()
    @Transactional
    public User post(String firstName, String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return userRepo.save(user);
    }
}
