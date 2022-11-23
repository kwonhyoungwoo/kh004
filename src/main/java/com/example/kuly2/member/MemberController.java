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
			session.setAttribute("name", member.getName());   // ~~님 환영합니다 이름!
			model.addAttribute("message", "로그인 성공!"); // 이 message?
		} else {
			model.addAttribute("message", "로그인 실패!");
			//return "redirect:/loginFail.html";
			return "login/loginFail";
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
	public Boolean validateId(@PathVariable String id) {
		return memberService.validateId(id);
	}

	@GetMapping("/find/id")
	public String findId(MemberFindIdRequest request, Model model) {
		String id = memberService.findId(request);
		if (id == null || id.equals("")) {
			return "redirect:/findIdFail.html";
		}
		model.addAttribute("id", id);
		return "th/loginFindResult";

	}

	@GetMapping("/find/password")
	public String findPassword(MemberFindPasswordRequest request, Model model) {
		String password = memberService.findPassword(request);
		if (password == null || password.equals("")) {
			return "redirect:/findPasswordFail.html";
		}
		model.addAttribute("password", password);
		return "th/passwordFindResult";
	}

	@GetMapping("/my")
	public String my(HttpSession session, Model model) {
		// 로그인이 되어있는지?
		if (session.getAttribute("name") != null) {
			// 모델에 이름 정보를 담아준다.
			model.addAttribute("name", session.getAttribute("name"));
		}
		String id = (String)session.getAttribute("id");
		if (memberService.isAdmin(id)) {
			return "/main/myAdminPage";
		}

		return "/main/myPage";
	}

	@PostMapping("/update")
	public String update(HttpSession session, Model model, MemberUpdateRequest request) {
		String id = (String)session.getAttribute("id");
		boolean update = memberService.update(id, request);

		model.addAttribute("success", update);
		session.setAttribute("name", request.getName());
		return "main/myPage";
		//return "th/myPage"; 
	}

	// 관리자 회원 정보 페이지로 가기
	@GetMapping("/update/admin/{memberId}")
	public String updatePage(HttpSession session, Model model, @PathVariable String memberId) {
		String id = (String)session.getAttribute("id");
		// 관리자 권한 체크
		if (!memberService.isAdmin(id)) {
			model.addAttribute("memberList", memberService.getAllMembers());
			return "admin/member/memberList";
		}

		// 수정할 멤버 데이터 넘기기
		model.addAttribute("member", memberService.findMemberById(memberId));
		return "th/adminMemberUpdate";
	}

	// 관리자의 회원 수정
	@PostMapping("/update/admin")
	public String updateByAdmin(HttpSession session, Model model, MemberUpdateRequest request) {
		memberService.update(request.getId(), request); //?b?
		model.addAttribute("memberList", memberService.getAllMembers());
		return "admin/member/memberList";
	}

	// 회원 목록 + 페이징
	/*
	@GetMapping("/list")
	public String list(Model model, @PageableDefault(direction = Sort.Direction.DESC, size = 20) Pageable pageable) {
		Page<MemberDto> memberDtos = memberService.findAll(pageable);

		// 현재 페이지
		int pageNumber = memberDtos.getPageable().getPageNumber();
		// 총 페이지
		int totalPages = memberDtos.getTotalPages();
		int pageBlock = 5;
		int startBlockPage  = ((pageNumber)/pageBlock)*pageBlock + 1;
		int endBlockPage = startBlockPage+pageBlock - 1;
		endBlockPage = totalPages < endBlockPage ? totalPages : endBlockPage;

		model.addAttribute("memberList", memberDtos.getContent());
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("totalPages",totalPages);
		model.addAttribute("startBlockPage",startBlockPage);
		model.addAttribute("endBlockPage", endBlockPage);

		return "admin/member/memberList";
	}

*/

	//구매
	@GetMapping("/item")
	public String myItem(HttpSession session, Model model) {
		String id = (String)session.getAttribute("id");
		MemberEntity member = memberService.findById(id);
		model.addAttribute("list", member.getItemList());
		return "th/ItemList";

	}

}