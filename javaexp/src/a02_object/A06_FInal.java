package a02_object;

class MathExp{
	int num01 =25; //초기값 할당 
	final double PI=3.14;
	final double PI2;
	MathExp(){
		PI2=0.0;//포함된 필드가 초기화되지 않으면 에러발생. 
	}
	MathExp(int pi){//생성자를 통한 초기화 
		PI2 = pi;
	}
}
final class Dragon{
	Dragon(){
		System.out.println("용 객체 생성");
	}
	void fly() {
		System.out.println("용이 불을 발사하며 날아다니다.");
	}
}//class Dragon2 extends Dragon (X) 상속불가능. 

class Horse{
	
	void sound() {
		System.out.println("말이 울다.");
	}
	final void stop() {
		//특정한 메서드를 상속하는 하위클래스에서 변경해서 사용하지 못하게 할 때,
		//final을 붙인다.
		
		System.out.println("정지하다.");
	}
	void runningFast() {
		System.out.println("빠르게 달리다.");
	}
}
class RobotHorse extends Horse{
	void sound() {//상위에서 선언한 메서드와 동일한 메서드 재정의(overriding) 
		super.sound(); //상위에 정의된 메서드 사용
		System.out.println("경쾌한 음악소리");
	}
	void runningFast() {
		super.runningFast();
		System.out.println("로켓장착");
	}
//	void stop() {} //상위클래스에서 final로 정의되어 있기 때문에  
				   //하위에서 추가 정의하거나, 변경처리 불가능
				   //=> overriding 금지 
}
// class DragonSon extends Dragon{} 
// Dragon 클래스 앞에 상수가 붙어 있기때문에 
// 더 이상 상속을 할 수 없다. 
public class A06_FInal {
	
/*
 # final
 1. final은 클래스의 구성요소와 클래스 자체에 키워드로 사용된다.
 2. 적용대상별로 기능 내용
 	1) 필드명 앞에 쓰이면? - 초기값 할당 이후, 
 						더 이상 변경할 수 없는 값으로 설정된다.
 		상수로 사용되면 일반적으로 상수를 표현할때, 
 		상수명을 전체 다 대문자로 사용.
 		ex) final int PI = 3.14;
 		변수(variable): 데이터가 변경될수 있는 수
 		상수(const): 데이터가 변경될 수 없는 
 	2) 클래스명 ? - final 클래스명으로 선언되면 더이상 상속을 할 수 없다.
 		ex) final class Horse{}
 	3) 메서드명 앞에 붙으면 더 이상 재정의(overriding)할 수 없다.
 	    - 상속받는 하위 클래스에서 
 		  재정의하여 사용할 수 없는 것을 말한다. 
 		  ex) final void running(){}
 		  
 		  
 		
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MathExp m01 = new MathExp();
		System.out.println("변수1:"+m01.num01);
		System.out.println("상수1:"+m01.PI);
		m01.num01 = 75; //다른 데이터 할당 가능
//		m01.PI = 3.5; //다른데이터 할당 시 에러 발생
		
//ex) 상수사용예제 Calculator2 num01, num02 는 변수
//		연산자("+,-,*,/")상수로 생성자에 의해서 
//		초기화 될 수 있게 처리하고 ,
//		show() 를 통해서 출력하세요 
		Calculator2 c = new Calculator2(25,"X",5);
		c.show();
		
		
		Dragon d1= new Dragon();
		d1.fly(); 
		
		RobotHorse rh = new RobotHorse();
		rh.sound();
		rh.runningFast();
		rh.stop();
		
	}
//ex) final 메서드 확인 예제 
// class Duck 메서드 sound(),fly(), swim()
// swim()은 final 
// 상속받은 하위 클래스 class RobotDuck //class RubberDuck 재정의
// swim에 대한 내용을 확인 
	
}
class Calculator2{
	int num01; 
	int num02; 
	final String CAL; 
	Calculator2(int num01, String cal, int num02){
		this.num01 = num01;
		this.CAL = cal;
		this.num02 = num02;
	}
	
	void show() {
		System.out.println(num01+CAL+num02);
	}
}
