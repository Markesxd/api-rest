package com.dio.apirest.controllers;

import java.util.List;

import com.dio.apirest.exeptions.NotFoundException;
import com.dio.apirest.models.Person;
import com.dio.apirest.services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
    
    private PersonService personService;

    @Autowired
    PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public List<Person> getPeople() {
        return personService.findPeople();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id) throws Exception {
        return personService.findPerson(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public String create(@RequestBody Person person) {
        return personService.create(person);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void remove(@PathVariable long id) throws Exception {
        personService.kill(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void update(@PathVariable long id, @RequestBody Person params) throws NotFoundException{
        personService.change(id, params);
    }
}
