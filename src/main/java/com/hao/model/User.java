package com.hao.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hao.util.CustomDateSerializer;

import java.util.Date;

/**
 * com.hao.model
 *
 * @author Hao
 * @version v1.0
 * @since 2018/2/10 9:22
 */
public class User {

    private int id;
    private String name;
    private int age;
    private String gender;

    @JsonSerialize(using = CustomDateSerializer.class)
    private Date birthday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", birthday=" + birthday +
                '}';
    }
}
