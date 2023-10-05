
-- root 로 접속

-- pes 사용자계정 생성
create user 'pes'@'localhost' identified by '1234';


-- pes가 사용하는 DB(Schema) 생성
create database pesdb;

-- pes에게 pesdb 권한 부여
grant all privileges on pesdb.* to 'pes'@'localhost' with grant option;

-- pes에게 파일 처리권한 부여
grant file on *.* to 'pes'@'localhost';



-- 회원가입 테이블
create table register (
  id varchar(20),
  userPW varchar(20),
  userName varchar(20),
  PRIMARY KEY (id)
) CHARSET=utf8;

desc register;

select * from register where id ='ㅁ';
select * from register;

insert into register (id,userPW,username) values ('sun010331','pqnajn1541!','이영선');

insert into register (id,userPW,username) values ('a','a','이영선');
drop table register;

-- OCR 임시 저장 테이블


CREATE TABLE foodlist (
  no INT AUTO_INCREMENT PRIMARY KEY,
  id VARCHAR(20),
  foodname VARCHAR(30),
  buydate date,
  expirydate date
) CHARSET=utf8;

desc foodlist;

select * from foodlist;
delete  from foodlist;
drop table foodlist;
ALTER TABLE foodlist AUTO_INCREMENT = 1; 

-- 데이터 복사 코드
INSERT INTO food (id,foodname,buydate,expirydate)
	SELECT fl.id, fl.foodname, fl.buydate , fl.expirydate
FROM foodlist as fl
where fl.foodname = '대림';
-- OCR 사용자 전체 테이블

CREATE TABLE food (
  no INT AUTO_INCREMENT,
  id  varchar(20) NOT NULL,
  foodname CHAR(30) NOT NULL,
  buydate date,
  expirydate date,
  PRIMARY KEY (no,id)
) CHARSET=utf8;

drop table food;
select * from food;
delete  from food;
desc food;

INSERT INTO food (id,foodname)
VALUES
  ('0', 'apple1'),
  ('ys', 'banana'),
  ('jj', '고기'),
  ('jj', '나물무침'),
  ('jj', '산적'),
  ('abdk', '훈제오리'); 

delete from food where no = 19;

-- 그룹별로 AUTO_INCREMENT 값을 할당하는 UPDATE 문
UPDATE food a
JOIN (
  SELECT id, foodname, ROW_NUMBER() OVER (PARTITION BY id ORDER BY no) AS new_no
  FROM food
) AS subquery
ON a.id = subquery.id AND a.foodname = subquery.foodname
SET a.no = subquery.new_no;

-- 결과 조회
SELECT * FROM food where id = 'ys' ORDER BY id,no ;

drop table food;
select * from food;

ALTER TABLE food
DROP INDEX unique_foodname;

























