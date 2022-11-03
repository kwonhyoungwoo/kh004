package com.example.kuly2.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.kuly2.board.dto.BoardDto;
import com.example.kuly2.board.service.BoardService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BoardController {

	private BoardService boardService;

	// 게시글 목록
	@GetMapping("/board")
	public String list(HttpSession session, Model model) {
		if (session.getAttribute("id") == null) { // 세션값을 가져와서 로그인된 유저인지 확인
			model.addAttribute("msg", "not_login");
		}
		List<BoardDto> boardList = boardService.getBoardList();
		model.addAttribute("boardList", boardList);

		return "/board/list";
	}

	// 게시글 작성페이지
	@GetMapping("/boardPost")
	public String write() {
		return "/board/write";
	}

	// 게시글 등록
	@PostMapping("/boardPost")
	public String write(HttpSession session, BoardDto boardDTO) {
		// 로그인된 회원 id를 작성자에 넘겨서 자동으로 등록
		String writer = (String) session.getAttribute("id");
		boardDTO.setWriter(writer);
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
	public String update(BoardDto boardDTO) {
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
