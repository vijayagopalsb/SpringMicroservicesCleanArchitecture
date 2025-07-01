package com.example.orderservice.domain.port;

import java.util.List;
import java.util.Optional;

import com.example.orderservice.domain.model.Order;

public interface OrderRepository {
	
	Order save(Order order);
	Optional<Order> findById(Long id);
	List<Order> findAll();

}
