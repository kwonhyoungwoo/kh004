package com.example.kuly2.member.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberUpdateRequest {
	private String id;
	private String name;
	private String password;
	private String phone;
	private String email;
	private String birth;
	private String gender;
	private String address;
}
