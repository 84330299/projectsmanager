**项目说明** 
- 基于SpringBoot、MyBatis-plus等框架，开发的一套简单内容管理系统
- 官方文档：http://mp.baomidou.com
<br> 

**项目结构** 
```
projectsmanager
├─projects-api	   				API服务
│    ├─annotation  				注解相关
│    ├─config  	   				配置相关
│    ├─constant	   				常量相关
│    ├─dto	   	   				工具类DTO
│    ├─exception   				异常处理
│    ├─model	   				模型层核心
│    ├─utils	   				工具类相关
│    ├─web	   	   				接口提供相关
│    ├──aop	   					注解实现  
│    ├──controller   			前端控制器
│    ├──dto     				数据传输对象
│    ├──param   				普通传输对象
│    └─resources 
│        ├─mapper   			MyBatis文件
│        ├─statics  			静态资源含swaggerui
│        └─application.yml   	全局配置文件
│
├─projects-generator	   			生成工具(可优化)


```

<br>

 **技术选型：** 
- 核心框架：Spring Boot 2.0
- 持久层框架：MyBatis-plus
- 鉴权机制:JWT
- 数据库连接池：Druid 1.1
- 日志管理：SLF4J 1.7、LogBak

<br>

 **软件需求** 
- JDK1.8
- MySQL5.6+
- Maven3.0+

<br>

 **项目演示**
- 接口地址：http://127.0.0.1：8085/index.html

<br>
