package com.example.kuly2.category.service;


import com.example.kuly2.category.Dto.CategoryResponse;
import com.example.kuly2.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryResponse> getPrimaryCategoryList() {
        return categoryRepository.findBySecondaryCategoryIsNull().stream().map(CategoryResponse::from).collect(Collectors.toList());
    }
    public List<CategoryResponse> getSecondaryCategoryList(String id) {
        return categoryRepository.findByPrimaryCategoryAndSecondaryCategoryIsNotNull(id).stream().map(CategoryResponse::from).collect(Collectors.toList());
    }

    public CategoryResponse getCategory(Long id) {
        return CategoryResponse.from(Objects.requireNonNull(categoryRepository.findById(id).orElse(null)));
    }
}
