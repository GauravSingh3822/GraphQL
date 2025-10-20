package com.nexDew.SpringBootGraphQL.repository;

import com.nexDew.SpringBootGraphQL.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
