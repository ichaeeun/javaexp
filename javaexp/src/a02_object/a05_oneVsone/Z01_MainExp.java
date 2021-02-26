package a02_object.a05_oneVsone;

public class Z01_MainExp {
/*
 # 객체지향 프로그램에서 관계 설정이란? 
 	1. 객체는 객체안에서 메모리를 설정해서 사용할 수 있다. 
 		ex) 자동차라는 객체 안에는 핸들객체, 바퀴객체, 엔진객체들이 각각의
 		속성과 속성값을 가지고 유기체적으로 연관관계를 만들어 수행하듯이
 		객체지향프로그램에서는 객체와 객체의 연관관계를 아는 것이 중요하고, 
 		그 연관관계 프로그래밍을 하여야 한다. 
 	2. 객체안에 객체의 선언과 활용 
 		1) 포함될 객체부터 class로 먼저 선언
 			class Woman{} 
 		2) 호출할 객체에서 필드나 메서드 안에서 선언하여 활용을 할 수 있다. 
 			class Man{
 				int age; 
 				Woman woman; 
 			}
 		3) main()에서 실제 메모리를 만들어 할당한다. 
 			Woman woman = new Woman();
 			Man man = new Man();
 			man.woman=woman; //Man객체 안에 Woman 객체를 할당
 			man.woman = new Woman(); //Man객체 안에 Woman객체 생성하면서 바로 할당
 		
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		A02_Woman w1 = new A02_Woman("송지나");
		System.out.println("w1.name: "+w1.name);
		A01_Man m1 = new A01_Man("김철수");
		System.out.println("m1.name: "+m1.name);
		// A02_Woman 에서 생성 w1을 A01_Man의 m1 하위에 있는
		// Woman 메모리에 할당 처리
		// m1 객체에 종속적인 메모리에 있는 woman에 할당처리 
		m1.woman = w1;
		A01_Man m2 = new A01_Man("마승수");
		m2.woman = new A02_Woman("김신영"); //m2에 종속적인 woman
		// 종속적인 woman의 속성 출력
		System.out.println("Man종속적 Woman의 이름: "+m1.woman.name);
		System.out.println("Man종속적 Woman의 이름: "+m2.woman.name);
		

		A05_Product p2 = new A05_Product("사과",3000,2);
		A06_Buyer b3 = new A06_Buyer("김철수");
		//A05_Product가 A06_Buyer에 할당되지 않을 때,
		// 처리할 내용 
		System.out.println("물건정보가 할당되지 않았을때");
		b3.showBuyInfo();
		b3.prod=p2; //물건정보를 할당했을때
		b3.showBuyInfo();
		
/*
#1:1 관계 설정 연습
1. Car 필드: 자동차명, 최고속도, 메서드: showInfo() 
2. Driver 필드: 이름, Car 
	메서드 divingCar() @@가 차가 없다.
					 @@가 @@차를 최고속도 @@키로 주행.
*/
		
		A07_Car c = new A07_Car("지바겐",250);
		A08_Driver d1= new A08_Driver("챈");
		A08_Driver d2 = new A08_Driver("파이");
		
		d1.car=c;
		d1.drivingCar();
		d2.drivingCar();
		
	}
}
