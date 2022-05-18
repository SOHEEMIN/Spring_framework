package com.its.member.Repository;

import com.its.member.DTO.MemberDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {
    @Autowired
    private SqlSessionTemplate sql;

    public int save(MemberDTO memberDTO) {
        System.out.println("memberDTO = " + memberDTO);
        return sql.insert("Member.save", memberDTO);

    }
    public List<MemberDTO> findAll(){
        return sql.selectList("Member.findAll");
    }

    public boolean login(MemberDTO memberDTO) {
        boolean result = false;
        if(sql.selectOne("Member.login")){
            result=true;
        }
        return result;
    }
}
