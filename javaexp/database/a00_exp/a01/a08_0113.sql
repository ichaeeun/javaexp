/*
[데이터베이스]
[하] 1. 테이블 구조변경 형식을 기본 예제와 함께 기술하세요.
	alter table 명령문을 이용하여,
 	컬럼의 추가, 삭제, 타입이나 길이의 재정의와 같은 작업을 할 수 있다. 
 
 	alter table 테이블명 
 	add 컬럼명 데이터유형 [default 디폴트데이터], [제약조건]
[하] 2. 테이블 구조변경의 한계(데이터 입력, 유형, 크기 별로)를 기술하세요.
	 테이블의 컬럼의 타입, 크기, 기본값은 변경이 가능하다. 
      alter table 테이블명
      modify 컬럼 데이터유형 옵션1
 	 - 기존 컬럼에 데이터가 없는 경우 
      컬럼 타입이나 크기 변경이 가능 
   	 - 기존 컬럼에 데이터가 있는 경우 
      - 타입변경 char, varchar2 허용 
      - 변경한 컬럼의 크기가 저장된 데이터의 크기보다 같거나 클 경우만 가능 
         varchar2(10)==>varchar2(15) 변경가능 
         varchar2(5) ==> varchar2(4) (X)
[중] 3. 테이블 구조복사 종합예제
    1) emp54으로 구조복사해서 테이블 만들고,
    2) 테이블을 dname, position 를 추가. 
       grade char(1) 추가
       tmp_empno char(10)로 추가
    3) 입사년월(4)부서번호(2)사원번호(4) 로 tmp_empno 할당 처리,
    4) subquery를 이용해서 해당 데이터에 맞게 데이터를 입력처리.
        grade는 sal의 등급에 따라 5000이상 A, 4000 이상 B, .. C...로 할당 처리.
    5) hiredate는 credte로 변경 char(8)  YYYYMMDD  변경처리
    6) empno 컬럼 삭제 처리, tmp_empno는 empno로 컬럼명 변경
*/
DROP TABLE emp54;
CREATE TABLE emp54 AS SELECT * FROM emp WHERE 1=0;
ALTER TABLE emp54
ADD (dname varchar2(30), POSITION varchar2(50), grade char(1), tmp_empno char(10));

SELECT * FROM emp54;
-- 입력할 데이터의 subquery를 일단 데이터 sql로 확인 
-- 확인 후 해당 테이블에 데이터 입력처리 
INSERT INTO emp54
SELECT empno, ename, job, mgr, hiredate, sal, comm, e.deptno, 
	dname, loc position, 
	CASE 
		WHEN sal>=5000 THEN 'A'
		WHEN sal>=4000 THEN 'B'
		WHEN sal>=3000 THEN 'C'
		WHEN sal>=2000 THEN 'D'
		WHEN sal>=1000 THEN 'E'
		ELSE 'F' 
	END grade, 
	to_char(hiredate,'YYMM')||e.deptno||empno tmp_empno
FROM emp e, dept d
WHERE e.deptno=d.deptno;

ALTER TABLE emp54
RENAME COLUMN hiredate TO credte;
-- 데이터가 있을 때, 컬럼의 데이터 타입을 변경하고, 다시 해당 유형으로 데이터를 입력할 때. 
-- 1. emp테이블이 없을 때 임시테이블에 복사처리 
--	  key인 empno와 함께 복사할 컬럼을 지정해야 한다. 

CREATE TABLE emp54_tmp 
AS SELECT empno, credte FROM emp54;
SELECT * FROM emp54_tmp

UPDATE emp54
SET credte = NULL;

ALTER TABLE emp54 
MODIFY credte char(8); 

UPDATE emp54 a
SET credte = (SELECT to_char(credte,'YYYYMMDD') 
				FROM emp54_tmp b WHERE a.empno=b.empno);
SELECT * FROM emp54;
			
ALTER TABLE emp54
DROP COLUMN empno;

ALTER TABLE emp54
RENAME COLUMN tmp_empno TO empno;
SELECT * FROM emp54;





