package com.example.kuly2.member;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.kuly2.member.request.MemberFindIdRequest;
import com.example.kuly2.member.request.MemberFindPasswordRequest;
import com.example.kuly2.member.request.MemberLoginRequest;
import com.example.kuly2.member.request.MemberRegistRequest;
import com.example.kuly2.member.request.MemberUpdateRequest;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

	private final MemberService memberService;

	@PostMapping
	public String regist(MemberRegistRequest request) {
		memberService.regist(request);
		return "redirect:/";
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
			return "redirect:/loginFail.html";
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

	@GetMapping("/find/id")
	public String findId(MemberFindIdRequest request, Model model) {
		String id = memberService.findId(request);
		if (id == null || id.equals("")) {
			return "redirect:/findIdFail.html";
		}
		model.addAttribute("id", id);
		return "loginFindResult";
	}
	
	@GetMapping("/find/password")
	public String findPassword(MemberFindPasswordRequest request, Model model) {
		String password = memberService.findPassword(request);
		if (password ==null || password.equals("")) {
			return "redirect:/findPasswordFail.html";
		}
		model.addAttribute("password", password);
		return "passwordFindResult";
		
	
}
	

	@GetMapping("/my")
	public String my(HttpSession session) {
		return "myPage";
	}

	@PostMapping("/update")
	public String update(HttpSession session, Model model, MemberUpdateRequest request) {
		String id = (String)session.getAttribute("id");
		boolean update = memberService.update(id, request);

		model.addAttribute("success", update);
		session.setAttribute("name", request.getName());
		return "myPage";
	}

}
