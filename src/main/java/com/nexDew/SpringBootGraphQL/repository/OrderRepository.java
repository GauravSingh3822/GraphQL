package com.nexDew.SpringBootGraphQL.repository;

import com.nexDew.SpringBootGraphQL.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,String> {
}
