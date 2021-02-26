/*
[데이터베이스]
[하] 1. subquery를 통한 수정 처리 기본형식을 기술하세요 
	update 테이블명 
 	set 컬럼명1=변경할데이터, 
 		컬럼명2=변경할데이터,
 		컬럼명3=변경할데이터
 	where 조건문; 
 	set절에 subquery를 이용하여 수정한다. 
 	UPDATE EMP10 
	SET sal = (SELECT max(sal) FROM emp10 WHERE deptno=20)
	WHERE deptno=10;
[하] 2. job이 CLERK이고 부서번호가 20인 사람을 SAL와 COMM을 각각20% 인상
      처리 하세요.
 */
SELECT * FROM emp11;
UPDATE emp11 
SET sal = sal*1.2,
	comm= comm*1.2
WHERE job='CLERK' AND deptno=20;


/*
[하] 3.  comm이 null이거나 0인데이터를 sal의 15%로 comm으로 지정하고, 
      hiredate를  2000-01-01로 변경하세요.
 */
UPDATE emp11 
SET comm=sal*0.15,
	hiredate=to_date('2000-01-01','YYYY-MM-DD')
WHERE nvl(comm,0)=0;
SELECT * FROM emp11;
/*
[중] 4. emp21복사테이블을 만들고, 부서별 최고 급여자의 사원번호를 확인하고, 
        10=>20, 20=>30, 30 => 10으로 변경하고, 평균 급여로 변경
        처리하세요.
        10 - 7839
		20 - 7902
		30 - 7698 
 */

CREATE TABLE emp25 AS select * FROM emp;
SELECT * FROM emp25; 

-- 부서별 최고급여의 사원번호, 부서번호, 급여 
SELECT empno,sal,deptno FROM emp25 
WHERE sal IN(SELECT max(sal) FROM emp25 GROUP BY deptno);

-- subquery이용해서 한번에 처리. 
UPDATE emp25
SET deptno=decode(deptno,30,10,deptno+10),
	sal=(SELECT avg(SAL) FROM emp25)
WHERE sal IN (SELECT max(sal) FROM emp25 GROUP BY deptno);

-- subquery이용 한번에 처리 sol 
UPDATE emp25
SET deptno=decode(deptno,30,10,deptno+10),
	sal=(SELECT avg(SAL) FROM emp25)
WHERE empno in(SELECT empno FROM emp25 WHERE (deptno,sal) IN 
				(SELECT deptno,max(sal)FROM emp25 GROUP BY deptno));
/*
[하] 5. 삭제구분의 기본형식을 기술하세요
	delete 
	from 테이블명; 
	where 조건문; 
[하] 6. emp22복사 테이블 만들고, 부서별 최저 급여 데이터를 삭제 처리하세요.
*/
CREATE TABLE emp22 AS SELECT * FROM emp;
DELETE FROM EMP22 
WHERE 
sal=(SELECT min(SAL) FROM emp22 WHERE deptno=10 GROUP BY deptno)
OR sal=(SELECT min(SAL) FROM emp22 WHERE deptno=20 GROUP BY deptno)
OR sal=(SELECT min(SAL) FROM emp22 WHERE deptno=30 GROUP BY deptno);
SELECT * FROM emp22;

