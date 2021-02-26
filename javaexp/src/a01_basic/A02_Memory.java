package a01_basic;

import java.util.Scanner;

public class A02_Memory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
# java의 메모리 사용
1. java는 핵심 메모리로 두가지를 사용하고 있다. 
2. stack: 기본데이터유형, 객체의 참조변수(heap영역의 주소값)
3. heap: 실제 객체가 들어가는 메모리 영역 
*/
		//기본데이터할당
		int num01 = 25;
		System.out.println("데이터의 할당 확인(stack):"+num01);
		//객체는
		//stack 영역에 직접적으로 객체를 할당하는 것이 아니라
		//heap 영역의 주소값으로 할당하고 있다. 
		//			a01_basic.Person@19e1023e
		//			패키지명.객체명@16진수의 주소값 
		Person p = new Person();
		System.out.println("데이터의 할당 확인(heap의 주소):"+p);
		//객체의 구성요소(필드, 생성자, 메서드)는 참조명을 통해서 접근이 가능하다.
		System.out.println("객체의 필드값 확인:"+p.num01);
		int num02 = 30;
		int num03 = 3;
		
		System.out.println(num02+"+"+num03+"="+(num02+num03));
		System.out.println(num02+"-"+num03+"="+(num02-num03));
		System.out.println(num02+"*"+num03+"="+(num02*num03));
		System.out.println(num02+"/"+num03+"="+(num02/num03));
		Product pd = new Product();
		System.out.println(pd);
		System.out.println("물건명:"+pd.name);
		System.out.println("가격:"+pd.price);
		System.out.println("갯수:"+pd.cnt);
	/*
	 ex) 일반 변수 num02과 num03의 사칙 연산 데이터를 할당한 결과값을 출력하고,
	 	클래스 Product를 선언하고, 필드로 name, price, cnt를 선언하고
	 	할당한 결과값을 출력하세요 
	 */
		
	/*
	 #String 값과 메모리할당
	 1.boolean연산자(비교연산자) == 는 stack 영역의 데이터를 비교해준다
	 2. 기본데이터 유형은 동일한 값을 할당하면 true로 처리되지만,
	 	객체의 경우 동일한 값을 할당하더라도 주소값이 다르기때문에 false가 처리되는 경우가
	 	많다. 
	 
	 */
		int num04 = 50;
		int num05 = 50;
		System.out.println("두개의 기본 유형 비교:"+(num04==num05));
		System.out.println("==============");
		Product p02 = new Product();
		Product p03 = new Product();
		System.out.println(p02.name+":"+p03.name);
		System.out.println(p02.price+":"+p03.price);
		System.out.println(p02.cnt+":"+p03.cnt);
		//두객체의 참조값 비교 => 
		System.out.println("참조값의 비교:"+(p02==p03));
		//heap영역의 주소값이 다르기 때문에 stack영역의 주소값이 다르다.
		System.out.println(p02);
		System.out.println(p03);
	System.out.println("==================");
	/*
	3. String 은 객체이다.
	4. 데이터는 heap영역에 할당된다.
	
	
	 */
		String name01 = "홍길동";
		String name02 = "홍길동";
		String name03 = new String("홍길동");
		String name04 = new String("홍길동");
		//name03과 name04는 new String()로 생성하면 다른 heap주소 위치에 
		//객체가 생성이 된다. => 
		System.out.println("name03==name04:"+(name03==name04));
		
		//new 없이 바로 문자열을 할당하면, 어떤 메모리가 사용되는지?
		//"홍길동" 이란 문자열은 모두 다 같은 heap영역의 메모리를 사용한다. 
		System.out.println("name01==name02:"+(name01==name02));
		
	/*
	5. 문자열이 동일한지의 비교는 ==를 활용하면 예외사항 때문에 문제가 발생한다. 
	6. 문자열의 동등비교는 문자열이 객체이므로 사용되는 .equals()를 활용하여 비교하여야 한다.
		ex) 파일을 읽거나, console 입력을 통해서 입력 받거나, 데이터베이스를 통해서 
			가져오는 데이터는 명시적으로 new String()가 보이진 않지만, 이 처리가 된 
			각각의 heap영역의 메모리에 할당되고, 할당된 데이터를 호출하여 가져온다. 
	 	ex) 다른 프로그래밍 언어에서는 equals와 ==를 구분하는 경우가 드물기때문에 
	 		기억해야한다. (자바의 특징) 
	 	
	 */
		
		System.out.println("name01.equals(name02): "+name01.equals(name02));
		System.out.println("name01.equals(name04): "+name01.equals(name04));
		System.out.println("name03.equals(name04): "+name03.equals(name04));
		
	/*
	 임의의 id,pass 문자열에 데이터를 할당하고, 
	 해당 id pass가 동일하면 true, 그렇지 않으면 false를 처리하세요(문자열만 비교)
	 */
		
	String id = "chaenee";
	String pass = "lifeofpi";
	Scanner scanner = new Scanner(System.in);
	System.out.println("아이디를 입력하세요");
	String input = scanner.nextLine();
	System.out.println("패스워드를 입력하세요 ");
	String input2 = scanner.nextLine();
	if(id.equals(input)&& pass.equals(input2)) System.out.println("true");
	else System.out.println("false");
	
		
	}
}
class Product{
	String name = "맥북";
	int price = 200;
	int cnt = 1;
}
class Person{
	int num01=30;
}
