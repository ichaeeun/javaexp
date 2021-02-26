/*
 [데이터베이스]
[하] 1. 데이터베이스 설계에서 entity, entity type, reference를 구분하여 기술하세요.
entity
	현실 세계에서 조직을 운영하는데 꼭 필요한 사람이나 사물과 같이	구별되는 모든 것을 말한다. 
	저장할 가치가 있는 중요 데이터를 가지고 있는 사람이나, 사물, 개념, 사건. 
	다른 개체와 구별되는 이름을 가지고 있고, 각 개체만의 고유한 특성이나 상태, 
		즉 속성을 하나 이상 가지고 있음 
entity type 
	개체를 고유의 이름과 속성들로 정의한 것을 말한다. 	
	고객 entity인 경우 고객아이디, 고객명이 entity type
entity instance
	개체를 구성하고 있는 속성의 실제 값을 가짐으로써 실체화된 개체를 말한다. 
	고객 entity인 경우 고객아이디, 고객명이 entity type
	himan 7777 ==> 개체의 인스턴스 
reference 
	- 실제 위에 지정한 컬럼에 데이터를 할당한 row단위를 말한다. 
	- 파일 구조의 레코드를 의미한다. 
[하] 2. 무결성 제약조건 5가지를 기술하세요.
	1) primary key: not null(반드시 입력)+ unique(유일한 데이터) 
	2) not null: 반드시 입력해야 할 때 
	3) unique: 고유키 
	4) check: 해당하는 데이터만 입력 가능  
	5) foreign: 한 열과 참조된 테이블 열 간의 외래키 설정 
			refernce 참조할 테이블과 컬럼 지정. 
	
[중] 3. 가계부테이블을 만들어 온라인 가계부를 처리할려고 한다. 
	pk를 비롯한 제약조건이 있는 속성을 도출하고 테이블을 만들고 데이터를 등록해서
    select문으로 출력하세요.
*/
CREATE TABLE mn_book(
	NO NUMBER CONSTRAINT mn_book_no_pk PRIMARY KEY,
	idate DATE NOT NULL, 
	kind char(6) NOT NULL, 
	content varchar2(50),
	val number
);
-- 1. 설계시, 화면에는 보이지 않지만 반드시 추가할 컬럼 ex)no (식별자) 
-- 2. 화면에 보이지만 데이터로 관리되지 않은 데이터 
-- 		ex) 잔액/총계/평균값 등 연산처리 결과값 
-- 가계부 
-- [no]		날짜		수입/지출구분	항목		금액		잔액(잔액은 프로그램적으로 처리) 
-- 	1		1/18		수입		용돈		100000	100000
-- 	2		1/18 		지출		차비		5000	95000	

CREATE TABLE account( 
	accno NUMBER CONSTRAINT account_accno_pk PRIMARY KEY, 
	accdate DATE CONSTRAINT account_accdate_nn NOT NULL,
	accinput NUMBER, 
	accoutput NUMBER,
	acctot number
);
INSERT INTO account values(1,to_date('20200202','YYYYMMDD'),10000,0,10000);
INSERT INTO account values(2,to_date('20200203','YYYYMMDD'),0,5000,5000);
SELECT * FROM ALL_CONSTRAINTS 
WHERE table_name='ACCOUNT';
SELECT * FROM account;

/*
[하] 4. primary key와 not null을 함께 사용하는 테이블을 일상에서 생각해서 테이블을 각각의 컬럼에
    지정하고 선언해 보세요.
    
    학과 관리 프로그램에서 학생의 식별자와 이름, 
    도서 관리 프로그램에서 도서식별자와 도서명 등은 
    primary key와 not null로 사용한다. 
    create table book(
    	bk_id number primary key,
    	bname varchar2 not null,
    	isuse number(1),
    	-- 대출여부 boolean값은 데이터베이스에 없다. 
    	-- number(1) 0/1로 설정하면 boolean전환 가능 
    	loc number(7) -- 위치를 코드값으로 설정, 
    				  -- 코드값은 일반적으로 지정된 크기로 char로 설정
    );
*/
CREATE TABLE reg02(
	id varchar2(30) CONSTRAINT reg02_id_pk	PRIMARY KEY,
	pass varchar2(30) CONSTRAINT reg02_pass_nn NOT NULL,
	name varchar2(30) CONSTRAINT reg02_name_nn NOT NULL,
	email varchar2(60)
);
INSERT INTO reg02 values('chaen','1111','챈','chaen@naver.com');
SELECT * FROM reg02;
SELECT * FROM ALL_CONSTRAINTS 
WHERE table_name='REG02';








