/*
[데이터베이스]
[하] 1. 직책별로 급여가 가장 많은 사람과 가장 적은 사람을 출력하세요
*/
SELECT job, max(sal), min(sal)
FROM EMP 
GROUP BY job
ORDER BY job;
-- 쿼리1 union all 쿼리2: 쿼리1과 쿼리2를 순차적으로 출력  
SELECT * 
FROM EMP e2 
WHERE (job, SAL) IN (SELECT job, max(SAL) FROM emp GROUP BY job) 
UNION ALL 
SELECT * 
FROM EMP 
WHERE (job,sal) IN (SELECT job,min(sal) FROM emp GROUP BY job); 
/*
[중] 2. 월별로 평균 급여를 출력하세요.
*/
SELECT to_char(hiredate,'MM') 월, round(avg(sal),1) 평균급여 
FROM EMP 
GROUP BY to_char(hiredate,'MM')
ORDER BY to_char(hiredate,'MM');
/*
[중] 3. 직책별로 근무일수가 가장 오래된 사원의 직책, 이름, 입사일을 출력(직책으로 정렬)하세요
*/
SELECT job, ename, hiredate 
FROM emp 
WHERE  hiredate IN (SELECT  min(HIREDATE) FROM emp GROUP BY job)
order BY job;
-- 해당 데이터가 단일데이터일 경우에는  '='대입연산자 활용한다.  

/*
[하] 4. rollup와 cube의 차이점을 기본예제를 통해서 기술하세요.
		rollup은 상위항목의 통계치에 대해서 다시 전체통계치를 처리할 때 사용한다. 
		select job, max(sal) 
		from emp 
		group by rollup(job); 
		cube 는 rollup에서 전체데이터 summary 기능을 활용할 때 사용한다. 
		SELECT deptno, job, sum(sal) "합계", count(*) "데이터건수"
		FROM EMP e 
		GROUP BY CUBE (deptno, job)
		ORDER BY deptno, job;
[하] 5. 조인이란 무엇인가? 개념과 기본형식을 기술하세요.
		join이란 하나의 sql문으로 여러테이블에 저장된 데이터를 한번에 조회할 수 있는 기능을 말한다. 
		SELECT 테이블별칭.컬럼명, 테이블별칭.컬럼명 ... 
		FROM 테이블1 별칭, 테이블2 별칭 
		WHERE 별칭.공통컬럼 = 별칭.공통컬럼 
[하] 6. 급여가 3000~4000 사이에 있는 부서명과 사원명,급여를 출력하세요.
*/
SELECT dname, ename, sal 
FROM emp e, dept d 
WHERE e.deptno=d.deptno 
AND sal BETWEEN 3000 AND 4000;
-- between 범위를 지정해서 사이에 있는 데이터 호출 
-- in 범위가 아니고 특정한 데이터 지정해서 호출(사이에 있는 데이터를 나타내지 못함) 
/*
[하] 7. 부서위치가 DALLAS인 사원정보를 출력하세요.
*/
SELECT dname, ename, loc
FROM emp e, dept d
WHERE e.deptno=d.deptno AND loc='DALLAS';
/*
[하] 8. natural join과 일반 where문에 의한 조인을 차이점을 기술하세요.
		natural join은 
		select * from emp natural join dept; 
		명시하지 않더라도 내부적으로 자동조인처리가 됨. 
		select * from emp e, dept d where e.deptno=d.deptno; 
		where문 명시적. 
		
		테이블에서 join하는 컬럼명을 지정하는 부분에 있어서, 
		명시성과 내부적 자동 조인처리에서 차이가 난다. 
		
		natural join은 foreign key 관계에 있으면 자동으로 해당 컬럼을 명시적으로 지정하지 않더라도 
		join이 된다. 
		
[하] 9. non equi join에 대하여 emp, salgrade를 활용하여 설명하세요.
	두개의 테이블에 조인할 조건이 '='(동일) 조건이 아니고, 범위를 지정할 때 활용된다. 
	SELECT ename, sal, grade 
	FROM emp e, salgrade s
	WHERE e.sal BETWEEN losal AND hisal;
[하]10. outer join과 일반 공통 컬럼 join과의 차이점을 기술하세요.
	일반 공통 컬럼 join은 한쪽 컬럼의 데이터가 null일경우 결과로 나타나지 않는데, 
	outer join은 한쪽 컬럼 데이터가 null이더라도 출력된다. 
	해당 정보가 없는 컬럼에 (+)기호를 붙인다. 
	emp와 dept관계에 있어서 dept의 모든 데이터가 emp에 없을 지라도 
	아웃조인을 통해서 처리할 수 있다. 
	SELECT *
	FROM emp e, dept d
	WHERE d.deptno=e.deptno(+);
*/
	