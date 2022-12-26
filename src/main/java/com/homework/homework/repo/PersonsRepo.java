package com.homework.homework.repo;

import com.homework.homework.modle.Homework;
import com.homework.homework.modle.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonsRepo extends JpaRepository<Person, Long> {



    Optional<Person> findPersonByUserID(Long id);
    Optional<Person> findPersonByEmail(String email);
    Optional<Person> findPersonByUsername(String username);
    void deletePersonByUserID(Long id);
}
