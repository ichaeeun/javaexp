package a02_object;
/*
 # static 메서드도 객체 생성 없이 바로 사용할 수 있다. 
 
 */
class Calculator{
	static int plus(int num01, int num02) {
		return num01+ num02;
	}
}
//ex) ShopMember 클래스 만들고 static 메서드로 login 선언하고, 
//		매개변수로 id, pass를 입력하게 하여, 
//		로그인 성공 문자열 그외에는 로그인실패 문자열 리턴하게 하세요
class ShopMember{
	static String login(String id, String pass) {
		return (id.equals("chaenee")&&pass.equals("1234"))?"로그인성공":"로그인실패";
	}
}

public class A09_StaticMethod {
	static int minus(int num01, int num02) {
		return num01-num02;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("스테틱 메서드 활용1: "+Calculator.plus(25, 30));
		System.out.println("스테틱 메서드 활용1: "+minus(25, 30));//main 소속 클래스이기 때문에 생성가능
		
		
		System.out.println("예제");
		System.out.println(ShopMember.login("chaenee","1234"));
		System.out.println(ShopMember.login("pi","1234"));
		
	}
}
