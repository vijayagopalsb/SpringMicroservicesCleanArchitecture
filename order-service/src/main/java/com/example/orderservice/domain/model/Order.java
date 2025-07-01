package com.example.orderservice.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String product;
	
	@Column(nullable = false)
	private int quantity;
	
	@Column(nullable = false)
	private double price;

	public Order() {
		super();
	}

	public Order(Long id, String product) {
		super();
		this.id = id;
		this.product = product;
	}

	public Order(Long id, String product, int quality, double price) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quality;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getQuality() {
		return quantity;
	}

	public void setQuality(int quality) {
		this.quantity = quality;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", product=" + product + ", quality=" + quantity + ", price=" + price + "]";
	}

}
