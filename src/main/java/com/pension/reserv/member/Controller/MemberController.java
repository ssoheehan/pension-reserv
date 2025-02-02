package com.pension.reserv.member.Controller;

import com.pension.reserv.member.dto.Member;
import com.pension.reserv.member.dto.MemberDto;
import com.pension.reserv.member.servies.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/")
    public String index(){
        return "/index";
    }

    @PostMapping("/login")
    public String login(@RequestBody MemberDto memberDto){
        boolean validated = memberService.validateMember(memberDto);
        return validated ? "sucess" : "fail";
    }

    @PostMapping("/joinMember")
    public String joinMember(@RequestBody MemberDto memberDto){
        Member member = memberService.joinMember(memberDto);
        System.out.println("==========member=========="+member);
        if(member != null){
            return "success";
        } else{
            return "fail";
        }
    }
}
