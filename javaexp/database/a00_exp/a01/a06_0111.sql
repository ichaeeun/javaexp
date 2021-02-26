/*
[데이터베이스]
[하] 1. merge의 형식으로 테이블간, 입력데이터간 처리 기본형식을 기술하세요.
	MERGE INTO 테이블명 
 	USING 테이블명 B 
 	ON A와 B의 특정한 컬럼비교 
 	WHEN MATCHED THEN: 두개의 테이블의 특정 컬럼에 데이터가 있을 때. 
 		 UPDATE SET: 수정 처리 
 	WHEN NOT MATCHED THEN 
 		 INSERT VALUES: 등록 처리 
[중] 2. dept구조 복사 테이블 dept10, dept11을 만들고, 위에 기술한 merge입력처리 예제, 
    테이블간 복사 merge예제를 만드세요
*/
CREATE TABLE dept10 
AS SELECT * FROM dept;
SELECT * FROM dept10;

CREATE TABLE dept11 
AS SELECT * FROM dept10 WHERE 1=0;
SELECT * FROM dept11;
MERGE INTO dept11 a
USING dept10 b 
ON (a.deptno=b.deptno)
WHEN MATCHED THEN 
UPDATE SET a.dname=b.dname,
			a.loc=b.loc
WHEN NOT MATCHED THEN 
INSERT values(b.deptno,b.dname,b.loc);

UPDATE dept10
SET dname='회계'
	WHERE deptno=10;
INSERT INTO dept10 values(50,'인사','서울강남');

MERGE INTO dept11 a
USING dept10 b 
ON (a.deptno=b.deptno)
WHEN MATCHED THEN 
UPDATE SET a.dname=b.dname,
			a.loc=b.loc
WHEN NOT MATCHED THEN 
INSERT values(b.deptno,b.dname,b.loc);
SELECT * FROM dept11;
-- 웹프로그램에서 
-- 부서번호 [ ]
-- 부서명 [ ]
-- 부서위치 [ ] 
--	[등록/수정] - 요청값을 전달해서 자바프로그램에서 db처리할 때 활용된다. 
MERGE INTO dept11 a 
USING dual 
ON (a.deptno=60)
WHEN MATCHED THEN 	
	UPDATE SET a.dname='it사업',
			   a.loc='서초'
WHEN NOT MATCHED THEN 
	INSERT (deptno,dname,loc)
	values(60,'it사업','서초');

MERGE INTO dept11 a 
USING dual 
ON (a.deptno=30)
WHEN MATCHED THEN 	
	UPDATE SET a.dname='영업',
			   a.loc='개포동'
WHEN NOT MATCHED THEN 
	INSERT (deptno,dname,loc)
	values(30,'영업','개포동');




