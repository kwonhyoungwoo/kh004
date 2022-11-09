package com.example.kuly2.admin.repository;

import com.example.kuly2.admin.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * 작성자 : 정지수
 * 내용  :  관리자 Repository
 */

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    /**  */
    List<ProductEntity> findAll();
    /**  */
    Optional<ProductEntity> findById(int product_no);

//    ProductEntity<> save(ProductEntity ProductEntity);

}
