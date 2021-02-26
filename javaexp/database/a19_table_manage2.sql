/*
1. 테이블명의 변경 
	1) 형식
		RENAME 기존테이블명 TO 새로운테이블명; 
*/
SELECT * FROM emp51;
RENAME emp51 TO emp52;
SELECT * FROM emp52;
/*
2. 컬럼명 변경 
	1) 형식
		ALTER TABLE 테이블명 
		RENAME COLUMN 기존컬럼명 TO 새로운컬럼명;
*/
SELECT * FROM emp50;
ALTER TABLE EMP50
RENAME COLUMN empno TO NO;
/*
 1. 테이블명 변경 명령어를 활용하여 아래 내용을 처리하세요
 	1) emp53구조복사해서 테이블 만들기
 	2) dept테이블을 dname,loc를 추가 
 		SALGRADE의 GRADE추가 
 	3) hirdate와 deptno컬럼 삭제 
 	4) subquery를 이용해서 해당 데이터에 맞게 데이터를 입력 
 	5) hiredte의 credte로 컬럼명 변경, 데이터 삭제 후 
 		varchar2로 변경하여 2001/12/12형식으로 데이터 입력처리 
 */
CREATE TABLE emp53 AS SELECT * FROM emp WHERE 1=0;
ALTER TABLE emp53
ADD (dname varchar2(30),
	loc varchar2(30),
	grade NUMBER);
SELECT * FROM emp53;
INSERT INTO emp53(empno, ename, job, mgr, hiredate, sal, comm, dname, loc, grade)
SELECT e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, e.comm, d.dname, d.loc, s.grade
FROM emp e, dept d, salgrade s
WHERE e.deptno =d.deptno
AND e.sal BETWEEN s.losal AND s.hisal;

ALTER TABLE emp53
RENAME COLUMN hiredate TO credte;
/* 데이터가 입력된 상태에서 컬럼의 데이터유형을 변경할 때
 * 1. 임시테이블이나 다른 테이블에 해당 key와 변경할 데이터가 저장되어 있어야 한다.
 *  */
-- 특정한 컬럼의 데이터 삭제는 update구문을 통해서 처리한다. 
-- 기존에 있는 데이터의 type을 문자=>숫자,날짜=>문자 변경은 데이터를 삭제 후 처리 
UPDATE emp53
SET credte=NULL;
ALTER TABLE emp53
MODIFY credte varchar2(10);
--수정처리할 테이블기준으로 기존테이블에 있는 empno와 입력할 테이블의 empno의 join관계로 수정 
UPDATE emp53 b
SET credte=(SELECT to_char(hiredate,'YYYY/MM/DD') FROM emp a WHERE a.empno=b.empno);
SELECT * FROM emp53;

















