package com.example.kuly2.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {

	@Override
	Optional<MemberEntity> findById(String id);

	Optional<MemberEntity> findByNameAndEmail(String name, String email);
	
	Optional<MemberEntity> findByNameAndId(String name, String id);
}
