--1. 조회의 기본 형식을 기술하고, 예제를 통해서 그 의미를 기술하세요.
/*
 SELECT 컬럼명 FROM 테이블명; 
 SELECT * --모든 컬럼 조회 
 FROM emp; --emp 테이블에서 조회 
 */
--2. 컬럼의 별칭사용 형식을 기술하고, 기본 예제를 통해 기술하세요.
/*
 SELECT 컬럼명 as 별칭명, 컬럼명 별칭명 으로 사용한다. 
 별칭명으로 공백이나 @,# 등 특수문자를 사용할때는 ""를 사용한다. 
 SELECT ename as name, empno 번호, empno "@ 번 호 @"
 FROM emp; 
 */
--3. dbeaver에서 데이터 베이스서버에 연결하는 핵심 정보를 기술하세요.
/*
 	1) jdbc 드라이버설정 : 클라이언트 툴에 jdbc 드라이버설정
 		ex) dbeaver: 메뉴(데이터베이스 ==> 드라이버관리자)
 	2) 데이터베이스 서버 연결: 
 		host : 특정 db서버의 ip 주소, 
 				현재 사용자(클라이언트) 컴퓨터와 서버 위치가 동일하면 localhost
 		port : db서버를 접근할 port ex)1521
 		database sid : 데이터베이스 식별자 ex)xe
 		username : 사용자 계정명 ex)scott
 		password : 비밀버호 ex)tiger 
 */
SELECT * FROM emp;
--4. @@님의 사원번호는 @@이고, 올해 연말보너스는 연봉의 20%인 @@원입니다.
SELECT ename || '님의 사원번호는 ' || empno || '이고, 올해 연말보너스는 연봉의 20%인 '||
			sal*0.2 || '입니다.' show
FROM emp;
--5. sql문의 기본 형식을 기술하고, 각 기본 형식에서 활용되는 keyword를 예제별로 기술하세요.
SELECT DISTINCT * -- distinct: 중복된 데이터 배제 처리 
FROM emp;
SELECT deptno 
FROM EMP 
GROUP BY deptno; -- group by : deptno로 그룹핑 
SELECT ename, empno, sal
FROM emp;
ORDER BY empno; -- empno로 정렬한다 
SELECT *
FROM emp
WHERE deptno=10; --where 조건의 데이터만 조회한다. 
--SELECT
--  distinct : 데이터의 중복을 삭제
--  * : 전체 데이터
--  컬럼명 : 특정 컬럼
--  as 별칭
-- FROM 테이블 : 데이터를 호출할 테이블을 지칭 
-- WHERE 조건: 컬럼명 = 데이터, >, <, >=, <=, !=, <> 비교연산자 AND OR IN
--				BETWEEN A AND B 등의 키워드를 이용해서 데이터의 조건을 
--				[행단위] 선택 처리 한다. 
-- GROUP BY 컬러명: 특정 컬럼의 데이터를 그룹으로 분류하여 그룹함수 (min(), max(),
--				avg(), count()) 등을 이용하여 데이터를처리 할 때, 활용된다. 
-- HAVING 조건 : 그룹함수를 통한 결과값을 조건에 따라 FILTERING 할때, 사용된다. 
-- 기타 SQL: SUBQUERY, 내장함수이용을 이용해서 데이터를 조회하고, UPDATE, INSERT,
--			DELETE 구문으로 데이터를 수정, 등록, 삭제 처리한다. 
--6. 컬럼명을  별칭명으로 사용할 때, ""를 활용하는 이유는 무엇인가?
-- 별칭명으로 공백이나 @,# 와 같은 특수문자를 쓸 때 ""를 활용한다. 
--7. sql에서 ||와 + 의 차이점을 기술하세요.
-- ||는 컬럼 또는 데이터를 연결(concatenate)를처리할 때 활용된다.  
-- +는 숫자형 데이터 + 숫자형 컬럼: 숫자 데이터값의 연산 시 사용한다. 
--8. sql을 이용하여 
-- @@번 부서의  사원 @@@(사원번호)의 현재 연봉은 @@ 만원입니다.
-- 를 한 라인으로 출력하되, 연봉이 3000이상인 사원만 출력되게 하세요.

SELECT deptno ||'번 부서의 사원 ' || ename ||'('||empno||')의 현재 연봉은 ' || sal ||'만원 입니다.' show
FROM emp
WHERE sal>=3000;