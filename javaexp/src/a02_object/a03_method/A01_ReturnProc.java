package a02_object.a03_method;
class Calculator{
	int num1;
	int num2;
	
	int plus(int num1, int num2) {
		System.out.println("# plus 메서드 호출");
		return num1+num2;
	}
	int minus(int num1, int num2) {
		System.out.println("# minus 메서드 호출");
		return num1-num2;
	}
	int multiply(int num1, int num2) {
		System.out.println("# multiply 메서드 호출");
		return num1*num2;
	}
	double divide(int num1, int num2) {
		System.out.println("# divide 메서드 호출");
		return num1/(double)num2;
	}
}
public class A01_ReturnProc {
	
	String name;
	//#메서드의 리턴 유형
	//1. void: 리턴할 데이터가 없을 때, 
	//		주로 입력만 하거나 화면에 출력하는 용도로만 쓰일때, 활용한다.
	void showHello() {
		System.out.println("안녕하세요");
	}
	void showHello2(String name) {
		System.out.println(name+"님 안녕하세요");
	}
	//2. int : 정수형 데이터의 return
	int plus(int num01, int num02) {
		int sum = num01 + num02;
		return sum; //이 메서드를 호출한 곳으로 return데이터를 전달한다. 
	}
	//3. String : 문자열 데이터 return
	String chMember(int chIdx) {
		String gender = "남자";
		if(chIdx==0) {
			gender="여자";
		}
		return gender;
	}
	int total(int price, int cnt) {
		int total = price*cnt;
		return total;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A01_ReturnProc a01 = new A01_ReturnProc();
		a01.showHello();
		a01.showHello2("이채은");
		a01.plus(25, 30); //리턴하는 데이터를 해당 라인에 
	                      //특정한 데이터메모리를 가지고있다.
						  //처리를 할려면 특정한 메모리를 만들어 할당하거나
		                  //출력메서드 System.out.println을 통해 출력 
		int sum = a01.plus(25, 30);
		System.out.println("합산한 데이터: "+sum);
		System.out.println("합산한 데이터: "+a01.plus(25, 30));
		
		//ex1) 물건가격과 갯수를 입력받아서 곱셈연산 후 리턴할 데이터 메서드를
		//	선언하고, 그 리턴값을 출력하세요. 
		//ex2) Calculator 클래스를 선언하고, 생성자에 의해 2개의 값을 받아
		//	plus,minus,multiply,divide 메서드를 통해 리턴하여 처리하세요. 
		//
		
		System.out.println("예제1");
		int total = a01.total(3000, 5);
		System.out.println("총계: "+total);
		
		System.out.println("예제2");
		Calculator c = new Calculator();
		System.out.println("더하기: "+c.plus(24,3));
		System.out.println("빼기: "+c.minus(3,1));
		System.out.println("곱하기: "+c.multiply(4,9));
		System.out.println("나누기: "+c.divide(8,3));
		
/*
 #메서드의 리턴값 처리
 1. 객체는 생성자와 필드를 통해서 기본 데이터를 저장하고, 
 	또한, 특정 메서드를 통해서 데이터 변경/수정할 수 있다. 
 2. 메서드 기능 중에 특정 데이터가 입력되면, 그 결과 데이터
 	여러 조건/반복을 통해서 원하는 결과를 처리할 수 있다. 
 3. 메서드 return값은 메서드를 통해서 최종결과값을 가져오는 것을 
 	말한다. 
 4. 기본형식
 	리턴데이터type 메서드명(매개변수1, 매개변수2){
 	//처리될 프로세스
 	 return 실제리턴할 값;
 	 }
 	 ex)
 	 int plus(int num01, int num02){
 	 	int sum = num01 + num02;
 	 	return sum;
 	 }
 	 변수를 선언할 때, 데이터 유형을 선언하고, 
 	 그 유형에 받는 데이터를 할당하듯, int num01 = 25;
 	 메서드에서도 return할 데이터의 유형을 선언하고, 실제 데이터를
 	 return처리한다. 
 	 위의 예제와 같이 입력값 정수로 2개의 데이터를 받고, 
 	 합산한 값을 return할때, return할 결과 유형에 맞게 선언한다.
 	 
 */
	}

}
