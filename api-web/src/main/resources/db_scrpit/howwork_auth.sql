DROP TABLE IF EXISTS `sm_org`;
CREATE TABLE `sm_org`
(
    `id`               bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '组织ID',
    `name`             varchar(200) NOT NULL COMMENT '组织名称',
    `code`             varchar(100) NOT NULL COMMENT '组织编码',
    `incode`           varchar(50)  NOT NULL COMMENT '组织树形内码',
    `memo`             varchar(500)          DEFAULT NULL COMMENT '备注',
    `status`           tinyint(1)   NOT NULL default 1 COMMENT '状态',
    `parent_id`        bigint(20)   NOT NULL COMMENT '父节点ID',
    `type`             tinyint(2)   NOT NULL COMMENT '类型',
    `principal`        varchar(100) COMMENT '负责人',
    `phone`            varchar(50) COMMENT '负责人电话',
    `sq`               int(5)       NOT NULL COMMENT '排序字段',
    `create_time`      datetime     NOT NULL COMMENT '创建时间',
    `create_user`      bigint(20)   NOT NULL COMMENT '创建人',
    `update_time`      datetime              DEFAULT NULL COMMENT '更新时间',
    `update_user`      bigint(20)            DEFAULT NULL COMMENT '更新人',
    `ts`               timestamp(3)    NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '时间戳',
    `is_delete`        tinyint(1)   NOT NULL default 0 COMMENT '删除标志',

    PRIMARY KEY (`id`)
) ENGINE = InnoDB  DEFAULT CHARSET = utf8 COMMENT '组织机构';


