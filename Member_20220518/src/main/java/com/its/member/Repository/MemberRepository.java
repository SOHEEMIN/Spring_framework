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

    public MemberDTO login(MemberDTO memberDTO) {
        return sql.selectOne("Member.login", memberDTO);
    }

    public MemberDTO findById(long m_id){
        return sql.selectOne(("Member.findById"), m_id);
    }

}
