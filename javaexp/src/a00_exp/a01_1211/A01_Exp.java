package a00_exp.a01_1211;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class A01_Exp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 /*
  # 주말과제 
  1. 자바의 핵심 메모리 두가지를 primitive 변수와 객체와 비교하여 설명
  
  	heap 영역과 stack영역의 메모리가 있다. 
  	primitive 변수는 stack 영역에 값이 저장되고, 
  	객체는 heap 영역에 저장되며 참조변수 값(객체의 주소)값이 stack영역에 저장.
  	 
  2. String 의 메모리 할당의 특성을 비교연산자와 equals를 통해서 기술하세요.
  
  	 String name1=="홍길동"; "홍길동"으로 된 모든 문자열은 
  	 heap영역에 같은 주소를 쓴다. 
  	 String name2="홍길동"; name1==name2는 true값 나온다.
  	 String name3=new String("홍길동");
  	 String name4 = new String("홍길동");
  	 new String()은 다른 heap영역에 주소값에 객체가 생성이 되기에
  	 name3==name4는 false값으로 처리된다. 
  	 문자열만 비교할 때는 문자열1.equals(문자열2)를 통해서 비교하여야한다. 
  	 name1.equals(name2), name1.equals(name3), 
  	 name3.equals(name4) 모두 다 문자열 자체에 대한 비교이므로 true로 처리된다. 
  	 
  3. Scanner를 통해서 id와 pass를입력하고, himan/777일때,
 	 로그인 성공, 그렇지 않을때, 로그인 실패를 처리하는 프로그램을 만들어 보세요
 	 
  4. 조건물 활용 예제(난이도 중) Scanner를 통해서 나이 입력받아서 처리
  		* 나이에 따른 할인률 적용
  		* 3세 이하, 65세 이상 무료
  		* 4~7: 50% 할인
  		* 8~13: 40% 할인
  		* 14~19: 20% 할인
  		* 그외에는 전액
  		* 
  		* 1)변수나이에 따른 할인률을 출력하세요
  		* 2)요금이 50000일 때, 할인률 적용된 금액까지출력하세요
  		
  	5. 버스 클래스를 만들고 필드로 번호, 시작점, 마지막 종착점 선언
  		생성자를 통해서 해당 필드값을 초기화 처리
  		메서드를 통해서 @@번 @@@~@@ 노선
  	6. Card: (중급)
  		필드: 번호, 모양  52를 배열을 선언
  		번호: A 2 3 4 5 ... J, Q, K
  		모양: 4 가지 
  		메서드: show() 번호와 모양을 출력
  		1) ArrayList<Card> 카드 52개 만들기
  		2) 이 중에서 임의로 7장 뽑아서 출력 show() 
  	 7. Math.random()을 이용해서 주사위가 1~6번호가 나오게 하고,
  	 	실행할 때마다 해당 번호가 나온 확률을 표기하세요 (중급)
  	 	반복문으로 6회 실행하여
  	 	나온 번호: @@
  	 	1: @@ %, 2:@@ %, 3: @@ %, 4: @@ %, 5:@@ %, 6: @@ %
  	 8. 상위는 학년 하위는 반을 출력하세요 (학년은 1~3)(반은 1~10)
  	 		1학년 1반 ~~ 1학년 10반
  	 		2학년 1반 ~~ 2학년 10반 
  	 		3학년 1반 ~~ 3학년 10반 (반복문 활용)
  	 9. 컴퓨터와 하는 가위바위보
  	 	가위! 바위! 보!(1,2,3)를 입력하세요!!
  	 	컴퓨터 vs 나
  	 	  @@ : @@
  	 	  결과: 승/무/패 
  	 10. # 어서오세요 행복 반점 입니다. #
  	 	# 메뉴
  	 	1. 짜장면(5000원)
  	 	2. 짬뽕(6000원)
  	 	3. 탕수육(12000원)
  	 	# 주문번호를 입력하세요(1~3): @@
  	 	# 주문할 수량을 입력하세요 (1~): @@
  	 	@@@를 @@개 주문했습니다.
  	 	계속 주문하시겠습니까?(Y/N):@@
  	 	------------------------
  	 	총 비용은 @@@원 입니다.
  	 11. Book 클래스를 만들고, 
  	  	 생성자로 도서명을 입력받고
  	  	 buy(..,..)를 통해서 가격과 갯수를 입력받아 처리하고,
  	  	 tot()를 통해서 총액을 return받아 처리하고,
  	  	 prn()을 통해서 현재 구매한 도서의 도서명, 가격, 갯수를 출력하세요
  	  	 도서를 3권으로 구매 처리하고, 총비용을 출력하세요 .
 	 	 
  */
 
		System.out.println("=====예제3======");
		Scanner scan = new Scanner(System.in);
		System.out.print("id를 입력하세요.");
		String id = scan.nextLine();
		System.out.print("password를 입력하세요.");
		String pass = scan.nextLine();
		System.out.println(id.equals("himan")&&pass.equals("7777")?"로그인성공":"로그인실패");
		
		System.out.println("======예제4======");
		System.out.println("나이를 입력하세요.");
		int age = scan.nextInt();
		int sale;
		if((age<=3)||(age>=65)) sale = 100;
		else if(age>=4&&age<=7) sale = 50;
		else if(age>=8&&age<=13) sale = 40;
		else if(age>=14&&age<=19) sale=20;
		else sale=0;
		
		System.out.println("# 할인율 #");
		System.out.println(age+"세: "+sale+"%");
		int price = 50000;
		System.out.println("금액: "+price+"원");
		int saledprice=price-price*sale/100;
		System.out.println("할인된 금액: "+saledprice+"원");
		

		System.out.println("=====에제5=====");
		Bus b = new Bus(9401,"오리역","강남역");
		b.route();
		
		
		System.out.println("=====예제7======");
		int num = (int)(Math.random()*5+1);
		System.out.println("나온번호: "+num);
		int cnt=0;
		for(int i=1;i<7;i++) {
			int num2 = (int)(Math.random()*5+1);
			if(num==num2)cnt++;
			System.out.println(i+": "+cnt/6.0*100+"%");
		}
		System.out.println("=====================");
		//1~6까지 해당 수가 나오면 counting 처리할 변수 선언. 
		int no1=0; int no2=0; int no3=0; 
		int no4=0; int no5=0; int no6=0;
		
		for(int i=1;i<=6;i++) {
			System.out.println(i+"번째 주사위 던지기");
			int dice = (int)(Math.random()*5+1);
			System.out.println("\t나온 주사위번호: "+dice);
			//나온 번호에 따른 번호별 횟수 카운트 업
			if(dice ==1) no1++;
			else if(dice ==2) no2++;
			else if(dice ==3) no3++;
			else if(dice ==4) no4++;
			else if(dice ==5) no5++;
			else if(dice ==6) no6++;
			
			//no1/cnt: 소숫점 이하의 확률이 나온다. 3/횟수: 0.5
			// *100 : %로 변환 50.0
			//(int): 정수로 casting 처리 
		}
		System.out.println("\t#나온 확률#");
		System.out.print("\t1: "+(int)((no1/6.0)*100)+"%\t");
		System.out.print("2: "+(int)((no2/6.0)*100)+"%\t");
		System.out.print("3: "+(int)((no3/6.0)*100)+"%\t");
		System.out.print("4: "+(int)((no4/6.0)*100)+"%\t");
		System.out.print("5: "+(int)((no5/6.0)*100)+"%\t");
		System.out.print("6: "+(int)((no6/6.0)*100)+"%\t");
		System.out.println();
	
		
		System.out.println("====예제8=====");
		for(int i =1;i<=3;i++) {
			for(int j=1;j<=10;j++) {
				System.out.print(i+"학년"+j+"반\t");
			}System.out.println();
		}

		//
		//9. 컴퓨터와 하는 가위바위보
