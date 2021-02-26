/*
[데이터베이스]
[하] 1. exists, not exists 연산자의 기능과 기본예제를 기술하세요.
	exists: 서브쿼리에 결과값이 있는지 여부를 확인해서 메인쿼리를 실행해준다. 
	--subquery 데이터 있을 때
		SELECT * FROM emp WHERE exists(SELECT * FROM emp WHERE comm IS NOT NULL);
	--subquery 데이터 없을 때 
		SELECT * FROM emp WHERE exists(SELECT * FROM emp WHERE deptno=40);
[하] 2. sql을 통해서 부서번호 40이 없을 때, 부서번호 10인 데이터를 조회하는 처리를 하세요.
*/
SELECT * FROM EMP 
WHERE NOT exists(SELECT * FROM emp WHERE deptno=40) AND deptno=10;
/*
[하] 3. 데이터의 단일행 입력 구문 2가지 형식과 예제를 통해 처리해 보세요.
		insert into 테이블명(컬럼1, 컬럼2, ...) values(데이터1, 데이터2 ...); 
 		insert into 테이블명 values(테이블 구조 순서에 따른 데이터1, 데이터2); 
*/
		SELECT * FROM emp01;
		INSERT INTO emp01(empno, job, mgr) values(5000,'사원',7782);
/*
[하] 4. 복사테이블 emp15(구조만 복사)를 만들고, ename/job의 크기를 50으로 변경하고, 
        데이터를 입력처리(전체데이터입력, 부분컬럼입력) 하세요
 */
 	CREATE TABLE emp15 AS SELECT * FROM emp WHERE 1=0;
 	SELECT * FROM emp15;
 	INSERT INTO emp15 values(5000,'홍길동','사원',7782,sysdate,3000,200,20);
 	INSERT INTO emp15(empno,ename,JOB) values(5001,'가길동','대리');
 /*
[하] 5. 다중행 insert 형식을 기술하세요.
	 insert into 테이블명 
	 subquery;
	 INSERT INTO emp15
	 SELECT * FROM emp10 
	 WHERE empno BETWEEN 5001 AND 6000;
	 insert all|first : all(전체), first(첫번째 데이터) 
 	 into 테이블(컬럼명1, 컬럼명2, 컬럼명3) values(subquery에서 온 데이터1, 데이터2, 데이터3)
   	 into 테이블(컬럼명1, 컬럼명2, 컬럼명3) values(subquery에서 온 데이터1, 데이터2, 데이터3)
 	 into 테이블(컬럼명1, 컬럼명2, 컬럼명3) values(subquery에서 온 데이터1, 데이터2, 데이터3)
 	 서브쿼리;
	 INSERT ALL 
	 into emp16(empno, ename, deptno) values(empno,ename,deptno)
	 into emp17(empno, ename, deptno) values(empno,ename,deptno)
	 into emp18(empno, ename, deptno) values(empno,ename,deptno)
	 SELECT empno, ename, deptno 
	 FROM emp10 
	 WHERE deptno=10; 
[중] 6. 부서별 최고급여의 구조와 데이터를 가진 복사 테이블 emp20을 만들고, emp20테이블에 subquery를 활용하여,
        부서번호 10 데이터를 입력하세요. 
        
        1) 테이블을 만들 때도 subquery 에 결과로 테이블과 데이터가 입력되어진다.  
  */

 -- sol
 	CREATE TABLE emp20 
 	AS SELECT deptno, max(SAL) SAL 
 	FROM EMP 
 	GROUP BY deptno; 
-- 테이블과 데이터를 만들기 위한 컬럼을 alias로 지정해주면 
-- 그 이름으로 테이블이 만들어진다. 
 	SELECT * FROM emp20;
 	INSERT INTO emp20
 	SELECT deptno, sal
 	FROM EMP e 
 	WHERE deptno=10;
 ----------------------------------------------------
  	CREATE TABLE emp20 
 	AS SELECT sal, deptno FROM emp WHERE 1=0;
 	SELECT * FROM emp20;
 	INSERT INTO emp20(sal,DEPTNO)
 	SELECT max(sal),deptno FROM emp GROUP BY deptno;
 	SELECT * FROM emp20;
 	INSERT INTO emp20 values(NULL,10);
 	
 /*
[하] 7. emp21,emp22,emp23 테이블을 만들고, 급여 2000인 이상의 데이터를 각 테이블에 입력 처리하세요.
*/
 	CREATE TABLE emp21 AS SELECT * FROM emp WHERE 1=0;
 	CREATE TABLE emp22 AS SELECT * FROM emp WHERE 1=0;
 	CREATE TABLE emp23 AS SELECT * FROM emp WHERE 1=0;
 	INSERT ALL 
 	INTO emp21
 	INTO emp22
 	INTO emp23
 	SELECT * FROM emp 
 	WHERE sal>=2000;
 	
 	SELECT * FROM emp21;
 /*
[하] 8. 수정문의 기본형식을 기술하세요.
	update 테이블명 
 	set 컬럼명1=변경할데이터, 
 		컬럼명2=변경할데이터,
 		컬럼명3=변경할데이터
 	where 조건문 
[중] 9. emp10 테이블에서 입사일이 2000년도 이전 데이터에 대하여, 입사년도는 + 10(년)을 더하고, 
		급여는 +1000을 더하여 수정 처리하세요.
		-- 날짜데이터+1 : 1일이후, 
		-- ADD_MONTHS(날짜, 추가할 월단위): 날짜에서 추가할 월이후 날짜. 
*/ 
 	UPDATE EMP10 
 	SET hiredate=ADD_MONTHS(hiredate,120),
 		sal=sal+1000
 	WHERE to_number(to_char(hiredate,'YYYY'))<2000;
 	-- 묵시적 형변환 보다는 명시적으로 함수를 기술하는 것이 효과적이다. 
 	SELECT * FROM emp10;
 