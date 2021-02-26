/*
 # 정규화 
 1. 데이터베이스 설계 시, 정규화를 통해 데이터의 중복과 이상현상을 사전에 방지할 수 있다. 
 2. 정규화의 주요 개념 
 	1) 이상현상 
 	2) 함수 종속성 
 3. 정규화 과정 
 	1) 제 1정규화
 	2) 제 2정규화
 	3) 제 3정규화
 ---------------------------
 	4) BCNF 정규화 
 	5) 제 4정규화
 	6) 제 5정규화 
 	
 # 이상현상 
 1. 잘못된 데이터베이스 설계는 이상현상을 발생하여, 
 	데이터의 중복과 잘못된 update 및 입력이 될 수 있다. 
 2. 종류 
 	1) 삽입이상: 데이터 입력 시 특정 속성에 해당하는 값이 
 		null로 입력되어 데이터의 낭비를 초래할 수 있다. 
 	2) 삭제이상: 데이터 row 단위 삭제 시 저장된 다른 정보까지 연쇄적으로 삭제되어, 
 		추후에 해당 정보를 확인할 수 없는 상황이 발생한다. 
 	3) 수정이상: 수정 시 중복된 데이터의 일부만 수정되어 데이터의 불일치 문제가 발생한다. 
*/
-- 이상현상 예제 확인 
CREATE TABLE Summer(
	sid NUMBER,
	class varchar2(20),
	price NUMBER 
);
INSERT INTO Summer values(100,'FORTRAN',20000);
INSERT INTO Summer values(150,'PASCAL',15000);
INSERT INTO Summer values(200,'C',10000);
SELECT * FROM Summer;
INSERT INTO Summer values(250,'FORTRAN',20000);
-- sql을 작성해보세요. 
-- 계절학기를 듣는 학생의 학번과 수강하는 과목은? 
SELECT sid,class FROM Summer;
-- C강좌의 수강료는? 
SELECT price FROM summer WHERE class='C';
-- 수강료가 가장 비싼 과목은? 
SELECT class, price FROM Summer WHERE price IN(SELECT max(PRICE) FROM Summer);
-- 계절학기를 듣는 학생 수와 수강료 총합은? 
SELECT count(*),sum(price) FROM Summer;

-- # 삭제이상의 예 
-- 1. 100번 학생의 계절학기 수강신청을 취소처리 sql 작성하세요. 
SELECT * FROM Summer;
DELETE FROM Summer
WHERE sid = 200;
-- 2. C 강좌의 수강료를 조회...?
-- 100번 학생을 삭제하는 순간 C강좌 정보와 수강료 정보까지 사라진다. 
-- 정규화 과정은 이와 같이 특정 정보를 삭제하더라도 연관된 다른 정보는 다시 볼 수 있게 하는 것을 말한다. 
-- ==> 삭제 이상을 보완한다. 

INSERT INTO summer values(200,'C',10000); -- 실습을 위해 다시 입력 

-- # 삽입 이상의 예 
-- 1. 계절학기에 새로운 자바 강좌를 수강료 25000원으로 개설하세요. 
INSERT INTO summer values(NULL,'JAVA',25000);
SELECT * FROM summer;
-- 수강인원 확인 
SELECT count(*) FROM summer;
-- row 단위의 튜플은 5이지만 수강인원은 sid를 기준으로 하여야 한다. 
SELECT count(sid) FROM summer;
SELECT count(*) FROM summer WHERE sid IS NOT NULL;
-- sid가 수강인원이 없을 때는 null로 비워져 있고, 통계치나 자료를 활용할고자할때 
-- 문제가 발생한다.  : 삽입이상 
-- 정규화 과정을 거치면 이와 같이 필요없는 null 데이터 처리되는 것을 방지할 수 있다. 
-- 입력이상은 학생정보나 과목정보를 입력할 때, 아직 입력되어 매핑되지 않는 
-- 정보는 null로 처리되어 있는 현상을 말한다. 



