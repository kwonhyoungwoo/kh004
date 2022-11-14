package com.example.kuly2.board.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "board")
@NoArgsConstructor
public class BoardEntity {

	@Id
	@GeneratedValue
	@Column(name = "board_id")
	private Long id;

	private String userId; // 회원 아이디

	private String writer; // 작성자 (회원 이름)

	private String title; // 글제목

	@Lob // 대용량 데이터
	private String content; // 글내용

	private LocalDateTime createDate; // 작성일자

	@OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE) // CascadeType.REMOVE 부모 엔티티 삭제시 자식 엔티티도 삭제됨
	private List<ReplyEntity> repList;

	@Builder
	public BoardEntity(Long id, String title, String writer, String content, LocalDateTime createDate, String userId,
			List<ReplyEntity> repList) {
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.createDate = LocalDateTime.now();
		this.userId = userId;
		this.repList = repList;
	}

}
