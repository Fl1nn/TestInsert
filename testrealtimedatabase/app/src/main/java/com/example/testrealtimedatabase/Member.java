package com.example.testrealtimedatabase;
import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Member {
    private String name;
    private Integer age;
    private String phone;
    private Integer height;


    public Member()
    {

    }

    public Member(String name, Integer age, String phone, Integer height) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
