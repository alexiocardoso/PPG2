package pt.ipleiria.ppg.model;

import java.io.Serializable;

public class Task implements Serializable {

    private int id;
    private String title;
    private String description;
    private int value;
    private int validateNumber;
    private int order;

    //Construtor
    public Task (String title, String description, int value, int validateNumber, int order){

        this.title = title;
        this.description = description;
        this.value = value;
        this.validateNumber = validateNumber;
        this.order = order;
        this.id = title.hashCode() * value * 69;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValidateNumber() {
        return validateNumber;
    }

    public void setValidateNumber(int validateNumber) {
        this.validateNumber = validateNumber;
    }

    @Override
    public String toString() {
        return  "Title: " + title +
                "\nDescription: " + description +
                "\nValue:" + value +
                "\1Order:" + order;
    }
}
