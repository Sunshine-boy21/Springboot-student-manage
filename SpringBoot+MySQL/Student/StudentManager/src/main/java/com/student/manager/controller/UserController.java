package com.student.manager.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.student.manager.common.Result;
import com.student.manager.entity.User;
import com.student.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result<?> login(@RequestParam String username, @RequestParam String password){
        if(StrUtil.isBlank(username) || StrUtil.isBlank(password)){
            return Result.fail("用户名或密码不能为空");
        }
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername,username);
        User user = userService.getOne(wrapper);
        if(user == null){
            return Result.fail("用户不存在");
        }
        //MD5比对
        String md5Pwd = DigestUtil.md5Hex(password);
        if(!user.getPassword().equals(md5Pwd)){
            return Result.fail("密码错误");
        }
        return Result.success(user);
    }
}
