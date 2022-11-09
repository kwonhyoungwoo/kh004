package com.example.kuly2.admin.Dto;

import lombok.*;

import java.io.Serializable;

/**
 * request, response DTO 클래스를 하나로 묶어 InnerStaticClass로 한 번에 관리
 */
public class AdminDto {

    /** 관리자 Service 요청(Request) DTO 클래스 */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {

        private Long id;

//        @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{4,20}$", message = "아이디는 특수문자를 제외한 4~20자리여야 합니다.")
//        @NotBlank(message = "아이디는 필수 입력 값입니다.")
        private String admin_id;
//
//        @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
        private String admin_password;
//
//        @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{2,10}$", message = "닉네임은 특수문자를 제외한 2~10자리여야 합니다.")
//        @NotBlank(message = "닉네임은 필수 입력 값입니다.")
        private String admin_nickname;
//
//        @Pattern(regexp = "^(?:\\w+\\.?)*\\w+@(?:\\w+\\.)+\\w+$", message = "이메일 형식이 올바르지 않습니다.")
//        @NotBlank(message = "이메일은 필수 입력 값입니다.")
//        private String email;
//
//        private Role role;

        /* DTO -> Entity */
        public AdminDto toEntity() {
            AdminDto admin = AdminDto.builder()
                    .id(id)
                    .username(admin_id)
                    .password(admin_password)
                    .nickname(admin_nickname)
                    .build();
            return admin;
        }
    }

    /**
     * 인증된 사용자 정보를 세션에 저장하기 위한 클래스
     * 세션을 저장하기 위해 User 엔티티 클래스를 직접 사용하게 되면 직렬화를 해야 하는데,
     * 엔티티 클래스에 직렬화를 넣어주면 추후에 다른 엔티티와 연관관계를 맺을시
     * 직렬화 대상에 다른 엔티티까지 포함될 수 있어 성능 이슈 우려가 있기 때문에
     * 세션 저장용 Dto 클래스 생성
     * */
    @Getter
    public static class Response implements Serializable {

        private final Long id;
        private final String admin_id;
        private final String admin_nickname;
//        private final String email;
//        private final Role role;
//        private final String modifiedDate;

        /* Entity -> dto */
        public Response(AdminDto adminDto) {
            this.id = adminDto.getId();
            this.admin_id = adminDto.getAdmin_id();
            this.admin_nickname = adminDto.getAdmin_nickname();
//            this.email = adminDto.getEmail();
//            this.role = adminDto.getRole();
//            this.modifiedDate = adminDto.getModifiedDate();
        }
    }

}
