package com.homework.homework;

import com.homework.homework.modle.Homework;
import com.homework.homework.sevice.HomeworksService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/homework")
public class HomeworkResouce {
    private final HomeworksService homeworksService;

    public HomeworkResouce(HomeworksService homeworksService) {
        this.homeworksService = homeworksService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Homework>> getAllHomeworks(){
        List<Homework> homeworks = homeworksService.findAllHomeworks();
        return  new ResponseEntity<>(homeworks, HttpStatus.OK);
    }
    @GetMapping("/find/{userID}")
    public ResponseEntity<List<Homework>> getHomeworksByUserID(@PathVariable("userID")Long id){
        List<Homework> homeworks = (List<Homework>) homeworksService.findHomeworksByUserID(id);
        return  new ResponseEntity<>(homeworks, HttpStatus.OK);
    }

    @GetMapping("/find/{homeworkID}")
    public ResponseEntity<Homework> getHomeworksByHomeworkID(@PathVariable("homeworkID")Long id){
        Homework homework = homeworksService.findHomeworkByHomeworkID(id);
        return  new ResponseEntity<>(homework, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Homework> addHomework(@RequestBody Homework homework){
        Homework newHomework = homeworksService.addHomework(homework);
        return new ResponseEntity<>(newHomework, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Homework> updateHomework(@RequestBody Homework homework){
        Homework updateHomework = homeworksService.updateHomework(homework);
        return new ResponseEntity<>(updateHomework, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{homeworkID}")
    public ResponseEntity<?> deleteHomework(@PathVariable("homeworkID") Long homeworkID){
        homeworksService.deleteHomework(homeworkID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
