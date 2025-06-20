-- 创建库 可以换成自己的名字 需要修改将application.yml中的替换即可 jdbc:mysql://localhost:3306/zkg_user_manage?useUnicode=true&characterEncoding=UTF-8
create database if not exists zkg_user_manage;

-- 切换库
use zkg_user_manage;

-- 用户表 名字不要变

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                        `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                        `username` varchar(256) DEFAULT NULL COMMENT '用户昵称',
                        `userAccount` varchar(255) DEFAULT NULL,
                        `avatarUrl` varchar(1024) DEFAULT NULL COMMENT '用户头像',
                        `gender` tinyint(4) DEFAULT NULL COMMENT '用户性别',
                        `userPassword` varchar(512) DEFAULT NULL COMMENT '密码',
                        `phone` varchar(128) DEFAULT NULL COMMENT '电话',
                        `email` varchar(512) DEFAULT NULL COMMENT '邮箱',
                        `userStatus` int(11) NOT NULL DEFAULT '0' COMMENT '状态：0，正常',
                        `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                        `isDelete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4_unicode_ci COMMENT='用户表';