package com.its.people.PeopleController;

import com.its.people.DTO.PeopleDTO;
import com.its.people.PeopleService.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PeopleController {
    @Autowired
    private PeopleService peopleService;


    @GetMapping("/save-form")
    public String saveForm() {
        return "save-form";
    }

    @PostMapping("/save")
    public String save(@RequestParam("name1") String name1, @RequestParam("age") int age) {
        System.out.println("name1 = " + name1 + ", age = " + age);
        System.out.println("PeopleController.save");
        peopleService.save(name1, age);
        return null;
    }

    //1번
    @PostMapping("/save1")
    public String save1(@RequestParam("name1") String name1, @RequestParam("age") int age) {
        System.out.println("name1 = " + name1 + ", age = " + age);
        PeopleDTO peopleDTO = new PeopleDTO();
        peopleDTO.setName1(name1);
        peopleDTO.setAge(age);
        peopleService.save1(peopleDTO);
        return null;
    }

    //2번
    //네임이 똑같으면 스트링이 알아서 필드값을 알아서 넣어줌 (단, jsp네임값과 DTO의 필드값이 정확히 일치해야함)
    //그렇다면 아래 주석처리 된 내용을 생략할 수 있음
    @PostMapping("/save2")
    public String save2(@ModelAttribute PeopleDTO peopleDTO) {
//        System.out.println("name1 = " + name1 + ", age = " + age);
//        PeopleDTO peopleDTO = new PeopleDTO();
//        peopleDTO.setName1(name1);
//        peopleDTO.setAge(age);
        System.out.println("peopleDTO = " + peopleDTO);
        boolean saveResult = peopleService.save1(peopleDTO);
        if (saveResult) {
            System.out.println("저장성공");
            return "index";
        } else {
            System.out.println("저장실패");
            return "save-fail";
        }
    }
}
