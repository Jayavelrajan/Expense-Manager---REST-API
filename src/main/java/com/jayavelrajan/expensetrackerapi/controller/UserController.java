package com.jayavelrajan.expensetrackerapi.controller;

import com.jayavelrajan.expensetrackerapi.entity.User;
import com.jayavelrajan.expensetrackerapi.entity.UserModel;
import com.jayavelrajan.expensetrackerapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping("/users/{id}")
    public ResponseEntity<User> readUser(@PathVariable Long id){

        return new ResponseEntity<User>(userService.readUser(id), HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody UserModel user, @PathVariable Long id){

        return new ResponseEntity<>(userService.updateUser(user,id), HttpStatus.OK);

    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
}
