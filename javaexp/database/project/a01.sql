/*

product 

prod_id   pk  제품id
category fk  카테고리id
pname 	   제품명
price
sell_unit  판매단위
qnt			중량용량 
delivery  	배송구분 
package_type  	포장타입
stock  		재고

*/
CREATE TABLE product10(
	prod_id NUMBER CONSTRAINT product10_prod_id_pk PRIMARY KEY,
	category varchar2(50) NOT NULL, 
	pname varchar2(50) NOT NULL,
	price NUMBER NOT NULL,
	sell_unit varchar2(50),
	qnt varchar2(50),
	delivery varchar2(50),
	package_type varchar2(50),
	stock NUMBER
);

INSERT INTO product10 
values('1000','베이커리','[밀클레버]미니붕어빵',4900,'1봉','300g/15개입','샛별배송/택배배송','냉동/종이포장',100);
SELECT prod_id "제품id", category "카테고리", pname "제품명" ,price "가격", sell_unit "판매단위",
		qnt "중량/용량", delivery "배송구분", package_type "포장타입", stock "재고"
FROM product10;
SELECT * FROM product10;

ALTER TABLE product10 
ADD image varchar2(300);
UPDATE product10
SET image='root/bakery/bungeobbang.jpg'
WHERE prod_id =1000;
SELECT prod_id "제품id", category "카테고리", pname "제품명" ,price "가격", sell_unit "판매단위", qnt "중량/용량", delivery "배송구분", package_type "포장타입", stock "재고", image "이미지경로" 
FROM product10;




