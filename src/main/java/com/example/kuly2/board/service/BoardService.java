package com.example.kuly2.board.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import com.example.kuly2.board.domain.entity.BoardEntity;
import com.example.kuly2.board.domain.repository.BoardRepository;
import com.example.kuly2.board.dto.BoardDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BoardService {

	private BoardRepository boardRepository;
	private ModelMapper modelMapper;
	private static final int BLOCK_PAGE_NUM_COUNT = 5; // 블럭에 존재하는 페이지 수
	private static final int PAGE_BOARD_COUNT = 10; // 한 페이지에 존재하는 게시글 수

	// 등록, 수정
	@Transactional // 예외 발생시 rollback 해줌
	public Long saveBoard(BoardDto boardDto) {
		return boardRepository.save(boardDto.toEntity()).getId();
	}

	// 글 등록시 유효성 검사
	public Map<String, String> validateHandling(Errors errors) {
		Map<String, String> result = new HashMap<>();

		for (FieldError error : errors.getFieldErrors()) {
			String validKeyName = String.format("valid_%s", error.getField());
			result.put(validKeyName, error.getDefaultMessage());
		}
		return result;
	}

	// 전체 게시글
	@Transactional
	public List<BoardDto> getBoardList(Integer pageNum) {
		Page<BoardEntity> page = boardRepository
				.findAll(PageRequest.of(pageNum - 1, PAGE_BOARD_COUNT, Sort.by(Sort.Direction.DESC, "id")));
		// repository.find() 호출하면서 PageRequest.of()를 사용해 페이징 처리, Sort를 사용해서 DESC정렬 ""에는 기준컬럼을 넣어주기
		List<BoardEntity> boardEntities = page.getContent();
		List<BoardDto> boardDtoList = Arrays.asList(modelMapper.map(boardEntities, BoardDto[].class));
		// Arrays.asList, 배열 처리후 리스트로 변환하기

		return boardDtoList;
	}

	// 로그인된 유저 게시글
	@Transactional
	public List<BoardDto> getMemberBoardList(String userId, Pageable pageable) {
		Page<BoardEntity> page = boardRepository.findByUserId(userId, pageable);
		List<BoardEntity> boardEntities = page.getContent();
		List<BoardDto> boardDtoList = Arrays.asList(modelMapper.map(boardEntities, BoardDto[].class));
		return boardDtoList;
	}

	// 게시글 카운트
	@Transactional
	public Long getBoardCount() {
		return boardRepository.count();
	}

	// 페이지
	public Integer[] getPageList(Integer curPageNum) {
		Integer[] pageList = new Integer[BLOCK_PAGE_NUM_COUNT];

		// 총 게시글 수
		Double boardsTotalCount = Double.valueOf(this.getBoardCount());

		// boardsTotalCount 기준으로 계산한 마지막 번호 찾기
		Integer totalLastPageNum = (int) (Math.ceil((boardsTotalCount / PAGE_BOARD_COUNT)));

		// 이동하는 페이지에 따라서 보이는 첫번째 페이지가 달라진다 넘어온 값이 BLOCK_PAGE_NUM_COUNT/2보다 작으면 1
		Integer blockStartpageNum = (curPageNum <= BLOCK_PAGE_NUM_COUNT / 2) ? 1
				: curPageNum - BLOCK_PAGE_NUM_COUNT / 2;

		// 이동한 페이지를 기준으로 블럭의 마지막 페이지 번호 찾기
		Integer blockLastPageNum = (totalLastPageNum > blockStartpageNum + BLOCK_PAGE_NUM_COUNT - 1)
				? blockStartpageNum + BLOCK_PAGE_NUM_COUNT - 1
				: totalLastPageNum;

		// 페이지 번호
		for (int bsn = blockStartpageNum, i = 0; bsn <= blockLastPageNum; bsn++, i++) {
			pageList[i] = bsn;

		}
		return pageList;
	}

	// 상세 게시글
	@Transactional
	public BoardDto getBoard(Long id) {
		BoardEntity boardEntity = boardRepository.findById(id).get();
		BoardDto boardDTO = modelMapper.map(boardEntity, BoardDto.class);

		return boardDTO;
	}

	// 삭제
	@Transactional
	public void deleteBoard(Long id) {
		boardRepository.deleteById(id);
	}

}
