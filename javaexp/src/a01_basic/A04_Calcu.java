package a01_basic;

public class A04_Calcu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 #연산자
 1. 개념
 	1) 데이터를 처리하여 결과를 산출하는 것을 말한다. 
 	2) 연산자(Operations)
 		연산에 사용되는 표시나 기호(+, -, *, /, %, =, ==, !=, >=, <, >)
 		ex) 25+30, num05=75, num01!=num02, num01>=num02
 	3) 피연산자(Operand)
 		연산 대상이 되는 데이터(리터럴 ,변수)
 		ex) sum = num01 + num02;
 		+, = : 연산자
 		num01,num02,sum: 피연산자
 	4) 연산식(Expression)
 		특정한 요구사항에 의해 연산자와 피연산자를 이용하여 연산의 과정을 기술하는 것을 말한다.
 		ex) 2000원 단가를 하는 사과를 5개 구매했을때, 비용을 연산식으로 처리하세요 
 		int price = 2000;
 		int cnt = 5;
 		int total = price*cnt;
 		
 */
		
	/*
	 ex1) 테이블 위에 빵 10개가 있고,
	 곰돌이 3마리에게 각각 빵을 3개씩 배분하고,
	 나머지를 출력하세요 
	 ex2) 10000원을 용돈을 받아서 교통비 1200 2회, 
	 점심값 5000원 지출하고 나머지를 연산식을 이용해서 출력하세요 
	 */
		int bread = 10;
		int bear = 3; 
		int disbread = bear*3;
		int restbread = bread - disbread;
		System.out.println("남은빵갯수:"+restbread);
		
		int money = 10000;
		int tran = 1200;
		int bab = 5000;
		int restmoney = money - (tran*2 + bab);
		System.out.println("나머지금액:"+restmoney);
	
		
	/*
	 #연산자의 우선순위
	 1. 연산자는 우선순위에 따라 연산된다. 
	 	1) (): 소괄호를 씌운 연산자와 피연산자는 가장 먼저 연산을 해준다.
	 		ex) (5+2)*7
	 	2) *, /, % 이 먼저 왼쪽부터 오른쪽으로 수행한다. 
	 		해당 연산식은 순서에 상관없이 결과가 같으므로 왼쪽부터 오른쪽으로 수행해준다.
	 		ex) 5 + 2 * 7 : *이 우선이므로 2*7가 처리된 후, 5를 더해준다. 
	 	3) +, -
	 	4) 단항연산자(++,--,|), 부호연산자(+,-), 대입연산자(+,+=,-= ...)
	 		오른쪽부터 시작해서 왼쪽으로 연산으로 해준다. 
	 		int num05 = 25; 25라는 데이터를 num05에 할당해준다. 
	 */
		System.out.println("(5+2)*7="+(5+2)*7);
		System.out.println("5+2*7="+(5+2*7));
		
		
/*
 #대입연산자
 데이터를 대입시 처리되는 연산자 즉 '='를 말한다.
 대입연산자를 통해서 데이터는 왼쪽에서부터 오른쪽으로 흘러서 대입된다.
 int num01 = 25;
 
 #증감연산자
 데이터를 증가하거나 감소할 때, 사용되는 연산자 ++변수, --변수 형태로 사용된다.
 num01++;
 num01--;
 1씩 증가하고 감소하는 연산자.
 
 #대입증감연산자 
 2이상으로 데이터를 특정한 변수를 통해서 증가시킬때, 사용한다.
 num01=num01 + 2; 기존에 있는 변수에 2와 합산하여 다시 변수에 할당.
 위 내용을 간편하게 하여, 
 num01 += 2; 
 ex) for(int cnt=1; cnt<=100; cnt+=3)
 반복문에서 3씩 증가할때, 활용.
 
 #삼항연산자
1. 일반적으로 조건문에 대한 처리를 한라인으로 효과적으로 처리할 때, 사용된다.
2. 기본형식
	조건식 ? 결과1: 결과2;
	1) 조건식(boolean)에 따라 할당하거나 출력할 데이터를 결과1과 결과2로 
	처리된다. 조건식이 true이면 결과1로 처리되고, 조건식이 false 이면 
	결과2로 처리된다. 
*/
	int point = (int)(Math.random()*101);
	System.out.println("점수: "+point);
    System.out.println("결과: "+((point>=60)? "합격":"불합격"));
    
//ex) 주사위를 돌려서, 홀수가 나오면 승, 짝수가 나오면 패
    int random = (int)(Math.random()*5+1);
   
    System.out.println(random+": "+((random%2==0)?"패":"승"));
	
 
	}
}
