package com.nexDew.SpringBootGraphQL.service.impl;

import com.nexDew.SpringBootGraphQL.entity.OrderEntity;
import com.nexDew.SpringBootGraphQL.entity.UserEntity;
import com.nexDew.SpringBootGraphQL.repository.UserRepository;
import com.nexDew.SpringBootGraphQL.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.IllformedLocaleException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(()-> new IllformedLocaleException("User not found by id"+userId));
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity updateUser(UserEntity user, Long userId) {
        UserEntity existingUser = userRepository.findById(userId).orElseThrow(() -> new IllformedLocaleException("User not found by id" + userId));
        existingUser.setUserName(user.getUserName());
        existingUser.setUserEmail(user.getUserEmail());
        existingUser.setUserCity(user.getUserCity());
        existingUser.setUserPhone(user.getUserPhone());
        return userRepository.save(existingUser);
    }

    @Override
    public String deleteUser(Long userId) {
        UserEntity existingUser = userRepository.findById(userId).orElseThrow(() -> new IllformedLocaleException("User not found by id" + userId));
        userRepository.delete(existingUser);
        return "User deleted successfully";
    }

    @Override
    public List<OrderEntity> getUserOrder(Long userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not By this Id :" + userId));
        return userEntity.getOrders();

    }
}
