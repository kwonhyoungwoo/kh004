package com.example.kuly2.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.kuly2.board.dto.BoardDto;
import com.example.kuly2.board.service.BoardService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BoardController {

	private BoardService boardService;

	// 게시글 목록
	@GetMapping("/board")
	public String list(HttpSession session, Model model, @RequestParam(value="page", defaultValue= "1") Integer pageNum){
		
		if (session.getAttribute("id") == null) { // 세션값을 가져와서 로그인된 유저인지 확인
			model.addAttribute("msg", "not_login");
		}
		
		List<BoardDto> boardList = boardService.getBoardList(pageNum);
		Integer[] pageList = boardService.getPageList(pageNum);
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageList", pageList);

		return "/board/list";
	}

	// 게시글 작성페이지
	@GetMapping("/boardPost")
	public String write(HttpSession session, BoardDto boardDTO, Model model) {
		// 로그인된 회원 id를 작성자에 넘겨서 자동으로 등록
		String writer = (String) session.getAttribute("id");
		boardDTO.setWriter(writer);
		return "/board/write";
	}

	// 게시글 등록
	@PostMapping("/boardPost")
	public String write(@Valid BoardDto boardDTO, Errors errors, Model model) {
		if (errors.hasErrors()) {
			model.addAttribute("boardDto", boardDTO); //글 등록 실패시 입력 값 유지
			
			//유효성 통과 못한 필드와 메시지 핸들링 처리
			Map<String, String> result = boardService.validateHandling(errors);
			for (String key : result.keySet()) {
				model.addAttribute(key, result.get(key));
			}
			return "/board/write";
		}
		boardService.saveBoard(boardDTO);
		return "redirect:/board";
	}

	// 게시글 상세조회
	@GetMapping("/board/{id}")
	public String detail(@PathVariable("id") Long id, Model model) {
		BoardDto boardDTO = boardService.getBoard(id);
		model.addAttribute("boardDto", boardDTO);
		return "/board/detail";
	}

	// 게시글 수정 페이지
	@GetMapping("/board/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		BoardDto boardDTO = boardService.getBoard(id);

		model.addAttribute("boardDto", boardDTO);
		return "/board/update";
	}

	// 게시글 수정
	@PostMapping("/board/edit/{id}")
	public String update(@Valid BoardDto boardDTO, Errors errors, Model model) {
		boardService.saveBoard(boardDTO);
		return "redirect:/board";
	}

	// 게시글 삭제
	@PostMapping("/board/{id}")
	public String delete(@PathVariable("id") Long id) {
		boardService.deleteBoard(id);

		return "redirect:/board";
	}
}
