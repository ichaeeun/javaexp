/*
 # 데이터 수정 
 1. update 명령문은 테이블에 저장된 데이터 수정을 위한 조작어이다. 
 2. 기본형식 
 	update 테이블명 
 	set 컬럼명1=변경할데이터, 
 		컬럼명2=변경할데이터,
 		컬럼명3=변경할데이터
 	where 조건문 
 3. 주의사항 
 	1) where 절을 생략하면 테이블의 모든 행이 수정된다. 
 	2) 조건문과 변경할 데이터부분을 subquery를 이용하여 처리할 수 있다. 
 	
*/
SELECT * FROM emp10;
-- 사원이름이 '홍만호'를 사원번호,직책, 관리자번호, 급여, 보너스, 부서번호 수정 처리 
UPDATE emp10 
SET empno=5005,
	mgr=7698,
	sal=3600,
	comm=500,
	deptno=40,
	ename='홍만호'
WHERE ename='강길동';
-- ex) 5003과 5004에 null로 된 데이터를 update 구문을 이용해서 
UPDATE emp10 
SET job='사원',
	MGR=7698,
	HIREDATE=to_date('2020/03/12','YYYY/MM/DD'),
	COMM =200
WHERE empno=5003;
UPDATE EMP10 
SET job='대리',
	hiredate=to_date('2020/04/23','YYYY/MM/DD')
WHERE empno=5004;
/*
 기존데이터에 추가하여 데이터를 수정할 때. 
 ex) 게시판의 조회수를 증갈처리 
 update board
 	set readcnt= readcnt+1
 	where no=25; 
 */
/*
 # subquery를 통한 수정 처리 
 1. update명령문에 set절에 서브쿼리를 이용하여 수정 처리하는 것을 말한다. 
 2. 다른 테이블이나 현재 테이블의 정보를 변경할 때 활용할 수 있다. 
 3. 변경할 컬럼의 타입과 갯수는 반드시 일치하여야 한다. 
 
 */
SELECT * FROM emp10;
-- 부서번호 10인 사원의 급여
SELECT sal FROM emp10
WHERE deptno=10; 
SELECT sal FROM emp10 WHERE deptno=20;
UPDATE EMP10 
SET sal = (SELECT max(sal) FROM emp10 WHERE deptno=20)
WHERE deptno=10;
-- ex) job이 salesman의 평균 급여를 사원번호 7499에 할당 
UPDATE emp10 
SET sal = (SELECT avg(SAL) FROM emp10 WHERE job='SALESMAN')
WHERE empno=7499;
SELECT sal FROM emp10 WHERE empno=7499;
-- 사원번호가 7369의 급여를 부서번호 30의 평균급여와 부서번호로 변경처리 

-- update구문의 subquery는 해당하는 컬럼에 맞는 하나의 결과이기에 
-- =(대입) 으로 처리한다. 
-- 1) 한개의 컬럼 set 컬럼1=(select 1개의 결과컬럼) 
-- 2) 한개이상의 컬럼 
--		set (컬럼1, .. 컬럼n) = (select n개의 결과 컬럼) 

SELECT deptno, avg(sal)
FROM emp10 
WHERE deptno=30
GROUP BY deptno;

UPDATE EMP10 
SET (deptno, sal) = (SELECT deptno, avg(sal)
						FROM emp10 
						WHERE deptno=30
						GROUP BY deptno)
WHERE empno=7369;
SELECT * FROM emp10 WHERE empno=7369;
-- ex) SALESMAN의 평균 급여를 사원번호 7566인 사람의 job과 급여를 수정처리 
UPDATE emp10 
SET (job, sal) = (SELECT job, avg(SAL) FROM emp10 WHERE job='SALESMAN' GROUP BY job)
WHERE empno=7566;
SELECT * FROM emp10 WHERE empno=7566;

/*
 # 삭제(delete)
 1. 행단위로 데이터를 삭제하는 구문을 말한다. 
 2. 기본 형식 
 	delete 
 	from 테이블명 
 	where 조건; 
 	행단위로 삭제가 되기 때문에 delete 구문 이하의 컬럼을 정할 필요가 없다. 
 */
