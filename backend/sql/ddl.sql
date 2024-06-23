-- 创建库
create database if not exists api;

-- 切换库
use api;

-- 用户表
create table if not exists user
(
    id           bigint auto_increment comment 'id' primary key,
    userName     varchar(256)                           null comment '用户昵称',
    userAccount  varchar(256)                           not null comment '账号',
    userAvatar   varchar(1024)                          null comment '用户头像',
    gender       tinyint                                null comment '性别',
    userRole     varchar(256) default 'user'            not null comment '用户角色：user / admin',
    userPassword varchar(512)                           not null comment '密码',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除',
    constraint uni_userAccount
        unique (userAccount)
) comment '用户';

-- 接口信息表
create table if not exists api.`interface_info`
(
    `id` bigint not null auto_increment comment '主键' primary key,
    `name` varchar(256) not null comment '名称',
    `description` varchar(256) null comment '描述',
    `url` varchar(512) not null comment '接口地址',
    `requestHeader` text null comment '请求头',
    `responseHeader` text null comment '响应头',
    `status` int default 0 not null comment '接口状态（0-关闭，1-开启）',
    `method` varchar(256) not null comment '请求类型',
    `userId` bigint not null comment '创建人',
    `createTime` datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    `updateTime` datetime default CURRENT_TIMESTAMP not null on update
        CURRENT_TIMESTAMP comment '更新时间',
    `isDeleted` tinyint default 0 not null comment '是否删除(0-未删, 1-已删)'
) comment '接口信息';

insert into api.`interface_info` (`name`, `description`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`)
    values ('廖立轩', '脱颖而出', 'www.foster-larkin.co', '龙嘉懿', '秦天磊', 0, 'GET', 1718083101),
        ('曹明辉', '举一反三', 'www.tony-kiehn.com', '任擎苍', '陈凯瑞', 0, 'GET', 28978),
        ('金乐驹', '首当其冲', 'www.coleen-prosacco.net', '毛浩', '陆致远', 0, 'GET', 208),
        ('廖思', '来之不易', 'www.don-sipes.net', '梁彬', '白君浩', 0, 'GET', 470),
        ('董煜祺', '长治久安', 'www.terry-turner.co', '覃绍齐', '胡雪松', 0, 'GET', 611007),
        ('侯聪健', '精心设计', 'www.augustus-yost.info', '傅鸿煊', '潘鹏飞', 0, 'GET', 0),
        ('魏弘文', '玩忽职守', 'www.guadalupe-beatty.biz', '江梓晨', '魏思淼', 0, 'GET', 1162536022),
        ('于苑博', '各式各样', 'www.nolan-metz.net', '韦果', '金胤祥', 0, 'GET', 0),
        ('姚炫明', '翻天覆地', 'www.jodie-schultz.info', '许越彬', '毛晋鹏', 0, 'GET', 973),
        ('孙鑫鹏', '络绎不绝', 'www.liza-sporer.co', '孙彬', '傅鸿煊', 0, 'GET', 30308),
        ('唐展鹏', '铤而走险', 'www.hayden-purdy.co', '杨哲瀚', '陆凯瑞', 0, 'GET', 473462835),
        ('曹擎苍', '赞不绝口', 'www.phung-glover.org', '邱志泽', '张健雄', 0, 'GET', 32155653),
        ('夏烨霖', '哭笑不得', 'www.augustine-funk.org', '宋聪健', '郝鹏涛', 0, 'GET', 3964),
        ('董浩', '对症下药', 'www.erik-hamill.biz', '黎立果', '廖鹤轩', 0, 'GET', 2275),
        ('罗荣轩', '喜闻乐见', 'www.gia-hermann.biz', '韩煜城', '阎耀杰', 0, 'GET', 847),
        ('沈正豪', '统筹兼顾', 'www.isabella-reinger.io', '邓子轩', '廖伟诚', 0, 'GET', 997378602),
        ('任立果', '出人意料', 'www.geoffrey-koss.name', '覃浩然', '萧雨泽', 0, 'GET', 403),
        ('张炫明', '名不虚传', 'www.ellan-gleason.com', '黎正豪', '韦炎彬', 0, 'GET', 35127293),
        ('方雨泽', '衣食住行', 'www.wilton-walsh.biz', '黎越泽', '白远航', 0, 'GET', 62264),
        ('袁天翊', '卷土重来', 'www.lynetta-mclaughlin.info', '邹熠彤', '叶潇然', 0, 'GET', 9884455);
