/*
# 날짜함수 
1. 날짜형 데이터 타입에 사용하는 함수 
2. 기본연산 
	 1) 날짜 +(-) 숫자 : 해당 일자의 일수를 가산(감산)하여 처리 
	 2) 날짜 +(-) 1/24 : 시간단위 연산 처리 
	 1일이 24시간이기 때문에 5시간 이후인 경우, 날짜 + 5/24 로 처리한다. 
cf) sysdate는 현재날짜시간을 나타낸다. 
*/
SELECT sysdate "현재날짜와 시간",
	   sysdate+1 "내일 현재시간",
	   sysdate-1 "어제 현재시간",
	   sysdate+(8/24) "8시간 이후"
FROM dual;
--ex) 사원명과, 입사 후 120일 후 인턴기간, 입사 8시간 전, 
-- 근무일수 
SELECT ename, hiredate+120 "인턴기간", hiredate-(8/24) "8시간전",
	   floor(sysdate-hiredate) "근무일수"
FROM emp;

/*
# 날짜함수
1. sysdate: 오라클 서버시스템의 현재 날짜와 시간 
2. months_between(날짜데이터1, 날짜데이터2) : 날짜와 날짜 사이의 개월을 계산 
	1개월 = 1, 15일 = 0.5로 기준하여 날짜/시간/분/초 등을 소숫점으로 계산이 된다. 
*/ 
SELECT ename, hiredate,sysdate,months_between(sysdate,hiredate) "근무개월1",
	floor(months_between(sysdate,hiredate)) "근무개월2",
	floor(months_between(sysdate,hiredate)/12) "근무연한"
FROM emp; 
--ex) dual테이블로 오늘은 1일로 해서, 만난 지 100,1000 후 날짜 
SELECT sysdate+100 "100일", sysdate+1000 "1000일" 
FROM dual;
--ex) emp테이블에서 근무개월이 470~480 사이 데이터를 출력하세요 
SELECT e.* ,floor(months_between(sysdate,hiredate)) "근무개월"
FROM emp e
WHERE floor(months_between(sysdate,hiredate))BETWEEN 470 AND 480;
/*
3. add_months(날짜데이터, 추가개월) : 날짜에 개월을 더한 날짜 계산 
 */
SELECT sysdate, add_months(SYSDATE,3)"오늘로부터 3개월 후" 
FROM emp;
--ex) 사원번호는 부서별 업무파악을 난이도에 따라 3개로 분류한다. 바로 파악되는 0, 
--	1개월 1, 2개월 2로 사원번호에 나머지값으로 처리하였다. 
--	입사해서 업무파악 만료일을 출력하세요 
-- 회사에서 사원번호의 마지막 자리를 업무난이도에 따라서 분류하여 만든 경우를 말한다. 
--	사원번호, 사원명, 업무파악 난이도, 입사일, 업무파악 만료일 
SELECT empno, ename, mod(empno,10) 난이도 , hiredate 입사일,
		hiredate+mod(empno,10) 업무파악만료일
FROM emp;


