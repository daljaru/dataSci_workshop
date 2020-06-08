create table book(
isbn char(12) PRIMARY key,
title varchar(100) not null,
catalogue varchar(50) not null,
nation varchar(50),
publish_date date,
publisher varchar(100),
author varchar(100) not null,
price int(10) not null,
currency char(6),
description varchar(4000) 
)
