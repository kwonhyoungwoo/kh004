package com.example.kuly2.admin.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * 작성자 : 정지수
 * 내용  :  관리자 엔티티
 */

@Entity
@Getter
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

    private String product_descrition;

    private int product_rate;

    private String product_adder;

    private Timestamp product_regdate;

}
