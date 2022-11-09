package com.example.kuly2.admin.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class AdminEntity {

        @Id
        private Long id;
        private String admin_id; // 아이디
        private String admin_nickname;
        private String admin_password;

//        @Enumerated(EnumType.STRING)
//        @Column(nullable = false)
//        private Role role;

//        /* 회원정보 수정 */
//        public void modify(String nickname, String password) {
//            this.nickname = nickname;
//            this.password = password;
//        }

        /* 소셜로그인시 이미 등록된 회원이라면 수정날짜만 업데이트해줘서
         * 기존 데이터를 보존하도록 예외처리 */
//        public User updateModifiedDate() {
//            this.onPreUpdate();
//            return this;
//        }
//
//        public String getRoleValue() {
//            return this.role.getValue();
//        }

}
