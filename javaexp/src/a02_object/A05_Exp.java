package a02_object;

import java.util.Scanner;

public class A05_Exp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 # 전날 복습 내용
 1. 조건문의 형식은 if, switch문이 있다. if문의 형식과 기본 예제를 기술하시오
 	switch(특정데이터/변수){
 	case 데이터1: 처리할 프로세서 break;
 	case 데이터2: 처리할 프로세서 break;
 	case 데이터3: 처리할 프로세서 break;
 	default : 위에 나열된 case가 아닐때 처리할 process 
 	
 	
 	if(조건식) {
		조건이 참일때 수행할 문장 ;
	}
 2. 임의의 객관식 문제의 정답을 변수 corNum으로 할당하고 있다가, 
 	Scanner를 통해서 입력받은 변수 inputNum과 비교하여, 같으면 정답, 다르면 
 	오답을 처리하는 프로그램을 만드세요. 
 3. 반복문 for의 기본형식 2가지를기술하세요. 
 	for(초기값;조건식;증감식){	 조건식이 참일동안 수행될 문장 ; }
 	for(type 변수명 : 배열)
 4. 반복문에서 사용되는 continue와 break의 차이를 기술하세요 
  	continue는 해당 조건에서만 실행하지 않고 반복문 그대로 수행 
  	break문은 반복문 빠져나간다.
  	ex) for(int cnt=1; cnt<=5; cnt++){
  	if(cnt==3){
  	continue; //cnt가 3일 때만, 더이상진행하지안고, 다음 반복을 처리한다. 
    	}
    	System.out.println(cnt);
  	} 
 5. for을 활용하여 3의배수를 1~100까지 출력하고, 5의배수를 100부터 50으로 감소처리하는
 	구문을 만드세요
 6. 실수형 배열로 3명의 키를 할당하고, for문을 이용해서 출력하세요. 
 7. primitive data type의 default 데이터와 객체의 default 데이터에 대하여 기술하세요.
  	primitive data type의 default 데이터는 int는 0, double은 0.0, boolean은 false
  	로, default 데이터로 연산식을 수행할 수 있지만
  	객체의 default 데이터는 null로 메모리가 할당 되지 않아, 디폴트 객체를 이용할 수 없다. 
 8. 클래스의 구성요소 3가지를 Music(타이틀,가수)라는 이름으로 선언하고 호출하세요
 9. 생성자의 overloading은 무엇을 의미하는지 기술하세요. 
 	생성자의 매개변수 갯수, type이 다른경우, 순서가 다른경우, 생성자를 overloading 할 수 있다. 
 	생성자의 이름만으로 생성자를 식별하지 않는다. 
 */
		
	Scanner scan = new Scanner(System.in);
	int corNum = (int)(Math.random()*4+1);
	System.out.println("예제2");
	System.out.println("정답을 입력하세요. ");
	int input = scan.nextInt();
	System.out.println("정답: "+corNum);
	System.out.println((input==corNum)?"정답입니다.":"오답입니다.");
	
	System.out.println("-----------------------------");
	System.out.println("예제3");
	System.out.println("# 1부터 100까지 3의 배수 #");
	for(int i =3;i<=100;i+=3) {
		System.out.print(i+" ");
	}System.out.println();
	System.out.println("# 100부터 50까지 5의 배수 #");
	for(int i=100;i>=50;i-=5) {
		System.out.print(i+" ");
	}System.out.println();
	System.out.println("-------------------------------");
	System.out.println("예제6");
	double arr[] = {160.3,170.2,180.7};
	for(double a: arr) {System.out.print(a+"\t");}
	System.out.println();
	System.out.println("---------------------------------");
	System.out.println("예제8");
	Music m = new Music("백예린","신곡");
	m.showMusic();
	}
}
class Music{
	String name;
	String title;
	Music(String name, String title){
		this.name = name;
		this.title= title;
	}
	void showMusic() {
		System.out.println("가수: "+name);
		System.out.println("타이틀: "+title);
	}
}

