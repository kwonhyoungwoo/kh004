package com.example.kuly2;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.kuly2.testitem.ItemCategory;

import com.example.kuly2.member.MemberEntity;
import com.example.kuly2.member.MemberRepository;

import com.example.kuly2.testitem.TestItem;
import com.example.kuly2.testitem.TestItemRepository;

@Configuration
public class AppConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	ApplicationRunner applicationRunner() {
		return new ApplicationRunner() {

			@Autowired
			TestItemRepository repository;

			@Autowired
			MemberRepository memberRepository;

			@Override
			public void run(ApplicationArguments args) throws Exception {
				MemberEntity member = new MemberEntity();
				member.setId("admin");
				member.setName("관리자");
				member.setPassword("1234");
				member.setRole("Admin");
				memberRepository.save(member);

				member = new MemberEntity();
				member.setId("user");
				member.setName("유저");
				member.setPassword("1234");
				member.setEmail("user@user.com");
				member.setPhone("01000000000");
				member.setRole("User");
				memberRepository.save(member);
/*
				repository.save(TestItem.builder()
					.name("사과")
					.price(10000L)
					.discount(10)
					.category(ItemCategory.Fruit)
					.build());

				repository.save(TestItem.builder()
					.name("사과")
					.price(1000L)
					.discount(20)
					.category(ItemCategory.Snack)
					.build());

				repository.save(TestItem.builder()
					.name("감사과")
					.price(30000L)
					.discount(50)
					.category(ItemCategory.Fruit)
					.build());

				repository.save(TestItem.builder()
					.name("수박사과")
					.price(1000000L)
					.discount(3)
					.category(ItemCategory.Fruit)
					.build());

				repository.save(TestItem.builder()
					.name("자동차사과")
					.price(1000000000L)
					.discount(20)
					.category(ItemCategory.Fruit)
					.build());

				repository.save(TestItem.builder()
					.name("사과사과")
					.price(10500L)
					.category(ItemCategory.Snack)
					.discount(20)
					.build());
					*/
			}
		};
		
	}
	
}
