package com.resell.toyprj.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class User {

    @Id @GeneratedValue
    private Long id; //PK

    private String account; //계정
    private String password;//비밀번호
    private String astatus; //회원상태
    private String email;   //이메일
    private String phone;   //전화번호
    private LocalDateTime createdAt; //생성일자
    private String createdBy; //생성자
    private LocalDateTime updatedAt; //수정일자
    private String updatedBy; //수정자

}
