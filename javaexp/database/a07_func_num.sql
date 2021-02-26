/*
# 숫자형 처리함수
1. 숫자형 데이터를 원하는 형태로 수학적 처리나 연산을 처리해주는 함수를 말한다. 
2. 종류
	1) round: 지정한 소숫점 자리로 반올림 처리를 해준다. 
		round(데이터, 자릿수) 
		자릿수: +값은 소숫점 이하 자리수를 말한다. 
			ex) round(45.2432,2) ==> 45.24 
			  -값은 소숫점 기준으로 10,100,1000 자릿수. 
			  10단위 이상의 자릿수 반올림처리. 
			    round(2456435,-3) ==> 2456000 
	2) trunc: 지정한 소숫점 자리까지 남기고 절삭처리 
		trunc(데이터, 자릿수)   cf)floor(): 정수로 절삭 
		
*/
SELECT round(222452.7552,2)FROM dual;
SELECT round(222452.7552)FROM dual;
SELECT round(222452.7552,-2)FROM dual;
SELECT trunc(5734.24599,2) FROM dual;
SELECT trunc(5734.24599) FROM dual;
SELECT trunc(5734.24599,-2) FROM dual;
--ex) sal의 15% 인상 금액을 100 자리 단위와 소숫점1자리 단위로 출력하세요 
SELECT round(sal*1.15,1) "소숫점1자리", round(sal*1.15,-2) "100자리" 
FROM emp;
--ex) 급여를 부서번호 기준으로 %로 올해 인상급여을 지정한다고 할때, 
--	  100단위 절삭과 소숫점 2자리 절삭을 사원명과 함께 출력하세요 
SELECT ename, sal, trunc(sal+(sal*(deptno/100)),-2) "인상분1",
		trunc(sal+(sal*(deptno/100)),2) "인상분2"
FROM emp;
/*
	3) mod: 데이터베이스에서 산술연산자 % 대신 쓰인 나머지 처리 함수를 말한다. 
		mod(데이터,m) : 데이터를 m으로 나눈 나머지값 
		ex) mod(10,3) ==> 1
*/
SELECT mod(10,3) 예제1, mod(10,2) 예제2 FROM dual;
-- 사번이 짝수인 데이터를 출력하세요 
SELECT e.*, mod(empno,2)
FROM EMP e 
WHERE mod(empno,2)=0;
/*
 	4) ceil: 지정한 값보다 큰 수 중에서 가장 작은 정수 
 			소숫점이하의 내용에 대하여 올림 정수. 
 	5) floor: 지정한 값보다 작은 수 중에서 가장 큰 정수 
 			소숫점이하의 내용에 대하여 내림 정수 
 */
SELECT ceil(25.75) "올림 정수",
		floor(25.75) "내림 정수"
FROM dual;
--ex) 사원 중에서 홀수번호가 
--sal과 comm의 합산한금액에 5% 향상된 최종 금액을 내년 급여로 선정. 
--소숫점이하 올린금액, 내린금액을 출력 
SELECT empno, CEIL((sal+nvl(comm,0))*1.05) "올림 내년급여",
		floor((sal+nvl(comm,0))*1.05) "내림 내년급여"
FROM emp 
WHERE mod(empno,2)!=0;

