package a02_object;

import java.util.Scanner;

class Friend{
	Friend(String name, int time){
		this.name = name;
		this.time=time;
	}
	String name;
	int time;
	void show(){
		System.out.println("이름:"+name);
		System.out.println("친구가 된 시기:"+time+"월");
	}
}
class Member{
	String id;
	String pass;
	String name;
	Member(String id, String pass, String name){
		this.id = id;
		this.pass = pass;
		this.name = name;
	}
	void login() {
		System.out.println(name+"님 id: "+id+", 패스워드: "+pass+"를 통해서 로그인 성공");
	}
	 
	 void login(String id,String pass) {
		 Scanner scan = new Scanner(System.in);
		 System.out.println("아이디를 입력하세요.");
		 String input = scan.nextLine()	;
		 System.out.println("패스워드를 입력핫요.");
		 String input2= scan.nextLine();
		System.out.println( (input.equals(id)&&input2.equals(pass))?"로그인성공":"로그인실패");
	 }
}

class Entertainer{
	String name;
	int age;
	char gen;
	Entertainer(String name, int age, char gen){
		this.name = name;
		this.age = age;
		this.gen =gen;
	}
	void showMyEnter(){
		System.out.println("이름: "+name);
		System.out.println("나이: "+age);
		System.out.println("성별: "+gen);
	}
}

public class A04_Exp {
	
	public static void main(String[] args) {
	 System.out.println("예제1");
	 Friend f = new Friend("홍길동",7);
	
	 f.show();
	 
	 System.out.println("예제2");
	 Member m = new Member("chaenee","1234","이채은");
	 m.login();
	 
	 System.out.println("예제3");
	 Entertainer e= new Entertainer("누구야",25,'F');
	 e.showMyEnter();
	 
	 System.out.println("예제4");
	 m.login("chaenee","1234");
	 
/*
# 객체의 기본 구성요소를 통한 연습예제 
  1. Friend 클래스를 선언하고, 필드: 이름, 친구가된시기, 생성자를 통해 메서드 show() 출력처리
  2. Member 클래스 선언, 필드: id, pass,name, 생성자를 통해서 id, pass, name할당,
  		메서드 login()을 통해서 @@@님 패스워드 @@@를 통해서 로그인 성공 출력
  3. Entertainer 클래스 선언 필드: 이름, 나이, 성별, 생성자 초기화, 
  		showMyEnter() 메서드 통해서 정보 출력
  
  4. 위 2번에서 login()메서드에 매개변수로 id, pass를 입력하게 하여, 기존 필드에 있는 id, pass와
   	 동일하면 로그인성공, 아니면 로그인 실패 
 */
		
	}
}
