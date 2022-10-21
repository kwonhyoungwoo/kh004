package com.example.kuly2.member;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.kuly2.member.request.MemberLoginRequest;
import com.example.kuly2.member.request.MemberRegistRequest;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

	private final MemberService memberService;

	@PostMapping
	public String regist(MemberRegistRequest request) {
		memberService.regist(request);
		return "main";
	}

	@PostMapping("/login")
	public String login(MemberLoginRequest request, Model model, HttpSession session) {
		MemberEntity member = memberService.login(request);
		if (member != null) {
			session.setAttribute("id", member.getId());
			session.setAttribute("name", member.getName());
			model.addAttribute("message", "로그인 성공!");
		} else {
			model.addAttribute("message", "로그인 실패!");
			return "login";
		}
		return "redirect:/";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("id");
		session.removeAttribute("name");
		return "redirect:/";
	}

	@GetMapping("/check/{id}")
	@ResponseBody
	public Boolean validateId(@PathVariable String id, HttpSession session) {
		System.out.println(session.getAttribute("id"));
		return memberService.validateId(id);
	}

}
