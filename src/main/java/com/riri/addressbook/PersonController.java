package com.riri.addressbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {

    @Autowired
    PersonRepository personRepository;


    @GetMapping("/add")
    public String addPerson(Model model){
        model.addAttribute("person", new Person());
        return "addperson";
    }

    @PostMapping("/add")
    public String postPerson(@ModelAttribute Person person, Model model){
        model.addAttribute("person", person);
        return "confirmperson";

    }

    @PostMapping("/display")
    public String displayPersons(@ModelAttribute Person person, Model model){

        return "displaypersons";
    }

    @GetMapping("/search")
    public String searchPerson(){

        return "searchperson";
    }

    @PostMapping("/search")
    public String ShowSearchPerson(@RequestParam("search") String search, Model model){
        model.addAttribute("searchval", search);
        personRepository.findAllByFname(search);
        return "searchresult";
    }


}
