package a00_exp.a03_1215;

import java.util.ArrayList;

public class A01_Exp {

	public static void main(String[] args) {
/*
 1. 1:다 중 종류가 다른 객체를 포함하는 객체에 할당하는 예제를 만들어 보세요.
 	1) 컴퓨터 vs cpu/메모리/hdd 
 		컴퓨터: 필드로 컴퓨터 종류, Cpu, Ram, Hdd 
 			  메서드 showInfo() 
 			  		@@@ 컴퓨터 부품 사양 
 		Cpu, Ram, Hdd: 필드로 이름, capacity(기능속도/메모리크기)
 	
 2. java에서 상속이 현실세계의 상속과 어떤 점이 공통인지를 기술하고, 
 	기본 문법을 예제를 통해서 선언하세요. 
 	
 	java에서 상속은 자식 클래스가 부모클래스를 물려받는 것을 말한다. 
 	부모클래스의 필드와 메서드를 상속받는다. 
 	class Parent{
 		String name; 
 	}
 	class Child extends Parent{
 		int age; 
 		void callParent(){
 			System.out.println(name); //부모클래스의 멤버를 자식클래스에서 사용할 수 있다. 
 		}
 	}
 	
 	class Flyway{
 		private String kind;
 		public Flyway(String kind){
 			this.kind = kind;
 		}
 		public void fly(){
 			System.out.println(kind+"비행한다");
 		}
 	}
 	class AirPlane extends Flyway{
 		int cnt;
 		public AirPlane(){
 			super("비행기");
 		}
 		public void fly(){
 			super.fly();
 			System.out.println("탑승객을 "+cnt+"명 태우고 비행하다");
 		}
 	}
 	
 3. 상속에서 접근제어자로 통한 한계를 기술하세요. 
 
 	상속받은 클래스는 상위클래스에서 protected, public 접근제어자인 멤버를 사용할 수 있고, 
 	같은 패키지 내라면 default 접근제어자인 멤버도 사용할 수 있다. 
 	private 는 해당 class만 사용 가능하므로 상속받더라도 사용할 수 없다. 
 	
 	private : 상속에 의해서 하위 클래스가 직접적인 접근을 하지 못한다. 
 	default : 하위 클래스가 패키지가 다를 때, 접근하지 못한다. 
 	protected, public : 외부 패키지일지라도 접근이 가능하다. 
 	# 필드를 접근 하기 위하여 public 으로 된 setXXX(), getXXX() 메서드로 간접접근을 한다. 
 	
 4. 자바에서 다중상속이 안 된다는 말은 무엇을 의미하는지 개념과 소스 코드예제를
 	통해 기술하세요 
 	자식클래스는 한개의 부모클래스만 상속받을 수 있다. 
 	class Child extends Parent{} 
 	class Child extends Parent1,Parent2{} 과 같이 두개의 상위클래스를 상속받을 수 없다. 
 	
 5. 상속에서 상위 생성자에 따른 하위 생성자의 영향을 매개변수 관점에서 
 	예제 코드를 통해 설명하세요 
 	하위클래스를 생성할 때는 상위클래스의 생성자를 먼저 호출해야한다. 
 	1. default 생성자//매개변수 없는 생성자는 super()를 기본으로 포함하기 때문에 
 	하위에서 특별한 선언없이 사용할 수 있다. 
 	2. 상위에 매개변수 있는 생성자를 선언시, 하위 생성자에서는 해당 생성자의 type, 갯수에
 	맞게 생성자 선언 첫번째 라인에 호출하여야 한다. 
 	
 	class Parent {}
 	class Child extends Parent{} 
 	Child c = new Child(); 
 	에서 default 생성자가 호출되고, child 클래스에서 호출되는 default 생성자는
 	Child(){	super(); 	}
 	로, 상위클래스의 default 생성자를 먼저 호출한다. 
 	만약 상위클래스에서 매개변수 없는 생성자를 선언했다면 
 	class Parent{ 
 		Parent(){
 			System.out.println("Parent클래스생성자");
 		}
 	}
 	class Child extends Parent{} 
 	Child c = new Child(); 
 	에서 default생성자가 호출되고, child클래스에서 호출되는 default 생성자는
 	Child(){	super();	}
 	이므로, default 생성자가 호출되고, 다시 매개변수없는 super(); 생성자를 호출하므로 
 	"Parent 클래스 생성자" 가 실행된다. 
 	
 	만약 상위클래스에서 매개변수 있는 생성자를 선언했다면 
 	하위클래스에서 매개변수 type에 맞추어 생성해주어야 하므로, 
 	class Parent{ 
 		Parent(String name){
 			System.out.println("Parent클래스생성자");
 		}
 	}
 	class Child extends Parent{
 		Child(){
 			super("이름"); //과 같이, 자식 클래스에서 매개변수 type에 맞게 생성자를 선언해주어야 한다. 
 	
 		}
 	} 
 	
 6. overloading과 overriding의 차이점을 기술하세요 
 	
 	overloading은 클래스 내에서 메서드나 생성자를 만들때 
 	매개변수 타입이나 순서, 갯수를 다르게 지정해주면 
 	이름이 같더라도 여러개를 생성할 수 있는 것을 말한다. 
 	overriding은 하위클래스가 상위클래스를 상속받을때 
 	상위 클래스에 있는 메서드를 이름은 같지만 내용은 다르게 재정의해서 사용하는 것을 말한다. 
 	
 7. 다각형이라는 클래스에서 상속받은 삼각형, 사각형, 오각형의 클래스를 
 	필드와 메서드를 이용해서 적절하게 구성해보세요 
 	
 8. 다형성의 개념으로 Robot에서 재정의할 attack()메서드를 통해,
 	상속받은 여러가지 (2가지 이상) 로봇종류 클래스(TV,MZ...)를 선언하고, 
 	상위 = 하위 로 처리하여, 재정의된 메서드를 통해 기능을 출력하세요
 	attack() 하위에서 미사일발사/로켓포발사 등 여러가지재정의가 
 	가능하겠죠? 이런 내용을처리하라는 말입니다. 
 */
		Computer c1 = new Computer("맥 프로");
		//하나씩 부품 추가. 
		c1.setCpu(new Cpu(3.2));
		c1.setRam(new Ram(16));
		c1.setHdd(new Hdd(250));
		c1.showInfo1();
		
		c1.setPart(new Cpu(3.5)); //상위 =하위 (다형성) 
								 // Compart p = new Cpu(3.5);
		c1.setPart(new Ram(32));
		c1.setPart(new Hdd(500));
		c1.showInfo2();
		
		//상위 클래스 메모리 = 하위 클래스 메모리 할당 
		Robot r1 = new Tv(); 
		r1.attack();
		Robot r2 = new Mz();
		r2.attack();
		ArrayList<Robot>rlist = new ArrayList<Robot>();
		rlist.add(new Tv());
		rlist.add(new Tv());
		rlist.add(new Tv());
		rlist.add(new Mz());
		rlist.add(new Mz());
		rlist.add(new Mz());
		rlist.add(new Mz());
		System.out.println("# 반복문 실행 #");
		for(Robot r: rlist) {
			r.attack();
		}
	}
} 

