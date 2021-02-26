package a02_object.a03_method;

public class MainExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member m1 = new Member("chaenee","lifeofpi","이채은");
		m1.showInfo();
		System.out.println("현재 입력된 id: "+m1.id);
		System.out.println("기능 입력 메서드 처리 ");
		m1.setId("hi");
		System.out.println("현재 입력된 id: "+m1.id);
		System.out.println("기능 메서드2 처리");
		m1.setIdPass("pi", "1234");
		System.out.println("현재 입력된 id: "+m1.id);
		System.out.println("현재 입력된 pass: "+m1.pass);
		
		System.out.println("ex1");
		m1.setName("이파이");
		System.out.println("현재 입력된 이름: "+m1.name);
		
		System.out.println("ex2");
		m1.setAuth("관리자권한");
		System.out.println("권한: "+m1.auth);
		
		System.out.println("ex3");
		m1.setAuthPoint("일반사용자", 1000);
		System.out.println("권한: "+m1.auth);
		System.out.println("포인트: "+m1.point);
		//ex1) name값을 저장하는 메서드를 선언하고 변경된 name을 출력하세요.
		//ex2) 필드로 auth(권한)을 추가하여, 메서드로 auth권한을 변경하는 처리
		//ex3) 필드 point(정수)를 추가하여, auth와 point를 같이 변경할수있게 처리 
		
	}
}