//			가위! 바위! 보!(1,2,3)를 입력하세요!!
//			컴퓨터 vs 나
//			  @@ : @@
//			  결과: 승/무/패 
		System.out.println("=====예제9=====");
		System.out.println("가위! 바위! 보!(1,2,3)를 입력하세요!!");
		Scanner sc = new Scanner(System.in);
		int num01 = (int)(Math.random()*2+1);
		int num02 = sc.nextInt();
		String com;
		String my;
		com = (num01==1)?"가위":(num01==2)?"바위":"보";
		my = (num02==1)?"가위":(num02==2)?"바위":"보";
		System.out.println("컴퓨터  vs  나");
		System.out.println(" "+com+"   :  "+my);
		String result;
		if(num01==num02) result = "무";
		else if((num01-num02)==2) result= "승";
		else if((num02-num01)==1) result = "승";
		else result = "패";
		System.out.println(" 결과: "+result);
		
		System.out.println("=================");
		String [] games= {"가위","바위","보"};
		System.out.println("가위1 바위2 보3 를입력하세요");
		int chIdx = sc.nextInt()-1; //배열과 index 번호 차이로 -1
		System.out.println("나: "+games[chIdx]);
		int ranIdx = (int)(Math.random()*games.length);
		System.out.println("컴퓨터: "+games[ranIdx]);
		//games[0], games[1],games[2]	중 한개출력 
		
		if(chIdx==ranIdx) {
			System.out.println("무승부");
		}else if((chIdx+1)%3==ranIdx) {
			//내가 나온 임의의 index값에서 +1한 값에 %3 했을떄
			// 상대방의 idx와 동일하면 상대방이 승리 
			System.out.println("컴퓨터 승");
		}else {
			System.out.println("나 승");
		}
		
		
		System.out.println("====예제10=====");
		System.out.println("# 메뉴");
		System.out.println("1. 짜장면(5000원)");
		System.out.println("2. 짬뽕(6000원)");
		System.out.println("3. 탕수육(12000원)");
		int total = 0;
		while(true) {
			int price2=0;
			int cnt2 = 0;
			String menu="";
			Scanner scan2 = new Scanner(System.in);
			System.out.println("# 주문번호를 입력하세요(1~3): ");
			int input3 =scan2.nextInt();
			System.out.println("# 주문할 수량을 입력하세요(1~): ");
			int input4 = scan2.nextInt();
			cnt2=input4;
			if(input3==1) {
				menu="짜장면";
				price2+=5000;
			}
			else if(input3==2) {
				menu="짬뽕";
				price2+=6000;
			}
			else if(input3==3) {
				menu= "탕수육";
				price2+=12000;
			}
			total += price2*cnt2;
			System.out.println(menu+"를 "+cnt2+"개 주문했습니다.");
			System.out.println("계속 주문하시겠습니까? (Y/N)");
			Scanner scan3 = new Scanner(System.in);
			if (scan3.nextLine().equals("N")) {
				System.out.println("-----------------");
				System.out.println("총비용은 "+total+"원 입니다.");
				break;
			}
		}
		System.out.println("=====================");
		String menus[]= {"짜장면","짬뽕","탕수육"};
		int prices[]= {5000,6000,12000};
		int totpay=0;
		while(true) {
			System.out.println(" # 메뉴");
			System.out.println("1. 짜장면(5000원)");
			System.out.println("2. 짬뽕(6000원)");
			System.out.println("3. 탕수육(12000원)");
			System.out.print(" # 주문번호를 입력하세요(1~3): ");
			Scanner s = new Scanner(System.in);
			int menuIdx = s.nextInt()-1;
			System.out.println(" #주문수량을 입력하세요");
			int menucnt = s.nextInt();
			System.out.println(menus[menuIdx]+"를 "+menucnt+"개 주문하셨습니다.");
			totpay += prices[menuIdx]*menucnt;
			System.out.println("계속 주문하시겠습니까? (Y/N)");
			if(!s.nextLine().equals("Y")) {
				System.out.println("주문 완료");
				break;
			}
			System.out.println("총 비용: "+totpay+"원");
		}
		
		System.out.println("======예제11======");
		Book book = new Book("해리포터");
		book.buy(20000, 5);
		book.tot();
		Book book2 = new Book("노인과 바다");
		book2.buy(15000, 1);
		book2.tot();
		Book book3 = new Book("위대한개츠비");
		book3.buy(18000, 2);
		book3.tot();
		System.out.println("------------------");
		System.out.println("총액: "+book3.tot()+"원");
		
		
		
		System.out.println("=======예제6=======");
		Card []cardArray = new Card[52];
		int card=0;
		for(int i = 0;i<4;i++) {
			for(int j=0;j<13;j++) {
				cardArray[card++]=new Card(i,j);
			}
		}
		int []numbers=new int[7];
		for(int i = 0; i<7;i++) {
			numbers[i]=(int)(Math.random()*51);
			for(int j=0;j<i;j++) {
				if(numbers[i]==numbers[j]) {
					i--;
					break;
				}
			}
		}
		for(int a=0;a<7;a++) {
			System.out.println(cardArray[numbers[a]].show());
		}
		
		System.out.println("=====================");
		//ArrayList<Card2>: Card로 된 ArrayList형 List객체를 생성한다.
		//ArrayList는 기본적으로 모든 객체(Object)가 할당될 수 있지만,
		//generic<객체> 를 이용해서 해당 객체type만 할당할 수 있게 선언. 
		ArrayList<Card2> cards = new ArrayList<Card2>();
		String nums[]= {"A","2","3","4","5","6","7","8","9","10","J","Q","k"};
		//배열로 카드 숫자 선언 
		String shapes[]={"♥","♣","♦","♠"};
		//배열로 카드 모양 선언 
		//1. 모양 배열 호출 
		for(String shape:shapes) {
		//2. 이중 for문으로 모양별로 숫자가 할당 
			for(String num2:nums) {
				//cards list유형 데이터에 ...add()를 통해서 객체 추가
				//new Card(번호,모양) 할당 
				cards.add(new Card2(num2,shape));
			}
		}
		//ArrayList 객체 
		//1. add(추가객체);
		//2. get(index); : 특정한 index에 있는 객체를 가져올 수 있다. 
		//3. size() : 현재 arrayList 크기를 가져온다. 
		System.out.println("카드의 갯수: "+cards.size());
		//총 52개의 카드가 만들어져 메서드를 통해서 확인할 수 있다. 
		System.out.println("카드 list");
		for(Card2 d: cards) {
			d.show();
		}System.out.println();
		
		System.out.println("# 랜덤으로 7장 카드 뽑기(중복도 가능)");
		for(int cnt2=1;cnt2<=7;cnt2++) {
			//카드의 갯수만큼 경우의 수 추출 
			System.out.print(cnt2+"번째 카드: ");
			int rIdx = (int)(Math.random()*cards.size());
			//cards.get(index)
			//리스트.get(임의의 인덱스 위치).show() 출력 
			cards.get(rIdx).show();
			System.out.println();
		}
		//# 중복 제거 방법
		//1. 배열의 알고리즘으로 반복제거(2중 for문)
		//2. Collections.shuffle()메서드 활용
		//		52장의 카드를 섞어준다. 
		//		list객체를 섞어주는 api
		System.out.println("## 중복제거처리 ");
		Collections.shuffle(cards);
		for(int idx=0;idx<7;idx++) {
			cards.get(idx).show();
		}
		System.out.println();
		
		System.out.println("## 중복제거처리2");
		int number2[] = new int[7];
		for(int i=0;i<7;i++) {
			for(int j =0; j<i; j++ ) {
				number2[i]=(int)(Math.random()*cards.size());
				if(number2[i]==number2[j]) {
					i--;
					break;
				}
			}
		}
		for(int idx=0;idx<7;idx++) {
			cards.get(number2[idx]).show();
		}
	}
	
	
}
/*
 * 6. Card: (중급) 필드: 번호, 모양 52를 배열을 선언 
 * 번호: A 2 3 4 5 ... J, Q, K 
 * 모양: ♥︎ ♣︎ ♦︎ ♠︎
 * 메서드:
 * show() 번호와 모양을 출력 
 * 1) ArrayList<Card> 카드 52개 만들기 
 * 2) 이 중에서 임의로 7장 뽑아서 출력 show()
 */
