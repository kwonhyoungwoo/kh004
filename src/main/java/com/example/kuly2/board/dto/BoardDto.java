package com.example.kuly2.board.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.example.kuly2.board.domain.entity.BoardEntity;
import com.example.kuly2.board.domain.entity.ReplyEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {

	private Long id;
	private String userId;
	private String writer;
	@NotBlank(message = "제목을 입력해주세요.")
	private String title;
	@NotBlank(message = "내용을 입력해주세요.")
	private String content;
	private LocalDateTime createDate;
	private List<ReplyEntity> repList;
	
	@Builder
	public BoardDto(BoardEntity boardEntity) {
		this.id = boardEntity.getId();
		this.title = boardEntity.getTitle();
		this.writer = boardEntity.getWriter();
		this.content = boardEntity.getContent();
		this.createDate = boardEntity.getCreateDate();
		this.userId = boardEntity.getUserId();
		this.repList = boardEntity.getRepList();
	}

	// 필요한 Entity추가
	public BoardEntity toEntity() {
		BoardEntity boardEntity = BoardEntity
			.builder()
			.id(id)
			.writer(writer)
			.title(title)
			.content(content)
			.userId(userId)
			.build();
		return boardEntity;
	}
}
