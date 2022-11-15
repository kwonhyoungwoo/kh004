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

}
