package com.its.member.Controller;


import com.its.member.DTO.MemberDTO;
import com.its.member.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        boolean saveResult = memberService.save(memberDTO);
        if (saveResult) {
            System.out.println("저장성공");
            return "login";
        } else {
            System.out.println("저장실패");
            return "save-fail";
        }
    }
    @GetMapping("/findAll")
    public String findAll(Model model){
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberList", memberDTOList);
        return "list";
    }

    public String login(@ModelAttribute MemberDTO memberDTO){
        boolean loginResult = memberService.login(memberDTO);
        if(loginResult){
            return "main";
        } else{
            System.out.println("ㅎㅎ");
            return null;
        }
    }



}
