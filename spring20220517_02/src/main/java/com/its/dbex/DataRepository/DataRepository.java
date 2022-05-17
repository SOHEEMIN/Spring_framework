package com.its.dbex.DataRepository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataRepository {
    @Autowired
    private SqlSessionTemplate sql;  //자바와 매퍼를 연결해주는 역할

    public void save(String val1, String val2) {
        System.out.println("DataRepository.save");
        System.out.println("val1 = " + val1 + ", val2 = " + val2);
        sql.insert("Data.save",val1);
    }
}
