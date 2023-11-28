package com.janghyeon.lolchart.controller;

import com.janghyeon.lolchart.dto.UserDTO;
import com.janghyeon.lolchart.entity.UserEntity;
import com.janghyeon.lolchart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/users/register")
    public Status registerUser(@RequestBody UserDTO userDTO) {
        List<UserEntity> users = userService.findAll();
        System.out.println("New user: "+ userDTO.toString());
        for (UserEntity user: users) {
            if (user.equals(userDTO)) {
                System.out.println("User Already exists!");
                return Status.USER_ALREADY_EXISTS;
            }
        }
        userService.save(userDTO);
        return Status.SUCCESS;
    }
    @PostMapping("/users/login")
    public Status loginUser(@RequestBody UserDTO userDTO) {
        List<UserEntity> users = userService.findAll();
        for (UserEntity other : users) {
            if (userDTO.equals(other)) {
                userDTO.setLoggedIn(true);
                userService.save(userDTO);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }
    @PostMapping("/users/logout")
    public Status logUserOut(@RequestBody UserDTO userDTO) {
        List<UserEntity> users = userService.findAll();
        for (UserEntity other : users) {
            if (other.equals(userDTO)) {
                userDTO.setLoggedIn(false);
                userService.save(userDTO);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }
    @DeleteMapping("/users/all")
    public Status deleteUsers() {
        userService.deleteAll();
        return Status.SUCCESS;
    }
}