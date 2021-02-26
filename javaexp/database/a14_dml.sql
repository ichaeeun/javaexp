/*
 DML
 # Break the ice! 
 # 생각해봅시다. 
 1. 회원등록을 처리한다면, 실제 프로그램에서 어떤 과정을 거치면서 진행될까? 
 	요구사항을 정리하여, 저장할 데이터를 나열, data를 저장할 테이블을 만들고, 
 	사용할 sql(insert, sql)을 통해서 입력을 확인 
 	요구사항에 의해, 화면설계서 작성, html을 통해서 화면구현(form을 통해 전송할 페이지 지정) 
 	jsp를 통해서 받은 데이터를 java를 통해 데이터 입력 처리 
 	일때, insert구문을 통해서 데이터 입력 처리 
 2. 게시판의 리스트내용을 확인하고, 클릭시, 상세화면이 나오고, 수정/삭제 버튼을 통해서 
 	해당 게시물에 대한 변경과 삭제를 처리한다. - db에서 처리해주는 프로세스 무엇일까? 
 	수정/삭제 버튼 클릭 시 요청값으로 서버에 전달, jsp를 통해서 수정하는/삭제하는 객체를 통해서 
 	DB에 있는 내용을 수정/삭제 처리한다. 
 3. 위에 있는 화면에 데이터를 입력/수정/삭제 시, 네트웍상 문제가 발생하거나 잘못된 프로그램이 
 	사용에 의해서 정상적으로 처리되지 않았을 때, 어떤 처리과정이 필요할까? 
 	- 프로그래밍적으로 exception, database서버에서도 transaction 처리로 
 	rollback(원복)을 하여야 한다. dml을 처리할 때, 위와 같은 상황에서도 데이터의 신뢰성 확보를 
 	위해서 transaction처리(commit/rollback)를 한다. 
 # 학습목표 
 1. 데이터를 처리하는 항목 중에 DML이라는 개념을 이해한다. 
 2. 여러가지 DML의 기본 문법을 알고, 실제 프로그래밍에서 활용할 수 있다. 
 3. DML에서 단일 데이터 변경과 다중 데이터 변경 개념을 알고 활용할 수 있다. 
 4. subquery를 이용한 DML 처리를 할 수 있다. 
 5. transaction 개념을 알고 필요한 transaction을 처리할 수 있다. 
 
 # 목차 
 1. 데이터 조작어 
 2. 데이터 입력
 3. 데이터 수정 
 4. 데이터 삭제
 5. 트랜젝션 관리
 6. 기타 데이터 관리 
 
 # 데이터 조작어(Data Manipulation Language)
 1. 테이블에 새로운 데이터를 입력하거나 기존 데이터를 수정 또는 삭제하기 위한 명령어 
 2. 종류 
 	insert: 입력 처리 명령어
 	update: 수정 처리 명령어
 	delete: 삭제 처리 명령어
 	merge: 병합처리 명령어(논리적 테이블의 병합-수정과 동시에 입력) 
 3. 트랜잭션 
 	여러개의 명령문을 하나의 논리적인 작업단위로 처리하는 기능을 말한다. 
 	명령어 종류: commit(정상종료 확정), rollback(비정상종료 복구) 
 	ex) DB클라이언트가 접속해서 변경을 했을 때, 본인 계정으로만 
 		변경된 데이터가 보인다(다른 계정으로 접근하면 변경되지 않은 데이터가 보임). 
 		이때, commit 하는 순간 현재 클라이언트 뿐만 아니라 
 		다른 계정으로 접속하더라도 변경되게 처리된다. 
 
 # 데이터 입력 처리 
 1. 테이블에 데이터를 입력하기 위한 명령어 insert 구문을 말한다. 
 2. 입력방법 
 	1) 단일 행 입력: 한 번에 하나의 행을 테이블에 입력하는 구문
 	2) 다중 행 입력: 서브 쿼리(subquery)를 이용하여 한번에 여러 행을 동시에 입력하는 구문 
 3. 단일행 입력 방법	
 	1) 기본구문 
 		insert into 테이블명(컬럼1, 컬럼2, ...) values(데이터1, 데이터2 ...); 
 		insert into 테이블명 values(테이블 구조 순서에 따른 데이터1, 데이터2); 
*/
-- 복사테이블 만들기 
-- create table 테이블명 as select * from 테이블명; : 구조와 데이터 모두 복사해서 새로운 테이블 생성
-- create table 테이블명 as select * from 테이블명 where 1=0; : 구조만 복사해서 새로운 테이블 생성 
-- where 1=0 은 해당 sql을 실행했을때, false이기에 데이터는 보이지 않지만, 
-- 기본 컬럼구조는 보인다. 이 테이블 구조를 복사하게 한다. 
CREATE TABLE emp10 
AS SELECT * FROM emp;
SELECT * FROM emp10; -- ctrl+테이블명 클릭 
CREATE TABLE emp11 
AS SELECT * FROM emp WHERE 1=0;
SELECT * FROM emp11;
-- 기본 구조에서 데이터 입력하기. 
-- 단일 전체 데이터 입력 
ALTER TABLE emp10 modify ename varchar2(30);
ALTER TABLE emp10 MODIFY job varchar2(30);

