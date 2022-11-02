package com.example.kuly2.product.service;

import java.util.List;

import com.example.kuly2.product.domain.ProductDTO;

public interface ProductService {
	public List<ProductDTO> getListWhithCate(ProductDTO product);
}
