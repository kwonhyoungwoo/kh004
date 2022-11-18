package com.example.kuly2.member;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "name2")
	private String name;

	@Column(name = "password")
	private String password;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;

	@Column(name = "birth")
	private String birth;

	@Column(name = "gender")
	private String gender;

	@Column(name = "address")
	private String address;

	@Column(name = "role")
	private String role;

	private LocalDateTime member_regdate;

	@PrePersist
	public void createdAt() {
		this.member_regdate = LocalDateTime.now();
	}

}
