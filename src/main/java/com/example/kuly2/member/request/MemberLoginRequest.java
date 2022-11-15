package com.example.kuly2.member.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// 로그인 저장소
public class MemberLoginRequest {

	private String id;
	private String password;
}
