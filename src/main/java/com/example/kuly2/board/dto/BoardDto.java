package com.example.kuly2.board.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

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
	private String writer;
	@NotBlank(message = "제목을 입력해주세요.")
	private String title;
	@NotBlank(message = "내용을 입력해주세요.")
	private String content;
	private LocalDate createDate;

	@Builder
	public BoardDto(Long id, String title, String writer, String content, LocalDate createDate) {
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.createDate = createDate;
	}

	// 필요한 Entity추가
	public BoardEntity toEntity() {
		BoardEntity boardEntity = BoardEntity
				.builder()
				.id(id)
				.writer(writer)
				.title(title)
				.content(content)
				.build();
		return boardEntity;
	}
}
