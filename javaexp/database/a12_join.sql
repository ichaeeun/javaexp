/*
 # 조인이란? 
 1. 하나의 sql명령문에 의해 여러 테이블에 저장된 데이터를 한번에 조회할 수 있는 기능을 말한다. 
 2. 두개의 테이블에서 공통되는 컬럼을 기준으로 조건문을 만들어, 조인을 한다. 
 3. 기본 형식 
	SELECT 테이블별칭.컬럼명, 테이블별칭.컬럼명 ... 
	FROM 테이블1 별칭, 테이블2 별칭 
	WHERE 별칭.공통컬럼 = 별칭.공통컬럼 
*/ 
-- emp 마지막 컬럼인 deptno를 통해서 부서번호를 가지고 있다. 
SELECT * FROM emp;
-- dept는 첫번째 컬럼인 deptno를 통해서 정보를 가지고 있다. 
SELECT * FROM dept;
-- 사원별로 부서이름을 가져올려면 다음과 같은 sql 사용 
SELECT * 
FROM EMP e 
WHERE deptno=20;
-- 부서테이블에서 부서정보 sql을 사용하여 가져온다. 
SELECT * 
FROM DEPT d 
WHERE deptno=20;
-- 두개의 테이블에 공통되는 부서번호(deptno)가 있기 때문에 join관계를 활용하면 
-- 사원별로 부서정보(부서번호, 부서명, 부서위치)를 가져올 수 있다. 
SELECT e.*, d.*
FROM emp e, dept d
WHERE e.deptno=d.deptno;


-- cf) 통합 테이블 사용 시 (테이블 분리의 필요성) 
CREATE TABLE emp_dept
AS 
SELECT e.*,dname,loc
FROM emp e, dept d
WHERE e.deptno=d.deptno;
-- 1. 입력시 부서정보의 부서명, 위치를 계속 입력해야한다.(메모리 비효율) 
-- 2. 부서명, 위치를 잘못입력할 수 있다. 
-- 3. 수정/삭제 시 데이터 건수가 늘어날 수록 엄청난 부하를 발생한다. 
--	ex)부서명이나 부서위치가 변결될때, 통합테이블과 분리된 테이블의 차이 
--		ACCOUNTING ==> 회계 
--		1) DEPT 테이블이 있을 때, DEPT테이블의 1개의 ROW만 수정 
--		2) 통합되어 있을 때, EMP_DEPT테이블에 있는 데이터 건수만큼 수정 



-- 부서명, 사원명, 급여 
SELECT d.dname , e.ename, e.sal
FROM emp e, dept d 
WHERE e.deptno=d.deptno;
--
SELECT deptno 부서번호, dname 부서이름, loc 부서위치  
FROM dept;
-- ex) 사원번호, 사원명, 부서이름, 부서위치를 출력하세요 
-- 컬럼명 해당 테이블 고유의 컬럼이면, 테이블의 별칭을 사용하지 않아도 된다. 
SELECT empno 사원번호, ename 사원명, dname 부서명, loc 부서위치 
FROM emp e, dept d
WHERE e.deptno = d.deptno;
-- 검색 조건의 추가 또는 기존의 여러가지 sql query 사용하기 
-- 급여가 3000 이상인 부서명, 부서위치, 사원명, 급여를 출력 
SELECT dname, loc, ename, sal 
FROM emp e, dept d
WHERE e.deptno=d.deptno 
AND sal>=3000;
-- ex) 3,4 분기 입사한사원의 이름과 부서위치, 분기를 출력하세요 
SELECT ename, loc, to_char(hiredate,'Q') "분기"
FROM emp e, dept d
WHERE e.deptno=d.DEPTNO 
AND to_char(hiredate,'Q') IN ('3','4');
-- ex) 부서명별 최고 급여를 출력하세요. 부서명, 급여 
SELECT dname, max(sal) 
FROM emp e, dept d
WHERE e.deptno=d.DEPTNO 
GROUP BY dname;
/*
 # 카티션 곱 
 1. 전체 데이터 내용을 리스트 처리하는 것을 말한다. 
 	where 조건을 걸지 않을 때, 연관 관계와 별도로 하나의 테이블의 하나의 행에 
 	반대쪽 테이블에 전체행이 연결되어 리스트 되어진다. 
 */
SELECT e.*, d.*
FROM emp e, dept d;

