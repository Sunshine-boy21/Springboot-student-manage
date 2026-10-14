package com.student.manager.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("class")
public class ClassEntity {
    @TableId
    private Integer id;
    private String className;
    private String major;
}