-- 7369 데이터 삭제 처리 
DELETE FROM emp10 WHERE empno=7369;
SELECT * FROM emp10; 
-- subquery를 이용해서 10 부서번호의 평균값이하의 sal가 있는 사원정보를 삭제 처리 
CREATE TABLE emp02 AS SELECT * FROM emp;
-- ex) job이 clerk인 데이터를 삭제처리 
DELETE FROM emp02 WHERE job='CLERK';
SELECT * FROM emp02;
-- ex) 부서번호 30의 sal 평균을 기준으로 그 이하인 데이터 삭제처리 
DELETE FROM emp02
WHERE sal<=(SELECT avg(SAL) FROM emp02 WHERE deptno=30 GROUP BY deptno);
/*
 # merge
 1. 변경 내지 입력할 데이터의 구조가 같은 두 개의 테이블을 비교하여	
 	하나의 테이블로 합치기 위한 오라클에서 지원하는 데이터 조작어. 
 2. 조건문을 이용해서 해당 데이터의 특정한 컬럼값이 있으면 update구문 처리하고, 
 	데이터가 없으면 insert 구문을 처리한다. 
 3. 기본형식 
 	MERGE INTO 테이블명 
 	USING 테이블명 B 
 	ON A와 B의 특정한 컬럼비교 
 	WHEN MATCHED THEN: 두개의 테이블의 특정 컬럼에 데이터가 있을 때. 
 		 UPDATE SET: 수정 처리 
 	WHEN NOT MATCHED THEN 
 		 INSERT VALUES: 등록 처리 
 */
CREATE TABLE emp30
AS SELECT * FROM emp;
CREATE TABLE emp31
AS SELECT * FROM emp WHERE 1=0;
SELECT * FROM emp30;
-- 1) 두개의 테이블의 비교를 통해 입력하기 
MERGE INTO emp31 s 
USING emp30 t
ON (s.empno=t.empno)
WHEN MATCHED THEN 
	UPDATE SET 
			   s.ename=t.ename,
			   s.job=t.job,
			   s.sal=t.sal 
WHEN NOT MATCHED THEN 
	INSERT (s.empno, s.ename, s.sal, s.deptno)
	VALUES (t.empno, t.ename, t.sal, t.deptno);
SELECT * FROM emp31;
-- ON 부분에 있는 입력이나 수정처리의 기준이 되는 컬럼을 
-- update set 구문에 사용하지 못한다. 

-- 2) 가상의 테이블로 데이터 입력처리 
-- 8000,'홍길동'은 프로그램을 통해서 전달된 입력값. 
-- 해당 데이터의 key인 empno가 있으면 수정되고, 없으면 등록 처리되는 내용. 
MERGE INTO emp31 s
USING dual
on(s.empno=8001)
WHEN MATCHED THEN 
	UPDATE SET s.ename='마길동'
WHEN NOT MATCHED THEN 
	INSERT (s.empno,s.ename)
	VALUES (8001,'마길동');
SELECT * FROM emp31;
-- ex) emp32 테이블로 구조만 복사된 테이블을 만들고, 
-- 전체데이터 기준으로 수정/등록되게 3개정도 데이터를 입력/수정 테스트 
CREATE TABLE emp32 
AS SELECT * FROM emp WHERE 1=0;
SELECT * FROM emp32;

MERGE INTO emp32 s
USING dual
ON (s.empno=8003)
WHEN MATCHED THEN 
	UPDATE SET s.ename='하길동', s.job='사원', s.mgr=7999 
WHEN NOT MATCHED THEN 
	INSERT VALUES (8003,'하길동','사원',7999,sysdate,3000,100,10);
-- merge into emp32 에서 대상 테이블을 지정했기 때문에, 
-- insert 구문의 기본형식인 into테이블명을 지정하지 않아야한다. 

MERGE INTO emp32 s
USING dual
ON (s.empno=7566)
WHEN MATCHED THEN 
	UPDATE SET s.ename='오길동',
			   s.job='대리',
			   s.mgr=7999,
			   s.hiredate=sysdate,
			   s.sal=3000,
			   s.comm=100,
			   s.deptno=10
WHEN NOT MATCHED THEN 
	INSERT 
   VALUES (7566,'오길동','대리',7999,sysdate,3000,100,10);
 SELECT * FROM emp32;

-- emp33테이블을 구조만 복사한 테이블로 만들고, 
-- emp30기준이 되는 데이터 empno컬럼으로 사원명, 부서명, 입사일을 merge처리 하세요 
CREATE TABLE emp33 
AS SELECT * FROM emp WHERE 1=0;
MERGE INTO emp33 s 
USING emp30 t
ON (s.empno=t.empno)
WHEN MATCHED THEN 
	UPDATE SET s.ename='홍길동'
WHEN NOT MATCHED THEN 
	INSERT (s.ename,s.deptno,s.hiredate) values(t.ename,t.deptno,t.hiredate
);
SELECT * FROM emp33;
MERGE INTO emp33 s 
USING emp30 t
ON (s.empno=t.empno)
WHEN MATCHED THEN 
	UPDATE SET s.ename=t.ename,
				s.job=t.job
WHEN NOT MATCHED THEN 
	INSERT (s.ename,s.deptno,s.hiredate) values('홍길동',10,sysdate);





