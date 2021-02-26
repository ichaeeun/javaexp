package a00_exp.a05_1218;

import java.util.ArrayList;
import java.util.Scanner;

public class A01_Exp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 # 주말 과제
 1. 메서드의 기본 구성요소의 기본 예제와 함께 기술하세요. 
 
 	void showInfo(매개변수){메서드구현시 처리할 문장;} 
 	리턴타입, 메서드명, 매개변수, 프로세스 
 	
 2. 완성도 있는 자판기 프로그램을 구현하세요 
 	1) 객체를 이용해서 
 		생성자: 자판기명(음료/점심식사)
 		메서드1: 금액 투입(총금액누적처리)
 		메서드2: 메뉴보이기 
 		메서드3: 메뉴선택 - 투입한 금액과 함께 물건 리턴 
 		메서드4: 잔액 리턴 처리 
 	2) 기본 자판기 예제를 활용하여 완성도 있게 만들어 보세요 
 	

		
		ArrayList<Menu> mlist = new ArrayList<Menu>();
		mlist.add(new Menu("콜라",1200));
		mlist.add(new Menu("사이다",1000));
		mlist.add(new Menu("캔커피",800));
		SellingMachine sm = new SellingMachine("음료자판기",mlist);
		sm.menuList();
		sm.inputMoney(1000);
		//scanner통해서 번호 선택 
		int chNum = sm.choiceNum();
		System.out.println("선택한 번호: "+chNum);
		String result = sm.choiceMenu(chNum);
		System.out.println("나온 음료 내용: "+result);
		int rest = sm.restMoney();
		System.out.println("반환된 잔액: "+rest+"원");
		
	
		

 3. 필기구와 노트의 1:1관계로 설정하여 
 	@@필기구를 이용하여 노트에 @@를 기록하다. 
 	객체 1:1관계 설정으로 프로그램을 처리하세요 

		Pen p = new Pen("연필");
		Note n = new Note("일기장");
		n.write();

 4. 기차예매표 처리 프로그램 기차객체와 좌석별 내용을 1:다 관계로 설정하세요 
 	기차클래스 : 서울~부산
 	좌석클래스 : @@호수 @@좌석번호 예약여부 
 	## 중간에 구간으로 정해서 예매처리. 

		//ArrayList 좌석 설정 
		ArrayList<Seat> slist = new ArrayList<Seat>();
		for(int cnt =1; cnt<=5;cnt++) {
			for(int scnt = 1;scnt<=60;scnt++) {
				slist.add(new Seat(cnt,scnt,false));
			}
		}
		Train t = new Train("서울-부산",slist);
		t.showList();
		t.reserved(1, 1);
		t.reserved(1, 2);
		t.reserved(1, 2);
		t.showList();
		

/*
 5. final, static의 개념과 기본예제를 통해 설명하세요 
 	final은 최종의 의미로, 변수 앞에 붙어서 final int NUM= 25; 
 	로 선언하면, NUM은 상수가 되어 변경할 수 없게 된다. 
 	final 이 메서드 앞에 붙으면 상속받은 클래스에서 오버라이딩 할 수없고, 
 	클래스 앞에 붙으면 final이 붙은 class 는 다른 클래스에서 상속받을 수 없다. 
 	static은 객체의 클래스단위 공유메모리영역, 선언 시에 생성되어서 
 	객체 생성 시 마다 값이 변경되지 않고 객체들이 공통으로 static 멤버를 갖는다. 
 	
 6. 접근제어자의 종류와 범위를 기술하되, default,protected와 관련하여 
 	기본예제를 만들어 보세요. 
 	
 	private 접근제어자는 해당 클래스에서만 사용할 수 있다. 
 	default 접근제어자는 같은 패키지 내에서 사용할 수 있다. 
 	protected 접근제어자는 다른 패키지라도, 상속받은 클래스에서는 사용할 수 있다. 
 	public 클래스는 모두 사용할 수 있다. 
 7. 상속의 멤버(생성자, 필드, 메서드) 별로 접근제어와 재정의에 대하여 기능별로 기술하세요 
 	
 	class Father{
 		private String name; //멤버 
 		Father(String name){
 			this.name = name; 
 		}
 		public void call(){
 			System.out.println("이름: "+name);
 		}
 	}
 	class Son extends Father{
 		//상위 클래스 접근자 private 는 직접적으로 접근이 불가능 
 		Son(){
 			//상위 클래스의 생성자는 반드시 호출하여야 한다. 
 			super("아들이름default");
 			//이렇게 함으로써 간접적으로 name을 할당 할 수 있다. 
 			 
 		}
 		public void call(){//메서드는 동일한 매개변수와 이름으로 재정의가능.(오버라이딩)  
 			super.call(); //상위메서드를 super.으로 호출 가능. 
 		}
 		public void call(String n){//동일한 매개변수가 아니면 오버로딩 . 
 			System.out.println("추가 내용 처리"); //오버라이딩의 핵심인 추가내용 처리가능 
 		}
 	}
 	
 8. 상속에서 Robot을 추상클래스로 정의하고 하위에 실제 클래스를 TV, Dagan, MZ를 선언하여 
 	처리할 수 있도록 하되, Interface는 Weapon으로 하위에 여러 무기(로켓포, 레이저빔 ...)
 	처리 할수 있게 하되, 각 로봇마다 무기를 여러개를 장착가능하게 처리하세요.
 	(오버라이딩, 공통메서드)를 활용하여 처리해보세요. 
 */	
		Tv t1 = new Tv();
		//추상클래스에서 상속받으면, 공통내용을 효과적 사용 및 재정의할 수 있다. 
		//추상/인터페이스 이용시, 추가되는 객체로 기존코드에 영향을 미치지 않는다. 
		t1.attack();
		t1.addWeapon(new Rocket());
		t1.addWeapon(new Laser());
		t1.addWeapon(new ChangeAttack());
		t1.attack();
		t1.shapeAndColor();
		
