package com.student.manager.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.student.manager.common.Result;
import com.student.manager.entity.Student;
import com.student.manager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //分页+模糊查询
    @GetMapping("/page")
    public Result<Page<Student>> page(
            @RequestParam(defaultValue = "1") Long pageNum,
            @RequestParam(defaultValue = "5") Long pageSize,
            @RequestParam(required = false) String name
    ){
        Page<Student> page = new Page<>(pageNum,pageSize);
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(name != null,Student::getName,name);
        Page<Student> studentPage = studentService.page(page,wrapper);
        return Result.success(studentPage);
    }

    //新增
    @PostMapping("/add")
    public Result<?> add(@RequestBody Student student){
        studentService.save(student);
        return Result.success();
    }

    //修改
    @PutMapping
    public Result<?> update(@RequestBody Student student){

        studentService.updateById(student);
        return Result.success();
    }
    //删除
    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Integer id){
        studentService.removeById(id);
        return Result.success();
    }
    //根据id查询
    @GetMapping("/{id}")
    public Result<Student> getById(@PathVariable Integer id){
        Student student = studentService.getById(id);
        return Result.success(student);
    }
    //查询全部
    @GetMapping("/list")
    public Result<List<Student>> list(){
        return Result.success(studentService.list());
    }
}
