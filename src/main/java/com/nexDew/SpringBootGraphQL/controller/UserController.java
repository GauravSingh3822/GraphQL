package com.nexDew.SpringBootGraphQL.controller;

import com.nexDew.SpringBootGraphQL.entity.UserEntity;
import com.nexDew.SpringBootGraphQL.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // 1. Create User
    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    // 2. Get User by ID
    @GetMapping("/{userId}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long userId){
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.FOUND);
    }

    // 3. Get All Users
    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.FOUND);
    }

    // 4. Update User
    @PutMapping("/{userId}")
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user,@PathVariable Long userId){
        return new ResponseEntity<>(userService.updateUser(user,userId), HttpStatus.OK);
    }

    // 5. Delete User
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){
        return new ResponseEntity<>(userService.deleteUser(userId),HttpStatus.OK);
    }
}
