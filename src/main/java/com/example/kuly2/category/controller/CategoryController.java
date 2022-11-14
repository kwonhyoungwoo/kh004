package com.example.kuly2.category.controller;


import com.example.kuly2.category.Dto.CategoryResponse;
import com.example.kuly2.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/primary-category-list")
    public List<CategoryResponse> list() {
        return categoryService.getPrimaryCategoryList();
    }

    @PostMapping("/secondary-category-list")
    public List<CategoryResponse> list(String id) {
        return categoryService.getSecondaryCategoryList(id);
    }

}
