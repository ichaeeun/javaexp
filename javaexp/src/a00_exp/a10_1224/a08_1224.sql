/*
# 주간정리과제
1. 컬럼과 테이블의 별칭에 대하여 예제를 통해서 기술하세요.
	컬럼명의 별칭은 데이터 리스트 상단에 컬럼명으로 표기 
	특수문자나 공백을 사용할 때는 ""사용. 
	cf) 추후 데이터 연결 시 중요한 컬럼지칭명으로 사용된다. 
	테이블 별칭은 다른 테이블과 중복적으로 조인 시 활용되고, 
	전체 테이블의 컬럼에서 추가적인 컬럼을 처리할 때 활용된다. 
	select 컬럼명 별칭 
	from 테이블명 별칭 
	SELECT a.*, nvl(comm, 0)+sal "총계"
	FROM emp a;
*/
	SELECT a.*, empno AS NO, ename name, job "직 책" 
	FROM emp a;
/*
2. 아래의 형식으로 emp 테이블을 출력하세요.
    사원명(사원번호)의 급여는 @@, 보너스는 @@ 합계 @@ 이다.
*/
	SELECT ename||'('||empno||')의 급여는 '||sal||
	', 보너스는 '||comm||', 합계 '||(sal+nvl(comm,0))||'이다.' show
	FROM emp;
/*
3. sql 명령문의 표준 형식을 간단한 예제를 통해서 설명하세요.
	SELECT 컬럼명, 그룹함수() 
 	from 테이블명 
 	where 조건(비교연산자/컬럼명) 
 	group by 그룹함수를 활용할 때, 그룹핑할 컬럼 
 	HAVING 그룹함수()의 결과를 기준으로 (비교/논리연산자) 
 	order by 정렬할 컬럼명 ASC(default 오름차순) DESC(내림차순) 
 */
	
	SELECT deptno, avg(sal) savg --부서번호 별 평균 급여 
	FROM emp 
	WHERE deptno >= 20 -- 부서번호 20 이상인 것. 
	GROUP BY deptno    -- 부서번호를 그룹함수로 처리 
	HAVING avg(sal) >=2000 -- avg(sal) 사용. 
						   -- 그룹함수가 적용된 부분은 where조건 검색불가능. 
						   -- => HAVING 이용. 
	ORDER BY deptno DESC; 
/*
4. sql에서 null이란 무엇을 의미하는지 기술하고, null인 컬럼과 그렇지 않는 컬럼을 구분하세요.
	null이란 특정 컬럼에 데이터가 할당되지 않는 것을 말한다. 
	cf) 이러한 null으로 된 내용을 프로그래밍(Java)에서 호출을 하면 
		숫자형 데이터는 0으로 처리되고, String(문자열)로 된 데이터만 null로 할당된다. 
*/
	SELECT * FROM emp
	WHERE comm IS NULL; --comm이 null인 데이터를 로딩할 때 활용한다. 
