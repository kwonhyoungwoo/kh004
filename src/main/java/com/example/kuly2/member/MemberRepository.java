package com.example.kuly2.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {

	@Override
	//id
	Optional<MemberEntity> findById(String id);
    // name, email로 id찾기
	
	Optional<MemberEntity> findByNameAndEmail(String name, String email);
	// select * from MemberEntity
		// where name2 = '?' and email = '?';
	
	
	
	
	// name, id 로 pw찾기
	Optional<MemberEntity> findByNameAndId(String name, String id);
}
