drop table if exists TBL_ACCOUNT_TYPE;

/*==============================================================*/
/* Table: TBL_ACCOUNT_TYPE                                      */
/*==============================================================*/
create table TBL_ACCOUNT_TYPE
(
   ACCOUNT_TYPE_ID      char(4) not null comment '会员类型ID',
   ACCOUNT_TYPE_NAME    varchar(50) comment '会员类型名称',
   RECORD_STATUS        char(4) not null comment '记录状态',
   CREATE_TIME          datetime not null comment '创建时间',
   LAST_UPDATE_TIME     datetime not null comment '最后更新时间',
   primary key (ACCOUNT_TYPE_ID)
);

-- alter table TBL_ACCOUNT_TYPE comment '会员类型表';

drop table if exists TBL_USER;

/*==============================================================*/
/* Table: TBL_USER                                              */
/*==============================================================*/
create table TBL_USER
(
   USER_ID              char(16) not null comment '用户ID',
   ACCOUNT_TYPE_ID      char(4) comment '会员类型ID',
   USER_NAME            varchar(50) not null comment '用户名称',
   NICK_NAME            varchar(50) comment '用户昵称',
   PASSWORD             varchar(250) not null comment '用户密码',
   SALT                 char(8) not null comment '盐巴',
   PROFILE_PHOTO        varchar(250) comment '用户头像',
   REAL_NAME            varchar(50) comment '姓名',
   TELEPHONE            varchar(20) comment '手机号',
   EMAIL                varchar(250) comment '邮箱',
   COMPANY_NAME         varchar(500) comment '公司',
   JOB_TITLE            varchar(150) comment '职位',
   EXPIRY_DATE          datetime comment '有效期',
   RECORD_STATUS        char(4) not null comment '记录状态',
   CREATE_TIME          datetime not null comment '创建时间',
   LAST_UPDATE_TIME     datetime not null comment '最后更新时间',
   primary key (USER_ID)
);

-- alter table TBL_USER comment '用户表';

alter table TBL_USER add constraint FK_Relationship_3 foreign key (ACCOUNT_TYPE_ID)
      references TBL_ACCOUNT_TYPE (ACCOUNT_TYPE_ID) on delete restrict on update restrict;

