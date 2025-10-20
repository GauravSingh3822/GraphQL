package com.nexDew.SpringBootGraphQL.controller;

import com.nexDew.SpringBootGraphQL.entity.OrderEntity;
import com.nexDew.SpringBootGraphQL.entity.UserEntity;
import com.nexDew.SpringBootGraphQL.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserGraphQLController {

    private final UserService userService;

    @QueryMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @QueryMapping
    public ResponseEntity<UserEntity> getUserById(@Argument Long userId) {
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.FOUND);
    }

    @MutationMapping
    public UserEntity createUser(@Argument UserEntity user) {
        return userService.createUser(user);
    }

    @QueryMapping
    public List<OrderEntity> getUserOrderById(@Argument Long userId){
        return userService.getUserOrder(userId);
    }

}
