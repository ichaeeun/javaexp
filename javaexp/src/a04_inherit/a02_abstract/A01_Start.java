package a04_inherit.a02_abstract;

public class A01_Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 # 추상클래스 
 1. 추상이란? 
 	실체들 간의 공통되는 특징을 추출해서 그 특징에 맞는 실체를 만들기 위해 
 	선언한다 
 	1) 새, 곤충, 물고기 ==> 동물(추상)
 	2) 삼성, 현대, LG ==> 회사(추상) 
 2. 추상클래스란?
 	1) 실체 클래스의 공통 속성을 추출하여 필드와 메서드로 정의하여 사용하는 클래스를 말한다. 
 	2) 목적이 실체 클래스를 공통적인 필드와 메서드를 사용하기 위한 것이기 때문에 
 		객체로 사용하지 않는다. 
 3. 추상클래스는 왜 사용하는가? 
 	1) 하위 실제클래스의 공통되는 필드와 메서드를 정의하기 위하여 사용된다. 
 		특히, 추상클래스 안에 추상메서드는 상속받는 하위 클래스에서 반드시 
 		정의하여야 하기 때문에, 메서드의 통일성을 유지할 수 있다. 
 4. 기본형식
 	abstract class 추상클래스명{
 		//반드시 하나이상 추상메서드가 선언되어야 한다. 
 		//추상메서드는 body{} 가 없다. 
 		abstract void call(); 
 		public void show1(){} //공통되는 기능메서드를 포함 
 		public void show2(){}
 	}
 */
		//1. 추상클래스는 단독으로 생성하지 못한다. 
	//	Animal an = new Animal(); 
		//2. 주로 다형성 형태로 사용된다. 
		Animal an1 = new Dog();
		Animal an2 = new Cat();
		an1.sound();
		an2.sound(); 
/*
ex) 추상클래스 Phone 필드: 전화번호 추상메서드: specialFunc()
							  일반메서드: turnOn(), turnOff()
	상속받은 실제 SmartPhone 추상메서드 overriding처리. 인터넷검색
	상속받은 실제 CompanyPhone 추상메서드 overriding처리. 다른직원에게 전화를 돌리다
 */
		Phone p1 = new SmartPhone("010-1234-1234");
		p1.turnOn();
		p1.turnOff();
		p1.specialFunc();
		Phone p2 = new CompanyPhone("010-5678-5678");
		p2.turnOn();
		p2.turnOff();
		p2.specialFunc();
	}
}
abstract class Phone{
	private String number;
	public Phone(String number) {
		this.number= number;
	}
	public abstract void specialFunc();
	public void turnOn() {
		System.out.println(number+ "전원을 키다");
	}
	public void turnOff() {
		System.out.println(number +"전원을 끄다");
	}
	
}
class SmartPhone extends Phone{
	
	public SmartPhone(String number) {
		super(number);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void specialFunc() {
		// TODO Auto-generated method stub
		System.out.println("인터넷 검색");
	}
	
	
}
class CompanyPhone extends Phone{

	public CompanyPhone(String number) {
		super(number);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void specialFunc() {
		// TODO Auto-generated method stub
		System.out.println("다른 직원에게 전화를 돌리다");
	}
	
}
abstract class Animal{
	public void move() {//일반 메서드
		System.out.println("이동을 한다.");
	}
	public abstract void sound(); //body{}가 없는 추상메서드 
}

class Dog extends Animal{

	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("멍멍");
	}
}

class Cat extends Animal{

	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("냐앙");
	}
}








