### 快速开始

本地安装nacos
去 [GitHub](https://github.com/alibaba/nacos/releases/tag/1.4.1) 下载安装包，并将其解压到你想要的目录下（例如：`D:\Program Files\nacos\bin`）。
修改 `D:\Program Files\nacos\bin\startup.cmd` 文件，在本地开发时将 `MODE` 设置为 `"standalone"`，然后双击 `D:\Program Files\nacos\bin\startup.cmd` 启动 nacos。
启动后，会弹出一个命令窗口，其中会输出 nacos 的启动地址，例如：`http://192.168.23.1:8848/nacos/index.html`。
默认的账号和密码为：

- 账号：nacos
- 密码：nacos

Nacos 配置中心
请参考 [Nacos 配置中心文档](https://github.com/alibaba/spring-cloud-alibaba/wiki/Nacos-config)。

给 nacos 配置数据源
编辑 `D:\Program Files\nacos\conf\application.properties` 文件，在以下配置中开启指定网络配置，配置示例如下：

```
spring.datasource.platform=mysql
db.num=1
db.url.0=jdbc:mysql://127.0.0.1:3307/nacos?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=UTC
db.user.0=root
db.password.0=123456
```



执行 `nacos.sql` 脚本
执行位于 `/数据脚本/nacos/nacos.sql` 的脚本。

### 提交规范

在提交代码时，请在 commit message 前面添加以下前缀来标识不同的操作：

- 添加新功能：Add:
- 修复错误：Fix:
- 更新现有功能：Update:
- 移除功能: Remove:

### 开发规范

#### 接口规范

请参考以下接口规范：

GET http://localhost:8080/admin/user

- 查询用户

POST http://localhost:8080/admin/user

- 新增用户

PUT http://localhost:8080/admin/user

- 更新用户（完全更新所有字段），或使用 PATCH 方法进行部分字段更新

DELETE http://localhost:8080/admin/user

- 删除用户

以下是一些建议的 URI 命名规范：

- URI 应该只包含名词，不要包含动词，使用小写字母、数字和下划线来区分多个单词。
- 资源的路径应该从根到子逐级命名，例如：
  - `/{resources}/{resource_id}/{sub_resources}/{sub_resource_id}/{sub_resource_property}`
- 在某些情况下，如果使用标准的 RESTful