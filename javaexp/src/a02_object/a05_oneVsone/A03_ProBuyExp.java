package a02_object.a05_oneVsone;
/*
ex) Product 에 필드: 속성 물건명 가격 
	 Buyer 필드: 구매자이름, Product를 할당하여,
	 	객체생성자 할당하고 할당된 속성값을 확인하도록 하세요. 
	
*/
public class A03_ProBuyExp {
	public static void main(String[] args) {
		Product p1 = new Product("비비빅",1000);
		Buyer b1 = new Buyer("챈");
		b1.prod=p1;
		System.out.println(b1.name);
		System.out.println(b1.prod.name);
		System.out.println(b1.prod.price);
		Buyer b2 = new Buyer("챈챈");
		//객체를 생성과 함께 바로 할당 
		b2.prod = new Product("오렌지",3000);
		System.out.println(b2.name+"소속 product 객체");
		System.out.println(b2.prod.name);
		System.out.println(b2.prod.price);
		
	}
}
class Product{
	String name;
	int price;
	Product(String name, int price) {
		this.name = name;
		this.price=price;
	}
}
class Buyer{
	String name;
	//Buyer 객체를 만들면 종속적인 Product 객체를 할당할 수 있게 선언
	
	Product prod;
	Buyer(String name){
		this.name = name;
	}
	
}

