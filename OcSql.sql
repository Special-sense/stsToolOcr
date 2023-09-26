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