package a02_object.a06_access;
import a02_object.a06_access.a01_acc01.Person;
import a02_object.a06_access.a01_acc02.Mother;
import a02_object.a06_access.a01_acc02.*;
import a02_object.a06_access.a01_acc01.*; //해당 패키지 하위 모든 클래스 사용
//선언시 class명으로만 사용이 가능하다. 

public class Z01_MainExp {
/*
 # Access Modifier(접근제어자)
 1. 접근제어자는 클래스나 클래스 안에 있는 멤버(필드, 생성자, 메서드)
 	앞에 붙어서 다른 외부 객체에 대한 접근의 범위를 설정하고, 
 	그 설정된 범위에서만 접근해서 사용할수 있게 만드는 것을 말한다. 
 2. 접근제어자를 파악하기 위한 사전 지식 
 	1) package : 자바의 모든 클래스는 패키지라는 단위 안에 포함되어 있다. 
 		- 물리적으로 folder 개념과 함께 활용된다. 
 		- 패키지 하위에 여러개의 클래스가 포함되어 있다. 
 		- 패키지는 계층 개념보다는 클래스명 위에 패키지명으로 식별한다. 
 		//	package a02_object 하위에 있는 A01_Obj_Start 클래스
 		//	package a02_object.a06_access 하위에 있는 클래스
 			=> 계층 구조 영향 없이 다른 패키지로 인식한다. 
 			하위에 있는 패키지의 클래스간의 전혀 접근에 영향이 없다. 
 			다른 패키지로 인식한다. 
 		- 접근제어 범위가 package 안에 있는 클래스끼리는 
 			default 접근제어자(default-접근제어자가 없는것)범위로 
 			접근이 자유롭다. 
 			앞에 접근제어자 private가 붙으면 접근이 불가능하다. 
 			
 	2) import
 		- (접근제어자 허용 범위 안에 있는)패키지가 다른 클래스를 호출할 때, 
 			첫번쨰) 패키지명.클래스명 참조변수 = new 패키지명.클래스명();
 			두번쨰) import 패키지명.클래스명;를 class명 상단에 선언하고, 
 					클래스명 참조변수 = new 생성자명(); 
 		- api에 있는 클래스(자바에 내장된 클래스)를 사용할 때, 
 			java.lang.* 하위에 있는 패키지 이외에 클래스를 사용할 때, 
 			import java.@@@.클래스명 으로 사용한다. 
 			(https://docs.oracle.com/javase/8/docs/api/)
 			
 			
 	
 3. 접근제어 종류 
 	private(클래스만),default(패키지만), protected(상속관계), public(공용)
 	
 	1) private: 현재 정의된 클래스 내에서만 사용하는 구성요소를 접근제어자 설정
 	2) default: 접근 제어자가 선언되어 있지 않는 것을 말한다. 
 				패키지 내에서만 접근이 가능하다. 
 	3) 
 4. class와 구성요소에 대한 접근제어.
 	1) public class 클래스명{} 
 		클래스명.java로 선언된다. 
 		하나의 클래스 파일.java로 된 파일에 public 클래스는 하나만 선언한다.
 			-하나의 파일에 여러개의 클래스가 선언될 수 있는데, 
 				이 중에 하나만 파일명으로 된 public클래스가 선언될 수 있다. 
 		main()가  포함된 클래스가 public 클래스가 된다. 
 		
 		
 	
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//# 외부에 있는 패키지의 클래스 사용하기 
		//0. 접근제어자 범위 안에 있을때 public, protected 
		//1. 패키지명.클래스
		//2. import 패키지명.클래스명;
		//	 import 패키지명.*;
		//	 클래스명 참조변수;
		a02_object.a06_access.a01_acc01.Animal an; //1번. 
	//	import a02_object.a06_access.a01_acc01.Person; 2번. (클래스상단에)
		Person p01;
		
//ex) a02_object.a06_access.a01_acc02 패키지 안에 
//		Father, Mother, Sister 클래스를 만들고
//		private와 default 접근 필드를 각각 만들어 객체간에 접근 여부와
//		현재 a02_object.a06_access.Z01_MainExp main()에서 호출여부확인
		a02_object.a06_access.a01_acc02.Father f1= null;
		f1= new a02_object.a06_access.a01_acc02.Father();
		
		Mother m1 = new Mother(); //class 상단에 import. 
		Sister s1 = new Sister();
		//각 클래스의 public이 아닌 member들은 다른 패키지에서 사용불가. 
		System.out.println();
	//	System.out.println(m1.name); //default 접근불가 
	//	System.out.println(m1.sec01); //private 접근불가
	//	System.out.println(m1.dinnerFood); //default 접근불가
		System.out.println(m1.favorite); //public
		System.out.println(m1.announce); //public
		
		
/*
 ex) 선녀와 나무꾼 
 */
		
/*
 ex) protected 관련 예제 
  	 a05_grandhome 패키지 
  	 	GrandFather 클래스 하위 protected 변수로 earnMoney 
  	 a06_ourhome 패키지 
  	 	Father 클래스 
  	 		callGrandFather()를 통해서 사용여부확인. 
  	 	
 */
		
		
	}
}
