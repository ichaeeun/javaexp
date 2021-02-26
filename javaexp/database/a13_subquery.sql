SELECT * FROM emp;
/*
 # 서브 쿼리 
 1. 하나의 sql명령문의 결과를 이를 포함하고 있는 상위 sql 명령문에 전달하기 위해 
 	두개 이상의 sql명령문의 상위 sql명령문과 연결하여 처리하는 방법을 말한다. 
 	
*/
-- 사원명 ALLEN의 직책과 같은 사원의 정보를 출력하세요 
SELECT * 
FROM EMP e 
WHERE job = (SELECT job FROM emp WHERE ename='ALLEN');
-- ex) SMITH 와 같은 부서번호를 가진 사원정보 출력 
SELECT * 
FROM emp 
WHERE deptno=(SELECT deptno FROM emp WHERE ename='SMITH');
-- ex) MARTIN의 급여보다 같거나 작은 급여를 가진 사원정보를 출력하세요 
SELECT * 
FROM emp 
WHERE sal<=(SELECT sal FROM emp WHERE ename='MARTIN'); 
/*
 # 단일행 서브쿼리 
 1. 단 하나의 행만을 검색하여 메인쿼리에 반환하는 질의문을 말한다. 
 2. 비교연산자: =,>=,>,<,<=,<> 
 */
-- deptno가 10인 사원의 평균 급여보다 많은 사원을 출력하세요 
SELECT * 
FROM emp 
WHERE sal>(SELECT avg(SAL) FROM emp WHERE deptno=10);
-- ex) salesman중에서 가장 많은 급여보다 많이 받는 사원 출력 
SELECT * 
FROM emp 
WHERE sal>(SELECT max(SAL) FROM emp WHERE job='SALESMAN');
/*
 # 다중행 서브 쿼리 
 1. 서브쿼리에서 실행한 결과값이 1행 이상일 때, 사용하는 쿼리 
 2. 사용되는 연산자 
 	in : 결과값이 or 조건으로 처리해야할 필요가 있는 경우 활용된다. 
 	any, some: 결과값이 1개라도 있는 경우. min(조회데이터)과 동일 
 	all: 모든 결과값이 일치하는 경우. max(조회데이터)와 동일 
 	exist, not exist: 해당 sub query 값 존재하는 경우, 존재하지 않는 경우. 
 */
-- 부서번호 별 최고 급여자의 정보를 출력 
SELECT deptno, max(sal)
FROM emp
GROUP BY deptno;
SELECT * 
FROM emp
WHERE (deptno,sal)in(SELECT deptno, max(sal)
				   	FROM emp
					GROUP BY deptno);
				
SELECT * FROM emp; 
-- job이 salesman인 모든 사원번호에 해당하는 데이터를 조회하세요 

SELECT * 
FROM emp 
WHERE empno IN (SELECT empno FROM emp WHERE job='SALESMAN');
-- ex) blake를 관리자로 하는 사원을 조회하세요 (subquery이용) 
SELECT * 
FROM emp 
WHERE mgr IN (SELECT EMPNO FROM emp WHERE ename='BLAKE');

-- # any, some: 하나라도 일치하면 참이 되는 연산자 
-- 부서번호가 10인 사원의 급여 중 하나라도 보다 많으면 처리 
SELECT sal 
FROM emp 
WHERE deptno=10;

SELECT ename, sal 
FROM emp 
WHERE sal>any(SELECT sal FROM emp WHERE deptno=10);
-- # all 은 모두 다 일치하면 참이되는 연산자 
SELECT sal 
FROM emp 
WHERE deptno=20;

SELECT ename, sal
FROM emp 
WHERE sal>all(SELECT sal FROM emp WHERE deptno=20);

/*
 # exists 연산자 
 1. 서브쿼리의 결과값이 있는지 여부를 확인해서 메인쿼리를 실행해준다. 
 
 */
SELECT * FROM emp WHERE comm IS NOT NULL;
SELECT * FROM emp WHERE deptno=40; 

--subquery 데이터 있을 때
SELECT * FROM emp WHERE exists(SELECT * FROM emp WHERE comm IS NOT NULL);
--subquery 데이터 없을 때 
SELECT * FROM emp WHERE exists(SELECT * FROM emp WHERE deptno=40);


