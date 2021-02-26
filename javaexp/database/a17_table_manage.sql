/*
# 테이블 관리 
1. 테이블의 생성과 구조의 변경(추가, 수정)을 처리하는 것을 말한다. 
2. 테이블의 생성 
	1) 테이블에 대한 구조를 정의하고, 테이블을 저장하기 위한 공간을 할당하는 과정을 말한다. 
	2) 테이블에 대한 구조 정의는 테이블을 구성하는 컬럼의 데이터유형과 
		제약조건을 정의한다. 
3. 테이블 생성 기본 형식 
	CREATE 옵션1 TABLE 옵션2.테이블명(
		컬럼명 데이터유형 옵션3 옵션4, 
		컬럼명 데이터유형 옵션3 옵션4, 
		..
		컬럼명 데이터유형 옵션3 옵션4
	);
	옵션1: GLOBAL TEMPORARY - 임시테이블 만들 때 사용. 
							 해당 세션(클라이언트)에만 보임.
	옵션2: 스키마(사용자계정) - 다른 계정에서 호출해서 사용한다.
		현재 계정에서 사용할 테이블은 스키마 선언을 생략가능 하다. 
		ex) system계정으로 접속해서 scott계정에서 사용할 테이블을 만들때,
			반드시 스키마를 선언하여야 한다. 
	옵션3: DEFAULT 데이터 선언 - 데이터를 입력하지 않을 때 null값 대신에		
							 들어가는 데이터를 선언할 수 있다. 
	옵션4: 제약조건 - PRIMARY KEY, NOT NULL 등 무결성 제약조건을 선언할 수 있다. 
*/
-- 기본 테이블 생성 
CREATE TABLE address(
	id number(3),
	name varchar2(50),
	addr varchar2(100),
	phone varchar2(30),
	email varchar2(100)
);
-- 현재 등록된 테이블 확인 
SELECT * FROM tab;
/*
 # default 데이터의 선언. 
 1. 컬럼의 입력 값이 묵시적 null인 경우에 기본값을 지정하기 위하여 사용된다. 
 2. 기본값을 설정하는 데이터: 
 	리터럴값, 표현식, sql함수, sysdate, user를 사용할 수 있다. 
 	특정 컬럼이나 의사컬럼(nextval,currval)은 사용할 수 없다. 
 	
 */
 CREATE TABLE address2(
	id number(3) DEFAULT 1,
	name varchar2(50)  DEFAULT '이름',
	addr varchar2(100)  DEFAULT '주소',
	phone varchar2(30)  DEFAULT '전화번호',
	email varchar2(100)  DEFAULT '이메일'
);
-- default는 명시적 null은 제외, 묵시적 null로 입력된 데이터. 
INSERT INTO address2(id) values(null);
INSERT INTO address2(name) values(null);
SELECT * FROM address2;
-- ex) 묵시적 데이터 선언에 대하여 기본 형식을 기술하고, 
-- 회원가입 테이블(id,pass,name,regdte,uptdte)로 만들때,
-- id, pass는 임시/1111, 익명, 
-- 날짜형은 현재날짜로 default로 선언되게 하세요. 
CREATE TABLE reg01(
	id varchar2(30) DEFAULT '임시',
	pass varchar2(30) DEFAULT '1111',
	name varchar2(30) DEFAULT '익명',
	regdte DATE DEFAULT sysdate,
	uptdte DATE DEFAULT sysdate 
);
SELECT * FROM reg01;
INSERT INTO reg01(regdte) values(to_date('20200101','YYYYMMDD'));
/*
 # 서브쿼리를 이용한 테이블 생성 
 1. create table 명령문에서 서브쿼리절을 이용하여 다른 테이블 구조과 데이터를 
 	복사하여 새로운 테이블 생성이 가능하다. 
 	손쉽게 테이블 구조와 데이터입력을 할 수 있다. 
 2. 서브쿼리의 출력 결과가 테이블의 초기 데이터로 삽입이 가능하다. 
 3. create table 명령문에 지정한 컬럼 수와 데이터 타입과 반드시 일치하여 만들어진다. 
 	ps) 컬럼명은 다르더라도 컬럼수와 데이터타입만 맞으면 입력이 가능하다. 
 4. 컬럼 이름을 명시하지 않은 경우 서브쿼리 컬럼 이름과 동일 
 5. 무결성 제약조건은 not null 조건만 복사, primary key, foreign key, check 등은 
 	복사가 되지 않는다. 
 	ex) 추후에 alter 테이블	 add 컬럼명 제약조건; (컬럼 추가 제약조건 설정)
 	ex) 추후에 alter 테이블	 modify 컬럼명 제약조건; (컬럼 속성 변경 제약조건 설정)
 6. default 옵션은 정의한 값 그대로 복사 
 */ 
CREATE TABLE emp04 AS SELECT * FROM emp;
SELECT * FROM emp04;
-- 1. 컬럼명을 특정 컬럼명을 선택해서, 갯수를 맞추면 원하는 컬럼명으로 테이블을 생성할 수 있다. 
CREATE TABLE emp05(NO, name, grade) 
AS SELECT empno,ename,job FROM emp;
SELECT * FROM emp05;
/*
 # 테이블의 구조변경 
 1. 개요 
 	alter table 명령문을 이용하여,
 	컬럼의 추가, 삭제, 타입이나 길이의 재정의와 같은 작업을 할 수 있다. 
 2. 컬럼의 추가 
 	alter table 테이블명 
 	add 컬럼명 데이터유형 [default 디폴트데이터], [제약조건]
 */
