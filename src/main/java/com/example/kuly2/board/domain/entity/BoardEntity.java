package com.example.kuly2.board.domain.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "board")
@NoArgsConstructor
public class BoardEntity {

	@Id
	@GeneratedValue
	@Column(name = "board_id")
	private Long id;
	
	private String writer;
	
	private String title; // 글제목
	
	@Lob // 대용량 데이터
	private String content; // 글내용
	
	private LocalDate createDate; // 작성일자

	@Builder
	public BoardEntity(Long id, String title, String writer, String content, LocalDate createDate) {
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.createDate = LocalDate.now();
	}

}
