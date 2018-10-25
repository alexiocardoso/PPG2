package pt.ipleiria.ppg.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Game implements Serializable {
    private ArrayList<Task> tasks;
    private int id;
    private String title;
    private String description;
    private String author;
    private Date lastDate;
    private int duration;

    public Game( String title, String description, String author, int duration) {
        this.tasks = new ArrayList<>();
        this.title = title;
        this.description = description;
        this.author = author;
        this.duration = duration;
        this.id = title.hashCode() * author.hashCode() * 69;
        this.lastDate = Calendar.getInstance().getTime();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Title: " + title +
                "\nDescription: " + description;
    }
}
