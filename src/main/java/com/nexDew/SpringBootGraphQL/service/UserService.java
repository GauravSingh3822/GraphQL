package com.nexDew.SpringBootGraphQL.service;

import com.nexDew.SpringBootGraphQL.entity.OrderEntity;
import com.nexDew.SpringBootGraphQL.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity createUser(UserEntity user);

    UserEntity getUserById(Long userId);

    List<UserEntity> getAllUsers();

    UserEntity updateUser(UserEntity user, Long userId);

    String deleteUser(Long userId);

    List<OrderEntity> getUserOrder(Long userId);
}