class Computer{
	private String kind;
	//하나씩 추가처리. 
	private Cpu cpu;
	private Ram ram;
	private Hdd hdd;
	//상위 = 하위 (다형성처리) 
	private ArrayList<ComPart>list;
	
	public Computer(String kind) {
		super();
		this.kind = kind;
		list = new ArrayList<ComPart>();
	}
	//컴퓨터 부품 추가처리 
	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}

	public void setHdd(Hdd hdd) {
		this.hdd = hdd;
	}
	
	//컴퓨터 부품 추가처리 
	public void setPart(ComPart part) {
		list.add(part);
	}
	//하나씩 설정한 경우 
	public void showInfo1() {
		System.out.println("# "+kind+"컴퓨터 부품 #");
		cpu.info();
		ram.info();
		hdd.info();
	}
	//ArrayList로 한꺼번에 할당한 경우 
	public void showInfo2() {
		System.out.println("# "+kind+"컴퓨터 부품 #");
		for(ComPart part: list) {
			part.info();
		}
	}
	
	

	
}
//상속관계로 처리
class ComPart{
	private String kind;
	private double capacity;
	public ComPart(String kind, double capacity) {
		this.kind = kind;
		this.capacity = capacity;
	}
	public void info() {
		System.out.println("# 부품사양 # ");
		System.out.println("부품명: "+kind);
		System.out.print("성능: "+capacity);
	}
}
class Cpu extends ComPart{ 
	
	public Cpu(double capacity) {
		super("CPU",capacity);
	}
	public void info() {	//재정의 
		super.info();
		System.out.println("GHz");
	}
}
 
class Ram extends ComPart{
	
	public Ram(double capacity) {
		super("RAM",capacity);
	}
	public void info() {	//재정의 
		super.info();
		System.out.println("GB");
	}
}
class Hdd extends ComPart{

	public Hdd(double capacity) {
		super("HDD",capacity);

	}
	public void info() {
		super.info();
		System.out.println("GB");
	}
}


class Polygon{
	private String kind;
	Polygon(String kind){
		this.kind = kind;
	}
	public void shape() {
		System.out.println(kind+"형 입니다");
	}
}

class Triangle extends Polygon{
	Triangle(){
		super("삼각");
	}
}

class Rectangle extends Polygon{

	Rectangle() {
		super("사각");
		// TODO Auto-generated constructor stub
	}
}

class Pentagon extends Polygon{

	Pentagon() {
		super("오각");
		// TODO Auto-generated constructor stub
	}
}

class Robot{
	private String kind;
	
	public Robot(String kind) {
		super();
		this.kind = kind;
	}

	public String attack() {
		//System.out.println(kind+" 공격");
		return kind;
	}
}
class Tv extends Robot{
	
	public Tv() {
		super("태권브이");
		// TODO Auto-generated constructor stub
	}

	public String attack() {
		
		System.out.println(super.attack()+"가 발차기공격");
		return super.attack();
	}
}
class Mz extends Robot{
	public Mz() {
		super("마징가제트");
		// TODO Auto-generated constructor stub
	}

	public String attack() {
		System.out.println(super.attack()+"가 로켓포발사");
		return super.attack();
		
	}
}

