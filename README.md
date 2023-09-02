### 快速开始

```
本地安装nacos
去github下载安装包
https://github.com/alibaba/nacos/releases/tag/1.4.1
解压到你想要的目录下，我的目录是D:\Program Files\nacos\bin
修改 D:\Program Files\nacos\bin\startup.cmd(本地开发，这个模式改为单机即可) 
set MODE="standalone"
双击D:\Program Files\nacos\bin\startup.cmd 启动 nacos
后它会启动一个命令窗口，里面有输出， 找到nacos的启动地址，我的是http://192.168.23.1:8848/nacos/index.html
默认账号：nacos
默认密码：nacos


Nacos 配置中心
https://github.com/alibaba/spring-cloud-alibaba/wiki/Nacos-config

给 nacos 配置数据源
D:\Program Files\nacos\conf\application.properties
开启以下配置
spring.datasource.platform=mysql
db.num=1
db.url.0=jdbc:mysql://127.0.0.1:3307/nacos?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=UTC
db.user.0=root
db.password.0=123456

执行/数据脚本/nacos/nacos.sql脚本
```

### 提交规范

```
提交代码时，需要加上以下前缀
添加新功能：
Add:

修复错误：
Fix:

更新现有功能：
Update:

移除功能:
Remove:
```

### 开发规范

#### 接口规范

```
https://blog.csdn.net/LMGD_/article/details/124371107

GET http://localhost:8080/admin/user （查询用户）
POST http://localhost:8080/admin/user （新增用户）
PUT http://localhost:8080/admin/user （更新用户，全部字段更新，patch部分字段更新）
DELETE http://localhost:8080/admin/user （删除用户）


URI 不能包含动词，只能是名词（命名名词的时候，要使用小写、数字及下划线来区分多个单词）。
资源的路径应该从根到子依次如下:
/{resources}/{resource_id}/{sub_resources}/{sub_resource_id}/{sub_resource_property}
【POST】 /v1/users/{user_id}/roles/{role_id} // 添加用户的角色
有的时候，当一个资源变化难以使用标准的 RESTful API 来命名，可以考虑使用一些特殊的 actions 命名。
/{resources}/{resource_id}/actions/{action}
【PUT】 /v1/users/{user_id}/password/actions/modify // 密码修改
```

