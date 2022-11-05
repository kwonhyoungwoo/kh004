package com.example.kuly2.board.domain.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.example.kuly2.member.MemberEntity;

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

//	@ManyToOne // 단방향
//	@JoinColumn(name = "board_writer")
//	private MemberEntity writer; // 작성자

	private String userId;
	
	private String writer;

	private String title; // 글제목

	@Lob // 대용량 데이터
	private String content; // 글내용

	private LocalDate createDate; // 작성일자

//	private String reply; // 답변

//	@ColumnDefault("0") // default 0
//	private char replyCheck; // 답변여부 ?나중에 독립

	@Builder
	public BoardEntity(Long id, String title, String writer, String content, LocalDate createDate, String reply,
			char replyCheck, String userId) {
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.createDate = LocalDate.now();
		this.userId = userId;
//		this.reply = reply;
//		this.replyCheck = replyCheck;
	}

}
