package com.example.orderservice.infrastructure.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.orderservice.domain.model.Order;
import com.example.orderservice.domain.port.OrderRepository;
import com.example.orderservice.infrastructure.entity.OrderEntity;
import com.example.orderservice.infrastructure.repository.OrderJpaRepository;

public class OrderRepositoryImpl implements OrderRepository {

	private final OrderJpaRepository orderJpaRepository;

	public OrderRepositoryImpl(OrderJpaRepository orderJpaRepository) {
		this.orderJpaRepository = orderJpaRepository;
	}

	@Override
	public Order save(Order order) {

		OrderEntity entity = new OrderEntity(null, order.getProduct(), order.getQuality(), order.getPrice());
		entity = orderJpaRepository.save(entity);
		return new Order(entity.getId(), entity.getProduct(), entity.getQuantity(), entity.getPrice());

	}

	@Override
	public Optional<Order> findById(Long id) {
		return orderJpaRepository.findById(id)
				.map(entity -> new Order(entity.getId(), entity.getProduct(), entity.getQuantity(), entity.getPrice()));
	}

	@Override
	public List<Order> findAll() {
		return orderJpaRepository.findAll().stream()
				.map(entity -> new Order(entity.getId(), entity.getProduct(), entity.getQuantity(), entity.getPrice()))
				.toList();
	}

}
