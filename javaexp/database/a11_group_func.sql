/*
 # 그룹함수
 1. 테이블의 전체 행을 하나 이상의 컬럼을 기준으로 그룹화하여 그룹별로 결과를 출력하는 함수	
	그룹함수는 통계적인 결과를 출력하는데 자주 사용 
 2. 기본형식 
 	SELECT 컬럼명, 그룹함수() 
 	FROM 테이블명
 	WHERE 조건문 
 	GROUP BY 그룹할컬럼
 	HAVING 그룹함수의 조건 
 	
 	*** n개의 컬럼을 기준으로 그룹을 처리 ***
 	select 컬럼1, 컬럼2, 그룹함수()
 	from 테이블명 
 	group by 컬럼1... 컬럼n; 
 	1차로는 컬럼1, 2차로는 컬럼2...n차로 그룹함수를 처리하여 
 	그 결과를 확인할 수 있다. 
 	
 	
 3. 그룹함수의 종류 
 	count() : 행의 갯수 
 	max, min, sum, avg 
 	stddev(표준편차), variance(분산) - 데이터 분포의 밀집도 
 	grouping : 해당 컬럼이 그룹에 사용 여부(1/0), rollup, cube 
 	grouping sets : 한 번의 질의로 여러 그룹화 기능. 
*/
-- ex) 부서별 인원수 
SELECT deptno, count(*) 인원
FROM EMP e 
GROUP BY deptno
ORDER BY deptno;
-- ex) job별 인원 수 출력 
SELECT job, count(*) 인원수
FROM EMP e 
GROUP BY JOB
ORDER BY job;
-- ex) 입사분기별로 인원수를 출력 
-- **** 컬럼에서 함수를 적용한 내용을 가지고 그룹함수 처리 
--      기존 데이터에서 함수가 적용되어 변경된 데이터를 다시 그룹 적용처리 할 수 있다. 
SELECT to_char(hiredate,'Q') "분기", count(*) 인원 
FROM EMP e 
GROUP BY to_char(hiredate,'Q')
ORDER BY to_char(hiredate,'Q');

/*
 # 
 avg(컬럼): 평균값
 sum(컬럼): 합산값 
 min(컬럼): 최소값 
 max(컬럼): 최대값 
 stddev(컬럼명): 표준편차 
 variance(컬럼명): 분산 
 */
SELECT deptno, round(avg(sal),1) "평균", sum(sal)	 "총합",
	min(sal) "최소연봉", max(SAL) "최대연봉", stddev(SAL) "표준편차", 
	variance(SAL) "분산"
FROM EMP e 
GROUP BY deptno
ORDER BY deptno;
-- ex) 부서별로 가장 최근에 입사한 사람의 입사일과 입사일이 가장 오래된 사람의 입사일을 출력하세요 
SELECT deptno , max(HIREDATE), min(HIREDATE)
FROM EMP e 
GROUP BY DEPTNO
ORDER BY deptno;
-- cf) 부서별로 가장 최근에 입사한 사람의 이름, 입사일, 부서번호를 출력하세요 
SELECT deptno, ename, hiredate
FROM EMP e 
WHERE (deptno, hiredate) IN (SELECT deptno,max(hiredate) FROM emp GROUP BY deptno)
ORDER BY deptno;

/*
 # rollup 
 1. group by 절과 같이 사용되며, group by 절에 의해서 그룹 지어진 집합 결과에 대해서 
 	좀 더 상세한 정보를 반환하는 기능을 수행한다. 
 2. 그룹데이터와 데이터의 총계를 구할 수 있다. 
 */
--job 별로 급여 한계 
SELECT job, sum(sal)	
FROM emp 
GROUP BY job;
-- 급여 합계의 총계를 다시 구할 때. 
SELECT job, sum(sal)	
FROM emp 
GROUP BY ROLLUP(job);
-- 부서와 직책별로 급여와 데이터 건수 
SELECT deptno, job, sum(sal) "합계", count(*) "데이터건수"
FROM EMP e 
GROUP BY deptno, job
ORDER BY deptno, job;
-- 각각의 상위 항목별 통계치와 전체 통계치를 처리할 때 rollup을 활용한다. 
SELECT deptno, job, sum(sal) "합계", count(*) "데이터건수"
FROM EMP e 
GROUP BY ROLLUP(deptno, job)
ORDER BY deptno, job;
-- rollup을 통해서 부서별로 합계와 전체 총계합계를 처리할 수 있다. 
/*
 # cube: rollup에서 전체 데이터 summary 기능을 포함할때 활용된다. 
*/
SELECT deptno, job, sum(sal) "합계", count(*) "데이터건수"
FROM EMP e 
GROUP BY CUBE (deptno, job)
ORDER BY deptno, job;

-- cf) n차원 그룹함수 적용
select deptno, job, count(*)
FROM emp
GROUP BY deptno, job; 
-- 2개의 컬럼을 기준으로 그룹처리 
-- 부서번호와 직책에 해당하는 데이터 건수를 출력처리 



