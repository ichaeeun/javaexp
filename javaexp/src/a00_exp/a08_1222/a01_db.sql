/*

1. sql 명령문의 종류(ex DQL, DDL...)와 기능을 설명하고 주요 명령문의 예제 확인해서 정리하세요.
	1) 질의어(DQL:data query language) : 데이터를 검색한다. select 
		SELECT * FROM emp; 
	2) 데이터조작어(DML:data management language) :
		 데이터를 입력, 수정, 삭제한다. insert, update, delete
		 INSERT INTO 테이블명(컬럼명1,컬럼명2..) VALUES(값1,값2..);
		 UPDATE 테이블명
		 	set 컬럼명 = 변경할 데이터, 
		 		컬럼명 = 변경할 데이터
		  where 조건문;
		  delete 
		  from 테이블명
		  where 조건문; 삭제는 row 단위로 하기때문에 컬럼명을 지칭할 필요가 없음 
	3) 데이터 정의어(DDL:data definition language) : 데이터베이스 객체 생성
		객체의 생성(create), 객체의 구조변경(alter)(ex.컬럼의 타입변경), 객체 삭제(drop), 
		객체 이름 변경(rename), 데이터 및 저장 공간 삭제(truncate)
		
	4) 트랜색션 처리어(TCL:transaction control language): 
		dml 처리 후, session별(계정접속) 트랜잭션 처리 완료 및 취소를 해주는 것을 말한다. 
		commit(dml 처리 확정), rollback(dml 처리 취소), savepoint(임의저장지점설정) 
	5) DCL(data control language) 계정별 권한을 부여 처리 
		grant(권한부여), revoke(권한부여 취소) 
2. sal+comm으로 연산하는 경우 comm null인 경우, 문제가 발생한다. 
	어떤 문제이고 이것을 해결할려면 어떤 처리를 하는지 정리하세요.
	
	comm이 null인 경우 연산결과가 null로 처리된다. 
	이경우 조건문을 달아 where comm is null; 해서 null이 아닌 comm과만 연산하도록 하거나 
	nvl 함수 이용 nvl(컬럼, null인 경우 초기데이터) -- null인 경우 초기데이터를 만들어서 연산하도록 한다. 
	1) SELECT ename, sal, comm, sal+ nvl(comm, 0) 합산 
	   FROM emp; 
	2) SELECT sal + comm
	   FROM emp
	   where comm is null;
3. 오라클에서 사용하는 주요 데이터 타입의 종류를 예시와 함께 기술하세요.
	create table 테이블명(컬럼명1 데이터타입, 컬럼명2 데이터타입,...);
	char(size)  : 고정길이 문자 데이터타입 
	코드 생성시 자리수가 정해진 데이터 
		create table personnel(
			civilnum char(13)
		);
	1) varchar2(최고크기): 가변길이 문자 데이터 타입
		사용하는 최고 크기를 설정하고, 입력되는 데이터에 따라 가변적으로 데이터크기가 
		설정되는 것을 말한다. 최대 4000바이트.. - 메모리효율화를 이룰 수 있다. 
	2) number, number(p,s): 정수/실수 등 숫자형 데이터를 설정할 때 활용된다. 
		정밀도(p)와 스케일(s) 로 표현된다. 전체크기, 소숫점이하 크기로 쉽게 표현한다. 
	3) date: 날짜/시간 형식을 저장하기 위한 데이터 타입 
	4) char(고정크기): 고정길이 문자 데이터타입, 최대 2000바이트 
		코드성 데이터 즉, 학번,사번,주민번호 등과 같이 길이가 일정하여 변경될 일이 없는 경우 사용한다. 
		가변형에 비해 입력 속도가 빠르다. 
---------------------------------------------------------------------------------
	5) nvarchar2(최고크기): 국가별 문자 집합에 따른 최고 크기의 문자를 설정하는 가변형 데이터처리
	6) rowid: 테이블 내 행의 고유 주소를 가지는 64진수 문자 타입. 행당 6바이트 또는 10바이트 
	7) blob: 대용량의 바이너리 데이터를 저장하기 위한 데이터타입 최대, 4gb 
	8) clob: 대용량의 문자열 데이터를 저장하기 위한 데이터타입 최대, 4gb 
	9) bfile: 대용량의 바이너리 데이터를 파일 형태로 저장하기 위한 데이터 타입, 4gb
	10) timestamp(n): 날짜형 데이터타입의 확장된 형태 n은 millisecond. 
		자리수는 최대 9자리까지 표현가능 
		
4. 문자열을 저장하는 데이터 중, 고정형과 가변형이 있다. 두 데이터 유형의 차이점을 기술하세요.
	고정형은 문자데이터 크기가 정해져 있다. 
	크기가 작은 문자열을 입력하더라도 공백으로 해당 크기만큼 저장된다. 
	char(size) 코드 생성시 자리수가 정해진 데이터에 활용한다. 
	가변형은 최대크기를 설정해서 그보다 작은 데이터를 할당할 수 있다.
	최대크기 이하 데이터를 입력시, 해당크기만큼 데이터가 저장된다.  
5. 데이터 유형을 확인하고, 학생테이블(번호, 이름, 국어, 영어, 수학)을 만들고 데이터를 입력하세요.
*/
	CREATE TABLE student(
		num varchar2(20),
		name varchar2(20),
		kor NUMBER,
		eng NUMBER,
		math NUMBER 
	);

	SELECT * FROM student;
	INSERT INTO student values(1,'홍길동',80,90,85);
	INSERT INTO student values(2,'삼길동',85,70,65);
	INSERT INTO student values(1,'사길동',90,75,80);
