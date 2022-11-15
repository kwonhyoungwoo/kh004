package com.example.kuly2.board.dto;

import java.time.LocalDateTime;
import java.util.List;

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
	private String userId;
	private String writer;
	@NotBlank(message = "제목을 입력해주세요.")
	private String title;
	@NotBlank(message = "내용을 입력해주세요.")
	private String content;
	private LocalDateTime createDate;
	private List<ReplyDto> repList;
	
	@Builder
	public BoardDto(Long id, String title, String writer, String content, 
			LocalDateTime createDate, String userId, List<ReplyDto> repList) {
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.createDate = createDate;
		this.userId = userId;
		this.repList = repList;
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
