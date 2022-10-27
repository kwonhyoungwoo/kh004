package com.example.kuly2;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String main(HttpSession session, Model model) {
		// 로그인이 되어있는지?
		if (session.getAttribute("name") != null) {
			// 모델에 이름 정보를 담아준다.
			model.addAttribute("name", session.getAttribute("name"));
		}
		return "/main/index";
	}

}
