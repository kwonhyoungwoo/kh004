package com.example.kuly2.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {

	@Override
	//id 회원정보수정
	Optional<MemberEntity> findById(String id);
    // name, email로 id찾기
	Optional<MemberEntity> findByNameAndEmail(String name, String email);
	// name, id 로 pw찾기
	Optional<MemberEntity> findByNameAndId(String name, String id);
}