/*	
 	
 9. 예외처리에서 런타임시 예외와 필수예외를 처리하는 방법을 기본예제를 통해서 설명하세요. 
 	*/
	//런타임시 예외 
//		try {
//		System.out.println(10/0);
//		}catch(ArithmeticException e) {
//			System.out.println("런타임시예외:"+e.getMessage());
//		}
	//필수예외 
		//필수예외는 컴파일자체가 되지 않아서 필수적으로 예외처리를 해줘야한다. 
	//필수예외는 tool(eclipse) 등을 통해서, try{}catch 블럭이 생성된다. 
	//런타임 예외 일단 예외가 발생하는 코드를 입력하여, 실행 후, 예외 내용확인후,
	// 그 예외를 catch블럭의 매개변수로 처리한다. 
	// -1단계 
	// String s = null; 
	// System.out.println(s.toString());
	// -2단계 : 수행후, 예외내용 확인 
//	try{
//		String s = null;
//		System.out.println(s.toString());
//	}catch(NullPointerException e) {
//		System.out.println("예외발생: "+e.getMessage());
//	}
	/*
 10. 사용자 정의 예외를 구성하되, Scanner로 입력한 값이 id,pass가 맞지 않을 때, 
 	정의된 예외클래스를 통해서 처리되는 프로그램을 구현하세요. 
 	
		Scanner scan = new Scanner(System.in);
		
		try {
			System.out.println("아이디를 입력하세요");
			String id = scan.nextLine();
			System.out.println("패스워드를 입력하세요");
			String pass = scan.nextLine();
			if(!(id.equals("chaenee")&&pass.equals("1234"))) {
				throw new MyException("로그인실패");
			}else {System.out.println("로그인성공");}
		}catch(MyException e) {
			System.out.println(e.getMessage());
		}
		
		
		
	/*
 11. 데이터베이스 설치관련 내용을 캡쳐를 통해 설치되는 절차를 정리하여 ppt파일로 만들어보세요. 
 */
	}
}
class Note{
	String kind;
	Pen pen;
	public Note(String kind) {
		this.kind=kind;
	}
	void write() {
		System.out.println(pen+"을 사용해서 "+kind+" 노트에 적다.");
	}
}

class Pen{
	private String kind;
	public Pen(String kind) {
		this.kind = kind;
	}
}

class MyException extends Exception{
	
	public MyException(String msg) {
		super(msg);
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "[사용자정의예외]"+super.getMessage();
	}
}
/*
4. 기차예매표 처리 프로그램 기차객체와 좌석별 내용을 1:다 관계로 설정하세요 
	기차클래스 : 서울~부산
	좌석클래스 : @@호수 @@좌석번호 예약여부 
	## 중간에 구간으로 정해서 예매처리. 
*/
class Train {
	private String name;
	private ArrayList<Seat> slist;
	public Train(String name, ArrayList<Seat> slist) {
		super();
		this.name = name;
		this.slist = slist;
	}
	//좌석 정보 리스트 
	public void showList() {
		System.out.println(name + "기차 좌석 현황 ");
		for(Seat s: slist) {
			s.info();
		}
	}
	
	//예약 처리 
	public void reserved(int numCart, int num) {
		System.out.println(numCart+"호차"+num+"좌석예약여부확인");
		Seat reSeat = null;
		//for(Seat st: slist){
		for(int i=0;i<slist.size();i++) {
			Seat st = slist.get(i);
			if(st.getNumCart()==numCart&&st.getNum()==num) {
				reSeat = st;//해당 호차와 좌석 정보가 있을 때, 해당 좌석 리턴 
				System.out.println(reSeat.isFull()?"예약됨":"예약가능");
				st.setFull(true);
				slist.set(i, st);//변경할당처리 
			}
		}
		if(reSeat == null) {
			System.out.println("해당 좌석이 없습니다. ");
		}
		
	}
}