SELECT * FROM emp10; 
-- sysdate: 현재 날짜/시간 입력
-- to_date('2021/01/01','YYYY/MM/DD'); 
-- select to_date('2021/01/01','YYYY/MM/DD') FROM dual;
INSERT INTO emp10 values(5000,'홍길동','사원',7902,sysdate,3000,100,10);
INSERT INTO emp10 values(5001,'신길동','대리',7902,to_date('2021/01/01','YYYY/MM/DD'),4000,200,20);

-- ex) emp10에 본인 이름과 생일로 데이터를 등록해보세요. 
INSERT INTO emp10 values(5002,'이채은','사원',7902,to_date('1995/02/26','YYYY/MM/DD'),5000,300,20);
INSERT INTO emp10(empno,ename,sal,deptno) 
			values(5003,'신철환',2500,40); 
-- ex) 사원이름, 직책, 입사일을 입력하세요. 
INSERT INTO emp10(ename,job,hiredate)
			values('강길동','대리',to_date('2013/03/12','YYYY/MM/DD'));
-- 해당 row에 다른 컬럼은 묵시적으로 null이 입력된다. 
SELECT * FROM emp10;
-- 명시적으로 null 입력 
INSERT INTO emp10 values(5004,'민현식',NULL,7902,NULL,3500,100,20);
/*
 # 다중행 입력 
 1. 데이터를 하나의 테이블에 여러 행을 한번에 입력하는 query를 말한다. 
 2. 형식 
 	1) insert 명령문에서 서브쿼리로 다른 테이블에서 조회해 와서 입력처리. 
 	2) insert 명령문에 의해 한번에 여러 행을 동시에 입력
 	3) 아래의 형식 
 		insert all 
 		first insert 
 */
-- subquery를 이용한 입력 
SELECT * FROM emp11; 
SELECT * FROM emp10
WHERE empno BETWEEN 5000 AND 6000;
/*
 insert into 테이블명 
 subquery;
 */
INSERT INTO emp11 
SELECT * FROM emp10 
WHERE empno BETWEEN 5000 AND 6000;
-- subquery의 갯수와 입력할 컬럼의 갯수가 동일할 때. 

-- ex) emp10의 구조만 복사된 복사테이블을 만들고, emp테이블에서 부서번호가 10인 데이터를 subquery에 입력. 
CREATE TABLE emp12 AS SELECT * FROM emp WHERE 1=0;
SELECT * FROM emp12;
INSERT INTO emp12 
SELECT * FROM emp WHERE deptno=10;
SELECT * FROM emp12;
/*
 # 다중행 입력 - insert all 명령어 
 1. 서브쿼리의 결과 집합을 조건 없이 여러 테이블에 동시에 입력 
 2. 형식 
 	insert all|first : all(전체), first(첫번째 데이터) 
 	into 테이블(컬럼명1, 컬럼명2, 컬럼명3) values(subquery에서 온 데이터1, 데이터2, 데이터3)
 	into 테이블(컬럼명1, 컬럼명2, 컬럼명3) values(subquery에서 온 데이터1, 데이터2, 데이터3)
 	into 테이블(컬럼명1, 컬럼명2, 컬럼명3) values(subquery에서 온 데이터1, 데이터2, 데이터3)
 	서브쿼리;
 */
CREATE TABLE emp16 AS SELECT * FROM emp10 WHERE 1=0;
CREATE TABLE emp17 AS SELECT * FROM emp10 WHERE 1=0;
CREATE TABLE emp18 AS SELECT * FROM emp10 WHERE 1=0;
SELECT * FROM emp16;
SELECT * FROM emp17;
SELECT * FROM emp18;
-- into emp16(컬럼명1, 컬럼명2, 컬럼명3) values(subquery에서 온 데이터1, 데이터2, 데이터3);
INSERT ALL 
into emp16(empno, ename, deptno) values(empno,ename,deptno)
into emp17(empno, ename, deptno) values(empno,ename,deptno)
into emp18(empno, ename, deptno) values(empno,ename,deptno)
SELECT empno, ename, deptno 
FROM emp10 
WHERE deptno=10; 


















