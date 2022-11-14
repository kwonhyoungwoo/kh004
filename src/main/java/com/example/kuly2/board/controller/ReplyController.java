package com.example.kuly2.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.kuly2.board.dto.BoardDto;
import com.example.kuly2.board.dto.ReplyDto;
import com.example.kuly2.board.service.BoardService;
import com.example.kuly2.board.service.ReplyService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ReplyController {

	private BoardService boardService;
	private ReplyService replyService;

	// 답변 등록
	@PostMapping("/admin/repWrite/{id}")
	public String repWrite(@PathVariable("id") Long id, ReplyDto replyDTO) {
		BoardDto boardDTO = boardService.getBoard(id);
		replyService.repSave(boardDTO, replyDTO.getContent());
		return String.format("redirect:/admin/board/%s", id);
	}

	//답변 수정 
	@PostMapping("/edit/{id}/{bid}")
	public String repEdit(@PathVariable("id") Long id, @PathVariable("bid") Long bid, String content) {
		ReplyDto replyDTO = replyService.getRep(id);
		BoardDto boardDTO = boardService.getBoard(bid);
		replyService.editRep(replyDTO, boardDTO, content);
		return String.format("redirect:/admin/board/%s", bid);
	}

	// 답변 삭제
	@PostMapping("/delete/{id}/{bid}")
	public String repDelete(@PathVariable("id") Long id, @PathVariable("bid") Long bid) {
		ReplyDto replyDTO = replyService.getRep(id);
		replyService.delete(replyDTO);
		return String.format("redirect:/admin/board/%s", bid);
	}
}
