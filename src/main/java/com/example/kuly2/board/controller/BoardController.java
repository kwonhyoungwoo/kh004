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
	
	//게시글 목록 
	//접근 권한주기
	@GetMapping("/board")
	public String list(Model model) {
		List<BoardDto> boardList = boardService.getBoardList();
		model.addAttribute("boardList", boardList);
		return "/board/list";
	}
	
	//게시글 작성페이지
	// 회원 인증 추가
	@GetMapping("/boardPost")
	public String write(HttpSession session, Model model) {
		model.addAttribute("id", session.getAttribute("id"));
		model.addAttribute("name", session.getAttribute("name"));
		return "/board/write";
	}
	
	//게시글 등록
	@PostMapping("/boardPost")
	public String write(HttpSession session, BoardDto boardDTO) {
		boardService.saveBoard(boardDTO);
		
		return "redirect:/board";
	}
	
	//게시글 상세조회
	@GetMapping("/board/{id}")
	public String detail(@PathVariable("id") Long id, Model model) {
		BoardDto boardDTO = boardService.getBoard(id);
		
		model.addAttribute("boardDto",boardDTO);
		return "/board/detail";
	}
	
	//게시글 수정 페이지
	@GetMapping("/board/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		BoardDto boardDTO = boardService.getBoard(id);
		
		model.addAttribute("boardDto", boardDTO);
		return "/board/update";
	}
	
	//게시글 수정
	@PostMapping("/board/edit/{id}")
	public String update(BoardDto boardDTO) {
		boardService.saveBoard(boardDTO);
		
		return "redirect:/board";
	}
	
	//게시글 삭제
	@PostMapping("/board/{id}")
	public String delete(@PathVariable("id") Long id) {
		boardService.deleteBoard(id);
		
		return "redirect:/board";
	}
}
