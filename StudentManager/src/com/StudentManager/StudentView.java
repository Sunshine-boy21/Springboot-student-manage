package com.StudentManager;

import java.util.Scanner;

public class StudentView {
    Scanner sc = new Scanner(System.in);
    Student[] students = new Student[50];
    Student[] newStudents = new Student[students.length-1];
    int count = 0;

    public void start(){
        while (true){
            System.out.println("-----------学生管理系统------------");
            System.out.println("1 添加学生");
            System.out.println("2 修改学生");
            System.out.println("3 删除学生");
            System.out.println("4 查询学生");
            System.out.println("5 退出系统");
            System.out.println("请选择（1-5）");

            int num = sc.nextInt();
            System.out.println("---------------------------------");
            switch (num){
                case 1:
                    addStudent();
                    break;
                case 2:
                    updataStudent();
                    break;
                case 3:
                    detStudent();
                    break;
                case 4:
                    findStudent();
                    break;
                case 5:
                    int key = sc.nextInt();
                    if (key == 0){
                        return;
                    }else if (key == 9){
                        break;
                    }
            }

        }
    }
    private void addStudent(){
        System.out.println("请输入你要添加的学生学号：");
        int sid = sc.nextInt();
        System.out.println("请输入你要添加的学生姓名：");
        String sname = sc.next();
        System.out.println("请输入你要添加的学生年龄：");
        int age = sc.nextInt();
        System.out.println("请输入你要添加的学生性别：");
        String sex = sc.next();
        Student student = new Student(sid,sname,age,sex);
        students[count]=student;
        count++;
        System.out.println("添加成功！");
    }
    private void findStudent(){
        System.out.println("学号"+"\t"+"姓名"+"\t"+"年龄"+"\t"+"性别"+"\t");
        if(count==0){
            System.out.println("还没添加学生");
        }else{
            for(int i = 0;i<count;i++){
                System.out.println(students[i].getId()+"\t"+students[i].getSname()+"\t"+students[i].getAge()+"\t"+students[i].getSex()+"\t");
            }
        }
    }
    private void updataStudent(){
        System.out.println("请输入您要修改的学生学号：");
        int sid = sc.nextInt();
        int updataIndex = ArrayUtils.findIndexById(students,sid,count);
        System.out.println("请输入学生姓名：");
        String sname = sc.next();
        System.out.println("请输入学生年龄：");
        int age = sc.nextInt();
        System.out.println("请输入学生性别：");
        String sex = sc.next();
        Student student = new Student(sid,sname,age,sex);
        students[updataIndex] = student;
        System.out.println("修改成功！");
    }
    private void detStudent(){
        System.out.println("请输入要删除的学生学号：");
        int sid = sc.nextInt();
        int removeindex = ArrayUtils.findIndexById(students,sid,count);
        System.arraycopy(students,0,newStudents,0,removeindex);
        System.arraycopy(students,removeindex+1,newStudents,removeindex,students.length-removeindex-1);
        students = newStudents;
        count--;
        System.out.println("删除成功！");
    }
}
