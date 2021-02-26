/*
 # SEQUENCE
 1. oracel 서버에서 유일한 식별자 만들기 위한 객체 
 2. 기본 키를 자동으로 numbering 처리를 한다. 
 3. 여러 테이블에서 공유가 가능 
 4. 기본 형식 
	CREATE SEQUENCE 시퀀스명 
		INCREMENT BY n : 증가 단위 
		START WITH n: 초기 번호 
		MAXVALUE n | nomaxvalue: 최대 데이터 | 무한대
		MINVALUE n | nominvalue: 최소 데이터 
		CYCLE | nocycle: 최대/최소에 이를 때 반복여부 
		cache | nocache: 속도 향상을 위한 캐시메모리 사용여부 
 5. 활용함수 
 	1) 시퀀스명.currval: 현재 시퀀스의 번호 
 	2) 시퀀스명.nextval: numbering으로 다음 시퀀스 번호 호출 
 	ex) foriegn키로 입려할 때, 다른 테이블에 데이터를 입력하여야 할 경우.
 	메인게시판(시퀀스명.nextval를 입력), 
 	다중의 첨부파일 테이블(시쿼스명.currval) 
*/
SELECT max(empno) FROM emp21;
CREATE SEQUENCE emp21_seq 
	INCREMENT BY 1
	START WITH 7935
	MINVALUE 1000
	MAXVALUE 9999
	CYCLE;
SELECT emp21_seq.nextval FROM dual;	
SELECT emp21_seq.currval FROM dual;	
INSERT INTO emp21(empno,ENAME) values(emp21_seq.nextval,'홍길동');
SELECT * FROM emp21 ORDER BY empno DESC;

-- ex) student 테이블 . 번호 이름 국어 영어 수학 
--		stud_seq로 1번 부터 시작하여 30번까지 입력되게 sequence를 만들어 입력처리
CREATE TABLE student(
	num NUMBER,
	name varchar2(30),
	kor NUMBER,
	eng NUMBER,
	math number
);
SELECT * FROM student;
CREATE SEQUENCE stud_seq
	INCREMENT BY 1
	START WITH 1
	MINVALUE 1
	MAXVALUE 30
	nocycle;
INSERT INTO student
	values(stud_seq.nextval,'홍길동',80,80,80	);
-- primary key 컬럼의 데이터는 sequence로 그대로 사용하는 경우도 있지만 
-- 아래와 같이 복합키를 이용해서 생성하여, char()으로 저장하는 경우가 있다. 
-- 사번 코드 체계 (입사년월4자리)(부서코드2자리)(sequence5자리) 
CREATE SEQUENCE com_seq
	START WITH 10000
	INCREMENT BY 1
	MINVALUE 10000
	MAXVALUE 99999
	CYCLE;
SELECT to_char(SYSDATE,'YYMM')||'QA'||com_seq.nextval empno
FROM dual;
/*
 # sequence의 수정과 삭제 
 1. 시퀀스의 속성을 다음과 같은 형식으로 수정할 수 있다. 
 	1) 기본형식 
	 	alter sequence 시퀀스명 
	 	increment by n 
	 	maxvalue n | nomaxvalue
	 	minvalue n | nominvalue 
	 	cycle | nocycle 
	 	cache | nocache ;
 	2) 변경처리 내용
 		증가치, 최소값, 최대값 정의를 수정가능하다. 
 		start with절은 생성 직후 시작값을 변경불가. 
 */
SELECT stud_seq.currval FROM dual;
SELECT stud_seq.nextval FROM dual;
ALTER SEQUENCE stud_seq
	MAXVALUE 99999
	INCREMENT BY 5;
-- start with 15;는 변경 불가. 
-- minvalue|maxvalue: 현재값을 기준으로 적거나 많은 값으로 변경 불가능 
-- 변경에 대한 한계로 인해 시퀀스 삭제가 필요로 하다. 
/*
 # sequence 삭제 
 1. 기본 구문 
 	drop sequence 시퀀스명;
 	cf) 오라클 관련 객체들은 drop 객체유형 객체명; 
 */
SELECT emp21_seq.currval FROM dual;
DROP SEQUENCE emp21_seq;
SELECT max(empno) FROM emp21;
CREATE SEQUENCE emp21_seq
	START WITH 7943
	MINVALUE 1000
	MAXVALUE 9999
	CYCLE;
SELECT emp21_seq.nextval FROM dual;





