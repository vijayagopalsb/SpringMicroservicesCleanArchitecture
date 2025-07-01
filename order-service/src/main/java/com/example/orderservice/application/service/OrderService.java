package com.example.orderservice.application.service;

import java.util.List;

import com.example.orderservice.domain.model.Order;
import com.example.orderservice.domain.port.OrderRepository;

public class OrderService {

	private final OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}

	public Order getOrder(Long id) {
		return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
	}

	public List<Order> listOrders() {
		return orderRepository.findAll();
	}

}
