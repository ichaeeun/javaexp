package a02_object.a01_const;
/*
ex) package a02_object.a01_const; 안에
	BaseBallPlayer.java 클래스 선언하고 
	1. 필드: 소속사, 이름, 성적
	2. 생성자: 입력값 없는 생성자, 이름만 할당, 소속사/이름/성적 할당 생성자
		구현하세요.
	main() 에서 호출하여 필드값을 출력 처리하세요. 
	
*/
public class BaseBallPlayer {
	String player;
	String company;
	double record;
	/*
	1. default 생성자는 생성자를 선언하는 순간 사라지지만,
		매개변수가 없는 생성자는 다른 생성자와 함께 사용할 수 있다.
	2. 매개변수가 없는 생성자는 특정 데이터를 할당하거나 프로세스를 코드로 
		추가정의 할 수 있다. 
	 */
	BaseBallPlayer(){
		System.out.println("매개변수 없는 생성자 호출");
	    company = "무소속";
		player = "익명";
	}
	BaseBallPlayer(String player){
		//#전역변수와 지역변수
		//1. 전역변수: 클래스에 전체적으로 영향을 미치는 변수 
		//		클래스 선언 하위에 선언된필드가 전역변수로 사용된다. 
		//		1) 클래스의 구성요소인 생성자와 메서드에 영향을 미치고, 
		//		2) 이름이 동일한 생성자 또는 메서드에 있는 지역변수와
		//			구분하기 위해서 this.전역변수 = 지역변수;로 식별하여
		//			사용한다.
		
		//2. 지역변수
		//특정한 블럭(중괄호 {})안에서 선언하여 사용하는 변수 
		//	1) 매개변수 ex)BaseBallPlayer(String name)
		//	2)  중괄호 블럭 안에서 새로 선언된 변수
		//		void call(){
		//			int age = 25;
		//			}
		//this.변수 : 지역변수와 이름이 같을 때, 구분하여 사용한다. 
		//3. java에서는 지역변수와 이름이 겹치지 않으면 this없이도 
		//	사용해도 무방하다. (javascript 등에서는 이름이 달라도 this 써줘야함)
		//	아래의 company는 필드(전역변수)이지만 중괄호 내에 
		//	동일한 지역변수가 없기 때문에 선언된 내용으로 사용할 수 있다. 
		company = "무소속";
		this.player=player;
	}
	BaseBallPlayer(String company, String player, double record){
		this.company=company;
		this.player=player;
		this.record=record;
	}
}
