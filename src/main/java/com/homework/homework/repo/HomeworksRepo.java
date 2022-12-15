package com.homework.homework.repo;

import com.homework.homework.modle.Homework;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface HomeworksRepo extends JpaRepository<Homework, Long> {
    void deleteHomeworkByHomeworkID(Long id);

    Optional<Homework> findHomeworkBydueDate(Date date);

    Optional<Homework> findHomeworkByHomeworkID(Long id);
}