class Card{
	int num;
	int kind;
	Card(int kind, int num) {
		this.kind = kind;
		this.num = num;
	}
	String nums[]= {"A","2","3","4","5","6","7","8","9","10","J","Q","k"};
	String kinds[]={"♥","♣","♦","♠"};
	

	String show(){
		return kinds[kind]+" "+nums[num];
	}
}

class Card2{ 
	private String num;
	private String shape;
	public Card2(String num, String shape) {
		super();
		this.num = num;
		this.shape = shape;
	}
	
	public void show() {
		System.out.print(shape+num+" ");
	}
}





/*
 * 5. 버스 클래스를 만들고 필드로 번호, 시작점, 마지막 종착점 선언 생성자를 통해서 해당 필드값을 초기화 처리 메서드를
 * 통해서 @@번 @@@~@@ 노선
 */
class Bus{
	int busNum;
	String start;
	String end;
	public Bus(int busNum, String start, String end) {
		super();
		this.busNum = busNum;
		this.start = start;
		this.end = end;
	}
	void route() {
		System.out.println(busNum+" 번 버스"+start+"~"+end+" 노선");
		
	}
}


//11. Book 클래스를 만들고, 
//	 생성자로 도서명을 입력받고
//	 buy(..,..)를 통해서 가격과 갯수를 입력받아 처리하고,
//	 tot()를 통해서 총액을 return받아 처리하고,
//	 prn()을 통해서 현재 구매한 도서의 도서명, 가격, 갯수를 출력하세요
//	 도서를 3권으로 구매 처리하고, 총비용을 출력하세요 .
class Book{
	private String bookName;
	static int total;
	private int bookPrice;
	private int bookcnt;
	public Book(String bookName){
		this.bookName = bookName;
	}
	public void buy(int bookPrice, int bookcnt) {
		this.bookPrice = bookPrice;
		this.bookcnt=bookcnt;
		prn();
	}
	int tot()	{
		total+= bookPrice*bookcnt;
		return total;
	}
	void prn() {
		System.out.println("# 현재구매 #");
		System.out.println("도서명: "+bookName);
		System.out.println("가격: "+bookPrice);
		System.out.println("수량: "+bookcnt);
	}
	
}