DROP TABLE IF EXISTS `sm_role`;
CREATE TABLE `sm_role`
(
    `id`               bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name`             varchar(200) NOT NULL COMMENT '角色名称',
    `type`             tinyint(1)   NOT NULL COMMENT '角色类型',
    `code`             varchar(100) NOT NULL COMMENT '角色编码',
    `status`           tinyint(1)   NOT NULL default 0 COMMENT '状态',
    `memo`             varchar(500)          DEFAULT NULL COMMENT '备注',
    `is_delete`        tinyint(1)   NOT NULL COMMENT '删除标志',
    `ts`               timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '时间戳',
    `create_time`      datetime     NOT NULL COMMENT '创建时间',
    `create_user`      bigint(20)   NOT NULL COMMENT '创建人',
    `update_time`      datetime              DEFAULT NULL COMMENT '更新时间',
    `update_user`      bigint(20)            DEFAULT NULL COMMENT '更新人',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT '角色';

DROP TABLE IF EXISTS `sm_user`;
CREATE TABLE `sm_user`
(
    `id`               bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '主键',
    `is_delete`        tinyint(1)   NOT NULL COMMENT '删除标志',
    `ts`               timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '时间戳',
    `create_time`      datetime     NOT NULL COMMENT '创建时间',
    `create_user`      bigint(20)   NOT NULL COMMENT '创建人',
    `update_time`      datetime              DEFAULT NULL COMMENT '更新时间',
    `update_user`      bigint(20)            DEFAULT NULL COMMENT '更新人',
    `status`           tinyint(1)   NOT NULL default 0 COMMENT '状态',
    `code`             varchar(100) NOT NULL COMMENT '员工编码',
    `name`             varchar(50)  NOT NULL COMMENT '员工姓名',
    `phone`            varchar(20) COMMENT '手机号',
    `mail`             varchar(200) COMMENT '邮箱',
    `avatar_href`      varchar(200)          DEFAULT NULL COMMENT '头像',
    `org_id`           bigint(20) COMMENT '组织ID',
    `role_id`          bigint(20)            DEFAULT NULL COMMENT '角色ID',
    `memo`             varchar(500)          DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT '用户';

DROP TABLE IF EXISTS `sm_menu`;
CREATE TABLE `sm_menu`
(
    `id`               bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '主键',
    `is_delete`        tinyint(1)   NOT NULL COMMENT '删除标志',
    `ts`               timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '时间戳',
    `create_time`      datetime     NOT NULL COMMENT '创建时间',
    `create_user`      bigint(20)   NOT NULL COMMENT '创建人',
    `update_time`      datetime              DEFAULT NULL COMMENT '更新时间',
    `update_user`      bigint(20)            DEFAULT NULL COMMENT '更新人',
    `status`           tinyint(1)   NOT NULL default 0 COMMENT '状态',
    `memo`             varchar(500)          DEFAULT NULL COMMENT '备注',
    `name`             varchar(200) NOT NULL COMMENT '菜单名称',
    `code`             varchar(100) NOT NULL COMMENT '菜单编码',
    `incode`           varchar(100) NOT NULL COMMENT '内码',
    `parent_id`        bigint(20)   NOT NULL COMMENT '父节点',
    `sq`               int(5)       NOT NULL COMMENT '排序',
    `href`             varchar(200) NOT NULL COMMENT '菜单链接',
    `icon`             varchar(100) NOT NULL COMMENT '菜单icon',
    `component`        varchar(100) COMMENT '对应组件名',
    `type`             tinyint(1)   NOT NULL COMMENT '菜单类型',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT '菜单';

DROP TABLE IF EXISTS `sm_permission`;
CREATE TABLE `sm_permission`
(
    `id`               bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '主键',
    `is_delete`        tinyint(1)   NOT NULL COMMENT '删除标志',
    `ts`               timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '时间戳',
    `create_time`      datetime     NOT NULL COMMENT '创建时间',
    `create_user`      bigint(20)   NOT NULL COMMENT '创建人',
    `update_time`      datetime              DEFAULT NULL COMMENT '更新时间',
    `update_user`      bigint(20)            DEFAULT NULL COMMENT '更新人',
    `status`           tinyint(1)   NOT NULL default 0 COMMENT '状态',
    `memo`             varchar(500)          DEFAULT NULL COMMENT '备注',
    `role_id`          bigint(20)   NOT NULL COMMENT '角色ID',
    `menu_id`          bigint(20)   NOT NULL COMMENT '菜单ID',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1001
  DEFAULT CHARSET = utf8 COMMENT '角色菜单权限';

DROP TABLE IF EXISTS `sm_role_user`;
CREATE TABLE `sm_role_user`
(
    `id`               bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '主键',
    `is_delete`        tinyint(1)   NOT NULL COMMENT '删除标志',
    `ts`               timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '时间戳',
    `create_time`      datetime     NOT NULL COMMENT '创建时间',
    `create_user`      bigint(20)   NOT NULL COMMENT '创建人',
    `update_time`      datetime              DEFAULT NULL COMMENT '更新时间',
    `update_user`      bigint(20)            DEFAULT NULL COMMENT '更新人',
    `status`           tinyint(1)   NOT NULL default 0 COMMENT '状态',
    `role_id`          bigint(20)   NOT NULL COMMENT '角色ID',
    `user_id`          bigint(20)   NOT NULL COMMENT '用户ID',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT '用户关联角色';

DROP TABLE IF EXISTS `sm_account`;
CREATE TABLE `sm_account`
(
    `id`               bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '主键',
    `is_delete`        tinyint(1)   NOT NULL COMMENT '删除标志',
    `ts`               timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '时间戳',
    `create_time`      datetime     NOT NULL COMMENT '创建时间',
    `create_user`      bigint(20)   NOT NULL COMMENT '创建人',
    `update_time`      datetime              DEFAULT NULL COMMENT '更新时间',
    `update_user`      bigint(20)            DEFAULT NULL COMMENT '更新人',
    `status`           tinyint(1)   NOT NULL default 0 COMMENT '状态',
    `memo`             varchar(500)          DEFAULT NULL COMMENT '备注',
    `user_id`          bigint(20)            DEFAULT NULL COMMENT '用户ID',
    `username`         varchar(100) NOT NULL COMMENT '账号名称',
    `password`         varchar(100) NOT NULL COMMENT '账号密码',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1001
  DEFAULT CHARSET = utf8 COMMENT '账户';


INSERT INTO `leaf_alloc` VALUES ('sm_account', 1, 50, NULL, '2020-11-03 20:38:33');
INSERT INTO `leaf_alloc` VALUES ('sm_role_user', 1, 50, NULL, '2020-11-03 20:38:33');
INSERT INTO `leaf_alloc` VALUES ('sm_permission', 1, 50, NULL, '2020-11-03 20:38:33');
INSERT INTO `leaf_alloc` VALUES ('sm_menu', 1, 50, NULL, '2020-11-03 20:38:33');
INSERT INTO `leaf_alloc` VALUES ('sm_user', 1, 50, NULL, '2020-11-03 20:38:33');
INSERT INTO `leaf_alloc` VALUES ('sm_role', 1, 50, NULL, '2020-11-03 20:38:33');
INSERT INTO `leaf_alloc` VALUES ('sm_org', 1, 50, NULL, '2020-11-03 20:38:33');




