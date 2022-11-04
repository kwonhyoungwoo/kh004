package com.example.kuly2.admin.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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
}
