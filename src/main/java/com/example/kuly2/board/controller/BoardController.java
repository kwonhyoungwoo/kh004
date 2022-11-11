package com.example.kuly2.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

	// 게시글 목록 *본인이 작성한 글만 출력
	@GetMapping("/board")
	public String memberBoards(HttpSession session, Model model,
			@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		List<BoardDto> boardList = boardService.getMemberBoardList((String) session.getAttribute("id"), pageable);
		model.addAttribute("boardList", boardList);
		model.addAttribute("prev", pageable.previousOrFirst().getPageNumber());
		model.addAttribute("next", pageable.next().getPageNumber());
		if (session.getAttribute("id") == null) {
			model.addAttribute("msg", "잘못된 접근 방식입니다.");
			return "/board/error";
		}
		return "/board/list";
	}

	// 게시글 작성페이지
	// 회원 인증 추가
	@GetMapping("/boardPost")
	public String write(HttpSession session, Model model) {
		model.addAttribute("id", session.getAttribute("id"));
		model.addAttribute("name", session.getAttribute("name"));

		return "/board/write";

	}

	// 게시글 등록
	@PostMapping("/boardPost")
	public String write(@Valid BoardDto boardDTO, Errors errors, Model model) {
		if (errors.hasErrors()) {
			model.addAttribute("boardDto", boardDTO); // 글 등록 실패시 입력 값 유지

			// 유효성 통과 못한 필드와 메시지 핸들링 처리
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

	// **관리자
	// 게시글 목록
	@GetMapping("/admin/board")
	public String adminBoards(HttpSession session, Model model,
			@RequestParam(value = "page", defaultValue = "1") Integer pageNum) {
		List<BoardDto> boardList = boardService.getBoardList(pageNum);
		Integer[] pageList = boardService.getPageList(pageNum);
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageList", pageList);
		return "/board/adminList";
	}

	// 게시글 상세조회
	@GetMapping("/admin/board/{id}")
	public String adminBoardDetail(@PathVariable("id") Long id, Model model) {
		BoardDto boardDTO = boardService.getBoard(id);
		model.addAttribute("boardDto", boardDTO);

		return "/board/adminDetail";
	}

	// 게시글 삭제
	@PostMapping("/admin/board/{id}")
	public String adminBoardDelete(@PathVariable("id") Long id) {
		boardService.deleteBoard(id);

		return "redirect:/admin/board";
	}
}
