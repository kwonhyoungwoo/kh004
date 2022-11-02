package com.example.kuly2.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kuly2.product.domain.ProductDTO;
import com.example.kuly2.product.mapper.ProductMapper;

import lombok.Setter;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Setter(onMethod_ = @Autowired )
	ProductMapper productmapper;

	@Override
	public List<ProductDTO> getListWhithCate(ProductDTO product) {
		return productmapper.getListWithCate(product);
	}
	
}
