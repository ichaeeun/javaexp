/*
 # 권한(privilege) 
 1. 권한이란? 
 	사용자가 데이터베이스 시스템을 관리하거나 객체를 이용할 수 있는 권리 
 2. 권한의 종류 
 	1) 시스템 권한 
 		- 시스템 차원의 자원 관리나 사용자 스키마 객체 관리 등과 같은 
 			데이터베이스 관리 작업을 할 수 있는 권한 
 		- 오라클에서는 테이블, 뷰, 롤백 세그머트, 프로시저와 같은 
 			객체를 생성, 삭제, 수정하는 작업과 관련된 140여 종의 시스템 권한을 지원한다. 
 	2) 객체 권한 
 		- 테이블, 뷰, 시퀀스, 함수 등과 같은 객체를 조작할 수 있는 권한 
 		- 객체의 종류에 따라 서로 다른 유형의 객체 권한 
 		- 테이블의 컬럼별로 insert, update, references 등의 권한을 상세 부여한다. 
 3. 계정 생성과 권한 설정 
 	1) 사용자 생성 권한이 있는 계정으로 접근 
 	2) 사용자 생성 script 처리 
 		create user 사용자명 identified by 비밀번호; 
 		ex) create user orauser01 
 			identified by user01; 
 	3) 접속 권한을 할당, 처리 
 		grant 권한명 to 계정명; 
 		create session: 접속이 가능한 권한 
 		ex) grant create session 
 			to orauser01; 
 */
--docker exec -it oracle11g-test sqlplus
--Enter user-name: system
--Enter password: oracle 
--create user orauser01 identified by user01;
-- conn orauser01/user01;
--ERROR:
--ORA-01045: user ORAUSER01 lacks CREATE SESSION privilege; logon denied
--conn system/oracle;
-- grant create session to orauser01;

-- ex) 계정생성 예제 orclstudy/oracle로 계정을 생성하고, 
-- 	접근권한을 설정하고 다시 접근해보세요 
--ichaeeun@ichaeeun-ui-MacBookPro ~ % docker exec -it oracle11g-test sqlplus
--SQL*Plus: Release 11.2.0.2.0 Production on Wed Jan 20 02:08:54 2021
--Copyright (c) 1982, 2011, Oracle.  All rights reserved.
--Enter user-name: system
--Enter password: oracle
--Connected to:
--Oracle Database 11g Express Edition Release 11.2.0.2.0 - 64bit Production
--SQL> create user orclstudy identified by oracle;
--User created.
--SQL> conn orclstudy/oracle;
--ERROR:
--ORA-01045: user ORCLSTUDY lacks CREATE SESSION privilege; logon denied
--Warning: You are no longer connected to ORACLE.
--SQL> conn system/oracle;
--Connected.
--SQL> grant create session to orclstudy;
--Grant succeeded.
--SQL> conn orclstudy/oracle;
--Connected.
/*
 	 4) 비밀번호 변경 
 	 	alter user 계정명 identified by 변경할 비밀번호;
 */
 -- ALTER USER orauser01 IDENTIFIED BY 1111;
--SQL> conn system/oracle;
--Connected.
--SQL> alter user orauser01 identified by 1111;
--User altered.
--SQL> conn orauser01/1111;
--Connected.
-- ex1) himan/7777 접근계정을 만들고, 권한부여, 비밀번호를 1111로 변경처리하세요 
--SQL> create user himan identified by 7777;
--User created.
--SQL> grant create session to himan;
--Grant succeeded.
--SQL> conn himan/7777;
--Connected.
--SQL> alter user himan identified by 1111;
--User altered.
--SQL> conn himan/7777;
--ERROR:
--ORA-01017: invalid username/password; logon denied
--Warning: You are no longer connected to ORACLE.
--SQL> conn himan/1111;
--Connected.

/*
 # 시스템 권한 
 1. 일반사용자가 가질 수 있는 시스템 권한 
 	- 사용자가 생성한 객체를 관리, 내장 프로시저를 관리하는 권한을 말한다. 
 2. 시스템 권한의 종류 
 	- create session : 데이터베이스 서버에 접속할 수 있는 권한 
 	- create table: 사용자 스키마에서 테이블을 생성할 수 있는 권한 
 	- create sequence : 사용자 스키마에서 시퀀스를 생성할 수 있는 권한 
 	- create view : 사용자 스키마에서 뷰를 생성할 수 있는 권한 
 	- create procedure : 사용자 스키마에서 프로시저, 함수, 패키지를 생성할 수 있는 권한 
3. 시스템 권한 부여 
	- 시스템 권한은 특정 사용자나 모든 사용자에게 부여 가능 
	- grant 명령문을 사용한다. 
	- 권한부여 기본형식 
		grant 권한명 to 사용자 [public] : public은 모든 사용자에게 권한 부여 
		[with admin option] : 권한의 재할당을 할 수 있게 한다. 
	- resouce는 위에 정의된 내용을 한번에 할당할 수 있는 권한 처리 
		ex) grant resource to 사용자; 
		--SQL> grant resource, create session, create table to himan;
		--SQL> conn himan/1111;
		--Connected.
		--SQL> create table tmp(name varchar2(10));
		--Table created.
		--SQL> insert into tmp values('홍');
		--1 row created.
 4. 객체 권한 
 	- 객체 권한은 테이블, 뷰, 시퀀스, 함수 등과 같이 객체별로 사용할 수 있는 권한 
 	- 종류 
 		select, insert, update, delete
 		alter, excute, index, references 
 	
	
 */
