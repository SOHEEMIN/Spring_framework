package com.its.people.PeopleService;

import com.its.people.DTO.PeopleDTO;
import com.its.people.PeopleRepository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {
    @Autowired
    private PeopleRepository peopleRepository;

    public void save(String name1, int age){
        System.out.println("name1 = " + name1 + ", age = " + age);
        System.out.println("PeopleService.save");
        peopleRepository.save(name1, age);
    }

    //앞으로 실습할 내용은 이러한 형식으로!
    public boolean save1(PeopleDTO peopleDTO) {
        int saveResult = peopleRepository.save1(peopleDTO);
        if(saveResult>0){
            return true;
        } else {
            return false;
        }
    }
}
