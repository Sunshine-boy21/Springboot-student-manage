package com.student.manager.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("student")
public class Student {
    @TableId
    private Integer id;
    private String stuNo;
    private String name;
    private String gender;
    private Integer age;
    private Integer classId;
    private String phone;
    private LocalDateTime createTime;
}
