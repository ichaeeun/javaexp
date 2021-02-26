/*
# 데이터타입의 변환 
1. 오라클에서 사용하는 데이터 유형은 함수에 의해서 데이터 type을 변경할 수 있다. 
2. 형변환 유형	
	1) 묵시적 데이터 타입의 변환 
		조건문에서 정확하게 해당 type을 설정하지 않더라도 결과를 검색해주는 경우가 
		있는데 이것은 오라클 시스템 내부에서 내부적으로 타입을 변환했기 때문이다. 
		ex) SELECT * FROM emp 
			WHERE sal>='2000';
		문제는 시스템에서 index라는 빠르게 검색을 해주는 내용에 대해서는 묵시적으로 
		함수가 적용된 형변환을 했기 때문에 효율적으로 처리되지 못한다. 
		cf) index 책에서 책갈피를 끼워놓으면 빠르게 해당 내용을 찾을 수 있듯이 
		DB시스템 내부에 해당 객체를 설정해서 효과적으로 검색을 빠르게 한다. 
	2) 명시적 데이터 타입의 변환 
		일반적으로 데이터베이스는 변환함수를 이용하여 데이터타입을 변환하여 효과적으로 처리한다.
		1) to_char(문자열로): 숫자/날짜 타입을 문자열로 변환해주는 함수이다. 
		2) to_number(숫자로): 날짜/문자 타입을 숫자로 변환해주는 함수 
		3) to_date(날짜로): 문자/숫자 타입을 날짜로 변환해주는 함수 
		
*/
SELECT * FROM emp 
WHERE sal>='2000';

/*
# TO_CHAR
1. 날짜/숫자를 원하는 형식으로 데이터를 보기 위해서 사용된다. 
2. 기본 형식 
	to_char(데이터,'출력할 형식') 
3. 날짜형을 문자열로 표현하는 출력형식 
	1) CC: 세기 
	2) YYYY/YYY/YY/Y : 년도표기
	3) AD/A.D: AD/BC 표기 
	4) Q : 분기 
	5) MM/MONTH/MON/ : 월 표기 
	6) WW/W : 연을 주단위로 표기(1년 52주)/월을 주단위로 표기 
	7) DDD/DD/D: 날짜 표기 
	8) DY/DAY : 요일 표기 
*/
SELECT ename,hiredate,sal,
	to_char(hiredate,'YYYY') "년도",
	to_char(hiredate,'Q') "분기",
	to_char(hiredate,'MM') "월",
	to_char(hiredate,'YYYY-MM-DD') "년월일",
	to_char(hiredate,'YYYY"년 "MM"월 "DD"일"') "년월일",
	to_char(hiredate,'CC"세기 " WW"째주" DAY') "기타 날짜 표기"
FROM emp;
-- 위 내용을 조건문에서 활용할 수 있다. 
-- ex) to_char의 매개변수를 이용하여 @@@는 @@년@@월에 입사하였다. 
SELECT ename || '는 '||to_char(hiredate,'YYYY"년 "MM"월"')||'에 입사하였다.' show
FROM emp;
-- ex) 1/4 분기에 입사한 사원의 이름과 입사년월 분기를 출력하세요 
SELECT ename 이름, to_char(hiredate,'YYYY/MM') 입사년월, 
	to_char(hiredate,'Q"/4"') 분기 
FROM EMP e 
WHERE TO_char(hiredate,'Q')='1';
/*
4. data 타입의 시간 표시 형식 
	1) AM/PM : 오전/오후 시간 표시 
	2) A.M/P.M : 오전/오후 시간 표시 
	3) HH/HH12 : 시각(1~12) 표시 
	4) HH24 : 시각(0~23) 표시 
	5) MI : 분 
	6) SS : 초 
 */
SELECT ename, to_char(hiredate,'AM HH:MI:SS')"입사시간표기"
FROM emp;
SELECT '홍길동' ename, to_char(sysdate,'AM HH:MI:SS') "현재시간표기1",
	to_char(sysdate,'YYYY/MM/DD HH24"시 "MI"분 "SS"초"') "현재시간표기2"
FROM dual;

/*
5. 숫자형 데이터를 문자열 형식으로 변환처리 
	1) 기본형식 to_char(숫자형,'형식') 
	2) 주요형식 
		9999 : 기본 자릿수에 맞게 처리 
		0000 : 해당 자리수이하 일때 0으로 채워짐 
		$ : 앞에 $표기
		. : 특정한 자리를 표기 소숫점 
		, : 특정한 위치에 ,를 표기
 */
SELECT ename, sal, to_char(sal,'99999') "형식1",
	to_char(sal,'00000') "형식2", to_char(sal,'$9999')"형식3",
	to_char(sal,'9,999') "형식4", to_char(sal,'9,999.999') "형식5"
FROM emp;
-- ex) 사원명, 이름, 급여, 급여2(천단위콤마 앞에 $표기 소숫점1자리 표기) 
SELECT ename 이름, sal 급여, to_char(sal,'$9,999.9') "급여2"
FROM emp;
/*
# to_number 
1. 매개변수로 받은 숫자형 문자열을 숫자로 변환하여 연산이 가능하도록 처리한다. 
2. 기본 형식 : to_number(문자열) 
cf) 주로 자동형변환이 일어나서 사용되지 않는 경우도 많으나, 명시적인 처리로 
	해당 타입에 대한 구분을 할 때 사용된다. 
 */
SELECT '25'+25,  --자동현변환 
		to_number('25')+25
FROM dual;
/*
# to_date 
1. 숫자와 문자로 구성된 문자열을 날짜 데이터로 변환하는 함수 
2. to_date('문자열데이터','형식') 
	해당 문자열이 어떤 데이터를 내포하고 있는지 확인해야지 처리가 가능하다. 
	조회와 등록시 많이 활용된다. 
 */
-- 문자열형으로 날짜를 등록할 수 없기 때문에 이 형식이 많이 쓰인다. 
CREATE TABLE emp01
AS SELECT * FROM emp; 
SELECT * FROM emp01; -- 복사테이블 생성. 
INSERT INTO emp01(ename,hiredate)
	values('홍길동',to_date('2020-01-01','YYYY-MM-DD'));
-- 입력시 '2020-01-01' 형식이 어떤 형식으로 연도와 월 일이 설정되어 있는지를 
--	YYYY-MM-DD  
SELECT * FROM emp01;
INSERT INTO emp01(ename,hiredate)
	values('홍길동',to_date('2020-12-29 16:30:20','YYYY-MM-DD HH24:MI:SS'));
SELECT * FROM emp01;
-- ex) emp01에 사원번호와 사원명김길동으로 날짜(2020/12/31 23:59:59)데이터입력 
INSERT INTO emp01(empno,ename,hiredate) 
	values(9000,'김길동',to_date('2020/12/31 23:59:59','YYYY/MM/DD HH24:MI:SS'));
SELECT * FROM emp01;
