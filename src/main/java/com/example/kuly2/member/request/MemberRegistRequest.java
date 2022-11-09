package com.example.kuly2.member.request;

import lombok.Getter;
import lombok.Setter;
// 저장소
@Getter
@Setter
public class MemberRegistRequest {
	private String id;
	private String name;
	private String password;
	private String phone;
	private String email;
	private String birth;
	private String gender;
	private String address;
}
