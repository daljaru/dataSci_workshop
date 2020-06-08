
CREATE TABLE USERINFO ( 
	userId			varchar(30)		primary key, 
	password		varchar(30)		NOT NULL,
	name			varchar(30)		NOT NULL,
	email			varchar(100)
);

INSERT INTO USERINFO VALUES('admin', 'admin', '관리자', 'admin@encore.com');
INSERT INTO USERINFO VALUES('java', 'java', '자바지기', 'java@encore.com');

commit;