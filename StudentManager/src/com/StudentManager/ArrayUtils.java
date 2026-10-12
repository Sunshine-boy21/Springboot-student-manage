package com.StudentManager;

public class ArrayUtils {
    private ArrayUtils(){

    }
    public static int findIndexById(Student[] students,int sid,int count){
        for(int i=0;i<count;i++){
            if(sid == students[i].getId()){
                return i;
            }
        }
        return -1;
    }
}
