/*

데이터베이스
[하]1. nvl2, nullif의 기본형식을 예제를 통해 기술하세요
	  nvl2(데이터, null이 아닐떄 처리할 데이터, null일 때 처리할 데이터)
	  nullif(데이터1,데이터2) 데이터비교해서 동일하면 null, 동일하지 않으면 데이터1 반환
*/
SELECT comm, nvl2(comm,sal+comm,0+sal) "nvl2" FROM emp;
SELECT nullif('a','b'), nullif('a','a') FROM dual;
/*
[중]2. deptno가 30이면 보너스는
		sal 기준 100%, 그외에는 deptno로 보너스를 처리하고자 한다.
      이름, 부서번호, 보너스(%), 보너스 를 출력하세요
 */
SELECT ename, deptno, decode(deptno,30,100,deptno) "보너스(%)",
		sal, sal*decode(deptno,30,100,deptno)/100 "보너스"
FROM emp;

-- sol 
SELECT ename,deptno,sal,nullif(deptno,30),
	nvl(nullif(deptno,30),100)||'%' "보너스%",
	sal*(nvl(nullif(deptno,30),100)/100) "보너스"
from emp; 
/*
[하]3. decode함수의 기본형식을 예제를 통해 기술하세요.
	decode(데이터,조건1,조건1일때데이터, 조건2,조건2일때 데이터, 그 외 데이터) 
*/
SELECT decode(deptno,10,'총무',20,'회계','인사') "decode"
FROM emp;
/*
[중]4. hiredate기준  상반기(1~6), 하반기(7~12) 하여 sal 기준으로 
	  보너스를 100%, 200% 처리하고자 한다. 중첩함수 이용해서 출력하세요
      사원명, 상/하반기구분(보너스%), 급여, 보너스 
 */
SELECT ename, hiredate, 
	decode(floor(MOD(to_char(hiredate,'MM'),6)),0,'상반기','하반기') 상하반기구분,
	decode(floor(MOD(to_char(hiredate,'MM'),6)),0,100,200) "보너스%",
	sal*decode(floor(MOD(to_char(hiredate,'MM'),6)),0,100,200)/100 보너스,
	sal+(sal*decode(floor(MOD(to_char(hiredate,'MM'),6)),0,100,200)) 총급여
FROM emp;

-- sol 
SELECT ename, hiredate, 
	to_char(hiredate,'MM') 월,
	decode(floor(to_char(hiredate,'MM')/7),0,'상반기','하반기') 상하반기구분,
	decode(floor(to_char(hiredate,'MM')/7),0,'100%','200%') "보너스%",
	sal,
	decode(floor(to_char(hiredate,'MM')/7),0,sal*1,sal*2) 총급여 
from emp; 
	
/*
[하]5. sal를 기준으로 5000이상 A등급, 4000이상 B등급, 
	  3000이상 C등급, 2000이상 D등급, 
      1000이상 E등급, 1000미만 F등급으로 급여등급표기하세요
      사원명, 급여, 등급
*/ 
SELECT ename, sal, decode(floor(sal/1000),5,'A등급',4,'B등급',3,'C등급',2,'D등급',1,'E등급','F등급') 급여등급
FROM emp;





