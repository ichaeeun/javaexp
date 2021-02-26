/*
1. 숫자형 함수의 종류와 기능상 특징을 기술하세요.
	round(데이터,자릿수) 지정한 자릿수로 반올림 
	trunc(데이터,자릿수) 지정한 자릿수까지 남기고 절삭처리 
	ceil(데이터) 데이터값보다 큰 수 중 가장 작은 정수. 
	floor(데이터) 데이터값보다 작은수 중 가장 큰 정수 
	mod(데이터,m) 데이터를 m으로 나눈 나머지값. 
2. 부서 번호를 %로 해서, 10 ==> 10%, 20==>20%..
   보너스를 정하여, sal기준으로 원금+보너스 합산을 출력하되,
   10자리단위로 반올림 처리하여 출력하세요
   사원명, 급여, 보너스(%), 보너스, 총계
 */
SELECT ename, sal, deptno "보너스(%)", round(sal+(sal*(deptno/100)),-1) "총계"
FROM emp;
/*
3. 사번이 짝수인 사원의 사번과 이름과 급여를 출력하되, 급여는 100자리 수로 절삭하여 처리하세요.
*/
SELECT empno, ename, trunc(sal,-2)
FROM EMP
WHERE mod(empno,2)=0;

/*
4. floor와 trunc의 차이점을 기본 예제로 설명하세요.
	floor는 floor(데이터) 에서 데이터 소숫점 밑을 전부 절삭하여 정수값으로 반환한다. 
	trunc는 자릿수를 지정하여 절삭할 수 있다. 
	floor(100.533) ==> 100 
	trunc(100.533,2) ==> 100.53 
5. 날짜형 데이터에 증감단위를 일, 월, 년을 정할 때, 사용되는 연산자와 함수 또는 연산자+함수 조합으로
    처리되는 내용을 예제로 기술하세요.
    
    날짜형 데이터 +1 : 일단위 증가, add_months(날짜데이터,1): 한달 증가 
    add_months(날짜데이터,월*12):연단위증가 
  */
	SELECT ename, hiredate "입사일",
	hiredate+1 "입사후1일", add_months(hiredate,1)"입사후 한달",
	add_months(hiredate,12)"입사후 1년",
	add_months(hiredate,12*10)"입사후10년"
	FROM emp;
/*
6. 사원, 이름과 입사후 300일 날짜, 지금까지 근무연한(일년 - 365 기준)를 출력
*/
SELECT ename, hiredate+300, floor((sysdate-hiredate)/365) 근무연한
FROM emp;
/*
7. 오늘을 1일로, 1000일 후 개월수, 10000 후 년수를 출력하세요.
*/
SELECT substr(sysdate+1000,4,2) "1000일 후 개월수", 
substr(sysdate+10000,1,2) "10000일 후 년수"
FROM dual;
