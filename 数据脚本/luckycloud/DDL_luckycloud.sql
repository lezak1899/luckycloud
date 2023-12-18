create database luckycloud;

use luckycloud;

CREATE TABLE `lc_secure_invoke_record` (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
    `secure_invoke_json` json NOT NULL COMMENT '请求快照参数json',
    `status` tinyint(8) NOT NULL COMMENT '状态 1待执行 2已失败',
    `next_retry_time` datetime(3) NOT NULL COMMENT '下一次重试的时间',
    `retry_times` int(11) NOT NULL COMMENT '已经重试的次数',
    `max_retry_times` int(11) NOT NULL COMMENT '最大重试次数',
    `fail_reason` text COMMENT '执行失败的堆栈',
    `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '修改时间',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `idx_next_retry_time` (`next_retry_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=360 DEFAULT CHARSET=utf8mb4 COMMENT='本地消息表'


CREATE TABLE `lc_menu` (
    `id` varchar(50) NOT NULL COMMENT '主键',
    `f_id` varchar(50) DEFAULT NULL COMMENT '父级菜单id',
    `name` varchar(100) DEFAULT NULL COMMENT '菜单名称',
    `url` varchar(100) DEFAULT NULL COMMENT '菜单地址',
    `icon` varchar(50) DEFAULT NULL COMMENT '图标',
    `order` int(11) DEFAULT NULL COMMENT '排序号',
    `description` varchar(500) DEFAULT NULL COMMENT '备注',
    `is_valid` varchar(2) DEFAULT '1' COMMENT '是否有效，字典(0否；1是)，缺省值为1',
    `created_date` decimal(13,0) DEFAULT NULL COMMENT '创建时间',
    `modified_date` decimal(13,0) DEFAULT NULL COMMENT '最后修改时间',
    `deleted_date` decimal(13,0) DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='菜单信息表'


CREATE TABLE `lc_role_menu` (
     `id` varchar(50) NOT NULL COMMENT '主键',
     `role_id` varchar(50) DEFAULT NULL COMMENT '角色id',
     `menu_id` varchar(50) DEFAULT NULL COMMENT '菜单id',
     `is_valid` varchar(2) DEFAULT '1' COMMENT '是否有效，字典(0否；1是)，缺省值为1',
     `created_date` decimal(13,0) DEFAULT NULL COMMENT '创建时间',
     `modified_date` decimal(13,0) DEFAULT NULL COMMENT '最后修改时间',
     `deleted_date` decimal(13,0) DEFAULT NULL COMMENT '删除时间',
     PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色菜单关联表'


CREATE TABLE `lc_role` (
    `id` varchar(50) NOT NULL COMMENT '主键',
    `name` varchar(100) DEFAULT NULL COMMENT '角色名称',
    `type` varchar(10) DEFAULT NULL COMMENT '角色类型',
    `comment` varchar(500) DEFAULT NULL COMMENT '备注',
    `is_valid` varchar(2) DEFAULT '1' COMMENT '是否有效，字典(0否；1是)，缺省值为1',
    `created_date` decimal(13,0) DEFAULT NULL COMMENT '创建时间',
    `modified_date` decimal(13,0) DEFAULT NULL COMMENT '最后修改时间',
    `deleted_date` decimal(13,0) DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色信息表'

CREATE TABLE `lc_user_role` (
     `id` varchar(50) NOT NULL COMMENT '主键',
     `user_id` varchar(50) DEFAULT NULL COMMENT '用户id',
     `role_id` varchar(50) DEFAULT NULL COMMENT '角色id',
     `is_valid` varchar(2) DEFAULT '1' COMMENT '是否有效，字典(0否；1是)，缺省值为1',
     `created_date` decimal(13,0) DEFAULT NULL COMMENT '创建时间',
     `modified_date` decimal(13,0) DEFAULT NULL COMMENT '最后修改时间',
     `deleted_date` decimal(13,0) DEFAULT NULL COMMENT '删除时间',
     PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色关联表'


CREATE TABLE `lc_user` (
    `id` varchar(50) NOT NULL COMMENT '主键',
    `username` varchar(50) DEFAULT NULL COMMENT '用户名称，用于登陆',
    `gender` varchar(2) DEFAULT NULL COMMENT '性别',
    `password` varchar(50) DEFAULT NULL COMMENT '密码',
    `phone` varchar(11) DEFAULT NULL COMMENT '手机号码',
    `face_img` varchar(1000) DEFAULT NULL COMMENT '头像预览图',
    `face_img_whole` varchar(1000) DEFAULT NULL COMMENT '头像像完整图',
    `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
    `qrcode` varchar(500) DEFAULT NULL COMMENT '二维码',
    `plus_id` varchar(255) DEFAULT NULL COMMENT '设备id',
    `fun_signature` varchar(255) DEFAULT NULL COMMENT '个性签名',
    `last_login_date` decimal(13,0) DEFAULT NULL COMMENT '上一次登录时间',
    `last_login_location` varchar(50) DEFAULT NULL COMMENT '上一次登录地点',
    `last_login_equipment` varchar(255) DEFAULT NULL COMMENT '上一次登录设备信息',
    `is_valid` varchar(2) DEFAULT '1' COMMENT '是否有效，字典(0否；1是)，缺省值为1',
    `created_date` decimal(13,0) DEFAULT NULL,
    `modified_date` decimal(13,0) DEFAULT NULL COMMENT '最后修改时间',
    `deleted_date` decimal(13,0) DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`),
    KEY `index_username` (`username`),
    KEY `index_phone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表'