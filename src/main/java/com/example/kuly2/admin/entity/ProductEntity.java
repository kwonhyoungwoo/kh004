package com.example.kuly2.admin.entity;

import com.example.kuly2.admin.Dto.ProductDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 작성자 : 정지수
 * 내용  :  관리자 엔티티
 */

@Entity
@Getter
@Builder
@ToString
@NoArgsConstructor
@Table(name="PRODUCT_TB")
public class ProductEntity {

    @Id @GeneratedValue
    private Long product_no;
    private String product_name;
    private int product_price;
    private String product_information;
    private String product_photo;
    @Lob
    private String product_description;
    private int product_rate;
    private String product_adder;
    private LocalDateTime product_regdate;


    @Builder
    public ProductEntity(Long product_no, String product_name, int product_price,
                        String product_information, String product_photo,
                         String product_description, int product_rate ,String product_adder,
                         LocalDateTime product_regdate) {

        this.product_no = product_no;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_information = product_information;
        this.product_photo = product_photo;
        this.product_description = product_description;
        this.product_rate = product_rate;
        this.product_adder = product_adder;
        this.product_regdate = product_regdate;

    }

    public void update(ProductDto productDto){
        this.product_name = productDto.getProduct_name();
        this.product_price = productDto.getProduct_price();
        this.product_information = productDto.getProduct_information();
        this.product_photo = productDto.getProduct_photo();
        this.product_description = productDto.getProduct_description();
        this.product_rate = productDto.getProduct_rate();
        this.product_adder = productDto.getProduct_adder();
        this.product_regdate = productDto.getProduct_regdate();
    }

    @PrePersist
    public void createdAt() {
        this.product_regdate = LocalDateTime.now();
    }


}
