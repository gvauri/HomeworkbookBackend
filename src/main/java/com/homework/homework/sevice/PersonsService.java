package com.homework.homework.sevice;

import com.homework.homework.exception.HomeworkNotFoundException;
import com.homework.homework.modle.Person;
import com.homework.homework.repo.PersonsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonsService {
    private final PersonsRepo personsRepo;

    @Autowired
    public PersonsService(PersonsRepo personsRepo) {
        this.personsRepo = personsRepo;
    }
    public Person addPerson(Person person){
        return this.personsRepo.save(person);
    }
    public Person updatePerson(Person person){
        return this.personsRepo.save(person);
    }
    public void deletePerson(Long id){
        this.personsRepo.deletePersonByUserID(id);
    }
    public Person findPersonByUserID(long userID){
        return personsRepo.findPersonByUserID(userID)
                .orElseThrow(() -> new HomeworkNotFoundException("Homework by id"+ userID + "was not found."));

    }
    public Person findPersonByUsername(String username){
        return personsRepo.findPersonByUsername(username)
                .orElseThrow(() -> new HomeworkNotFoundException("Homework by id"+ username + "was not found."));

    }
    public Person findPersonByEmail(String email){
        return personsRepo.findPersonByEmail(email)
                .orElseThrow(() -> new HomeworkNotFoundException("Homework by id"+ email + "was not found."));
    }
}
