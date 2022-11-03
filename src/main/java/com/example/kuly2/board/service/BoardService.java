package com.example.kuly2.board.service;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.kuly2.board.domain.entity.BoardEntity;
import com.example.kuly2.board.domain.repository.BoardRepository;
import com.example.kuly2.board.dto.BoardDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BoardService {

	private BoardRepository boardRepository;
	private ModelMapper modelMapper;
	
	//등록, 수정
	@Transactional //예외 발생시 rollback 해줌
	public Long saveBoard(BoardDto boardDto) {
		return boardRepository.save(boardDto.toEntity()).getId();
	}
	
	//전체 게시글
	@Transactional 
	public List<BoardDto> getBoardList() {
		List<BoardEntity> boardEntities = boardRepository.findAll();
		List<BoardDto> boardDtoList = Arrays.asList(modelMapper.map(boardEntities, BoardDto[].class));
		//Arrays.asList, 배열 처리후 리스트로 변환하기 

		return boardDtoList;
	}
	
	//상세 게시글 //수정예정
	@Transactional
	public BoardDto getBoard(Long id) {
		
		BoardEntity boardEntity = boardRepository.findById(id).get(); 
		BoardDto boardDTO = modelMapper.map(boardEntity, BoardDto.class);
		     
        return boardDTO;
		
	}
	
	//삭제
	@Transactional
	public void deleteBoard(Long id) {
		boardRepository.deleteById(id);
	}
}
