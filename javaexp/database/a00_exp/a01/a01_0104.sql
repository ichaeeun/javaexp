/*
데이터베이스
[하] 1. case문의 기본 형식을 기술하세요.
	case [컬럼명]
		when 논리|산술|관계 then 처리할 데이터
		when 논리|산술|관계 then 처리할 데이터
		else 기타처리할 데이터 
	end 
[하] 2. job에 따른 인턴기간을 다르게 설정하였다고 한다.
    사원별 인턴기간의 만료일을 입사일과 인턴기간의 만료일을 설정하세요.
*/
SELECT job, hiredate,
	CASE job 
		WHEN 'ANALYST' THEN 5
		WHEN 'CLERK' THEN 1
		WHEN 'MANAGER' THEN 4
		WHEN 'PRESIDENT' THEN 6
		WHEN 'SALESMAN' THEN 2
		ELSE 0 END "개월",
	add_months(hiredate, CASE job 
							WHEN 'ANALYST' THEN 5
							WHEN 'CLERK' THEN 1
							WHEN 'MANAGER' THEN 4
							WHEN 'PRESIDENT' THEN 6
							WHEN 'SALESMAN' THEN 2
							ELSE 0 END) "인턴기간만료일"
FROM emp;
	
/*
[중] 3. sal등급을 만들고 0~999,1000~1999,.... 등급별 인원수를 group 함수를 통해 처리하세요.

*/
SELECT sal FROM emp;
SELECT  
	CASE WHEN sal<1000 THEN '0~999'
		 WHEN sal<2000 THEN '1000~1999' 
		 WHEN sal<3000 THEN '2000~2999'
		 WHEN sal>=3000 THEN '3000~'
		 END "sal등급", count(*) "등급별인원수"
FROM EMP e 
GROUP BY 
CASE WHEN sal<1000 THEN '0~999'
		 WHEN sal<2000 THEN '1000~1999' 
		 WHEN sal<3000 THEN '2000~2999'
		 WHEN sal>=3000 THEN '3000~'
		 END;
		
SELECT decode(floor(sal/1000),5,'A',4,'B',3,'C',3,'D',1,'E','F') 등급, count(*) 인원수 
FROM EMP e 
GROUP BY floor(sal/1000)
ORDER BY floor(sal/1000) DESC;



