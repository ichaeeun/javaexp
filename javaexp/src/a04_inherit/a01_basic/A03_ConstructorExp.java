package a04_inherit.a01_basic;

public class A03_ConstructorExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c1 = new Car();
		c1.show();
		Bus b1 = new Bus();
		b1.show();
		
		
//ex) Worker 필드: 일의 종류, 생성자를 통해서 종류 설정 
//		 메서드: work() @@가 일을 합니다. 
//		 하위 클래스: PoliceMan, FireMan 선언과 함께 상위 생성자 호출
		PoliceMan p1 = new PoliceMan();
		p1.work();
		FireMan f1 = new FireMan();
		f1.work();
	}
}