-- ex) higirl/8888 계정생성하고, 시스템 권한부여, 객체권한 부여하여 테이블을 생성하고, 
--		데이터를 입력 조회하세요. 
--SQL> conn system/oracle;
--Connected.
--SQL> create user higirl identified by 8888;
--User created.
--SQL> grant create session to higirl;
--Grant succeeded.
--SQL> conn system/oracle;
--Connected.
--SQL> grant resource,create session,create table to higirl;
--Grant succeeded.
--SQL> conn higirl/8888;
--Connected.
--SQL> create table tmp01(name varchar2(30),age number);
--Table created.
--SQL> insert into tmp01 values('gildong',27);
--1 row created.
--SQL> select * from tmp01;
--
--NAME				      AGE
-------------------------------- ----------
--gildong 			       27
/*
 * 
	 - 대상 객체별로 특정 권한 부여 
		GRANT 객체권한 ON 객체 TO 계정명; 
		
 */
--	SQL> conn scott/tiger;
--	Connected.
--	SQL> create table temp(col1 varchar2(10));
--	Table created.
--	SQL> insert into temp values('himan');
--	1 row created.
--	SQL> grant select on temp to orclstudy;
--	Grant succeeded.
--	SQL> grant insert on temp to orclstudy; 	
		-- scott계정에서 temp 테이블에 대한 insert 권한을 orclstudy계정에 할당 
--	Grant succeeded.
--	SQL> conn system/oracle;
--	Connected.
--	SQL> grant resource, create session, create table to orclstudy;
		-- 관리자계정으로 기본적인 자원에 대한 권한 할당. 
--	Grant succeeded.
		
--	SQL> conn orclstudy/oracle;
--	Connected.
--	SQL> select * from scott.temp;
--	COL1
--	----------
--	himan
--	SQL> insert into scott.temp values('gildong');
--	1 row created.
--	SQL> select * from scott.temp;
--	COL1
--	----------
--	himan
--	gildong

-- ex) scott계정으로 접근해서 member3테이블로 id,pass,name을 설정하고, 데이터를 등록한 후, 
--		member3 테이블에 대한 조회와 입력권한을 himan계정에  부여한다. 
--		다시 himan으로 접속한후, scott계정의 member3 테이블에 조회와 등록처리를 확인한다. 
--	SQL> conn scott/tiger;
--	Connected.
--	SQL> create table member3(id varchar2(10),pass varchar2(10), name varchar2(30));
--	Table created.
--	SQL> insert into member3 values('lifeofpi','1111','pi');
--	1 row created.
--	SQL> insert into member3 values('mangnae','2222','leemangnae');
--	1 row created.
--	SQL> select * from member3;
--	
--	ID	   PASS       NAME
--	---------- ---------- ------------------------------
--	lifeofpi   1111       pi
--	mangnae    2222       leemangnae
--	
--	SQL> grant select on member3 to himan;
--	Grant succeeded.
--	SQL> grant insert on member3 to himan;
--	Grant succeeded.
--	SQL> conn himan/1111;
--	Connected.
--	SQL> select * from scott.member3;
--	
--	ID	   PASS       NAME
--	---------- ---------- ------------------------------
--	lifeofpi   1111       pi
--	mangnae    2222       leemangnae
--	
--	SQL> insert into scott.member3 values('chaenee','3333','chaen');
--	1 row created.
--	SQL> select * from scott.member3;
--	
--	ID	   PASS       NAME
--	---------- ---------- ------------------------------
--	lifeofpi   1111       pi
--	mangnae    2222       leemangnae
--	chaenee    3333       chaen
/*
 5. 권한의 철회 
 	1) 기본형식 
 		revoke 권한명 
 		on 객체(테이블, sequence 등 사용 객체) 
 		from 계정명; 
 		
-- 	SQL> conn scott/tiger;
--	Connected.
--	SQL> revoke select, insert on temp from orclstudy;
--	Revoke succeeded.
--	SQL> conn orclstudy/oracle;
--	Connected.
--	SQL> select * from scott.temp;
--	select * from scott.temp
--	ERROR at line 1:
--	ORA-00942: table or view does not exist
 */
-- ex) scott 계정에서 himan 에 준 member3테이블에 대한 select,insert권한을 회수하고,
--		himan으로 접속해서 확인하세요 
--	SQL> conn scott/tiger;
--	Connected.
--	SQL> revoke select, insert on member3 from himan;
--	Revoke succeeded.
--	SQL> conn himan/1111;
--	Connected.
--	SQL> select * from scott.member3;
--	select * from scott.member3
--	ERROR at line 1:
--	ORA-00942: table or view does not exist
