package com.homework.homework.sevice;

import com.homework.homework.exception.HomeworkNotFoundException;
import com.homework.homework.modle.Homework;
import com.homework.homework.repo.HomeworksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class HomeworksService {
    private final HomeworksRepo homeworksRepo;

    @Autowired
    public HomeworksService(HomeworksRepo homeworksRepo) {
        this.homeworksRepo = homeworksRepo;
    }
    public Homework addHomework(Homework homework){
        return homeworksRepo.save(homework);
    }
    public List<Homework>findAllHomeworks(){
        return homeworksRepo.findAll();
    }

    public Homework updateHomework(Homework homework){
        return homeworksRepo.save(homework);
    }
    public void deleteHomework(Long id){
        homeworksRepo.deleteHomeworkByHomeworkID(id);
    }
    public Homework findHomeworkByDueDate(Date date){
        return homeworksRepo.findHomeworkBydueDate(date)
                        .orElseThrow(() -> new HomeworkNotFoundException("Homework by id"+ date + "was not found."));
    }
    public Homework findHomeworkByHomeworkID(Long id){
        return homeworksRepo.findHomeworkByHomeworkID(id)
                .orElseThrow(() -> new HomeworkNotFoundException("Homework by id"+ id + "was not found."));
    }
}
