package a00_exp.a01_1210;

/*
 # 개념과 코드 정리 
 1. 생성자와 메서드의 차이점을 기술하세요.
 
 	생성자는 초기화 메서드. 클래스명과 동일한 생성자명. 
 	생성자는 리턴값이 없다. 객체 생성시 한번만 사용. 
 	매서드는 매개변수 리턴값이 있고, 객체 생성 후 여러번 
 	참조변수를 이용해서 사용할 수 있다. 
 	
 	
 2. default 생성자와 매개변수가 없는 생성자의 차이점과 장단점을 기술
 
  	default생성자는 클래스를 생성하면 저절로 만들어지고 
  	다른 생성자를 만드는 순간 없어진다. 
  	생성자를 따로 선언하지 하지 않아도 만들어진다. 
  	매개변수 없는 생성자는 매개변수 있는 생성자를 만들고서도 같이 쓸 수 있다. 
  	
 3. 객체를 생성하면 생성자를 하나만 선택할 수 있다는 말을 
 	클래스 내 생성자 선언과 관련하여 설명하시오. 
 	
 	객체 생성시 Product p = new Product(); 와 같이 생성하는데 
 	클래스에는 overloading 규칙에 의해 여러 생성자를 선언할 수 있지만, 
 	Product p = new Product("상품");  과 같이 
 	따라서 구조적으로 객체 p 한개당 한개의 생성자밖에 쓸수 없다. 
 	
 4. 메서드의 구성요소 4가지를 메서드 예제 선언과 함께 설명하세요.
 
 	void showInfo(매개변수){메서드구현시 처리할 문장;} 
 	리턴타입, 메서드명, 매개변수, 프로세스 
 	
 5. 다음과 같은 메서드를 선언해 보세요. 
 	1) 매개변수 정수형으로 1~7
 	2) 리턴값 문자열로 된 색상
 	3) 프로세스 처리 
 	1~7번에 따라 무지개 색상 선택 빨/주/노/초/파/남/보 
 	
 6. 메서드에서도 overloading이 사용된다. 예제를 만들어 설명하세요.
 
 	이름이 같더라도 매개변수의 형식에 따라 선언가능한 것을 말한다. 
 	void showInfo(){ System.out.println("매개변수없는메서드";)}
 	void showInfo(String name){
 		System.out.println("매개변수있는 메서드";)
 	}
 7. final이 클래스의 구성요소에 쓰일 때, 각각의 형식과 차이점 
 
 	1) final class 클래스명1{}:상속이 불가능하다.
 	ex)class 클래스명2 extends 클래스명1 (X)
 	2) final int NUM01 = 25;: 상수가 되어, 다른데이터 할당이 불가. 
 	final 이 붙은 상수는 변수와 구분하기 위해 대문자를 사용한다. 
 	3) final void running() : 상속되는 하위 클래스에서 재정의가 불가능하다. 
 	
 	final int NUM =25;//NUM은 상수로, 변경할 수 없게 된다. 
 		  int num;// num은 변수로 변경할 수 있다. 
 8. 위에 final 내용 중에 메서드에서 쓰일 때에 예제를 간단하게 코딩
 
 	final void showInfo(){} 로 쓰이면 
 	showInfo() 매서드는 상속받은 클래스에서 오버로딩 할수 없다. 
 		
 9. static이란 무엇인가? 간단한 변수 앞에 쓰일때, 어떻게 처리되는지 기술
 
 	static : 클래스 종속 변수를 말한다. 즉, 객체 공유 변수이다. 
 	static 변수명; 을 선언하면 객체가 새로 생성되더라도 값이 바뀌지 않는다.
 	클래스명.변수명 으로 호출할 수 있다. 
 	
 	class Count{
 		int cnt1;
 		static int cnt2;
 	}
 	Count는 객체를 생성하면 cnt1은 각 객체마다 변수를 가지고 있지만, 
 	cnt2는 객체가 아닌 클래스 단위로 변수를 처리할 수 있다. 
 	
 10. 클래스 안에 static 으로 메서드를 구현한 내용으로 
   	가위/바위/보 3가지중에 하나가 임의로 나오는 메서드를 구현하여
 	main()에서 호출처리 
 	
 	
 11. 칫솔 클래스와 치약 클래스를 1:1 관계로 설정하여, 종속관계를 만들고 출력
 
 12. 만일 static과 final이 함께 쓰인다면 어떤 효과가 발생하는지. 
 		
 	 클래스단위로 하나의 상수만 쓰일 수 있게 된다. 
 	 
 	 static final int NUM = 25; 
 	 객체가 생성될때마다 변하지 않는 상수가 되고, 
 	 동시에 클래스명.NUM 으로 호출할 수 있다.   
 */
