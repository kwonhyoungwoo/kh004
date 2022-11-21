package com.example.kuly2.admin.Dto;

import com.example.kuly2.admin.entity.ProductEntity;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

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
    private Long product_no;
    private String product_name;
    private int product_price;
    private String product_information;
    private String product_photo;
    private String product_description;
    private int product_rate;
    private String product_adder;
    private LocalDateTime product_regdate;


    @Builder
    public ProductDto(ProductEntity productEntity) {

        this.product_no = productEntity.getProduct_no();
        this.product_name = productEntity.getProduct_name();
        this.product_price = productEntity.getProduct_price();
        this.product_information = productEntity.getProduct_information();
        this.product_photo = productEntity.getProduct_photo();
        this.product_description = productEntity.getProduct_description();
        this.product_rate = productEntity.getProduct_rate();
        this.product_adder = productEntity.getProduct_adder();
        this.product_regdate = productEntity.getProduct_regdate();

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
