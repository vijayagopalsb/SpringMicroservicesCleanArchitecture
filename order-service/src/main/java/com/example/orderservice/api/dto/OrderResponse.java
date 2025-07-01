package com.example.orderservice.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
	
	private Long id;
	private String product;
	private int quantity;
	private double price;

}
