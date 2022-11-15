package com.example.kuly2.admin.repository;

import com.example.kuly2.admin.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
