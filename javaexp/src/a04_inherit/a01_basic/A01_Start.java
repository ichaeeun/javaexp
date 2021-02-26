package a04_inherit.a01_basic;

public class A01_Start {
/*
 # 상속
 1. 생각해봅시다.
 	1) 현실세계에서 상속은 어떤 개념인가? 
 	2) 상속은 어떤 효과가 있는가? 
 	3) 프로그래밍에 있어서 공통과 개별로 분화되면 어떤 장점이 있는가? 
 	4) 추가되는 기능이 다른 프로그래밍에 영향을 미치지 않게 하는 방법은 없을까?
 	5) 효과적인 설계와 그 바탕 하에 프로그래밍을 하려면 어떤 처리가 필요할까? 
 2. 학습목표 
 	1) 자바 프로그램에서 상속은 어떤 것인지를 명확히 파악한다. 
 	2) 상속의 기본 코드를 알고, 상속이 필요한 다양한 상황에서 적절한 프로그래밍을 할 수 있다.
 	3) 상속을 할 때, 생성자와 메서드 필드에는 어떤 영향이 있는지 안다. 
 	4) 메서드 overriding 개념을 알고, 실제 코드를 할 수 있다. 
 		- polymorphism(다형성)과의 관계를 명확히 안다. 
 	5) 상속에서 접근 제어자와 어떤 영향이 있는지 알고, 접근제어자를 적절하게 사용할 수 있다. 
 	6) 상속에서 형변환의 의미를 알고, 활용할 수 있다. 
 	7) 추상 클래스의 기본형식과 프로그래밍에서 필요한 경우를 파악하여 활용할 수 있다. 
 	8) 인터페이스를 효과적으로 활용할 수 있다. 
 	
 3. 주요 내용
 	1) 상속 개념
 	2) 클래스 상속
 	3) 부모 생성자 호출
 	4) 메서드 재정의 
 	5) final 클래스와 final 메서드 
 	6) protected 접근제어자
 	7) 타입 변환과 다형성
 	8) 추상클래스
 
 # 상속이란? 
 1. 현실세계 : 부모가 자식에게 물려주는 행위, 부모가 자식을 선택해서 물려주는 것
 2. 객체 지향 프로그램	
 	- 자식(하위, 파생) 클래스가 부모클래스의 멤버를 물려 받는 것
 	- 자식이 부모를 선택해 물려받음
 	- 상속의 대상은 부모의 필드와 메서드이다. 
 	
 3. 기본형식
 	class 상위클래스{
 		필드1
 		메서드1
 	}
 	class 하위클래스 extends 상위클래스{
 		필드2
 		메서드2
 		//하위 클래스에서는 상위클래스가 가지고 있는 필드1, 메서드1을 
 		//접근제어자 범위에서 사용할수 있다. 
 	}
 	
 */
	public static void main(String[] args) {
		Son s1 = new Son();
		System.out.println("상위 객체의 필드 활용:"+s1.charac);
		//상위 클래스의 메서드 활용 
		s1.swim();
		
		//ex) Mother 속성: skill-대화를잘하다. 
		//			 메서드: cook() 요리를하다 
		//	  Daughter 어머니클래스 상속
		//			속성: study - 공부를 잘하다
		//			메서드: run() - 달리기를 하다 
		//	상속관계 내용을 설정해서 하위 메서드,main()호출하여 사용
		Daughter d1 = new Daughter();
		System.out.println("상위필드:"+d1.skill);
		d1.cook();
		d1.callAll();
		
	}
}
class Mother{
	String skill = "대화를 잘하다.";
	void cook() {
		System.out.println("요리를 하다");
	}
}
/*
 # 상속의 효과
 1. 부모 클래스의 멤버를 재사용해서 자식 클래스 빨리 개발 가능
 	ex) skill, cook()메서드는 선언하지 않고 사용이 가능하다. 
 # 상속 대상 제한
 1. 부모 클래스의 접근제어자 범위 안에서 하위 클래스는 상속해서 필드와 메서드를 
	사용할 수 있다. 
	1) 같은 package일 경우:
	 	ex) Father, Son 관계에서 Father의 private 접근제어자 이외에는 
	 		다 접근이 가능하다. 
	2) 다른 package일 경우: 
		protected, public 으로 접근 제어자가 선언한 멤버만 접근이 가능하다.
		
							
 */
class Daughter extends Mother{
	String study = "공부를 잘하다";
	void run() {
		System.out.println("달리기를 하다");
	}
	void callAll() {
		System.out.println("# 전체 멤버 사용 #");
		System.out.println("상위필드: "+skill);//상위필드활용
		cook(); //상위 메서드 활용
		System.out.println("현재객체필드: "+study);
		run();
	}
	
}

class Father{
	String charac="성격이 원만하다";
	private int age =25;
	protected String favFood ="짜장면";
	public String announce = "자랑";
	void swim() {
		System.out.println("수영을 잘한다");
	}
}
class Son extends Father{
	String height = "키가 크다";
	void training() {
		
		System.out.println("운동을 잘한다.");
		System.out.println(charac);//상위에 정의된 필드 사용
		swim(); //상위 정의된 메서드 활용
	//	System.out.println(age);//상속을 하더라도 접근제어자 범위를 넘어서 처리할 수 없다. 
		
	}
}
//# 자바는 extends를 이용해 상위객체를 여러개 사용하는 다중 상속이 불가능하다. 
//	-단일 상속만 가능하다(하위에서 상위를 바라보는 입장에서)
// class Son3 extends Father, Mother{}  // 에러발생

	