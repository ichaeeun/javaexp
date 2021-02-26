/*
# 데이터 무결성 제약조건 
1. 학습목표 
	1) 데이터의 제약조건에 대한 개념을 이해한다. 
	2) 테이블의 생성시, 제약조건을 설정해야 하는 경우와 
		실제코드로 제약조건을 생성할 수 있다. 
	3) 업무에 따라서 제약조건에 대하여 효과적으로 생성한다. 
2. 주요 키워드
	1) primary key: not null(반드시 입력) 
					+ unique(유일한 데이터) 
	2) not null: 반드시 입력해야 할 때 
	3) unique: 고유키 
	4) check: 해당컬럼에 저장 가능한 데이터의 값의 범위나 조정 지정 
	5) constraint: 제약조건을 설정할 때, 선언되는 명명 
	6) references: 참조키를 설정할 때 활용된다. 
	7) foreign: 한 열과 참조된 테이블 열 간의 외래키 설정 
	
3. 퀴즈 
	1) 테이블의 모든 행에 고유한 값을 갖는 열 또는 열조합 지정 키? 
		unique key 
	2) 유니크와 not null을 혼합한 키? 
		primary key 
	3) 다른 테이블의 컬럼을 참조할 때 쓰이는 키와 참조라는 키의 키워드 
		foreign key, references 
		
4. 키를 먼저 설정해봅시다. 
	기본형식 
	CREATE TABLE 테이블명(
		컬럼명 데이터유형 constraint 제약키이름 제약키 
	);
*/
CREATE TABLE student01(
	studno NUMBER CONSTRAINT stud_studno_pk PRIMARY KEY, 
	name varchar2(30)
);

-- 제약조건 선언형식2 
-- 컬럼명 데이터유형 제약조건 
-- : 제약조건의 이름을 설정하지 않는 제약조건은 oracle 시스템에서 
--	 지정한 네이밍 규칙에 의해 자동으로 만들어진다. 
--	구조변경에서도 제약조건을 할당하거나 변경이 가능하다. 
--	 ex) alter table student05 modify name varchar2(20) not null; 
CREATE student05(
	studno number PRIMARY KEY, 
	name varchar2(20)
);
SELECT * FROM all_constraints WHERE owner='SCOTT';
-- SYS_C007000와 같이 제약조건의 이름을 설정하지 않는 경우에 
-- 시스템에서 자동으로 생성을 한다. 

-- 데이터 입력 
SELECT * FROM student01;
INSERT INTO student01 values(1,'홍길동');
INSERT INTO student01 values(1,'김길동'); -- 동일한 key를 입력시 에러 
INSERT INTO student01 values(2,'김길동');
INSERT INTO student01 VALUES(NULL,'마길동'); -- null로 입력시 에러 
INSERT INTO student01(name) values('하길동'); -- 묵시적 null 입력, 에러.
--ex) product01 만들고 물건고유번호, 물건명, 가격 
-- 물건고유번호 primary key 설정해서 데이터 입력 
CREATE TABLE product01(
	pno NUMBER CONSTRAINT prod_pno_pk PRIMARY KEY, 
	pname varchar2(30), 
	price NUMBER
);
INSERT INTO product01 values(1,'녹차스킨',5000);
INSERT INTO product01 values(2,'녹차로션',5000);
SELECT * FROM product01;
-- primary key 는 null이 아니고 식별할 수 있는 데이터를 입력해야 한다. 
/*
ALL_CONSTRAINTS: 데이터베이스의 데이터베이스 - 메타데이터 
	제약사항에 대한 정보를 확인할 수 있다. 
CONSTRAINTS_NAME 컬럼으로 제약사항의 이름을 확인 
	사용자 정의 제약 이름과 시스템에서 자동으로 생성된 제약이름을 구분할 수 있다. 
 */
SELECT * FROM ALL_CONSTRAINTS 
WHERE table_name = 'PRODUCT01';
/*
 # NOT NULL: 반드시 데이터를 입력해야하는 제약조건 설정 
 	1. 기본형식: constraint 제약조건 이름 not null 
 	2. 제약조건이름: 테이블명_컬럼명_nn
 */
CREATE TABLE student_nn_exp(
	name varchar2(50) CONSTRAINT student_nn_exp_name_nn NOT NULL
);
INSERT INTO student_nn_exp values('홍길동');
SELECT * FROM student_nn_exp;
INSERT INTO student_nn_exp values(null); --error
SELECT * FROM ALL_CONSTRAINTS 
WHERE table_name='STUDENT_NN_EXP';
-- ex) student02 테이블을 만들고 
--	   학번, 이름, 국어, 영어, 수학 점수 컬럼 설정 
--	   학번을 PRIMARY KEY, 이름은 NOT null로 설정하고, 
--	   데이터값의 입력을 통해 제약조건을 확인하세요 
CREATE TABLE student02(
	sno NUMBER CONSTRAINT student02_sno_pk PRIMARY KEY,
	name varchar2(10) CONSTRAINT student02_name_nn NOT NULL,
	kor NUMBER,
	eng NUMBER,
	math number
);
INSERT INTO student02 values(1,'홍길동',100,34,90.2);
SELECT * FROM ALL_constraints
WHERE table_name='STUDENT02';

















