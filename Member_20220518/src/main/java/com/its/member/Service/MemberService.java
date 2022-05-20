package com.its.member.Service;

import com.its.member.DTO.MemberDTO;
import com.its.member.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public boolean save(MemberDTO memberDTO) {
        int saveResult = memberRepository.save(memberDTO);
        if (saveResult > 0) {
            return true;
        } else {
            return false;
        }

    }

    public List<MemberDTO> findAll() {
//        List<MemberDTO> memberDTOList = memberRepository.findAll();
//        return memberDTOList;
//        위의 두줄 쓸 것을 밑의 한줄로 쓸 수 있음!
        return memberRepository.findAll();
    }

    public MemberDTO login(MemberDTO memberDTO) {
        MemberDTO loginMember = memberRepository.login(memberDTO);
        return loginMember;
    }

    public MemberDTO findById(long m_id) {
        return memberRepository.findById(m_id);
    }

    public int delete(String memberId) {
        return memberRepository.delete(memberId);
    }


    public boolean update(MemberDTO memberDTO) {
        int updateResult = memberRepository.update(memberDTO);
        if (updateResult > 0) {
            return true;
        } else {
            return false;
        }
    }

    public String duplicateCheck(String memberId) {
        String checkResult = memberRepository.duplicateCheck(memberId);
        if(checkResult == null) {
            return "ok";
        }else {
            return "no";
        }
    }
}