-- 테이블의별칭.* (:전케 컬럼)에서 추가할 때는 테이블 테이블별칭으로 설정 
-- 컬럼을 통한 연산이나 함수를 통해서 처리될 수 있는 데이터는 테이블로 관리하지 않는다.
-- round(컬럼, 소숫점자리수): 해당 자리수만큼 반올림처리. 
	SELECT a.*, kor+eng+math 총계, ROUND((kor+eng+math)/3,1) 평균
	FROM student a;
/*
6. 스포츠 스타의 이름 소속사 올해 성적을 입력하는 테이블을 만들고 데이터를 입력하고 조회하세요.
*/
	CREATE TABLE sportstar(
		name varchar2(20),
		company varchar2(20),
		grade NUMBER(10,3)
	);
	SELECT * FROM sportstar;
	INSERT INTO sportstar values('오재원','두산',0.318);
	
/*
7. select에서 쓰이는 컬럼과 where 조건의 비교 연산자에 쓰이는 컬럼은 어떤 차이가 있는가?
	select 선택컬럼1, 선택컬럼2
	from 테이블 
	where 조건컬럼1 = 데이터, 
	and 조건컬럼2 = 데이터 
	선택컬럼: 출력한 컬럼에 대한 선택을 처리한다.(열단위 선택)
	조건컬럼: 출력한 row단위 filtering처리 (행단위 필터링) 
	# 2차원의 데이터를 select,where에 의해서 행/열 단위로 선택 및 필터링을 해준다. 
	
*/
	SELECT empno,ename,job
	FROM EMP 
	WHERE job = 'SALESMAN';
/*
	
8. where 조건에 쓰이는 비교 연산자의 종류와 논리 연산자의 종류를 기술하세요.	
	WHERE 컬럼명1 = 데이터 
	AND 컬럼명2 = 데이터 
	비교연산자: =, !=,<>,  <=, >=, <, > 가 있다. 
	논리 연산자: and, or, not 
	기타 함수나 키워드: between a and b, is null, in ... 
9. between, in 구문의 기본형식을 선언하고, 기본 예제를 기술하세요.
	컬럼명 between A and B : A와 B 사이 데이터를 출력한다. 
	컬럼명 in (데이터1,데이터2,...), 컬럼명 in(subquery) 
*/	
 	select * from emp
 	where sal between 2000 and 3000; 
 /*
 	where 컬럼명 in (데이터1, 데이터2, ..) 데이터 중 하나라도 맞으면 출력한다. 
 */
 	select * from emp
 	where job in ('SALESMAN', 'MANAGER');
 /*	
------------------------------------------------------------------

*/