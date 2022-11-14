package com.example.kuly2.board.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReplyDto {

	private Long id;
	private String content;
	private LocalDateTime createDate;
	private BoardDto boardDto;

}
