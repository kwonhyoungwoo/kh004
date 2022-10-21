package com.example.kuly2.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

}