-- 다음 예제를 위해 250 FORTRAN 15000을 입력해주세요 
-- 다음 예제를 위해 100 FORTRAN 15000을 입력해주세요 
INSERT INTO summer values(250,'FORTRAN',15000);
INSERT INTO summer values(150,'FORTRAN',15000);
SELECT * FROM summer;
-- # 수정이상 현상 
-- 1) FORTRAN 강좌 (sid가 100) 수강료 수정 15000 으로 수정 처리하세요 
-- 특정한 사람의 수강료를 변경했는데, 다시 과목이 같지만 다른 수강료는 수정이 되지 못한것을 확인할 수 있다. 
-- 특정한 사람이라고 실수를 하더라도 과목의 수강료를 수정하면 다음부터 해당 수강료가 다 수정되게 수정요류를 발생 
-- 정규식에서는 방지할 수 있다. 
/*
 
 */
-- summer 테이블 조회하면 fortran강좌의 수강료가 한건만 수정처리 
SELECT * FROM summer;
-- update 구문을 이용해서 fortran, 100의 price를 15000으로 변경 
UPDATE summer 
	SET price=15000
	WHERE class='FORTRAN' AND sid=100;
-- 어떤 계정에서든지 fortran을 변경을 하면 fortran의 수강료가
-- 변경된 데이터로 처리가 되어야 하는데 불일치가 발생하고 있다. 수정이상으로 
-- 정규화가 필요로 하다. 
-- # 이와 같은 등록, 수정, 삭제의 이상현상을 벗어나기 위하여 
-- 테이블 정규화 과정을 처리하도록 하자 
-- 1. 다음단계 처리를 위해 원복. 
UPDATE summer 
	SET price=20000
	WHERE class='FORTRAN' AND sid=100;
SELECT * FROM summer;
-- 2. 테이블 분리로 과목별가격이 있는 테이블과 학번별로 수강클래스 분리하여 구성하자
--	1) 계절학기 강좌 수강료 확인 
SELECT class, price FROM summer; 
--	중복 내용 distinct 
SELECT DISTINCT class, price FROM summer ORDER BY class;
CREATE TABLE summerprice
AS SELECT DISTINCT class, price FROM summer ORDER BY class; 
SELECT * FROM summerprice;
-- 2) 학번별 수강클래스 테이블 생성 
SELECT sid, class FROM summer WHERE sid IS NOT NULL ORDER BY sid;

CREATE TABLE summerenroll
AS SELECT sid, class FROM summer WHERE sid IS NOT NULL ORDER BY sid;
SELECT * FROM summerenroll;

-- sql을 작성해보세요. 
-- 계절학기를 듣는 학생의 학번과 수강하는 과목은? 
SELECT * FROM summerenroll;
-- C강좌의 수강료는? 
SELECT * FROM summerprice WHERE class='C';
-- 수강료가 가장 비싼 과목은? 
SELECT class,price FROM summerprice WHERE price = (SELECT max(PRICE) FROM summerprice);
-- 계절학기를 듣는 학생 수와 수강료 총합은? 
SELECT count(*), sum(price)
FROM summerenroll a, summerprice b
WHERE a.class=b.class;

-- # 정규화 처리 후, 이상현상 확인 
-- 1. 삭제 이상 확인 
--		200번 학생의 계절학기 수강신청을 취소했을 때, 
-- 		해당 과목의 정보를 확인할 수 있는지 확인 
SELECT * FROM summerenroll WHERE sid=200;
DELETE FROM SUMMERENROLL 
WHERE sid =200;
SELECT * FROM summerenroll;
SELECT * FROM summerprice;
-- 2. 삽입 이상 확인 
--		계절학기 과목을 등록하더라도, 수강신청에 영향이 없게 처리 
--		
INSERT INTO summerprice values('JSP',23000);
SELECT * FROM summerprice;
SELECT * FROM summerenroll;
-- 테이블 분리로 정상적인 입력이 가능한 것을 알 수 있다. 
-- fortran 강좌의 수강료를 20000에서 15000으로 수정하고, 
-- 신청자들의 수강료를 확인해보세요 
UPDATE summerprice
SET price=15000
WHERE class='FORTRAN';
SELECT a.*, b.* 
FROM summerenroll a, summerprice b
WHERE a.class=b.class;

