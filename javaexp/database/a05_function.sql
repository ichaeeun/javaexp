/*
 # database에서 함수(funtion)
 1. sql에서 함수 
 	1) 컬럼의 값이나 데이터타입을 변경하는 경우
 	2) 숫자 또는 날짜 데이터의 출력 형식을 변경하는 경우
 	3) 하나 이상의 행에 대한 집계(aggregation)를 하는 경우 
 2. sql 함수의 유형 
 	1) 단일 행 함수: 테이블에 저장되어 있는 개별 행을 대상으로 하는 함수를 
 		적용하여 하나의 결과를 반환하는 함수 
 	2) 복수 행 함수: 조건에 따라 여러 행을 그룹화하여 그룹별로 결과를 하나씩 
 		반환하는 함수 
 3. 단일행 함수 
 	1) 데이터 값을 조작하는데 주로 사용한다. 
 	2) 행별로 함수를 적용하여 하나의 결과를 반환하는 함수이다. 
 	3) 단일행 함수의 종류 
 		문자함수, 숫자함수, 날짜함수, 
 		변환함수(묵시적데이터변환/명시적데이터변환 - 문자==>숫자, 숫자==> 날짜, 날짜==> 문자), 
 		일반함수 
 4. 단일행 함수의 사용법 
 	select 함수명(컬럼명/데이터, 매개변수1,매개변수2...)
 	where 컬럼 = 함수명(컬럼명/데이터, 매개변수1, 매개변수2...) 
 	-- 단일행 함수 
	SELECT ename, comm, nvl(comm,0) 보너스2
	FROM emp;
	-- 복수행 함수
	SELECT deptno, max(sal) "부서별 최고 연봉"
	FROM emp
	GROUP BY deptno;
 
 # 문자함수 
 1. 문자 데이터를 입력하여 문자나 숫자를 결과로 반환하는 함수 
 2. 문자 함수의 종류 
 	1) 대소문자 변환 함수 
 	2) 문자조작 함수 
 	3) 문자열 길이반환 함수 
 3. initcat : 문자열의 첫번째 문자만 대문자로 변환 처리 함수 
 	lower : 문자열 전체를 소문자로 변환 
 	upper: 문자열 전체를 대문자로 변환 
 	
 */
	SELECT * FROM emp; 
	SELECT ename, initcap(ename), lower(ENAME), upper(ENAME)
	FROM emp;
--ex1) 함수를 이용하여 다음과 같은 형태로 출력하세요 
-- The Job Of Smith is a Clerk! 
--				ename     job
SELECT 'The Job of ' || INITCAP(ename) ||' is a ' || INITCAP(JOB) show
FROM EMP;
--ex2) emp테이블에 job컬럼을 'Man'이라는 문자열로 대소문자 관계없이 
-- 		키워드 검색을 하려고한다. 해당 처리 sql을 작성하세요 
-- 		해당내용이 데이터에 있는 내용으로 검색하려면 데이터베이스에 형태를 변경하거나 
--		입력하는 데이터 자체를 소문/대문자로 변경햐여야 한다. 
/*
 		사원명 [	Man	] [ search ]
 		사원번호 사원명 급여 부서 입사일 
 		  @@ 	@@	@@	@@	@@@
 		  @@ 	@@	@@	@@	@@@
 		  @@ 	@@	@@	@@	@@@
 		현재 데이터는 대문자이지만, 소문자가 들어갈 수 있다는 가정을 하면, 
 		저장된 데이터도 대문자로 변경, 입력하는 데이터도 대문자로 변경처리 
 */
SELECT ename, job
FROM emp 
WHERE upper(job) LIKE '%'||upper('Man')||'%'; 
--'Man' :입력될 데이터/검색할 데이터; 
/*
 # 문자열 길이 반환함수 
 1. length: 입력되는 문자열의 길이(글자수)를 반환하는 함수 
 2. lengthb: 입력되는 문자열의 바이트를 반환하는 함수 
 	한글이나 특수분자는 1글자의 바이트가 3byte인 경우가 있어, 
 	글자수와 byte수의 차이가 있다. 
 dual: 오라클에서 지원되는 가상테이블로 테스트용으로 한라인에 데이터와 
 함수를 적용할 때, 사용된다. 
 */
	SELECT '안녕하세요' greet, 'hello' greet2 FROM dual;
	SELECT '안녕하세요' 기본출력, LENGTH('안녕하세요') "length(한)",
		lengthb('안녕하세요') "lengthb(한)",
		length('hello!') "length(영)",
		LENGTHB('hello!') "lengthb(영)"
	FROM dual;
--ex) emp테이블의 사원명과 직책, 글자수 각각 표현하되, job의 글자수가 6이상인 경우를 검색하여 
-- 출력하세요 
SELECT ename, length(ENAME), job, length(job)
FROM emp 
WHERE length(JOB)>=6;
/*
 # 기타 문자열 조작함수 
 1. concat(문자열1, 문자열2): 두 문자열을 결합처리한다. 문자열1 || 문자열2 동일 
 	concat(concat(문자열1,문자열2),문자열3)   문자열1||문자열2||문자열3 
	 ex) concat('sql','plus') ==> sqlplus 
 2. substr(문자열데이터, 시작위치, 마지막위치): 문자열데이터를 시작위치와 마지막위치를 
 	기준으로 절삭처리하여 사용하는 것을 말한다. 
 	 ex) substr('sql*plus',5,4) ==> plus 
 	 		5번째 부터 시작해서 4개 문자 추출하여 데이터를 표현 
 	 ex) 코드성 데이터 - 사번, 주민번호, 학번에는 각각의 위치별로 의미하는 바가 있기 때문에 
 	 	추출하여 데이터 활용한다. 주민번호의 경우 생년월일을 위치에 따라 추출할 수 있다. 
 */
 SELECT empno, ename, job, concat(ename,job) "이름과 직책"
 FROM emp;
 SELECT '19'||substr('951210-2039201',1,2)||'년생' "년도"
 FROM dual; --주민번호를 통해서 몇년도에 태어났는지 추출해서 사용할 수 있다. 
 --ex1) concat을 이중으로 활용하여, 사원명-사번을 형식으로 표기하세요 
 SELECT concat(concat(ename,'-'),empno) show
 FROM emp;
--ex2) 951210-2012121 주민번호를 이용해서 1995년도 12월 10일생 입니다. 라고 
-- dual테이블로 출력하세요 
SELECT '19'||substr('951210-2012121',1,2)||'년도'||
	 substr('951210-2012121',3,2)||'월 '||
	 substr('951210-2012121',5,2)||'일생 입니다.' show
FROM dual;
	 
SELECT ''||hiredate, '19'||substr(hiredate,1,2)||'년'||
	substr(hiredate,4,2)||'월'||
	substr(hiredate,7,2)||'일' 입사일 
FROM emp; 
-- hiredate는 데이터타입이 date이고, 
-- 그래서 tool에 나타나는 모양과 문자열로 변환해서 나타나는 모양에 차이가 있다. 
-- 데이터 함수를 이용해서 처리하는 부분은 문자열로 처리해서 나타나는 부분이다. 

		