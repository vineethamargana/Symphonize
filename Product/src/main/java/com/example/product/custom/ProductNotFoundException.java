package com.example.product.custom;

public class ProductNotFoundException extends RuntimeException {
	public ProductNotFoundException(String message) {
        super(message);
    }

}