SELECT e.*, d.* 
FROM emp e CROSS JOIN dept d;
-- # equi join = natural join 
-- 두개의 공통되는 컬럼으로 조인을 하는 것을 말한다. 
SELECT *
FROM emp NATURAL JOIN dept;
/*
 # non-equi join
 1. 두개의 테이블에 조인할 조건이 '='(동일) 조건이 아니고, 범위를 지정할 때 
 	활용된다. 
 */ 
SELECT * FROM SALGRADE s ;
-- grade: 등급, local: 최소, hisal: 최대범위 
-- 사원의 이름과 급여, 등급을 표시하세요 
SELECT ename, sal, grade 
FROM emp e, salgrade s
WHERE e.sal BETWEEN losal AND hisal;
/*
 # outer join 
 1. 두개의 테이블에서 equi join 시, 한쪽에 해당 데이터가 없으면, 
 	나타나지 않는 특징이 있다. 이때, 특정한 테이블 기준으로 해당 테이블과 
 	조인하는 테이블이 데이터가 없더라도 데이터를 출력하게 해주는 join이 outer join이다. 
 */
SELECT * FROM dept;
SELECT DISTINCT deptno FROM emp;
-- emp에 있는 deptno데이터와 dept에 있는 deptno데이터에는 차이가 발생한다. 
-- 데이터의 존재여부에 상관없이 조인하여 현재 부서번호에 따른 할당 내용을 확인하고자 
-- outer join을 활용한다. 
SELECT d.*, ename, job, sal 
FROM dept d, emp e
WHERE d.deptno = e.deptno(+)
ORDER BY d.deptno;
-- e.deptno(+) : 사원테이블에 부서테이블에 비해 데이터가 없을 때, 
--				 NULL인 내용도 표기할 때, 해당 테이블의 컬럼을 (+)로 표기한다. 
/*
 # self 조인
 1. 하나의 테이블 안에 컬럼끼리 연관관계(계층관계)가 있어, join형식으로 데이터를 처리하는 것을 말한다. 
 2. 형식 
 	select a.*, b.* 
 	from 테이블1 a, 테이블1 b 
 	where a.컬럼1= b.컬럼2 
 */
SELECT * FROM emp; 
-- empno: 사원번호, mgr: 해당 사원의 관리자 사원번호 
-- SMITH의 관리자의 이름 
SELECT empno, ename, mgr
FROM EMP
WHERE ename='SMITH';
SELECT empno, ename 
FROM emp 
WHERE empno=7902;
-- 사원의 이름과 사원의 관리자 이름을 출력하세요 
-- 1. 연관관계가 있는 컬럼을 선택: empno, mgr 
-- 2. 하나의 테이블을 두개로 alias이름으로 선언하고, 두개의 컬럼을 연관관계를 설정한다. 
SELECT a.empno, a.ename, a.mgr, b.empno, b.ename 
FROM emp a, emp b -- 테이블 내에 self 조인이 있으면 alias를 사용 
WHERE a.mgr = b.empno;
-- 관리자 번호의 사원정보를 하나의 sql로 가져오고자 할때, 
-- join관계를 설정하여 처리한다. 
/*
 위 계층관계 테이블을 이해했으면, 아래와 같은 하나의 테이블 내에 계층 관계가 있는 
 데이터를 처리해보세요. 
 family 
 no(번호) pos(역할) name(이름) parno(부모번호) 
 1		할아버지		홍말순	0
 2		아버지		홍판서	1
 3		아들1			홍진희	2
 4		아들2			홍길동 	2 
 
 sample 데이터 입력, 
 @@@부모의 이름은 @@@ 이다 출력 
 */
CREATE TABLE family(
	no1 NUMBER, 
	pos varchar2(20),
	name varchar2(20),
	parno number
);
INSERT INTO family values(1, '할아버지','홍말순',0); --	최상위 계층 
INSERT INTO family values(2, '아버지','홍판서',1); -- no1과 parno의 연관관계를 설정하여 데이터 입력 
INSERT INTO family values(3, '아들1','홍진희',2);
INSERT INTO family values(4, '아들2','홍길동',2);
SELECT * FROM family;

SELECT a.name||'의 부모의 이름은 '||b.name||'이다.' show
FROM family a, family b
WHERE a.parno = b.no1;

 










 	
