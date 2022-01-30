package com.dio.apirest.services;

import java.util.List;
import java.util.Optional;

import com.dio.apirest.exeptions.NotFoundException;
import com.dio.apirest.models.Person;
import com.dio.apirest.repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }


    public String create(Person person){
        Person savedPerson = personRepository.save(person);
        return "Pessoa criada com o id de " + savedPerson.getId();
    }

    public List<Person> findPeople(){
        return personRepository.findAll();
    }    

    public Person findPerson(long id) throws NotFoundException{

        validateExistance(id);

        return personRepository.getById(id);
    }

    public void kill(long id) throws NotFoundException{
        validateExistance(id);
        personRepository.deleteById(id);
    }

    public void change(long id, Person newPerson) throws NotFoundException{ 
        validateExistance(id);
        Person oldPerson = personRepository.getById(id);
        if(newPerson.getFirstName() != null) oldPerson.setFirstName(newPerson.getFirstName());
        if(newPerson.getLastName() != null) oldPerson.setLastName(newPerson.getLastName());
        if(newPerson.getCpf() != null) oldPerson.setCpf(newPerson.getCpf());
        if(newPerson.getBirthDate() != null) oldPerson.setBirthDate(newPerson.getBirthDate());
        personRepository.save(oldPerson);
    }

    private void validateExistance(long id) throws NotFoundException {
        Optional<Person> person = personRepository.findById(id);
        if(person.isEmpty()) throw new NotFoundException(id); 
    }
}
