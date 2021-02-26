package a01_basic;

public class A05_Exp {

	public static void main(String[] args) {
/*
#복습 내용
1. 자바의 핵심 메모리 2가지를 기술하고, 기본데이터 유형과 객체 유형이
	할당할 때, 메모리 사용방식에 대하여 기술
	=> stack영역, heap영역
	=> 기본데이터 유형은 stack영역에 저장
		객체 유형은 객체 	heap영역에 저장, 데이터값 stack영역
		
2. String에서 비교연산자(==)를 활용할 때, 바로 대입한 경우와 생성자를 
	통해서 객체를 생성하여 대입한 경우에 차이가 발생한다.
	어떤 내용인지 실제코드를 통해서 기술하고, 이럴 경우 어떻게 데이터를 
	비교하여야 하는지 기술
	=>
	비교연산자(==): stack영역의 데이터를 비교한다. 
	heqp 영역에 "롸롸 " 라는 문자가 있으면 같은 메모리를 활용하여 사용된다. 
	그렇기 때문에 name1==name2는 boolean  true
	
	두번째인 경우,
	new String()으로 생성되어 다른 heap영역의 메모리르 사용하게 된다. 
	이럴 경우 name2==name3 는 false
	
	일반적으로 데이터를 외부에서 받아지게 되거나, DB를 통해서 할당되는 경우
	jvm내부에서 2번째 형식으로 데이터가 두번째형식으로 처리되기 때문에
	문자열로 비교할 경우 equals. 
*/
	    String name1 = "롸롸";
		String name2 = "롸롸";
		String name3 = new String("롸롸");
		String name4 = new String("롸롸");
		System.out.println("name1==name2: "+(name1==name2));//true
		System.out.println("name3==name: 4"+(name3==name4));//false
//	객체를 생성하여 대입시 ==를 쓰면 논리적동등이 비교되지 않음 .
//	이럴경우 equals를 써서 비교해야 논리적동등이 비교된다. 
	System.out.println("name3.equals(name4): "+name3.equals(name4));//true
/*
3. 기본데이터 타입 8가지를 나열하고, 각각의 특징을 기술하세요
 	1.byte(1byte)정수형 .8bits=1byte
 	2.int(4byte) default정수형
 	3.long 가장 큰 정수형
 	4. char(2byte) 문자 
 	5. short(2byte)
 	6. double default 실수형
 	7. float 
 	8.boolean  true/false
 4. 형변환은 어떤 경우에 발생하며, 실제 코드의 예를 통해서 설명하세요. 
*/ 
	//형변환은 데이터타입을 다른 타입으로 변환하는 것 .
	//작은타입을 큰타입으로 바꿀때는 (promotion) 자동(묵시적)타입변환 
	//큰타입을 작은타입으로 바꿀때 (casting) 강제(명시적) 타입변환 
//cf)크기의 종류
	//byte(1)<shor(2)<int(4)<long(8)<float(4)<double(8) 
	int num05 = 10;
	double num06 = 1000;
	num06 = num05;
	num05=(int) num06;
/*
5. 연산자와 피연산자의 개념을 정의하고 연산식의 우선순위에 대하여 간단하게 기술하세요
	5*8-9 *, - 연산자, 5,8,9가 피연산자(연산대상이 되는 데이터)
	소괄호 => *,/ => +, -
6. 다음의 내용에 연산식을 이용하여 프로그램을 처리하세요
	1)사과 10개 있는데 4명이 동일하게 할당할 사과의 갯수와 나머지 갯수
	2)개당 2000원 하는 사과를 5개 구매하였다. 총 비용출력
	3)가계부에 초기잔액이 100000에서, 교통비 2500원 2회지출,
		용돈 50000으로 수입. 변수를 이용하여 현 잔액을 출력
	4)Math.random()을 이용하여 주사위가 1~6번호가 나오게 하세요. 
	
 */ 
		int apple = 10;
		int per = 4;
		int perapple = apple/per;
		int last=apple%per;
		
		System.out.println("할당할 사과의 갯수:"+perapple);
		System.out.println("나머지 갯수:"+last);
		System.out.println("==========================");
		int apple2 = 2000;
		int cnt = 5;
		int total = apple2*cnt;
		System.out.println("총비용:"+total);
		System.out.println("==========================");
		int money = 100000;
		int tran = 2500;
		int plusmoney = 50000;
		int spend = money - tran*2;
		int last2 = spend + plusmoney;
		System.out.println("현잔액:"+last2);
		System.out.println("==========================");
		int dice = (int) (Math.random()*5+1);
		System.out.println("주사위번호:"+dice);
		System.out.println();
		//가위바위보 게임 
	
		String games[]= {"가위","바위","보"};
		String game1 = games[(int)(Math.random()*3)];
		String game2 = games[(int)(Math.random()*3)];
		System.out.println("가위바위보!!");
		System.out.println(game1+":"+game2);
		
		
		
	}

}