class Seat {
	private int numCart; //호차 
	private int num; //좌석번호 
	private boolean isFull; //예약여부 
	//구간처리 .. 배열을 문자열로 설정해서, 
	//해당 구간 별로 예약 여부를 처리하여서 처리한다. 
	//1. 배열. 
	//{"서울~수원","수원~대전","대전~대구","대구~부산"}
	//{true,false,false,true}
	//2. 아래 객체로 다시 호출 처리 
	//객체 안에 또 객체 class Loc{String location, boolean isFull;} 
	
	public Seat(int numCart, int num, boolean isFull) {
		super();
		this.numCart = numCart;
		this.num = num;
		this.isFull = isFull;
	}
	public void info() {
		System.out.print(numCart+"호차\t");
		System.out.print(num+"번 좌석\t");
		System.out.println((isFull?"예약":"빈")+"좌석");
	}
	//예약 여부 변경 처리 (외부에서 호출처리) 
	public boolean isReserved(int numCart, int num) {
		System.out.println("예약여부확인");
		if(this.numCart==numCart && this.num==num) {
			return isFull;
		}else {
			return false;
		}
	}
	public int getNumCart() {
		return numCart;
	}
	public int getNum() {
		return num;
	}
	public boolean isFull() {
		return isFull;
	}
	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}
	
	
	
}
//2. 완성도 있는 자판기 프로그램을 구현하세요 
//	1) 객체를 이용해서 
//		생성자: 자판기명(음료/점심식사)
//		메서드1: 금액 투입(총금액누적처리)
//		메서드2: 메뉴보이기 
//		메서드3: 메뉴선택 - 투입한 금액과 함께 물건 리턴 
//		메서드4: 잔액 리턴 처리 
//	2) 기본 자판기 예제를 활용하여 완성도 있게 만들어 보세요 
class SellingMachine{
	
	private String title;
	private int tot; //총금액 
	private ArrayList<Menu>mlist;
	
	//생성자를 통해서 자판기 타이틀 할당 
	//어떤 타이틀이고, 어떤 메뉴가 있는지는 초기 생성시 설정하는 것이 
	//비지니스로직(업무 처리)상 합당하다. 
	
	
	public SellingMachine(String title, ArrayList<Menu>mlist) {
		super();
		this.title = title;
		this.mlist = mlist;
	}
	//금액투입 
	public void inputMoney(int addMoney) {
		this.tot += addMoney;
		System.out.print("금액투입: "+addMoney+"원, ");
		displayMoney();
	}
	//현재금액 표기(공통)
	public void displayMoney() {
		System.out.println("현재금액: "+tot+"원");
	}
	//메뉴 리스트 보이기(번호)  
	public void menuList() {
		System.out.println("## "+title+"메뉴 리스트 ##");
		System.out.println("번호\t물건명\t가격");
		for(int i = 0; i<mlist.size();i++) {
			System.out.print(i+1+"\t"); //index번호와 선택번호 +1 차이 
			mlist.get(i).show();
		}
	}
	//기능 메서드 (Scanner 활용하기) 
	public int choiceNum() {
		Scanner sc2 = new Scanner(System.in);
		// 번호가 선택을 하지 않았거나 입력이 잘못되었을 때, 예외처리 
		int chNum = 0; 
		int maxNum = mlist.size();
		//번호가 정상입력 될때까지 반복수행 
		while(true) {
			try {
			System.out.print("번호를 선택하세요!(1~"+maxNum+"):");
			chNum = sc2.nextInt();
			if(chNum<1 || chNum > maxNum) {//예외발생 범위 설정 
				throw new Exception("입력범위는 1~"+maxNum+"입니다.");
			}
			}catch(Exception e) {//강제예외뿐만아니라 일반예외도 처리 .. 
				System.out.println("예외발생"+e.getMessage());
				System.out.println("다시 입력해주세요");
			}finally {
			//	System.out.println("에러상관없이 진행 ");
			}
			if(chNum>=0 && chNum<=maxNum) { //반복 처리 만료(정상범위 입력) 
				break;
			}
		}
		
		return chNum;
	}
	// 선택물품을 리턴. 
	public String choiceMenu(int chNum) {
		String chProd="";
		//메뉴 리스트 보이기 (내부 메서드 호출) 
		
		//번호 선택하기 (내부 메서드 호출) 
		
		//선택한 번호에 따라서 잔액여부에 대한 처리 
		Menu chMenu = mlist.get(chNum-1);//선택한 번호와 list index 차이 
		if(chMenu.getPrice()<=tot) {//현재입력된 금액이 가격보다 많아야 정상 처리 
			chProd = chMenu.getName();
			tot-=chMenu.getPrice(); //정상 처리 시 차감 
		}else {
			System.out.println("잔액이 부족합니다.");
		}
		//총 금액에서 차감 계산하여 최종 물건 리턴 
		return chProd;
	}
	//남은 잔액 리턴 
	public int restMoney() {
		int ret = tot;
		System.out.println("잔액"+tot+"원 반환합니다");
		tot = 0;
		return ret;
	}
	
}
class Menu{
	private String name; 
	private int price;
	public Menu(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	} 
	public void show() {
		System.out.println(name+"\t"+price+"원");
	}
	public int getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}
	
}


