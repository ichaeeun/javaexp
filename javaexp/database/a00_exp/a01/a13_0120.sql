/*
[데이터베이스]
[하] 1. 데이터베이스의 권한의 종류와 권한 부여의 기본 형식을 기술하세요.
1. 권한의 종류 
1) 시스템권한: 시스템차원의 자원 관리나 스키마 객체 등과 같은 데이터베이스 
	관리 작업을 할 수 있는 권한 
	오라클에서는 테이블, 뷰, 롤백 세그먼트, 프로시저와 같은 객체를 생성, 
	삭제, 수정하는 작업과 관련된 140여종의 시스템권한을 지원한다. 
	create session
	create table 
	create sequence
	create view
	create procedure 
	
2) 객체권한
 	- 객체 권한은 테이블, 뷰, 시퀀스, 함수 등과 같이 객체별로 사용할 수 있는 권한 
 	- 종류 
 		select, insert, update, delete
 		alter, excute, index, references 
권한부여 형식 
	- grant 권한명1, 권한명2... to 사용자(스키마계정단위) [public]: 모든 사용자 권한 부
	[with admin option]: 관리자 권한으로 권한의 재할당 처리 
	- grant 권한명1, 권한명2... on 테이블 등 객체 to 사용자(스키마단위) 
	
[하] 2. goodman/9999 계정을 생성하고 테이블생성/활용 권한을 부여하고 테이블 생성하고 입력 처리하세요.
SQL> conn system/oracle; 
Connected.
SQL> create user goodman identified by 9999;
User created.
SQL> grant resource,create session,create table to goodman;
-- resource: 객체권한 및 자원을 활용할 수있는 권한 포함 
Grant succeeded.
SQL> conn goodman/9999;
Connected.
SQL> create table goodman01(name varchar2(30));
Table created.
SQL> insert into goodman01 values('gildong');
1 row created.
SQL> select * from goodman01;
NAME
------------------------------
gildong

[하] 3. scott계정에서 emp10테이블에 대한 조회/등록/수정/삭제 권한을 goodman에 할당하세요.
SQL> conn scott/tiger;
Connected.
SQL> grant select on emp10 to goodman;
Grant succeeded.
SQL> grant insert on emp10 to goodman;
Grant succeeded.
SQL> grant update on emp10 to goodman;
Grant succeeded.
SQL> grant delete on emp10 to goodman;
Grant succeeded.

[하] 4. scott계정에서 emp10테이블에 대한 등록/수정/삭제 권한을 goodman에 발탈하세요.
SQL> conn scott/tiger;
Connected.
SQL> revoke select, insert, update, delete on emp10 from goodman;
Revoke succeeded.
*/