package com.example.kuly2.category.Dto;

import com.example.kuly2.category.entity.Category;
import lombok.*;


@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryResponse {

    private Long id;
    private String primaryCategory;
    private String secondaryCategory;

    public static CategoryResponse from(Category cate) {
        return new CategoryResponse(cate.getCategoryId(),cate.getPrimaryCategory(),cate.getSecondaryCategory());
    }
}
