package com.example.kuly2.board.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.kuly2.board.domain.entity.ReplyEntity;
import com.example.kuly2.board.domain.repository.ReplyRepository;
import com.example.kuly2.board.dto.BoardDto;
import com.example.kuly2.board.dto.ReplyDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ReplyService {

	private ReplyRepository replyRepository;
	private ModelMapper modelMapper;

	// 답변 등록
	@Transactional
	public ReplyDto repSave(BoardDto boardDTO, String content) {
		ReplyDto replyDTO = new ReplyDto();
		replyDTO.setContent(content);
		replyDTO.setBoardDto(boardDTO);
		replyDTO.setCreateDate(LocalDateTime.now());
		ReplyEntity replyEntity = modelMapper.map(replyDTO, ReplyEntity.class);
		replyEntity = replyRepository.save(replyEntity);
		replyDTO.setId(replyEntity.getId());
		return replyDTO;

	}

	// 수정할 답변 가져오기
	@Transactional
	public ReplyDto getRep(Long id) {
		ReplyEntity replyEntity = replyRepository.findById(id).get();
		ReplyDto replyDTO = modelMapper.map(replyEntity, ReplyDto.class);

		return replyDTO;
	}

	// 답변 수정
	@Transactional
	public ReplyDto editRep(ReplyDto replyDTO, BoardDto boardDTO, String content) {
		replyDTO.setContent(content);
		replyDTO.setBoardDto(boardDTO);
		replyDTO.setCreateDate(LocalDateTime.now());
		replyRepository.save(modelMapper.map(replyDTO, ReplyEntity.class));
		return replyDTO;
	}

	// 답변 삭제
	@Transactional
	public void delete(ReplyDto replyDTO) {
		replyRepository.delete(modelMapper.map(replyDTO, ReplyEntity.class));
	}

}
