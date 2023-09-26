
-- root 로 접속

-- pes 사용자계정 생성
create user 'pes'@'localhost' identified by '1234';


-- pes가 사용하는 DB(Schema) 생성
create database pesdb;

-- pes에게 pesdb 권한 부여
grant all privileges on pesdb.* to 'pes'@'localhost' with grant option;

-- pes에게 파일 처리권한 부여
grant file on *.* to 'pes'@'localhost';

-- OCR 음식 테이블
create table food (
	no int auto_increment,
	id varchar(20),
    foodname char(30),
    date char (10),

    primary key(no)
    )charset=utf8;
    
drop table food;
desc food;
    
insert into food (id,foodname,date) value('ys','사과','2023-12-12');
insert into food (id,foodname,date) values('ys','멋쟁이토마토','2023-12-12');
select * from food;