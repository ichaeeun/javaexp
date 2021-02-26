/*
# 중첩함수
1. 가장 내부에 있는 함수 f1의 결과값을 다음 함수 f2에 인수로 적용하고, 
	다시 f2의 결과값을 f3에 인수로 사용할 때 활용하는 함수형태를 말한다. 
	f3(f2(f1(데이터,매개변수),매개변수),매개변수) 
	- 특정한 데이터에서 여러가지 함수의 기능을 처리하고자 할 때, 활용된다. 
*/
-- 현재데이터의 입사년도를 올해연도로 변경하여 출력하려고 한다. 
-- 합쳐서 날짜데이터로 변경처리 
SELECT ename, to_char(sysdate,'YYYY') "올해연도",
	to_char(hiredate,'MMDD') "입사월일",
	to_char(sysdate,'YYYY')||to_char(hiredate,'MMDD') "올해입사년월",
	to_date(to_char(sysdate,'YYYY')||to_char(hiredate,'MMDD'),'YYYYMMDD') "날짜형데이터"
FROM emp;
-- ex) 입사일의 분기를 추출하여 해당 보너스의 기준으로 설정하려고 한다. 
--		1) 입사일, 분기, 급여, 
--		2) 분기1 ==> 10%, 2==>20%, 3==>30% .. 
--		3) 급여와 연산하여 보너스금액 출력 
SELECT ename 사원, hiredate 입사일, to_char(hiredate,'Q') "분기", sal 급여, 
	sal*(to_char(hiredate,'Q')*0.1) "보너스",
	-- 묵시적 형변환 
	sal+(sal*(to_char(hiredate,'Q')*0.1)) "총급여"
FROM emp;

/*
# 일반함수
1. nvl(데이터, null값일때 처리할 데이터)
	1) 해당 데이터가 null값일 때 처리할 데이터를 설정. null에 대한 연산처리 시 필요하다. 
 */
SELECT ename, sal, comm, sal+comm, sal+nvl(comm,0)
FROM emp;
/*
2. nvl2(데이터, null 아닐 때 처리할 데이터, null일 때 처리할 데이터) 
 */
-- comm이 null일때는 100으로 설정되고, null 이 아닐때는 comm 에서 10% 추가. 
SELECT ename,sal,comm, nvl2(comm,comm*1.1,100) 보너스
FROM emp;
-- ex1) comm이 null 일때는 sal의 15%로 설정하고, 
-- null이 아닐때는 sal의 5%더하여 보너스금액을 설정하여 

SELECT ename,sal,comm,nvl2(comm,comm+sal*0.05,sal*0.15) "보너스"
FROM emp;
/*
3. nullif(데이터1,데이터2) 
	1) 두개의 매개변수로 받는 데이터를 비교하여 동일하면 null을 반환하고, 동일하지 않으면 
		첫번째 데이터1을 반환하는 함수를 말한다. 
 */
SELECT nullif('a','a') show1,
	nullif('a','b') show2,
	nvl(NULLIF('a','a'),'동일') show3,
	nvl(NULLIF('a','b'),'동일') show4
FROM dual;

-- ex) 회사에서 일괄보너스 지급 금액이 60이라고 정하는데, 연봉의 5%와 같으면 
-- 		60, 다르면 연봉의 5%로 처리 
SELECT ename, sal, NULLIF(trunc(sal*0.05,-1),60) 보너스1, 
	nvl(nullif(trunc(sal*0.05,-1),60),60) 보너스2 
FROM emp;

/*
# decode 함수 
1. 프로그래밍 언어의 if문이나 case문으로 표현되는 내용을 하나의 함수로 처리할 수 있게 해준다. 
2. 기본형식
	decode(데이터, case1, case1일때처리할데이터, 
				 case2, case2일때처리할 데이터,
				 case3, case3일때처리할 데이터,
	위내용에 해당하지 않을때 처리할 데이터)
 */
SELECT ename, deptno, 
	decode(deptno,10,'인사과',
				  20,'총무',
				  30,'회계',
					'부서미정') 부서명 
FROM emp;
-- ex) 사원번호를 기준으로 짝수이면 홍팀, 홀수이면 청팀으로 처리하여 출력하세요
SELECT ename, empno, decode(mod(empno,2),0,'홍팀',1,'청팀') "팀"
FROM emp;
/*
# 일반함수 case 
1. decode의 확장된 함수. decode는 표현식 또는 컬럼 값 '=' 비교를 통해
	조건이 일치하는 경우에만 다른 값으로 대치하지만,
	case 함수에서는 산술 연산, 관계 연산, 논리 연산과 같은 다양한 비교가 가능하다. 
2. 기본형식
	1) 조건문 형태 활용 
	case 
		when 논리|산술|관계 then 처리할 데이터
		when 논리|산술|관계 then 처리할 데이터
		else 기타처리할 데이터 
	end 
	2) switch case 문 형태 
	case [컬럼명]
		when 데이터1 then 처리할 데이터
		when 데이터1 then 처리할 데이터
		else 그외 데이터 
	end 
 */  
SELECT ename, deptno, 
	CASE WHEN deptno=10 THEN sal*0.2
		 WHEN deptno=20 THEN sal*0.5
		 WHEN deptno=30 THEN sal*0.7
		 ELSE sal*1.2 
		 END show 
FROM emp;

SELECT ename, deptno, 
	CASE deptno
		 WHEN 10 THEN sal*0.2
		 WHEN 20 THEN sal*0.5
		 WHEN 30 THEN sal*0.7
		 ELSE sal*1.2 
		 END show 
FROM emp;
-- ex) case문을 이용하여, 분기별로 보너스 금액을 0.1,0.2,0.3,0.4로 지정하여 
--	   사원명, 입사일, 입사분기, 급여, 보너스 를 출력하세요 
SELECT ename 사원명, hiredate 입사일, to_char(hiredate,'Q') 입사분기, sal 급여, 
	CASE to_char(hiredate,'Q')
		 WHEN '1' THEN sal*0.1 
		 WHEN '2' THEN sal*0.2
		 WHEN '3' THEN sal*0.3
		 WHEN '4' THEN sal*0.4
		 END "보너스급여"
FROM emp; 
-- ex) 급여별 등급 표기(조건-비교연산자활용) 
SELECT ename, sal, 
	CASE WHEN sal>=5000 THEN 'A등급'
		 WHEN sal>=4000 THEN 'B등급'
		 WHEN sal>=3000 THEN 'C등급'
		 WHEN sal>=2000 THEN 'D등급'
		 WHEN sal>=1000 THEN 'E등급'
		 ELSE 'F등급'
		 END "급여등급"
FROM emp;

		 

