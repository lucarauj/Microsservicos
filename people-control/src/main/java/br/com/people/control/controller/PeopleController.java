package br.com.people.control.controller;

import br.com.people.control.model.People;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @GetMapping
    public List<People> getAll() {
        People people = new People();
        List<People> peopleList = new ArrayList<>();
        people.setName("Lucas");
        people.setEmail("lucas@gmail.com");
        people.setPhone("9988811312");
        peopleList.add(people);
        return peopleList;
    }
}
