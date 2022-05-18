package com.its.people.PeopleRepository;

import com.its.people.DTO.PeopleDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class PeopleRepository {
    @Autowired
    private SqlSessionTemplate sql;


    public void save(String name1, int age){
        PeopleDTO peopleDTO = new PeopleDTO();
        peopleDTO.setName1(name1);
        peopleDTO.setAge(age);
        sql.insert("people.save", peopleDTO);


    }

    public int save1(PeopleDTO peopleDTO) {
        return sql.insert("People.save", peopleDTO);
    }
}
