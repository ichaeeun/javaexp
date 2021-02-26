/*
데이터베이스
1. [하]타입변환에서 명시적/묵시적 형변환의 의미를 기술하고, 
	묵시적 형변환이 일어나는 이유와 해당 예제를
	간단한 코드로 기술하세요.
	명시적 형변환: 함수를 통한 형변환 
	묵시적 형변환: 
	조건문에서 해당 type을 정확하게 표시하지 않더라도 오라클 시스템 내부에서 
	타입을 변환해주기 떄문에 묵시적 형변환이 일어난다. 
*/
	SELECT '25'+25 FROM dual; -- 결과: 50 
/*
2. [하]명시적 형변환 3가지의 기본형식과 기본예제를 기술하세요.
	to_char(숫자/날짜 타입을 문자열로), to_number(문자,날짜 타입을 숫자로), 
	to_date(문자,숫자 타이블 날짜로) 가 있다. 
*/
	SELECT ename,hiredate,sal,
	to_char(hiredate,'YYYY') "년도",
	to_char(hiredate,'Q') "분기",
	to_char(hiredate,'MM') "월",
	to_char(hiredate,'YYYY-MM-DD') "년월일",
	to_char(hiredate,'YYYY-MM-DD 24HH:MI:SS') "년월일시분초",
	to_char(sal,9,999.99) "숫자형식",
	FROM emp;
	SELECT to_number('25')+25 FROM dual;
	INSERT INTO emp01(ename,hiredate) 
	values('강길동',to_date('2020-12-25','YYYY-MM-DD'));
	SELECT * FROM emp01;
/*
2. [중]매월 첫째주에 입사한 사원의 이름과 년도 입사월과 주,요일을 표기하세요.
*/
	SELECT ename, to_char(hiredate,'YYYY/MM/ W"째주 "DAY') "입사월 주 요일"
	FROM emp
	WHERE to_char(hiredate,'W')='1';
/*
3. [중]입사일을 상/하반기로 나누어서 상반기에 입사한 사람의 
	이름, 입사월, 상하반기구분으로 출력하세요.
*/
-- to_char(hiredate,'Q')>=3 
-- to_char(hiredate,'MM')>=7 
    
   SELECT ename, to_char(hiredate,'MM') 입사월
   FROM EMP e
   WHERE to_number( to_char(hiredate,'Q') ) < 3;
  
   SELECT ename, to_char(hiredate,'MM') 입사월,
         floor(to_number(to_char(hiredate,'Q'))/3) "상하반기 구분"
         -- to_number()/3 ==> 1,2: 소숫점이하, 3,4: 1이상 
         -- floor ==> 0은 상반기, 1은 하반기 
   FROM emp;
-- WHERE to_number( to_char(hiredate,'Q') ) < 3;

   SELECT ename, to_char(hiredate,'MM') 입사월,
         decode(floor(to_number(to_char(hiredate,'Q'))/3),0,'상반기','하반기') "상하반기구분"
   FROM emp;
-- WHERE to_number( to_char(hiredate,'Q') ) < 3; 

  

   SELECT ename, to_char(hiredate,'MM') 입사월,
   		decode(to_char(hiredate,'Q'),'1','상반기','2','상반기','하반기') "상하반기구분"
   FROM EMP e 
   WHERE to_char(hiredate,'Q')<3;

	
/*
4. [하]시간의 문자열 형식을 나열하고, 입사일을 기준으로 
	@@@@년 @@월 @@일 @@시@@분@@초 형식으로 입사일 표기하세요.
	HH24:MI:SS /HH12:MI:SS/ AM/PM 이 있다. 
*/
	SELECT to_char(hiredate,'YYYY"년 "MM"월 "DD"일" HH24"시" MI"분" SS"초"')
	FROM emp;
/*
5. [중] emp03 복사테이블을 만들고 각분기별로 입사한 사원정보를 시간까지 입력하여 등록하고, 
    YYYY/MM/DD일 @@/4분기에 @@요일 @@:@@:@@ 입사 형식으로 출력하세요.
*/
	CREATE TABLE emp03 AS SELECT * FROM emp;
	INSERT INTO emp03(ename,hiredate) 
	values('김길동',to_date('2020-01-14 12:12:12','YYYY-MM-DD HH:MI:SS'));
		INSERT INTO emp03(ename,hiredate) 
	values('이길동',to_date('2020-04-12 05:12:12','YYYY-MM-DD HH:MI:SS'));	
		INSERT INTO emp03(ename,hiredate) 
	values('홍길동',to_date('2020-09-4 8:12:12','YYYY-MM-DD HH:MI:SS'));
	SELECT ename, to_char(hiredate,'YYYY/MM/DD"일" Q"/4분기" DAY HH:MI:SS "입사"') 입사일 
	FROM emp03;

	



	