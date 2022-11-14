package com.example.kuly2.admin.entity;

import com.example.kuly2.category.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 작성자 : 정지수
 * 내용  :  관리자 엔티티
 */

@Entity
@Getter
@NoArgsConstructor
@Table(name="PRODUCT_TB")
@AllArgsConstructor
public class ProductEntity {

    @Id @GeneratedValue
    private Long product_no;

    private String productName;

    private int product_price;

    private String product_information;

    private String product_photo;

    private String product_descrition;

    private int product_rate;

    private String product_adder;

    private Timestamp product_regdate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name="category_id")
    private Category categoryId;



}
