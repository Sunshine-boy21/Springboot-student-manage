package com.StudentManager;

public class Student {

    private int sid;
    private String sname;
    private int age;
    private String sex;

    public Student(){

    }
    public Student(int sid,String sname,int age,String sex){
        this.sid = sid;
        this.sname = sname;
        this.age = age;
        this.sex = sex;
    }
    public int getId() {
        return sid;
    }

    public void setId(int id) {
        this.sid = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    }