SELECT * FROM address;
ALTER TABLE ADDRESS 
ADD birth DATE;
SELECT * FROM emp05;
-- ex) emp05테이블에 salary로 급여, departno로 부서번호를 추가처리하세요 
ALTER TABLE emp05
ADD salary NUMBER;
ALTER TABLE emp05 
ADD departno NUMBER;
/*
 3. 컬럼의 삭제 처리 
 	alter table 테이블명 drop column 컬럼명; 
 */
ALTER TABLE emp05 DROP COLUMN departno;
/*
4. 컬럼의 변경 
   1) 테이블의 컬럼의 타입, 크기, 기본값은 변경이 가능하다. 
   2) 기본형식
      alter table 테이블명
      modify 컬럼 데이터유형 옵션1
      옵션1(default 기본데이터)
   3) 기존 컬럼에 데이터가 없는 경우 
      컬럼 타입이나 크기 변경이 가능 
      ex) 큰데이터할당 => 작은데이터할당으로 변경도 가능하다. 
   4) 기존 컬럼에 데이터가 있는 경우 
      - 타입변경 char, varchar2 허용(현재 데이터보다 같거나 큰 데이터로)
      - 변경한 컬럼의 크기가 **저장된 데이터의 크기보다 같거나 클 경우만 가능 
         varchar2(10)==>varchar2(15) 변경가능 
         varchar2(5) ==> varchar2(4) (X)
       ps) 기존 데이터가 있는 경우 특정한 데이터 유형으로 변환이 필요한 경우
        	1. key(primary key) empno와 함께 특정 임시컬럼으로 저장 
        	2. update 테이블명	
        			set 컬럼명 = null; -- 타입을 변경할 컬럼은 null로 update처리
        	3. 컬럼 타입 변경 
        	4. 해당 타입에 맞는 유형을 to_XXX()함수를 이용해서 할당 후
        		임시컬럼에 있는 데이터를 할당한다. 
        	5. 필요없는 임시컬럼을 삭제처리 
        	
   5) default 값 변경은 변경 후에 입력되는 데이터 부터 적용 
*/
-- 데이터 없을 때, 변경 
CREATE TABLE emp50 
AS SELECT * FROM emp WHERE 1=0;
SELECT * FROM emp50; --refresh 후, ctrl+테이블명클릭 =>상세 내용 확인 
/*
     "EMPNO" NUMBER(4,0), 
   "ENAME" VARCHAR2(10), 
   "JOB" VARCHAR2(9), 
   "MGR" NUMBER(4,0), 
   "HIREDATE" DATE, 
   "SAL" NUMBER(7,2), 
   "COMM" NUMBER(7,2), 
   "DEPTNO" NUMBER(2,0)
*/
ALTER TABLE emp50 
MODIFY (ename varchar2(50),
      job varchar2(50));
/*
   "ENAME" VARCHAR2(50), 
   "JOB" VARCHAR2(50), 
 */
ALTER TABLE EMP50 
MODIFY (ename varchar2(10), job varchar2(10));
/*
 데이터 없을 때는 작은 데이터타입으로도 변경 가능 
 "ENAME" VARCHAR2(10), 
 "JOB" VARCHAR2(10)
 */
ALTER TABLE emp50 
MODIFY ename varchar2(50) DEFAULT '이름';
ALTER TABLE EMP50 
MODIFY JOB NUMBER; -- 자유롭게 유형 변경 가능 

-- 데이터가 있는 테이블의 컬럼 변경 
CREATE TABLE emp51
AS SELECT * FROM emp;
SELECT * FROM emp51;
-- 작은 크기 => 큰 크기 변경 
ALTER TABLE emp51 
modify(ename varchar2(50), job varchar2(50));
/* 
 "ENAME" VARCHAR2(50), 
 "JOB" VARCHAR2(50)
 */
-- ex) 다른 유형의 데이터변경/ 큰유형에서 작은 유형으로 변경
/*
 # 데이터가 있는 경우
 1. 문자열(char,varchar2)
 	- 현재 입력된 데이터의 크기범위 안에서 작거나 크게 변경이 가능하다.
 		입력된 데이터가 varchar2(10) length(컬럼명)<=10 일때,
 		20으로 변경하고 다시 11로 변경은 가능하지만,
 		10이하로는 변경 불가 
 		주의: 현재 입력된 데이터 크기 범위에서 수정 가능. 
 2. 숫자형 
 	- 입력된 데이터 상관없이 정밀도를 한번 크게 변경하면 
 		다시 작게 변경이 불가능하다. 
 		주의: 현재 입력된 데이터와 상관없음. 
 */
select max(length(ename)) from emp51; --데이터 최대크기 확인 
ALTER TABLE EMP51 
MODIFY (ename varchar2(10),job varchar2(10)); --(O)
ALTER TABLE emp51 
MODIFY ename varchar2(5); -- (X) 기존데이터값보다 작은크기로 변경 불가능 
ALTER TABLE EMP51 
MODIFY ename NUMBER; --(X) 데이터유형 변경 불가능 
-- 위 범위 안에서 varchar2<==>char 간 변경은 가능 
ALTER TABLE EMP51 
MODIFY ename char(10);
ALTER TABLE EMP51 
MODIFY empno varchar2(20); --(X) 데이터유형 변경 불가능 
-- 숫자형 데이터는 number(p,s) 
-- 작은 데이터로 변경이 불가능하고, 
-- 정밀도가 한번 커지면 할당 데이터 상관없이 작은 크기로 변경이 불가능하다. 
ALTER TABLE EMP51 
MODIFY sal number(2,2); --(X)
ALTER TABLE EMP51 
MODIFY deptno number(10,2);
-- 한번 커지면 작게 변경하는 것은 에러발생 
ALTER TABLE EMP51 
MODIFY deptno number(9,1); --(X)
























