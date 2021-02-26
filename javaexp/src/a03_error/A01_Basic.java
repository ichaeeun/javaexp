package a03_error;

public class A01_Basic {
/*
 #error 처리
 1. 에러의 유형
 	1) 컴파일 : 
 		소스코드를 정상적으로 했는데, 해당 클래스를 호출하는데서 
 		에러가 발생 
 		Person.java ==> Person.class(실제 기계어가 만들어서 작동)
 		클래스 파일이 만들어지지 않으면 없는 것과 같아서 에러가 난다.
 		class 파일이 만들어지는 시점 => 컴파일 되었을 때
 		javaexp\build\classes위치에 해당 클래스 파일이 저장하는 시점과 
 		동일하게 수정되었는지 확인 
 		==> 대응 방법
 		1) ctrl + S (저장)
 		2) 해당 폴더를 찾아가서 클래스  파일 확인 
 		3) eclipse 재기동 
 		
 	2) 오타 : 
 		- 기본형식 문제 발생 
 		- 내장 키워드를 변수로 사용 //int break;(X) int break01(O);
 		- 마지막 ;
 	3) 블럭 처리 부분(중괄호 블럭)
 		- 시작블럭과 마지막 블럭 {} 습관화 : 블럭만든 후에 내용쓰기 
 		- tab(4자공백) : 
 	4) NullPointerException 
 		- 문자열 String s; 
 		- 객체 선언 후, 
 		  데이터나 객체가 생성되지 않는 후에 
 		  참조변수.메서드 나 참조변수.필드 를 사용할 때 에러발생
 		   
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int break01=0; //내장키워드 변수사용X(해당변수가 bold표기)
		System.out.println(break01);//main메서드 안에서 데이터를 할당하지 않고 사용하면 에러발생
		String name = null;
		System.out.println(name); 
//		System.out.println(name.toString());//할당 하지 않고, 메서드 사용 시 에러 
		System.out.println("다음라인 수행");
		
		Person p1 = null;
//		p1.call();  //실행 시 에러. 객체생성 안되고 메서드 실행. 
		System.out.println("다음라인 수행");
		Person p2 = new Person();
		p2.call();
	}
}
class Person{
	public void call() {}
}
