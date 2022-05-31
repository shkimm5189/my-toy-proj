package com.resell.toyprj.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class UpdateUserForm {

    private Long id;
    @NotEmpty(message = "회원 계정은 필수입니다.")
    private String account;
    @NotEmpty(message = "비밀번호는 필수입니다.")
    private String password;
    @NotEmpty(message = "이메일은 필수입니다.")
    private String email;
    @NotEmpty(message = "전화번호는 필수입니다.")
    private String phone;
}
