package com.mission.mymission.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@NoArgsConstructor // 기본 생성자 생성
@AllArgsConstructor
@Getter @Setter
@ToString
public class CustomerReqForm {
    private Long id;

    @NotEmpty(message = "Name은 필수 입력 항목입니다") // " " 허용
    private String name;

    @NotBlank(message = "Email은 필수 입력 항목입니다") // " " 허용하지 않음
    @Email(message = "Email 형식이 아닙니다")
    private String email;

    private int age;
}
