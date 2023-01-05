package com.homework.homework.modle;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;


@Entity
public class Homework implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private  Long homeworkID;
    private Long userID;
    private Long statusID;
    private Date dueDate;
    private Date addedDate;
    private boolean isDone;
    private String description;
    private String fach;

    public Homework(){}
    public Homework(Long userID, Date dueDate, boolean isDone, Long statusID, String description, String fach){
        this.setFach(fach);

        this.setStatusID(statusID);
        long miliseconds = System.currentTimeMillis();
        Date date = new Date(miliseconds);
        this.setAddedDate(date);
        this.setDueDate(dueDate);
        this.setDone(isDone);
        this.setDescription(description);
        this.setUserID(userID);
    }

    public Long getHomeworkID() {
        return homeworkID;
    }

    public void setHomeworkID(Long homeworkID) {
        this.homeworkID = homeworkID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getStatusID() {
        return statusID;
    }

    public void setStatusID(Long statusID) {
        this.statusID = statusID;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString(){
        return "Homework{" +
                "id=" +getHomeworkID().toString()+
                ", description='"+ getDescription().toString() + "'"+
                ", isDone='"+ isDone() + "'"+
                ", addedDate='"+ getAddedDate().toString() + "'"+
                ", dueDate='"+ getDueDate().toString() + "'"+
                ", statusID='"+ getStatusID().toString() + "'"+
                ", fach='"+ getFach().toString() + "'"+
                ", userID='"+ getUserID().toString() + "'"+
                "}";
    }

    public String getFach() {
        return fach;
    }

    public void setFach(String fach) {
        this.fach = fach;
    }
}
