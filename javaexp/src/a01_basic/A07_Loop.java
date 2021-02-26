package a01_basic;

import java.util.Scanner;

public class A07_Loop {

	public static void main(String[] args) {

/*
 # 반복문
 1. 반복적인 처리를 위해서 사용되는 구문을 말한다. 
 2. 종류
 	1) for(1.초기값설정; 2.반복조건; 4.증감연산자){
 			3.반복할 코드 : 선언한 연산자와 함께 증가/감소하는 처리를 하는 반복문
      	}
      	1 234 234 234 ... 
     2) 반복문에 사용되는 키워드
     	break; continue; 조건문과 함께 반복처리를 효과적으로 도와준다.
     	break문: 반복을 중단시켜준다.
     	continue 문: 해당 단위 프로세스만 수행을 중지했다가 다음 프로세스에서는
     				반복 수행을 계속해 주는 처리를 한다.
     				
 */
		System.out.println("# 1부터 10까지 반복 #");
		for(int cnt=1;cnt<=10;cnt++) {
			System.out.println("카운트  "+cnt);
		}
		//break문 사용 5일때, 중단처리
		System.out.println("break문 사용");
		for(int cnt=1;cnt<=10;cnt++) {
			if(cnt==5)  
				break;
			System.out.println("카운트  "+cnt);
		}
		//continue문 사용 5일때만, 중단하고 계속 수행처리
		System.out.println("continue문 사용");
		for(int cnt=1;cnt<=10;cnt++) {
			if(cnt==5)  
				continue; //continue 이후, 내용만 수행하지 않다 
					  	  // 다음 반복 step 진행 
			System.out.println("카운트  "+cnt);
		}
		//ex) break연습 1에서부터 2씩 증가하면서 100까지 출력하되,
		//	1~100중에 임의의 숫자에서 중단처리되게 하세요
		System.out.println("예제1");
		for(int i=1;i<=100;i+=2) {
			if(i==(int)(Math.random()*99+1)) {
				
				System.out.println(i+" 중단합니다.");
				break;
			}
			System.out.print(i+" ");
		}
		System.out.println();
		//ex) continue 50~100까지 출력하되, continue를 이용해서
		//		짝수는 제외하여 출력하세요
		System.out.println("예제2");
		for(int i=50;i<=100;i++) {
			if(i%2==0) {
				continue;
			}
			System.out.print(i+"  ");
		}
		//ex)1부터 시작하여 369게임 형식으로 해당 번호가 나왔을때
		//숫자가 아닌 짝이 표기되게 하세요
		System.out.println();
		System.out.println("예제3(3,6,9)");
		for(int i=1;i<=1000;i++) {
			if(i<=10) {
				if(i%3==0) {
					System.out.println("짝");
				}
				else System.out.println(i);
			}
			else if(i<100) {
				if((i%10)%3==0&&((i%10)!=0)) {
					System.out.println("짝");
				}
				else System.out.println(i);
			}
			else if(i<1000) {
				if((i%100%10%3==0)&&(i%10)!=0) {
					System.out.println("짝");
				}else System.out.println(i);
			}
		}
		
		
/*
# for문의 index를 통한 배열 데이터 접근
	1) 배열은 index로 접근할 수 있기 때문에 
	2) 배열명.length 배열의 index한계를 설정할 수 있고,
		idx < 배열명.length 
	3) 각 배열의 데이터는 index형식으로 접근하여 처리할 수 있다. 
		배열명[index번호] 	
# for 의 단위데이터 처리 형식 
 */
		String fruits[]= {"사과","바나나","딸기"};
		// fruits[index번호]	: 각각의 개별데이터 접근
		// 	fruits[0] fruits[1]	 fruits[2] 
		// fruits.length: 배열의 길이,index번호는 배열의 길이보다 1작다.
		// 	위 데이터에서 배열의 길이는 3이지만 index번호는 2까지. 
		// idx<fruits.length : index번호는 배열의 길이보다 1적기 때문에 
		// 	반복의 한계치를 < 로 선언. 
		System.out.println();
		for(int idx=0;idx<fruits.length;idx++) {
			System.out.print(idx+1+"번째 과일: ");
			System.out.println(fruits[idx]);
		}
		//ex) 과일의 가격을 정수 배열로 선언하고, 해당 과일명과 가격을 출력하세요
		int price[]= {5000,2000,3000};
		//과일의 가격과 과일명은 index가 동일하기 때문에 한번에 처리할수있다. 
		for(int i=0;i<price.length;i++) {
			System.out.println(fruits[i]+" 가격: "+price[i]+"원");
		}
/*
 #for(단위 데이터: 배열형데이터) 
 	
 */
		System.out.println("# for2의 두번째 형식");
		for(String fruit:fruits) {
			System.out.println(fruit);
		}
		//객체형 배열 선언
		Fruit frus[]= {new Fruit("사과",3000,2),
					   new Fruit("바나나",4000,3),
					   new Fruit("딸기",12000,5) };
		for(Fruit fr: frus) {
			System.out.print(fr.name+"\t");
			System.out.print(fr.price+"\t");
			System.out.print(fr.cnt+"\n");
		}
		
/*
ex) 학생 3명의 이름, 국어, 영어, 수학 점수를 각각의 배열로 만들어서
	이름 국어 영어 수학 총점 평균
	홍	70 80  90 240 80
	김	80 90	95	240	80
	신	60	80	90	240	90
 */
		System.out.println("=============================================");
		String student[]= {"홍길동","김길동","신길동"};
		int kor[]= {70,80,60};
		int math[]= {90,95,90};
		int eng[]= {80,90,80};
		
		System.out.print(" 이름\t국어\t영어\t수학\t총점\t평균\n");

		for(int i=0;i<student.length;i++) {
			int sum;
			sum = kor[i]+math[i]+eng[i];
			
		System.out.print(student[i]+"\t"+kor[i]+"\t"+eng[i]+"\t"+math[i]+"\t"+sum+"\t"+sum/3.0+"\n");
		
		}
		
/*
 # while문
 1. 조건에 따라 반복을 계속할 지를 결정해서 처리하는 구분
 2. 기본 형식
 	while(boolean조건){
 		boolean조건이 true일때, 반복수행할 내용
 		}
 		do{
 			//최소한번은 수행하고, 반복 가능여부를 check 
 		}while(boolean조건);
 3. boolean조건이 true일 경우, 무한반복을 할 수도 있다. 
 
 */
		//System.in : jvm에서 기본적으로 입력하는 객체 
		//Scanner(입력스트림): console창에서 데이터를 입력받아 처리할 수 있는 객체
		//.nextLine() : 줄단위 문자열 입력.
		
		Scanner sc = new Scanner(System.in);
		int pay = 0; //구매할 금액 
		while(true) {//무한반복
			System.out.println("# 현재 구매한 금액 #");
			pay+=2000; //반복시 마다 누적처리
			System.out.println("현재 구매 금액: "+pay);
			System.out.println("구매를 그만하시려면 Y를 입력하세요:");
			if(sc.nextLine().equals("Y")) {
				System.out.println("안녕히가세요 ");
				break;
			}
			
		}
		System.out.println("프로그램 종료");
		
//	ex) Meeting 
//		1번째만남 
//		그만 만나시겠습니까?(Y)
//		2번 만남 
//		3번만남
//		Y => Say GoodBye 
		Scanner sc2 = new Scanner(System.in);
		int i =1;
	while(true) {
		System.out.println((i)+"번째 만남");
		System.out.println("그만 만나시겠습니까?(Y)");
		if(sc2.nextLine().equals("Y")) {
			System.out.println("Say GoodBye");
			break;
		}
		  i++;
    	}
	
	}
}

class Fruit{
	String name;
	int price;
	int cnt;
	Fruit(String name, int price, int cnt){
		this.name = name;
		this.price = price;
		this.cnt = cnt;
		
	}
}
