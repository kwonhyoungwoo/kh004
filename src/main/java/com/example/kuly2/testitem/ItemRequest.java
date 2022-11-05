package com.example.kuly2.testitem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemRequest {

	private String name;

	private Long price;

	private Integer discount;

	private ItemCategory category;

	private Integer cate;

	public void toItemCategory() {
		this.category = ItemCategory.values()[cate];
	}
}
