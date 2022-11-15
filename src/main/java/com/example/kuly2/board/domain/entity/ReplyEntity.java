package com.example.kuly2.board.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="reply")
@NoArgsConstructor
public class ReplyEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "reply_id")
	private Long id;
	
	@Lob
	private String content;	// 내용
	
	private LocalDateTime createDate; // 작성일자
	
	@OneToOne 	
	private BoardEntity board;
	
}
