###Mybatis简单介绍
官网：https://pagehelper.github.io/docs/howtouse/
PageHelper：Mybatis的分页插件
###1.搭建项目
![image.png](https://upload-images.jianshu.io/upload_images/15706831-fed0ae90ff751cbd.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
###2.导入依赖
```
<dependencies>
    <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web -->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
      <version>2.1.8.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.mybatis.spring.boot</groupId>
      <artifactId>mybatis-spring-boot-starter</artifactId>
      <version>2.1.0</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.17</version>
    </dependency>
    <!--pagehelper-->
    <dependency>
      <groupId>com.github.pagehelper</groupId>
      <artifactId>pagehelper-spring-boot-starter</artifactId>
      <version>1.2.12</version>
    </dependency>
  </dependencies>
```
``如果已经是springboot项目，导入pagehelper-spring-boot-starter即可``
###3.application.properties配置
```
#端口号
server.port=8080
#日志级别
logging.level.root=info

#mysql连接信息
spring.datasource.url=jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=admin
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
#mybatis
mybatis.type-aliases-package=PageHelperDemo.bo
mybatis.mapper-locations=classpath:mapper/*.xml

#pagehelper
#helper-dialect：可以不用配置，分页插件会自动检测当前的数据库链接，自动选择合适的分页方式
pagehelper.helper-dialect=mysql
#reasonable：分页合理化参数，默认值为false，当该参数设置为 true 时，pageNum<=0 时会查询第一页， pageNum>pages（超过总数时），会查询最后一页
pagehelper.reasonable=true
```

###4.简单使用
```
public PageInfo<Student> select(int pageNum, int pageSize) {
        //设置分页参数，默认查询总数count
        PageHelper.startPage(pageNum, pageSize);
        //紧跟着的第一个select方法会被分页（分页插件会自动检测当前的数据库链接，自动选择合适的分页方式）
        return new PageInfo<>(studentMapper.select());
    }
```
#####项目结构
![image.png](https://upload-images.jianshu.io/upload_images/15706831-88448b6e76774323.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
####git下载地址
https://github.com/shizhenshuang123/Springboot-Mybatis-PageHelper
