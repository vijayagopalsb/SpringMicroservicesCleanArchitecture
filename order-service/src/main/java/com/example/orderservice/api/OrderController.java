package com.example.orderservice.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.api.dto.OrderRequest;
import com.example.orderservice.api.dto.OrderResponse;
import com.example.orderservice.application.service.OrderService;
import com.example.orderservice.domain.model.Order;

@RestController
@RequestMapping("/orders")
public class OrderController {

	private static final int OrderResponse = 0;
	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping
	public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {

		Order order = new Order(null, orderRequest.getProduct(), orderRequest.getQuantity(), orderRequest.getPrice());
		Order saved = orderService.createOrder(order);
		OrderResponse orderResponse = new OrderResponse(saved.getId(), saved.getProduct(), saved.getQuality(),
				saved.getPrice());
		return ResponseEntity.status(HttpStatus.CREATED).body(orderResponse);
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrderResponse> getOrder(@PathVariable Long id) {
		Order order = orderService.getOrder(id);
		OrderResponse response = new OrderResponse(order.getId(), order.getProduct(), order.getQuality(),
				order.getPrice());
		return ResponseEntity.ok(response);
	}

	@GetMapping
	public List<OrderResponse> listOrders() {
		return orderService.listOrders().stream().map(
				order -> new OrderResponse(order.getId(), order.getProduct(), order.getQuality(), order.getPrice()))
				.collect(Collectors.toList());
	}

}
