package a02_object;
//ex) final 메서드 확인 예제 
//class Duck 메서드 sound(),fly(), swim()
//swim()은 final 
//상속받은 하위 클래스 class RobotDuck //class RubberDuck 재정의
//swim에 대한 내용을 확인 

class Duck{
	void sound() {
		System.out.println("꽥꽥");
		
	}
	void fly() {
		System.out.println("난다");
	}
	final void swim() {
		System.out.println("수영한다.");
	}

}
class RobotDuck extends Duck{
	void sound() {
		super.sound();
		System.out.println("기계음");
	}
	void fly() {
		super.fly();
		System.out.println("로켓장착");
	}
//	void swim() {} //final method - error
}
class RubberDuck extends Duck{
	void sound() {
		super.sound();
		System.out.println("고무소리");
	}
	void fly() {
		System.out.println("날갯짓");
	}
}
public class DuckEx {
	public static void main(String[] args) {
		
	RobotDuck rd = new RobotDuck();
	rd.sound();
	rd.fly();
	rd.swim();
	
	RubberDuck ru = new RubberDuck();
	ru.sound();
	ru.fly();
	ru.swim();
	
	}
}