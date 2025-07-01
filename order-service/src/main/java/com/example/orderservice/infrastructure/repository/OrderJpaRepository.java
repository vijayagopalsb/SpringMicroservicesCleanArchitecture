package com.example.orderservice.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.orderservice.infrastructure.entity.OrderEntity;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {
}
