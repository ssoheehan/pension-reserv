package com.pension.reserv.member.dto;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "user_id")
    private String userId;
    @Column(name= "user_nm")
    private String userNm;
    private String password;
    private String tel;
    private String email;
    private String use_yn;
//    @Temporal(TemporalType.TIMESTAMP)
//    private String i_time;
//    @Temporal(TemporalType.TIMESTAMP)
//    private String u_time;

    @Builder
    public Member(String userId, String userNm, String password, String tel, String email){
        this.userId = userId;
        this.userNm = userNm;
        this.password = password;
        this.tel = tel;
        this.email = email;
    }

}
