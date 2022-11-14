package com.example.kuly2.admin.Dto;

import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * 작성자 : 정지수
 * 내용  :  관리자 Dto
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private int product_no;
    private String productName;
    private int product_price;
    private String product_information;
    private String product_photo;
    private String product_descrition;
    private int product_rate;
    private String product_adder;



}
