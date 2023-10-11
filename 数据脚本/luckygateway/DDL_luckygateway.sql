create database luckygateway

use luckygateway;

CREATE TABLE `menu` (
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


CREATE TABLE `role_menu` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `role_id` varchar(50) DEFAULT NULL COMMENT '角色id',
  `menu_id` varchar(50) DEFAULT NULL COMMENT '菜单id',
  `is_valid` varchar(2) DEFAULT '1' COMMENT '是否有效，字典(0否；1是)，缺省值为1',
  `created_date` decimal(13,0) DEFAULT NULL COMMENT '创建时间',
  `modified_date` decimal(13,0) DEFAULT NULL COMMENT '最后修改时间',
  `deleted_date` decimal(13,0) DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色菜单关联表'


CREATE TABLE `role` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `type` varchar(10) DEFAULT NULL COMMENT '角色类型',
  `bz` varchar(500) DEFAULT NULL COMMENT '备注',
  `is_valid` varchar(2) DEFAULT '1' COMMENT '是否有效，字典(0否；1是)，缺省值为1',
  `created_date` decimal(13,0) DEFAULT NULL COMMENT '创建时间',
  `modified_date` decimal(13,0) DEFAULT NULL COMMENT '最后修改时间',
  `deleted_date` decimal(13,0) DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色信息表'

CREATE TABLE `user_role` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `role_id` varchar(50) DEFAULT NULL COMMENT '角色id',
  `user_id` varchar(50) DEFAULT NULL COMMENT '用户id',
  `is_valid` varchar(2) DEFAULT '1' COMMENT '是否有效，字典(0否；1是)，缺省值为1',
  `created_date` decimal(13,0) DEFAULT NULL COMMENT '创建时间',
  `modified_date` decimal(13,0) DEFAULT NULL COMMENT '最后修改时间',
  `deleted_date` decimal(13,0) DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色关联表'


CREATE TABLE `user` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `usertype` varchar(2) DEFAULT NULL COMMENT '用户类型，1： 普通用户；2：管理员',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名称，用于登陆',
  `sex` varchar(2) DEFAULT NULL COMMENT '性别',
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