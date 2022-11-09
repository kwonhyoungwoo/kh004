package com.example.kuly2.admin.Dto;

import com.example.kuly2.admin.entity.ProductEntity;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

/**
 * 작성자 : 정지수
 * 내용  :  관리자 Dto
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductDto {
    @Id
    private int product_no;
    private String product_name;
    private int product_price;
    private String product_information;
    private String product_photo;
    private String product_description;
    private int product_rate;
    private String product_adder;
    private Timestamp product_regdate;


    @Builder
    public ProductDto(int product_no, String product_name, int product_price,
                         String product_information, String product_photo,
                         String product_description, int product_rate ,String product_adder,
                         Timestamp product_regdate) {

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

    public ProductEntity toEntity(){
        ProductEntity productEntity = ProductEntity.builder()
                .product_no(product_no)
                .product_name(product_name)
                .product_price(product_price)
                .product_information(product_information)
                .product_photo(product_photo)
                .product_description(product_description)
                .product_rate(product_rate)
                .product_adder(product_adder)
                .product_regdate(product_regdate)
                .build();
        return productEntity;
    }

}
