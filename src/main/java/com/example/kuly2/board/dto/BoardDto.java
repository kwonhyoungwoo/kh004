package com.example.kuly2.board.dto;

import java.time.LocalDate;

import com.example.kuly2.board.domain.entity.BoardEntity;

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
	private String title;
	private String content;
	private LocalDate createDate;

	@Builder
	public BoardDto(Long id, String title, String writer, String content, LocalDate createDate, String reply,
		char replyCheck, String userId) {
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.createDate = createDate;
		this.userId = userId;
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