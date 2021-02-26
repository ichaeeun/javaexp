/*
database
1. 부서 10과 30에 속하는 모든 사원의 이름과 부서번호를 
	이름과 알파벳 순으로 정렬되도록 질의문을 만드세요.
*/
SELECT ename, deptno
FROM emp  
WHERE deptno in(10,30)
ORDER BY ename;
/*
2. 1982년도에 입사한 모든 사원의 이름과 입사일을 출력하세요(like %활용).
--hiredate는 date타입이기에 보이는 모양과 문자열로 접근해서 보이는 모양은 차이가 있다. 
-- ''||날짜형  강제타입캐스팅  
-- HIREDATE LIKE '%82%'; 문자열 타입캐스팅된 내용을 비교 
-- 원칙적으로는 날짜형==> 함수에 의해 ==> 문자열로 변환, 변환된문자열을 비교연산자로 비교 
*/
SELECT ename, hiredate 입사일, ''||hiredate "입사일(문자)"
FROM emp
WHERE hiredate LIKE '%82%';
/*
3. 보너스가 급여의 20%이상이고 부서번호가 30인 모든 사원에 대하여 
	이름, 급여, 그리고 보너스를 출력하세요. 급여(sal), 보너스(comm)
*/
SELECT ename "이름", sal "급여", comm 보너스
FROM EMP 
WHERE comm>=sal*0.2 AND DEPTNO =30;
/*
4. like 키워드에서 %, _ 의미를 기술하고 간단한 예제를 만드세요.
	'%A%'는 자릿수에 상관없이 A가 포함된 데이터를 모두 출력한다. 
	'A%'는 A로 시작하는 데이터 출력, '%A'는 A로 끝나는 데이터 출력 
	_는 자릿수를 지정해줄 수 있다. 
	'__A%'는 세번째자릿수에 A가 포함된 데이터를 출력한다. 
5. 가장 최근에 입사한 사원의 이름과 입사일을 출력하세요(in subquery구문 활용)
*/
SELECT ename,HIREDATE 
FROM emp
WHERE HIREDATE in(SELECT max(HIREDATE) FROM emp);

