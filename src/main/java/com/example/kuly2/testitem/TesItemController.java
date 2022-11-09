package com.example.kuly2.testitem;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/test-item")
@RequiredArgsConstructor
public class TesItemController {
	private final TestItemRepository repository;
	private final ModelMapper modelMapper;

	@GetMapping("/{name}")
	public String getItem(@PathVariable String name, Model model) {
		List<TestItem> byNameContains = repository.findByNameContains(name);
		model.addAttribute("list", byNameContains); //name?
		return "list";
	}

	@GetMapping("/regist/{category}")
	public String registItemPage(@PathVariable String category, Model model) {
		int cate = 0;
		if (!category.equals("Fruit")) {
			cate = 1;
		}

		model.addAttribute("cate", cate);
		return "th/registItem";
	}

	@PostMapping
	public String setItem(ItemRequest request, Model model) {
		request.toItemCategory();
		TestItem item = modelMapper.map(request, TestItem.class);
		repository.save(item);
		model.addAttribute("list", repository.findByCategory(item.getCategory()));
		return "th/ItemList";
	}
}
