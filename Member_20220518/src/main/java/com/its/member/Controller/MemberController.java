package com.its.member.Controller;


import com.its.member.DTO.MemberDTO;
import com.its.member.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Member;
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
    public String findAll(Model model) {
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberList", memberDTOList);
        return "list";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, Model model, HttpSession session) {
        MemberDTO loginMember = memberService.login(memberDTO);
        // 세션(session)
        if (loginMember != null) {
            model.addAttribute("loginMember", loginMember);
            session.setAttribute("loginMemberId", loginMember.getMemberId());
            session.setAttribute("loginId", loginMember.getM_id());
            return "main";
        } else {
            return "login";
        }
    }

    //db에 있는 것을 보고싶으면 컨트롤러에 요청. 컨트롤러는 모델에 담아서 디비로 가져간다.
    @GetMapping("/detail")
    public String findById(@RequestParam("m_id") long m_id, Model model) {
        System.out.println("m_id = " + m_id);
        MemberDTO memberDTO = memberService.findById(m_id);
        model.addAttribute("member", memberDTO);
        return "detail";
    }

    @GetMapping("/delete") //링크는 무조건 get!
    public String delete(@RequestParam("memberId") String memberId) {
        int memberDTOList = memberService.delete(memberId);
        if (memberDTOList > 0) {
            System.out.println("삭제 성공");
            //redirect: 컨트롤러의 메서드에서 다른 메서드의 주소를 호출
            //redirect를 이용하여 findAll 주소 요청 /jsp가 오지 않고 주소가 옴
            return "redirect:/findAll";
        } else {
            System.out.println("삭제 실패");
        }
        return "index";
    }
    @GetMapping("/update-form")
    public String updateForm(HttpSession session, Model model){
        //로그인을 한 상태기 때문에 세션이 id, memberId가 들어있고 여기서 세션에 있는 id를 가져온다.
        //session은 object타입(가장 최상위) 따라서 오류가 뜨므로 Long타입으로 강제 형변환.
        Long updateId = (Long) session.getAttribute("loginId");
        System.out.println("updateId = " + updateId);
        // DB에서 해당 회원의 정보를 가져와서 그 정보를 가지고 update.jsp로 이동
        MemberDTO memberDTO = memberService.findById(updateId);
        model.addAttribute("updateMember", memberDTO);
        return "update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute MemberDTO memberDTO){
        System.out.println("memberDTO = " + memberDTO);
        boolean updateResult = memberService.update(memberDTO);
        if(updateResult){
            //트루면 해당 회원의 상세정보를 띄워라
            return "redirect:/detail?m_id=" + memberDTO.getM_id();
        }else{
            return "update-fail";
        }
    }

}
