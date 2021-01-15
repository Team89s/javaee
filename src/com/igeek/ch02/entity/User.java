package com.igeek.ch02.entity;

import java.sql.Timestamp;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2021/1/15 11:05
 */
public class User {
    private Integer id;
    private String name;
    private String pwd;
    private String state;  // 状态  0未审核  1审核通过 2审核失败
    private Integer age;
    private String gender;
    private Timestamp birthday;
    private String pic;


    public User() {
    }

    public User(Integer id, String name, String pwd, String state, Integer age, String gender, Timestamp birthday, String pic) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.state = state;
        this.age = age;
        this.gender = gender;
        this.birthday = birthday;
        this.pic = pic;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 设置
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * 获取
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * 设置
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 获取
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return birthday
     */
    public Timestamp getBirthday() {
        return birthday;
    }

    /**
     * 设置
     * @param birthday
     */
    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取
     * @return pic
     */
    public String getPic() {
        return pic;
    }

    /**
     * 设置
     * @param pic
     */
    public void setPic(String pic) {
        this.pic = pic;
    }

    public String toString() {
        return "User{id = " + id + ", name = " + name + ", pwd = " + pwd + ", state = " + state + ", age = " + age + ", gender = " + gender + ", birthday = " + birthday + ", pic = " + pic + "}";
    }
}
