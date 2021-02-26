/*
[데이터베이스]
[하] 1. seqence의 생성 기본 형식을 기술하세요.
		CREATE SEQUENCE 시퀀스명 
		INCREMENT BY n : 증가 단위 
		START WITH n: 초기 번호 
		MAXVALUE n | nomaxvalue: 최대 데이터 | 무한대
		MINVALUE n | nominvalue: 최소 데이터 
		CYCLE | nocycle: 최대/최소에 이를 때 반복여부 
		cache | nocache: 속도 향상을 위한 캐시메모리 사용여부 
[하] 2. 게시판 테이블을 번호, 제목, 작성자, 내용, 조회수로 생성하고,
        sequence로 번호를 만들어 입력 처리하게 하세요..
*/
	CREATE TABLE board(
		num NUMBER,
		title varchar2(50),
		writer varchar2(30),
		content varchar2(100),
		cnt NUMBER 
	); 
	CREATE SEQUENCE board_seq
		INCREMENT BY 1
		START WITH 1
		MAXVALUE 10000
		MINVALUE 1;
	INSERT INTO board values(board_seq.nextval,'제목','작성자','내용',0);
	SELECT * FROM board;
/*
[중] 3. student2테이블 학번, 이름, 학과 테이블이다.
        학번을 올해연도(2)학과코드(CS)번호(4)로 해당 자리수로 설정할 때,
        테이블과 sequence를 만들고 데이터를 입력 처리하세요
*/
CREATE TABLE student3(
	num varchar2(20),
	name varchar2(30),
	major varchar2(30)
);
SELECT * FROM student3;
CREATE SEQUENCE stu3_seq
	START WITH 1000
	INCREMENT BY 1
	MINVALUE 1000
	MAXVALUE 9999;
SELECT to_char(sysdate,'YY')||'CS'||stu3_seq.nextval FROM dual;
INSERT INTO student3 values(to_char(sysdate,'YY')||'CS'||stu3_seq.nextval,'홍길동','컴퓨터공학');
SELECT * FROM student3;
/*
[하] 4. sequence의 변경/삭제 구문을 기술하고, 한계를 예제를 통해서 나타내세요.
	 	alter sequence 시퀀스명 
	 	increment by n 
	 	maxvalue n | nomaxvalue
	 	minvalue n | nominvalue 
	 	cycle | nocycle 
	 	cache | nocache ;
	 	한계=>
 		start with절은  변경불가. 
 		maxvalue와 minvalue는 현재값보다 크거나 작은값으로 변경불가. 
[하] 5. 테이블의 생성 기본형식을 옵션과 함께 기술하세요.
	create [global temporary] table 스키마명.테이블명(
		컬럼명 데이터유형 default데이터 제약조건,
		컬럼명 데이터유형 default데이터 제약조건,
		컬럼명 데이터유형 default데이터 제약조건
	);
	 GLOBAL TEMPORARY - 임시테이블 만들 때 사용. 
							 해당 세션(클라이언트)에만 보임.
	 스키마(사용자계정) - 다른 계정에서 호출해서 사용한다.
		ex) system계정으로 접속해서 scott계정에서 사용할 테이블을 만들때,
			반드시 스키마를 선언하여야 한다. 
	 DEFAULT 데이터 선언 - 데이터를 입력하지 않을 때 null값 대신에		
							 들어가는 데이터를 선언할 수 있다. 
	 제약조건 - PRIMARY KEY, NOT NULL 등 무결성 제약조건을 선언할 수 있다. 
[하] 6. 테이블 생성시, default 데이터의 입력의 제약사항에 대하여 기술하세요.
	테이블 생성시 defualt 데이터를 입력하면 null값 대신 들어갈 데이터를 지정할 수 있다. 
	묵시적 null 데이터ㅣ에만 적용되고 명시적 null에는 적용되지 않는다. 
[하] 7. 테이블의 구조 변경 형식을 지정하고, 복사테이블 emp60만들고, 
		부서명, 부서위치를 추가 처리하세요
		alter table 테이블명 
 		add 컬럼명 데이터유형 [default 디폴트데이터], [제약조건]
 		alter table 테이블명 drop column 컬럼명; 
 */
	CREATE TABLE emp60 AS SELECT * FROM emp;
	ALTER TABLE emp60 ADD dname varchar2(30);
	ALTER TABLE emp60 ADD loc varchar2(30);
	SELECT * FROM emp60;
/*
[하] 8. 컬럼의 삭제 처리하는 형식을 기술하고, 위 emp60에서 부서위치를 삭제 처리하세요.
	alter table 테이블명 drop column 컬럼명;
*/
	ALTER TABLE emp60 DROP COLUMN loc;
	SELECT * FROM emp60;