/*
5. sql의 논리연산자와 비교연산자를 구분하여 기술하세요.
	SQL 구문으로는 WHERE 문과 HAVING에서 활용한다. 
	논리연산자(TRUE/FALSE)로 처리되는 구문.(=,!=,<>,<,<=.>,>=)
	논리연산자를 AND, OR로 연결한 것을 비교연산자.(조건1 AND 조건2, 조건1 OR 조건2) 
	추가하여 NOT 연산자, BETWEEN A AND B, IS NULL, IN 구문을 활용하여 
	조건문에 사용된다. 
	
6. 데이터베이스에서 사용하는 데이터 타입의 종류를 기술하세요.
	
	varchar(n):  가변길이 문자열 데이터타입, n을 최고크기로 설정하여 문자열 데이터 할당. 
	char(n): 고정길이 문자열 데이터타입, n크기로 데이터가 입력되는 문자열. 
		ex) char(5) 데이터 'a' 할당되면 'a    ' 뒤에는 공백이 할당되어 크기동일하게 설정됨.
	number(p,s) : 전체크기와 소숫점이하 크기를 설정할 수 있는 숫자형 데이터 타입 
	date 날짜/시간을 입력할 수 있는 데이터타입 
	timestamp(n) : date형의 확장 형태로 n milliseconds로 세부적인 시간까지 처리 
	blob : 대용량 바이너리 데이터(일반 파일, 이미지 등)를 데이터유형으로 할당. 최대 4gb
	clob : 대용량 텍스트 데이터 할당. 최대 4gb 
	bfile : 대용량의 파일형 데이터를 파일형으로 저장하기 위한 데이터 타입. 최대 4gb 
	rowid : 테이블 내 행의 고유 주소를 가지는 64진수 문자 유형 
	
7. 위 데이터 타입을 이용하여 
    학번, 이름, 전공, 주소, 학년, 입학일 의  테이블을 구성하고, 데이터를 입력하세요.
*/
	CREATE TABLE student2(
		num char(7),	--입학년도,단과정보,그외sequence(순서) 
		name varchar2(20),
		major varchar2(20),
		address varchar2(30),
		grade NUMBER,
		entdate DATE
	);
	INSERT INTO student2 values(1306060,'홍길동','컴퓨터공학','강남구',3,'1999-12-12');
	INSERT INTO student2 values(1306061,'장길동','컴퓨터공학','경기도',3,'2012-05-17');
	INSERT INTO student2 values(1306062,'김길동','컴퓨터공학','서초구',3,'2013-03-12');
	INSERT INTO student2 values(1306063,'이길동','소프트웨어','강남구',2,sysdate);
	-- sysdate : 현재 입력하는 시간 (milliseconds까지) 출력 
	--	ex) SELECT sysdate FROM dual;
	-- 날짜형식을 입력시는 문자열 ==> 날짜로 변환하는 함수인 to_date()를 활용하여 입력한다. 
	SELECT * FROM student2;
/*
8. 함수란 무엇이며, 함수에 단일행 함수와 다중행 함수의 차이점을 예시를 통해서 설명하세요.
	
	함수의 매개변수를 통해 데이터가 입력되면, 함수로 인하여 원하는 데이터 형식으로 변경하여 
	효율적으로 활용하기 위하여 사용된다. 
	단일행 함수: 입력한 데이터의 갯수와 출력한 데이터의 갯수가 동일할 때를 말한다. 
				일반적인 함수. 
	복수행 함수 : 여러 입력한 데이터에 의해서 그룹으로 처리하여, 단일 또는 그룹의 데이터 건수에 
				의해서 처리되는 함수. 

	
9. 문자 함수가 사용되는 용도에서 웹화면에 물품명을 대소문자 관련없이 검색한다고 가정할 때,
    product(테이블명), pname(검색할 물건명) 을 기준으로 sql을 작성하세요.
    
    SELECT *
    FROM product
    WHERE upper(pname) LIKE upper('%'||검색데이터||'%');
  */
	CREATE TABLE product(
		pname varchar2(20)
	);
	INSERT INTO product values('MacBook');
	INSERT INTO product values('KeyBoard');
	INSERT INTO product values('Mouse');
	INSERT INTO product values('Macpro');
	INSERT INTO product values('Macair');

	SELECT pname
	FROM product
	WHERE upper(PNAME) LIKE '%'||upper('mac')||'%';

/*
10. length와 lengthb를 차이를 기술하고,  dual을 이용해서 한글과 영문을 비교하세요.
	length: 문자열의 크기를 처리해주는 함수. 영문/한글 구분없이 글자당 처리 
	lengthb: 문자열의 byte크기를 처리해주는 함수. 영문은 한글자당 1byte, 
			한글은 3byte(oracle) 
*/
	SELECT length('가나다') 한글, lengthb('가나다') 한글b,
	length('abc') 영어, lengthb('abc') 영어b
	FROM dual;
/*
11. ||, substr  이용하여  [ename(deptno)의 직책은 job 입니다. ] 형식으로 출력하세요.   
    ename : 앞에서 3자 추출
    job :뒤에서 5자 추출
*/
	SELECT '['||substr(ename,1,3)||'('||deptno||')의 직책은 '||substr(job,-5,5)||'입니다.' show
	FROM emp;

/*
12. lpad와 ltrim의 기본적인 형식을 기본예제와 함께 기술하세요.
	lpad(컬럼/데이터,전체지정크기,덧붙일문자열)
	ltrim(컬럼/데이터,지정문자왼쪽에서부터 삭제처리)
*/
	SELECT lpad('sql',5,'*')FROM dual;
	SELECT ltrim('***sql','*') FROM dual;
	
	SELECT ename, lpad(ename,10,'#') show 
	FROM emp;
	SELECT 