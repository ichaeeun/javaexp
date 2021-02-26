package a05_exception;

public class A04_UserException {
/*
 # 사용자 정의 예외 처리 
 1. 자바의 표준 API 에서 제공하지 않는 개발자가 새로 정의하여 만든 예외 
 2. 개발자에 의해 정의된 애플리케이션 서비스와 관련된 예외를 처리한다.
 3. 기본형식
 	1) 클래스를 통해서 사용자 정의 예외선언 
 		Exception 클래스를 상속하여 처리한다. 
 		class 사용자정의클래스 extends Exception{
 			생성자명(){}
 			생성자명(String msg){//매개변수로 받은 문자열의 
 			//예외 클래스의 생성자의 매개변수로 넘김 
 				super(msg); //Exception의 생성자 매개변수 
 			}
 			//재정의할 메서드 
 			public String getMessage(){
 				return super.getMessage()+"[사용자 정의 메서드 재정의]";
 			}
 			//추가할 메서드 선언 .. 
 		}
 	2) 사용자 정의 예외 클래스 호출 
 		예외를 처리할 내용에 
 		try{
 			if(조건){
 				throw new 사용자정의예외생성자(매개데이터);
 				//throw : 사용자정의예외 생성할때 
 				//throws: 예외 위임 할때 
 			}
 		}catch(사용자정의예외클래스 e){
 			System.out.println("사용자정의예외발생");
 			System.out.println(e.getMessage());
 			System.out.println(e.선언한기능메서드());
 		}
  */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		for(int cnt =1; cnt<10; cnt++) {
			if(cnt==5) {
				//생성자의 매개변수로 전달한 메세지는 
				//getMessage()를 통해서 가져올 수 있다. 
				throw new UserException("숫자5일때 예외");
			}
			System.out.println("카운트: "+cnt);
		}
		}catch(UserException e) {
			//재정의한 메서드 호출 
			System.out.println(e.getMessage());
			//추가한 메서드 호출 
			e.call();
		}
// ex) UserExcepton2 로 사용자 정의 예외를 만들고, 
//		생성자 매개변수로 문자열을 전달, 
//		getMessage() 오버로딩으로 "사용자정의2" 추가 처리 
//		추가메서드 call2()로 출력물표기 
//		main()에서 반복을 통해서 짝수일때, 해당 내용 호출 처리 .. 
	
		for (int i = 1; i <= 10; i++) {
			System.out.println("[" + i + "]");
			try {
				if (i % 2 == 0) {
					throw new UserException2("짝수일때예외");
				}
			} catch (UserException2 e) {
				System.out.println(e.getMessage());
				e.call2();
			}
		}
	}
}
class UserException2 extends Exception{
	public UserException2(String msg) {
		super(msg);
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "사용자정의2: "+super.getMessage();
	}
	public void call2() {
		System.out.println("두번째 예외 클래스 입니다. ");
	}
	
}

//1. 사용자정의선언 
//	1) Exception 클래스를 상속한다. 
class UserException extends Exception{
//	2) 사용하게 될 생성자를 선언한다. 
	public UserException(){
		//매개변수 없는 생성자 
		super("기본예외(사용자정의)");
	}
	
	public UserException(String msg) {
		super(msg);
	}
//	3) 메서드 재정의 
	@Override
	public String getMessage() {
		return "[사용자 정의 예외 msg]"+super.getMessage();
	}
//	4) 사용자 정의 메서드 추가 
	public void call() {
		System.out.println("사용자 정의 처리 메서드");
	}
}






