/*
[데이터베이스]
[하] 1. 설계의 정규화 과정에서 삽입,삭제,등록 이상이 무엇을 말하는지 기술하세요.
	1) 삽입이상: 데이터 입력 시 특정 속성에 해당하는 값이 
 		null로 입력되어 데이터의 낭비를 초래할 수 있다. 
 	2) 삭제이상: 데이터 row 단위 삭제 시 저장된 다른 정보까지 연쇄적으로 삭제되어, 
 		추후에 해당 정보를 확인할 수 없는 상황이 발생한다. 
 	3) 수정이상: 수정 시 중복된 데이터의 일부만 수정되어 데이터의 불일치 문제가 발생한다. 
[중] 2. 아래와 같은 데이터를 테이블로 만들고, 정규화 과정을 거친 테이블로 구성하세요.
    회원아이디  패스워드  회원명 구매할물건명  구매갯수  물건가격  재고량
    himan     7777   홍길동  사과        3      3000     27
    higirl    8888   신미나  사과        2      3000     25
*/
CREATE TABLE reg03(
	id varchar2(30),
	pass varchar2(30),
	name varchar2(30),
	pname varchar2(30),
	cnt NUMBER,
	price NUMBER,
	stock number
);
INSERT INTO reg03 values('himan','7777','홍길동','사과',3,3000,27);
INSERT INTO reg03 values('himan','7777','홍길동','바나나',4,4000,30);
INSERT INTO reg03 values('higirl','8888','신미나','사과',2,3000,25);
INSERT INTO reg03 values('higirl','8888','신미나','오렌지',3,2000,20);
SELECT * FROM reg03;

CREATE TABLE member01
AS SELECT DISTINCT id, pass, name 
FROM reg03;
SELECT * FROM member01;


CREATE TABLE prod01 AS
SELECT 1111 pid, pname,price,stock 		-- 물건테이블은 pid(key 컬럼이 필요하다) 	
FROM reg03								-- 재고량이 최종 내용이기에 group by로 min값을 사용한다.  
WHERE (pname, stock) IN (SELECT pname, min(stock) FROM reg03 GROUP BY pname);
SELECT * FROM prod01;


CREATE TABLE buy01(
	id varchar2(50),
	pid NUMBER,
	pcnt number
); 
-- 1001 바나나 
-- 1002 사과
-- 1003 오렌지 
SELECT id,pname,cnt FROM reg03;
INSERT INTO buy01 values('himan',1002,3);
INSERT INTO BUY01 values('higirl',1002,2);
INSERT INTO buy01 values('himan',1001,4);
INSERT INTO buy01 values('higirl',1003,3);

SELECT * FROM buy01;
SELECT a.name, b.pname, c.pcnt, b.stock
FROM member01 a, prod01 b, buy01 c
WHERE a.id = c.id AND b.pid = c.pid;







