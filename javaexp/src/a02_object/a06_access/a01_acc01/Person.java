package a02_object.a06_access.a01_acc01;
//import a02_object.a06_access.a01_acc01.Person;
public class Person {
	private String name="홍길동"; // 현재 클래스 외에는 사용불가. 
	int age=25; 			 // (default)같은 패키지까지 접근 가능. 
	Person(){
		System.out.println("이름: "+name);
	}
	void callPerson() {
		System.out.println("이름: "+name);
	}
	
}
