/*
 # foreign key: 한 열과 참조된 테이블의 열간에 외래키 관계를 설정하고 
 				실행가능하게 처리 
 	ex) 아래와 같이 사원테이블의 부서번호는 참조키관계를 부서테이블의 부서번호와 
 		설정하면 반드시 부서테이블에 데이터가 있어야 사원테이블에 입력이 가능하다. 
 1. 기본형식 
 	컬럼명 데이터유형 constraint 제약조건명 references 참조할테이블(참조할컬럼) 
 	컬럼명 데이터유형 references 참조할테이블(참조할컬럼) 
 */
SELECT * FROM emp;
SELECT * FROM dept; 
SELECT max(empno) FROM emp;
INSERT INTO emp(empno,deptno) values(7935,50); 
-- error: integrity constraint (SCOTT.FK_DEPTNO) violated - parent key not found
-- dept테이블에 없는 데이터인 50은 emp에 추가할 수 없음 (foriegn key) 
-- ex) 학사관리시스템의 학생테이블과 학과테이블을 만들고, 학과테이블의 학과번호와 
-- 	   학생테이블의 학과번호를 참조키 관계를 설정해보자. 
CREATE TABLE studept(
	deptno number(3) PRIMARY KEY, 
	dname varchar2(50),
	loc varchar2(50)
);
INSERT INTO studept values(101,'컴퓨터공학과','1호관');
SELECT * FROM studept;
CREATE TABLE student03(
	studno NUMBER PRIMARY KEY,
	name varchar2(50) NOT NULL,
	deptno number(3) CONSTRAINT STUDENT02_DEPTNO_FK REFERENCES studept(deptno)
);
INSERT INTO student03 values(1000,'홍길동',101); 
INSERT INTO student03 values(1001,'신길동',102); -- 참조테이블에 없는 데이터 입력시 에러
 
/*
 # check 제약조건 설정 
 1. 컬럼에서 허용가능한 데이터의 범위나 조건을 지정할 때 활용된다. 
 	ex) 학년은 1~4학년까지만 입력, 학생들의 점수의 범위 0~100 까지, 
 		성별은 '남','여' 만 입력 가능 
 2. 기본형식 
 	컬럼명 데이터유형 constraint 제약키명 check(컬럼명 조건문)
 	ex) 1,2,3,4 입력가능 
 	grade number(1) constraint stud_grade_ck check(grade in (1,2,3,4))
 	ex) 1~100 만 입력가능 
 	kor number(3) constraint stud_kor_ch check(kor between 1 and 100);
 */
CREATE TABLE student04(
	name varchar2(50) NOT NULL, 
	grade number(1) CONSTRAINT student01_grade_ck check(grade IN(1,2,3,4))
);
SELECT * FROM ALL_CONSTRAINTS 
WHERE owner='SCOTT';
INSERT INTO student04 values('홍길동',1);
INSERT INTO student04 values('홍길동',null);
-- check 제약조건은 null은 허용된다. 
INSERT INTO student04 values('김길동',5); -- error 
SELECT * FROM student04;
-- ex) student04 테이블을 no는 primary key, 이름은 not null,
-- 성별은 남/여, 국어, 수학,영어 점수는 0~100만 입력간으하게 만드세요 
CREATE TABLE student05(
	NO NUMBER PRIMARY KEY,
	name varchar2(50) NOT NULL,
	sex char(3) CONSTRAINT student05_sex_ck check(sex IN ('남','여')),
	kor NUMBER CONSTRAINT student05_kor_ck check(kor BETWEEN 0 AND 100),
	math NUMBER CONSTRAINT student05_math_ck check(math BETWEEN 0 AND 100),
	eng NUMBER CONSTRAINT student05_eng_ck check(eng BETWEEN 0 AND 100)
);
INSERT INTO student05 values(1,'홍길동','여',40,50,60);
INSERT INTO student05 values(2,'김길동','남',50,10,20);
INSERT INTO student05 values(3,'신길동','여',40,50,60);
SELECT * FROM student05;
SELECT * FROM all_constraints WHERE TABLE_NAME='STUDENT05';
/*
 # 기존 테이블에 무결성 제약조건 추가. 
 1. null을 제외한 무결성 제약조건 추가 
 	1) 기본 형식 
 		alter table 테이블명 
 		add constraint 제약조건이름 제약조건타입 컬럼; 
 2. null 무결성 제약조건 추가 
 	alter table 테이블명 
 	modify 컬럼명 constraint 제약조건이름 제약조건타입; 
 */
CREATE TABLE student06(
	NO NUMBER,
	name varchar2(50),
	kor number(3),
	eng number(3),
	math number(3)
);
-- 고유키 제약조건 설정 
ALTER TABLE student06
ADD CONSTRAINT stud06_no_uk unique(no);
-- not null 제약조건 설정 
ALTER TABLE student06
MODIFY (name CONSTRAINT stud06_name_nn NOT null);
SELECT * FROM USER_CONSTRAINTS;
-- emp55로 복사테이블 만들고 
-- empno - unique, ename not null, deptno는 dept테이블의 deptno참조 
-- sal은 0 이상으로 제약조건을 추가 처리 
CREATE TABLE emp55 AS select * FROM emp;
ALTER TABLE emp55
ADD CONSTRAINT emp55_empno_uq unique(empno);
-- add constraint 제약키명 제약조건(컬럼명) 
ALTER TABLE emp55 
modify ename constraint emp55_ename_nn NOT NULL;
-- not null: 
-- modify (컬럼명 constraint 제약키명 not null)

ALTER TABLE emp55 
ADD CONSTRAINT emp55_deptno_fk FOREIGN key(deptno) REFERENCES dept(deptno);

ALTER TABLE emp55
ADD CONSTRAINT emp55_sal_ck CHECK(sal>=0);
SELECT * FROM all_constraints WHERE table_name='EMP55';
/*
 # 무결성 제약조건 삭제 
 1. 기본 형식 
 	alter table 테이블명 
 	drop constraint 제약조건명; 
 	
 */
SELECT constraint_name, status, table_name 
FROM all_constraints WHERE table_name='EMP55';
ALTER TABLE emp55 
DROP CONSTRAINT emp55_deptno_fk;
/*
 # 무결성 제약조건의 비활성화
 1. 무결성 제약조건은 한시적으로 설정값에 의해 비활성화/활성화 처리를 할 수 있다. 
 2. 기본 형식 
 	alter table 테이블명 
 	disable constraint 제약조건명;
 	alter table 테이블명 
 	enable constraint 제약조건명;
 */
ALTER TABLE emp55
disable CONSTRAINT emp55_ename_nn;
SELECT constraint_name, status, table_name 
FROM all_constraints WHERE table_name='EMP55';

INSERT INTO emp55(ename) values(null);
SELECT * FROM emp55;
DELETE FROM emp55 
WHERE ename IS NULL;

ALTER TABLE emp55
enable CONSTRAINT emp55_ename_nn;

-- ex) 제약조건이 있는 student05 테이블의 제약조건을 삭제하고, 
-- 비활성화/활성화 처리를 해보세요 
SELECT constraint_name, status, table_name 
FROM all_constraints WHERE table_name='STUDENT05';
ALTER TABLE student05
DROP CONSTRAINT student05_sex_ck;
ALTER TABLE student05
disable CONSTRAINT student05_kor_ck;
ALTER TABLE student05
enable CONSTRAINT student05_kor_ck;










