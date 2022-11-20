package com.example.kuly2.testitem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestItemRepository extends JpaRepository<TestItem, Long> {

	List<TestItem> findByNameContains(String name);
	List<TestItem> findByCategory(ItemCategory category);
}