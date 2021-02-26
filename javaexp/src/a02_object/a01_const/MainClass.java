package a02_object.a01_const;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//필드의 default 확인
		Car c1 = new Car(); //default 생성자 호출
		//객체는 null, 숫자형 데이터는 0, boolean은 false 
		System.out.println(c1.company);
		System.out.println(c1.model);
		System.out.println(c1.maxSpeed);
		System.out.println(c1.isAuto);
		//메인 메서드에서는 class에서 선언한 생성장 중에 하나를 선택해서
		//객체로 생성을 한다. : 한 객체는 한 생성자로 사용한다. 
		Car c2 = new Car("현대자동차","gv80",250,true);
		System.out.println("# c2: "+c2);
		System.out.println("c2.company: "+c2.company);
		
		
	/*
	 ex) package a02_object.a01_const; 안에
	 	BaseBallPlayer.java 클래스 선언하고 
	 	1. 필드: 소속사, 이름, 성적
	 	2. 생성자: 입력값 없는 생성자, 이름만 할당, 소속사/이름/성적 할당 생성자
	 		구현하세요.
	 	main() 에서 호출하여 필드값을 출력 처리하세요. 
	 	
	 */
		System.out.println("-----------------");
		BaseBallPlayer b1 = new BaseBallPlayer("두산","정수빈",0.318);
		System.out.println("소속사: "+b1.company);
		System.out.println("선수: "+b1.player);
		System.out.println("성적: "+b1.record); 
		BaseBallPlayer b2 = new BaseBallPlayer("NC","양의지",0.289);
		System.out.println("소속사: "+b2.company);
		System.out.println("선수: "+b2.player);
		System.out.println("성적: "+b2.record); 
		BaseBallPlayer b3 = new BaseBallPlayer("김현수");
		System.out.println("소속사: "+b3.company);
		System.out.println("선수: "+b3.player);
		System.out.println("성적: "+b3.record);
		BaseBallPlayer b4 = new BaseBallPlayer();
		System.out.println("소속사: "+b4.company);
		System.out.println("선수: "+b4.player);
		System.out.println("성적: "+b4.record);
		
	}
}
