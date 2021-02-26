package a02_object.a06_access.a01_acc01;

public class Animal {
	void call() {
		//객체생성
		//1. 접근제어자 확인: public class Person{} 
		//	 클래스 선언 부분 - (public:)외부에 모든 클래스에서 접근이 가능. 
		//	  Person p01; 
		//2. new Person(): 생성자에 대한 접근이 가능할 때, 접근가능. 
		Person p01 = new Person();
//		Animal 클래스와 Person은 같은 패키지에 잇지만, 
//		구성요소의 접근제어자 범위가 private인 경우에는 접근불가. 
//		System.out.println(p01.name); //error: p01.name=>private
		System.out.println(p01.age); // 접근제어자: default(같은 패키지 내에서 접근가능)
		
	}
}
