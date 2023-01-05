package com.homework.homework;

import com.homework.homework.modle.Homework;
import com.homework.homework.modle.Person;
import com.homework.homework.sevice.PersonsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
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

    @GetMapping("/findLogin/{password}/{username}")
    public ResponseEntity <Person> getPersonByUsernamePassword(@PathVariable("password")String password, @PathVariable("username")String username) throws NoSuchAlgorithmException {
        Person person = personsService.findPersonByUsernameAndPassword(username ,generateHash(password,"SHA-256"));
        return  new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping("/findUsername/{username}")
    public ResponseEntity <Person> getPersonByUsername(@PathVariable("username")String username){
        Person person = personsService.findPersonByUsername(username);
        return  new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Person> addHomework(@RequestBody Person newperson) throws NoSuchAlgorithmException {
        newperson.setPassword(generateHash(newperson.getPassword(), "SHA-256"));


        Person person = personsService.addPerson(newperson);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Person> updateHomework(@RequestBody Person person) throws NoSuchAlgorithmException {
        person.setPassword(generateHash(person.getPassword(), "SHA-256"));
        Person personupdate = personsService.updatePerson(person);
        return new ResponseEntity<>(personupdate, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userID}")
    public ResponseEntity<?> deleteHomework(@PathVariable("userID") Long userID){
        personsService.deletePerson(userID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    private static String generateHash(String data, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm); digest.reset();
        byte [] hash = digest. digest ( data. getBytes ());
        return bytesToStringHex(hash);
    }
    private final static char[] hexArray = ",0123456789ABCDEF". toCharArray();
    public static String bytesToStringHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xff;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return  new String(hexChars);
        }
    }
