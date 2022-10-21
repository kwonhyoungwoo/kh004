package com.example.kuly2.testitem;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/test-item")
@RequiredArgsConstructor
public class TesItemController {
	private final TestItemRepository repository;

	@GetMapping("/{name}")
	public String getItem(@PathVariable String name, Model model) {
		List<TestItem> byNameContains = repository.findByNameContains(name);
		model.addAttribute("list", byNameContains);
		return "list";
	}
}
