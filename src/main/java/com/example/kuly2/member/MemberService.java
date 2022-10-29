package com.example.kuly2.member;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.kuly2.member.request.MemberFindIdRequest;
import com.example.kuly2.member.request.MemberLoginRequest;
import com.example.kuly2.member.request.MemberRegistRequest;
import com.example.kuly2.member.request.MemberUpdateRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	private final ModelMapper modelMapper;

	public MemberEntity regist(MemberRegistRequest request) {
		MemberEntity member = modelMapper.map(request, MemberEntity.class);
		return memberRepository.save(member);
	}

	public MemberEntity login(MemberLoginRequest request) {
		System.out.println(request.getId());
		System.out.println(request.getPassword());
		MemberEntity member = memberRepository.findById(request.getId()).orElse(null);  // ?
		if (member == null || !member.getPassword().equals(request.getPassword())) {
			return null;
		}
		return member;
	}

	public boolean validateId(String id) {
		return memberRepository.existsById(id);
	}

	public String findId(MemberFindIdRequest request) {
		MemberEntity member = memberRepository.findByNameAndEmail(request.getName(), request.getEmail()).orElse(new MemberEntity());
		return member.getId();
	}

	public boolean update(String id, MemberUpdateRequest request) {
		MemberEntity member = memberRepository.findById(id).orElse(null);
		if (member == null) {
			return false;
		}
		modelMapper.map(request, member);
		memberRepository.save(member);
		return true;
	}

}
