package databaseengine.backend.model;

import java.sql.Date;

public class Student {
    private String name;
    private int id;
    private Date birthday;
    private String birthPlace;
    private String address;
    private String highSchool;
    private String category;

    // for creating new student
    public Student(String name, Date birthday, String birthPlace, String address, String highSchool, String category) {
        this.name = name;
        this.birthday = birthday;
        this.birthPlace = birthPlace;
        this.address = address;
        this.highSchool = highSchool;
        this.category = category;
    }

    // for updating existing student
    public Student(int id, String name, Date birthday, String birthPlace, String address, String highSchool, String category) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.birthPlace = birthPlace;
        this.address = address;
        this.highSchool = highSchool;
        this.category = category;
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public String getAddress() {
        return address;
    }

    public String getHighSchool() {
        return highSchool;
    }

    public String getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHighSchool(String highSchool) {
        this.highSchool = highSchool;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}