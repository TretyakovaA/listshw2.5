package com.example.lists;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/employee")
public class ListController {

    public final ListService listService;


    public ListController(ListService listService) {
        this.listService = listService;
    }

    @GetMapping(path = "/find")
    public Employee find(String firstName, String lastName) {

            return listService.find(firstName, lastName);


    }

    @GetMapping(path = "/add")
    public Employee add(String firstName, String lastName) {
        return listService.add(firstName, lastName);
    }
    @GetMapping (path = "/remove")
    public Employee remove (String firstName, String lastName){
        return listService.remove(firstName, lastName);
    }


}
