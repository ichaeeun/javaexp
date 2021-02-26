/*
[데이터베이스]
[하] 1. 사원 테이블 emp60테이블을 emp테이블에서 복사를 하여, empno 프라이머리, 
ename not null, job (emp의 job데이터), hiredate(2001이후로 입력), sal(0이상)
 deptno(dept테이블 deptno참조) 로 설정해서 입력 하세요
*/
	CREATE TABLE emp60 AS SELECT * FROM emp;

 	ALTER TABLE EMP60 
 	ADD CONSTRAINT emp60_empno_pk PRIMARY key(empno);
 
 	ALTER TABLE EMP60 
 	MODIFY (ename CONSTRAINT emp60_ename_nn not NULL);
-- **********************************************************************************	
	ALTER TABLE EMP60 
	add  CONSTRAINT emp60_hiredate_ck check(to_char(hiredate,'YYYY')>=2001);
	ALTER TABLE emp60 ADD CONSTRAINT emp60_hiredate_ck check(hiredate>to_date('2001-01-01','YYYY-MM-DD'));
	
	CREATE TABLE emp56 AS SELECT * FROM emp;
	SELECT * FROM tmp_emp; 
	UPDATE emp56 a 
	SET hiredate=(SELECT hiredate FROM tmp_emp b WHERE a.empno=b.empno);
	SELECT * FROM emp56;

	CREATE TABLE tmp_emp
	AS SELECT empno, add_months(hiredate,12*21) hiredtae FROM emp;
	SELECT * FROM tmp_emp; 
	UPDATE emp60 a 
	SET hiredate =(SELECT hiredate FROM tmp_emp b WHERE a.empno=b.empno);
-- **********************************************************************************		

	ALTER TABLE EMP60
	ADD CONSTRAINT emp60_sal_ck check(sal>=0);
	
	ALTER TABLE EMP60 	
	ADD CONSTRAINT emp60_job_ck check(job IN ('CLERK','SALESMAN','PRESIDENT','MAGNAGER','ANALYST'));
	-- ALTER TABLE emp60 ADD CONSTRAINT emp60_job_fk FOREIGN key(JOB) REFERENCES emp(JOB); 
	-- 해당 내용이 foreign key는 unique/primary key로 처리하여 가능.
	
	
	
/*
[하] 2. emp60 설정된 제약조건, 삭제, 활성화/비활성화 처리를 하세요.
*/
	SELECT * FROM ALL_CONSTRAINTS WHERE table_name='EMP60';
	ALTER TABLE emp60 
	DROP CONSTRAINT emp60_hiredate_ck;
	ALTER TABLE EMP60 
	disable CONSTRAINT emp60_sal_ck;
	ALTER TABLE EMP60 
	enable CONSTRAINT emp60_sal_ck;