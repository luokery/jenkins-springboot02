INSERT INTO TBL_ACCOUNT_TYPE (ACCOUNT_TYPE_ID,ACCOUNT_TYPE_NAME,RECORD_STATUS,CREATE_TIME,LAST_UPDATE_TIME) VALUES 
('1001','用户','1001','2020-09-10 00:00:00.000','2020-09-10 00:00:00.000')
,('1002','普通会员','1001','2020-09-10 00:00:00.000','2020-09-10 00:00:00.000')
,('1003','VIP','1001','2020-09-10 00:00:00.000','2020-09-10 00:00:00.000')
,('1004','SVIP','1001','2020-09-10 00:00:00.000','2020-09-10 00:00:00.000')
;

INSERT INTO TBL_USER (USER_ID, ACCOUNT_TYPE_ID, USER_NAME, NICK_NAME, PASSWORD, SALT, PROFILE_PHOTO, REAL_NAME, TELEPHONE, EMAIL, COMPANY_NAME, JOB_TITLE, EXPIRY_DATE, RECORD_STATUS, CREATE_TIME, LAST_UPDATE_TIME) 
VALUES('4fa2b8be386045cb', '1004', 'admin', 'admin', '1C1DD60DB5D13F56C5C7BB4BDD002ED1', 'eade0491', 'https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/default/head_img/13.jpeg', NULL, '13797096073', NULL, NULL, NULL, NULL, '1001', '2020-09-25 20:41:49.000', '2020-09-25 20:41:49.000');


