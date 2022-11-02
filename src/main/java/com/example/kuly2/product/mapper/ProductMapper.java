package com.example.kuly2.product.mapper;

import java.util.List;

import com.example.kuly2.product.domain.ProductDTO;

public interface ProductMapper {
	public List<ProductDTO> getListWithCate(ProductDTO product);
}
