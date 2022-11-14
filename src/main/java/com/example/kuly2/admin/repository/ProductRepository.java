package com.example.kuly2.admin.repository;

import com.example.kuly2.admin.Dto.ProductDto;
import com.example.kuly2.admin.entity.ProductEntity;
import com.example.kuly2.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * 작성자 : 정지수
 * 내용  :  관리자 Repository
 */

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    List<ProductEntity> findAll();

    Optional<ProductEntity> findById(int product_no);

    @Query("SELECT p FROM ProductEntity p left join Category c on p.categoryId.categoryId = c.categoryId where c.primaryCategory=:categoryId")
    List<ProductEntity>findByCategoryId(String categoryId);

    List<ProductEntity> findByProductNameContaining(String productName);

    @Query("SELECT p FROM ProductEntity p left join Category c on p.categoryId.categoryId = c.categoryId where c.secondaryCategory=:filter")
    List<ProductEntity> findBySecondaryCategory(String filter);
}
