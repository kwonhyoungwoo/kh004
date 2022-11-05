package com.example.kuly2.testitem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestItem {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private Long price;

	private Integer discount;

	private ItemCategory category;
}
