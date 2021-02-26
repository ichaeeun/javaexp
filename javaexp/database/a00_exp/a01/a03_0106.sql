/*
[데이터베이스]
[하] 1. self 조인이란 무엇인가? 개념을 기술하세요.
		하나의 테이블안에서 컬럼끼리 연관관계가 있어 조인하는 것을 말한다. 
[중] 2. company테이블을 만들고 아래와 같은 직책과 상위 관리자를 만들어 
         @@@님의 현재 직잭은 @@이고 직속상관은 @@@이며 @@직책에 있다. 출력하세요.
*/
	CREATE TABLE company(
		name varchar2(30),
		job varchar2(20),
		no1 NUMBER,
		mgrno number
	);	
INSERT INTO company values('홍길동','영업직',1,2);
INSERT INTO company values('김길동','인사',2,3);
INSERT INTO company values('강길동','개발',3,5);
INSERT INTO company values('이길동','영업직',4,5); 
INSERT INTO company VALUES('박길동','개발',5,1);
SELECT * FROM company;
SELECT a.name||'님의 현재 직책은 '||a.job||'이고 직속상관은 '||b.name||'이며 '||b.job||'직책에 있다.' show
FROM company a, company b
WHERE a.mgrno = b.no1;

/*
[하] 3. sub query란 무엇인가? 기본 예제를 통해 개념을 설명하세요.
	하나의 sql명령문의 결과를 이를 포함하고 있는 상위 sql 명령문에 전달하기 위해 
 	두개 이상의 sql명령문의 상위 sql명령문과 연결하여 처리하는 방법을 말한다. 
 	select * from emp where deptno in (select deptno from emp where ename='ALLEN');
[하] 4. 단일행과 다중행 subquery의 차이점은 무엇인가 기술하세요.
	단일행 subquery는 하나의 행 만을 검색해서 메인쿼리에 반환하는 질의문을 말한단. 
	=, <=, <> 와 같은 연산자를 사용한다. 
	다중행 subquery는 서브쿼리에서 실행한 결과값이 1행 이상일때 사용하는 쿼리로, 
	in, any, some, all, exist, not exist 와 같은 연산자를 사용한다. 
[중] 5. 1981년 1~2사분기에 입사한 사람 중에서 가장 급여가 높은 사람 
        보다 많은 사원의 정보를 출력하세요.
 */
SELECT * FROM emp 
WHERE sal>all( SELECT sal FROM emp 
WHERE to_char(hiredate,'YYYY')='1981' AND to_char(hiredate,'Q')IN('1','2') );

SELECT * FROM emp
WHERE sal>( SELECT max(sal) FROM emp 
WHERE to_char(hiredate,'YYYY')='1981' AND to_char(hiredate,'Q')IN('1','2') );


 /*
[하] 6. 다중행 subquery의 연산자에 대하여 차이점을 기술하세요.
	in : 결과값이 or 조건으로 처리해야할 필요가 있는 경우 활용된다. 
 	any, some: 결과값이 1개라도 있는 경우. min(조회데이터)과 동일 
 	all: 모든 결과값이 일치하는 경우. max(조회데이터)와 동일 
 	exist, not exist: 해당 sub query 값 존재하는 경우, 존재하지 않는 경우. 
*/  