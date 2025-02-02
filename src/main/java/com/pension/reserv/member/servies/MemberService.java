package com.pension.reserv.member.servies;

import com.pension.reserv.member.dto.Member;
import com.pension.reserv.member.dto.MemberDto;
import com.pension.reserv.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

     public boolean validateMember(MemberDto memberDto) {
        Member member = memberRepository.findByUserId(memberDto.getUserId())
                .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + memberDto.getUserId()));
        return member.getPassword().equals(memberDto.getPassword());
    }

    public Member joinMember(MemberDto memberDto) {

         Member member = Member.builder()
                 .userId(memberDto.getUserId())
                 .userNm(memberDto.getUserNm())
                 .password(memberDto.getPassword())
                 .tel(memberDto.getTel())
                 .email(memberDto.getEmail())
                 .build();
        return memberRepository.save(member);
    }
}
