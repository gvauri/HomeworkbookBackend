package com.homework.homework;

import com.homework.homework.modle.Homework;
import com.homework.homework.modle.Person;
import com.homework.homework.sevice.PersonsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonResource {
    private final PersonsService personsService;

    public PersonResource(PersonsService personsService) {
        this.personsService = personsService;
    }


    @GetMapping("/find/{userID}")
    public ResponseEntity <Person> getPersonByUserID(@PathVariable("userID")Long id){
        Person person = personsService.findPersonByUserID(id);
        return  new ResponseEntity<>(person, HttpStatus.OK);
    }
    @GetMapping("/findEmail/{email}")
    public ResponseEntity <Person> getPersonByEmail(@PathVariable("email")String email){
        Person person = personsService.findPersonByEmail(email);
        return  new ResponseEntity<>(person, HttpStatus.OK);
    }
    @GetMapping("/findUsername/{username}")
    public ResponseEntity <Person> getPersonByUsername(@PathVariable("username")String username){
        Person person = personsService.findPersonByUsername(username);
        return  new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Person> addHomework(@RequestBody Person newperson){
        Person person = personsService.addPerson(newperson);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Person> updateHomework(@RequestBody Person person){
        Person personupdate = personsService.updatePerson(person);
        return new ResponseEntity<>(personupdate, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userID}")
    public ResponseEntity<?> deleteHomework(@PathVariable("userID") Long userID){
        personsService.deletePerson(userID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
