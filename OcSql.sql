
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


create table animals(
	grp varchar(20) not null,
	id mediumint not null auto_increment,
	name char(30) not null,
	primary key (id)
	)charset=utf8;

-- 그룹별 AUTO_INCREMENT 값을 초기화하기 위한 트리거 생성
delimiter //
create trigger reset_auto_increment
before insert on animals
for each row
begin
  declare max_id int;
  set max_id = (select max(id) from animals where grp = new.grp);
  if max_id is null then
    set new.id = 1;
  else
    set new.id = max_id + 1;
  end if;
end;
//
delimiter ;

-- 테이블에 데이터 추가
insert into animals (grp, name) values ('fish', 'Goldfish');
insert into animals (grp, name) values ('mammal', 'Dog');
insert into animals (grp, name) values ('bird', 'Parrot');

-- 확인
select * from animals;

insert into animals (grp,name) 
values('mammal','dog'),('mammal','cat'),('bird','penguin'),('fish','lax'),('mammal','whale'),('bird','ostrich');

drop table animals;
select * from animals;





























