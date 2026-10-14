# SpringBoot学生信息管理系统
## 📖项目简介
基于SpringBoot + MyBatis‑Plus开发的后端API项目，实现学生、班级信息的CRUD接口；采用Controller‑Service‑Mapper分层架构，统一返回结果封装，做参数校验，保障接口健壮性。

## 🛠技术栈
- 后端框架：SpringBoot 、MyBatis‑Plus
- 数据库：MySQL8.0
- 构建工具：Maven
- 开发工具：IDEA

## ⚙运行环境
JDK版本：JDK17
MySQL：8.0
Maven：3.8+

## 🚀启动步骤
1. 在MySQL中创建数据库 `student_db`，执行项目内sql脚本，生成student、class两张数据表
2. 修改yml配置文件，填写自己本地MySQL账号密码
3. 运行SpringBoot主启动类
4. 使用IDEA HTTP Client / Postman测试后端接口

## 📌核心接口
1. 新增学生：POST /student/add
2. 修改学生：PUT /student/update
3. 删除学生：DELETE /student/delete/{id}
4. 根据id查询学生：GET /student/{id}
5. 查询全部学生列表：GET /student/list
