package com.example.kuly2.member;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.kuly2.member.request.MemberFindIdRequest;
import com.example.kuly2.member.request.MemberFindPasswordRequest;
import com.example.kuly2.member.request.MemberLoginRequest;
import com.example.kuly2.member.request.MemberRegistRequest;
import com.example.kuly2.member.request.MemberUpdateRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	private final ModelMapper modelMapper;

	//memberentity 저장
	public MemberEntity regist(MemberRegistRequest request) {
		MemberEntity member = modelMapper.map(request, MemberEntity.class); //meberentity.class?
		return memberRepository.save(member);  // ?
	}

	// 로그인
	public MemberEntity login(MemberLoginRequest request) {
		System.out.println(request.getId());
		System.out.println(request.getPassword());
		MemberEntity member = memberRepository.findById(request.getId()).orElse(null);
		if (member == null || !member.getPassword().equals(request.getPassword())) {
			return null;
		}
		return member; // ??
	}

	// id 중복
	public boolean validateId(String id) {
		return memberRepository.existsById(id);
	}

	// id 찾기
	public String findId(MemberFindIdRequest request) {
		MemberEntity member = memberRepository.findByNameAndEmail(request.getName(), request.getEmail())
			.orElse(new MemberEntity());
		return member.getId();
	}

	// pw 찾기
	public String findPassword(MemberFindPasswordRequest request) {
		MemberEntity member = memberRepository.findByNameAndId(request.getName(), request.getId())
			.orElse(new MemberEntity());
		return member.getPassword();
	}

	// 회원정보 수정
	public boolean update(String id, MemberUpdateRequest request) {
		MemberEntity member = memberRepository.findById(id).orElse(null);
		if (member == null) {
			return false;
		}
		modelMapper.map(request, member);
		memberRepository.save(member);
		return true;
	}

	// 모든 멤버 조회기능 추가
	public List<MemberEntity> getAllMembers() {
		return memberRepository.findAll();
	}

	// 관리자인지 체크
	public boolean isAdmin(String id) {
		MemberEntity member = memberRepository.findById(id).orElse(null);

		return member != null && member.getRole() != null && member.getRole().equals("Admin");
	}

	public MemberEntity findMemberById(String id) {
		return memberRepository.findById(id).orElse(null);
	}

}
