package com.pension.reserv.member.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class MemberDto {

    @Column(name= "user_id")
    private String userId;
    @Column(name= "user_nm")
    private String userNm;
    private String password;
    private String tel;
    private String email;

}