class AutoSelling{
	int inputprice;
	int totalprice;
	int selectprice;
	String selectmenu;
	public AutoSelling() {
		System.out.println("음료자판기");
	}
	public void input() {
		System.out.println("금액을 투입하세요");
		Scanner scan2 = new Scanner(System.in);
		inputprice = scan2.nextInt();
		totalprice += inputprice;
		System.out.println("투입금액: "+inputprice+"원");
	}
	public void show() {
		System.out.println("1.콜라: 1000");
		System.out.println("2.스프라이트: 1200");
		System.out.println("3.환타: 800");
		System.out.println("4.물: 500");
		System.out.println("음료선택(1~4): ");
		Scanner scan3 = new Scanner(System.in);
		int no = scan3.nextInt();
		if(no==1) {
			selectprice = 1000;
			selectmenu = "콜라";
		}else if (no==2) {
			selectprice = 1200;
			selectmenu = "스프라이트";
		}else if (no==3) {
			selectprice = 800;
			selectmenu = "환타";
		}else if (no==4) {
			selectprice = 500;
			selectmenu = "물";
		}
		
	}
	public String select() {
		
		if(totalprice<selectprice) {
			return "잔액이 부족합니다.";
		}else {
			
			totalprice -= selectprice;
			return selectmenu+", 잔액: "+totalprice;
		}
		
	}
}

//8. 상속에서 Robot을 추상클래스로 정의하고 하위에 실제 클래스를 TV, Dagan, MZ를 선언하여 
//	처리할 수 있도록 하되, Interface는 Weapon으로 하위에 여러 무기(로켓포, 레이저빔 ...)
//	처리 할수 있게 하되, 각 로봇마다 무기를 여러개를 장착가능하게 처리하세요.
//	(오버라이딩, 공통메서드)를 활용하여 처리해보세요. 

interface Weapon{
	
	public void attack();
}
class Rocket implements Weapon{

	
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("로켓포로 공격하다");
	}
	
}
class Laser implements Weapon{

	
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("레이저빔으로 공격하다");
	}
	
}
class ChangeAttack implements Weapon{
	
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("변신 공격하다");
	}
	
}
abstract class Robot{
	private String kind;
	private ArrayList<Weapon>wlist; 
	public Robot(String kind) {
		super();
		this.kind = kind; 
		wlist = new ArrayList<Weapon>();
	}
	//무기를 추가할 수 있느 메서드 Weapon wp = 상속받는 하위 객체 
	public void addWeapon(Weapon wp) {
		wlist.add(wp);
		System.out.println("무기 장착");
	}
	public void attack() {
		System.out.println("# "+kind+" 로봇 공격하다 #");
		if(wlist.size()>=1) {
	//	for(Weapon wp: wlist) { //1.list내에 객체를 바로 할당해서 활용할 때 
		for(int i = 0;i<wlist.size();i++) {
		//2. numbering이나 index	를 활용해서 데이터를 처리할 필요가 있을때 활용 
			Weapon wp = wlist.get(i);
			System.out.println("\t"+(i+1)+"번째 무기");
			wp.attack();
		}
		}else {
			System.out.println("무기가 장착되지 않았습니다.");
		}
	}
	//추상클래스를 상속받은 하위클래스에서 재정의할 내용( 추상메서드 선언) 
	public abstract void shapeAndColor();
	
}
class Tv extends Robot{

	public Tv() {
		super("태권브이");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void shapeAndColor() {
		// TODO Auto-generated method stub
		System.out.println("빨간색 V 심볼과 철제 거대 로봇이다.");
	}
}
class Dagan extends Robot {

	public Dagan() {
		super("다간");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void shapeAndColor() {
		// TODO Auto-generated method stub
		System.out.println("변신하는 로봇이다.");
	}
}
class Mz extends Robot {

	public Mz() {
		super("마징가Z");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void shapeAndColor() {
		// TODO Auto-generated method stub
		System.out.println("빨간색 Z심볼과 여러가지 무기를 활용하는 로봇이다.");
	}
}


