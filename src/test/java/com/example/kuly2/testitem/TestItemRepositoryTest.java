package com.example.kuly2.testitem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestItemRepositoryTest {

	@Autowired
	TestItemRepository repository;

	@Test
	void test() {
		List<TestItem> list = repository.findByCategory(ItemCategory.Fruit);
		list.forEach(System.out::println);

		System.out.println();
		System.out.println();
		System.out.println();

		List<TestItem> byCategory = repository.findByCategory(ItemCategory.Snack);
		byCategory.forEach(System.out::println);
	}

}