CREATE TABLE stud01(
	NO NUMBER(3),
	name varchar2(30),
	major varchar2(50),
	address varchar2(200),
	class varchar2(50),
	room varchar2(50)
);
INSERT INTO stud01 values(501,'박지성','컴퓨터과','영국 맨체스타','데이터베이스','공학관110');
INSERT INTO stud01 values(401,'김연아','체육학과','대한민 서울','데이터베이스','공학관110');
INSERT INTO stud01 values(402,'장미란','체육학과','대한민국 강원도','스포츠경역학','체육관103');
INSERT INTO stud01 values(502,'추신수','컴퓨터과','미국 클리블랜드','자료구조','공학관111');
INSERT INTO stud01 values(501,'박지성','컴퓨터과','영국 맨체스타','자료구조','공학관111');
INSERT INTO stud01 values(401,'김연아','체육학과','대한민국 서울','스포츠경역학','체육관103');

SELECT * FROM stud01;
-- 정규화를 위해 복사 테이블 만듬 
CREATE TABLE stud02 AS SELECT * FROM stud01;


-- 1. 등록 이상 : 학생만 등록을 하는데 수강과목과 강의실은 null이 되어있음. 
INSERT INTO stud01(NO, name, major, address) values(503,'손흥민','체육학과','영국 런던');
SELECT * FROM stud01;

-- 2. 수정 이상 : 데이터베이스 공학과 정보가 다 변경되지 않음. 
UPDATE stud01 
SET room='공학과109'	
WHERE NO=401 AND class='데이터베이스';
SELECT * FROM stud01;

-- 3. 삭제 이상 : 501, 502 수강자료구조 정보가 없어짐 
-- 학번의 특정 정보를 삭제하든지, class로 조건을 삭제하면 연결된 모든 
-- 정보가 삭제되어 삭제이상이 발생한다. 
DELETE 
FROM stud01 
WHERE NO in(501,502);
SELECT * FROM stud01;

-- 정규화 
SELECT * FROM stud02;
-- 학생테이블 
CREATE TABLE stud 
AS SELECT DISTINCT NO, name, major, address
FROM STUD02 
ORDER BY NO;
SELECT * FROM stud;

-- 강의테이블 
CREATE TABLE course 
AS 
SELECT 100 cno, a.*
FROM 
(SELECT DISTINCT class, room FROM stud02 ORDER BY class) a;
SELECT * FROM course;

-- 수강테이블 
CREATE TABLE course_reg(
	NO NUMBER,
	cno NUMBER
);
INSERT INTO course_reg values(501,100);
INSERT INTO course_reg values(401,100);
INSERT INTO course_reg values(402,101);
INSERT INTO course_reg values(502,102);
INSERT INTO course_reg values(501,102);
INSERT INTO course_reg values(401,101);
SELECT * FROM course_reg;
SELECT * FROM stud;
SELECT * FROM course;
-- 학생별 수강정보 출력 
SELECT a.name, c.class
FROM stud a, course_reg b, course c
WHERE a.NO=b.NO AND b.cno = c.cno;
-- 1. 등록이상 : 학생정보, 수강신청정보, 과목정보를 각 테이블에 
-- 				등록 시, 등록이상이 생기지 않는다. 
-- 2. 수정이상 : 학생정보가 수정, 수정신청정보 수정, 과목정보를 
-- 				수정하더라도 수정이상이 생기지 않는다. 
-- 3. 삭제이상 : 수강신청 정보가 삭제 되더라도 학생정보나 과목정보가 
-- 				삭제되지 않는다. 











































