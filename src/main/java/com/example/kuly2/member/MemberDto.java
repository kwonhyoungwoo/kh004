package com.example.kuly2.member;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * 작성자 : 정지수
 * 내용  :  관리자 Dto
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
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

    @Column(name = "role")
    private String role;

    private LocalDateTime member_regdate;


    @Builder
    public MemberDto(MemberEntity memberEntity) {

        this.id = memberEntity.getId();
        this.name = memberEntity.getName();
        this.password = memberEntity.getPassword();
        this.phone = memberEntity.getPhone();
        this.email = memberEntity.getEmail();
        this.birth = memberEntity.getBirth();
        this.gender = memberEntity.getGender();
        this.address = memberEntity.getAddress();
        this.role = memberEntity.getRole();


    }

    public MemberEntity toEntity(){
        MemberEntity memberEntity = MemberEntity.builder()
                .id(id)
                .name(name)
                .password(password)
                .phone(phone)
                .email(email)
                .birth(birth)
                .gender(gender)
                .address(address)
                .role(role)
                .build();
        return memberEntity;
    }

}