class Number{
	
	static int cnt1; //static 변수 
	final int CNT2;  //상수 
	static final int CNT3=5; //클래스 단위로 상수가 설정. 
	int cnt4; //일반 변수 
	Number(int cnt1, int cnt2, int cnt3){
		this.cnt1=cnt1;
		this.CNT2 = cnt2;
		this.cnt4=cnt3;
//		this.CNT3=CNT3; //객체 단위로 안되기 때문에 에러발생. 
	}
}
public class A01_Exp {
	public static void main(String[] args) {
		
		System.out.println("예제12");
		Number n01 = new Number(1,1,1);
		Number n02 = new Number(2,2,2);
		Number n03 = new Number(3,3,3);
		System.out.println("static 변수1:"+n01.cnt1); 
		System.out.println("static 변수2:"+n02.cnt1); 
		System.out.println("static 변수3:"+n03.cnt1);
		//static 변수:3 => class 공유메모리로 마지막 할당된 데이터.
		System.out.println("final 변수1:"+n01.CNT2);
		System.out.println("final 변수2:"+n02.CNT2);
		System.out.println("final 변수3:"+n03.CNT2);
		//n02.CNT2++; //error ->상수이기 때문에 초기화된 데이터만 사용, 변경불가능 
		//final 상수는 각각의 객체마다 변경되지 않는 데이터를 가지고 있다. 
		System.out.println("static final 변수1:"+Number.CNT3);
		//static final은 클래스 단위 상수이기 때문에 객체마다 가지고 있지 않고, 
		// 클래스 선언할 때, 선언이 되어야한다. 
		
		System.out.println("예제5번");
		Color c1 = new Color();
		System.out.println("1번색: "+c1.showColor(1));
		System.out.println("2번색: "+c1.showColor(2));
		
		System.out.println("예제 11번");
		ToothBrush b1 = new ToothBrush("내칫솔");
		ToothPaste p1 = new ToothPaste("2080");
		p1.toothbrush=b1;
		p1.toothbrush.showBrush();
		
		System.out.println("예제10");
		RandomGame.random();
		RandomGame.random();
		RandomGame.random();
		
		System.out.println("****조건문효율적으로 코딩******");
		System.out.println(Game_02.play());
		
		FinEx f = new FinEx();
		FinEx f1 = new FinEx();
		f.num++;
		System.out.println(FinEx.NUM);
		
	}
}
class ToothBrush{
	String brushname;
	ToothBrush(String brushname){
		this.brushname=brushname;
	}
	void showBrush() {
		System.out.println("칫솔:"+brushname);
	}
}
class ToothPaste{
	String pastename;
	ToothPaste(String pastename){
		this.pastename=pastename;
	}
	ToothBrush toothbrush;
	void showPaste() {
		System.out.println("치약:"+pastename);
	}
}

class Color{
	String color;
	int num;
	String showColor(int num) {
		switch(num) {
		case 1: color = "빨"; break;
		case 2: color = "주"; break;
		case 3: color = "노"; break;
		case 4: color = "초"; break;
		case 5: color = "파"; break;
		case 6: color = "남"; break;
		case 7: color = "보"; break;
		}
		return color;
	}
	
	//******************조건문을 효율적으로 코딩하기******************
	String chColor(int chNum) {
		//1번부터 7번까지 입력되고, 나머지는 0으로 처리 
		int idx=chNum>0 && chNum<8? chNum:0;
		
		String []colors= {"선택안됨","빨","주","노","초","파","남","보"};
		//colors[0], colors[1], colors[2], colors[3], 
		return colors[idx];
	}


}

class RandomGame{
	static void random() {
		int num=(int)(Math.random()*2+1);
		if(num==1)System.out.println("가위");
		else if(num==2)System.out.println("바위");
		else if(num==3)System.out.println("보");
	}
}
//***********조건문 효율적으로 코딩 ***************
class Game_02{
	static String play() {
		int ranIdx=(int)(Math.random()*3);
		String[]arr = {"가위","바위","보"};
		return arr[ranIdx];
	}
}

class FinEx{
	static final int NUM = 25;
	int num;
}