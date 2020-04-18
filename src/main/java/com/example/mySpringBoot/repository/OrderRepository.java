package com.example.mySpringBoot.repository;

import com.example.mySpringBoot.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
