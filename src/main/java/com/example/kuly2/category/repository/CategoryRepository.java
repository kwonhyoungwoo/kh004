package com.example.kuly2.category.repository;

import com.example.kuly2.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Long> {

    //1차
    List<Category> findBySecondaryCategoryIsNull();
    //2차
    List<Category> findByPrimaryCategoryAndSecondaryCategoryIsNotNull(String primaryCategory);


}
