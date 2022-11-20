package com.example.kuly2.testitem;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.kuly2.member.MemberEntity;
import com.example.kuly2.member.MemberRepository;
import com.example.kuly2.member.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/test-item")
@RequiredArgsConstructor
public class TesItemController {
	private final TestItemRepository repository;
	private final MemberRepository memberRepository;
	private final ModelMapper modelMapper;
	private final MemberService memberService;

	@GetMapping("/{name}")
	public String getItem(@PathVariable String name, Model model) {
		List<TestItem> byNameContains = repository.findByNameContains(name);
		model.addAttribute("list", byNameContains); //name?
		return "list";
	}

	@GetMapping("/regist")
	public String registItemPage( Model model, HttpSession session) {
		String id = (String)session.getAttribute("id");
		if (memberService.isAdmin(id)) {
			return "th/registItem";
		}
		return "redirect:/";
	}

	@GetMapping("/view/{category}")
	public String viewItemPage(@PathVariable String category, Model model) {
		int cate = 0;
		if (!category.equals("Fruit")) {
			cate = 1;
		}

		model.addAttribute("list", repository.findByCategory(ItemCategory.values()[cate]));
		return "th/ItemList";
	}

	@PostMapping
	public String setItem(ItemRequest request, Model model) {
		request.toItemCategory();
		TestItem item = modelMapper.map(request, TestItem.class);
		repository.save(item);
		model.addAttribute("list", repository.findByCategory(item.getCategory()));
		return "th/ItemList";
	}

	@GetMapping("buy/{id}")
	public String buyItem(@PathVariable String id, HttpSession session, Model model) {
		TestItem testItem = repository.findById(Long.parseLong(id)).orElse(null);
		String memberId = (String)session.getAttribute("id");
		if (testItem != null) {
			MemberEntity member = memberRepository.findById(memberId).orElse(null);
			if (member != null) {
				member.getItemList().add(testItem);
				memberRepository.save(member);
				model.addAttribute("list", member.getItemList());
			}
		}
		return "th/ItemList";
	}
}