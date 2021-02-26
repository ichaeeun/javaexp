/*
 [데이터베이스]
[하] 1. 제약조건의 이름 설정과 바로 선언하여 사용하는 경우의 차이를 기술하세요.
제약키이름설정 
	CREATE TABLE 테이블명(
		컬럼명 데이터유형 constraint 제약키이름 제약키 
	);
바로 선언하여 사용 
	CREATE TABLE 테이블명(
		컬럼명 데이터유형 제약키
	);
	제약조건의 이름을 설정하지 않는 제약조건은 oracle 시스템에서 
	지정한 네이밍 규칙에 의해 자동으로 만들어진다. 
이름을 정하면 메타데이터로 해당 제약이름을 조회하거나 일괄관리시 효과적으로 처리할 수 있다. 
[하] 2. foreign key 기본 형식을 선언하세요.

  	컬럼명 데이터유형 constraint 제약조건명 references 참조할테이블(참조할컬럼) 
  	CREATE TABLE student03(
	deptno number(3) CONSTRAINT STUDENT02_DEPTNO_FK REFERENCES studept(deptno)
	);
*/ 

