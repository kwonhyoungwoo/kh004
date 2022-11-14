package com.example.kuly2.category.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Getter
@ToString
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue
    private Long categoryId;
    private String primaryCategory;
    private String secondaryCategory;
}
