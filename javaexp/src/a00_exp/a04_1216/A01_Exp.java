package a00_exp.a04_1216;

import java.util.ArrayList;

public class A01_Exp {
	public static void main(String[] args) {
/*
 1. 추상클래스를 상속하는 것과 일반클래스를 상속하는 궁극적인 차이점을 기술하세요
 
 	[ 일반클래스상속: 
 		1) 상위 객체는 자체로 객체생성이 가능하다. 
 		2) 하위에서 자유롭게 재활용 및 재정의 할 수 있다. 
 	추상클래스상속: 
 		1) 상위클래스는 자체로 객체생성을 하지 못한다. 
 			-하위 상속 클래스의 통일성 있는 사용을 목적으로 
 			다형성 처리를 위해 만든것이기 때문이다. 
 		2) 하위 클래스는 상위클래스에서 정의된 추상메서드를 반드시 
 			재정의 하여야 컴파일이 가능하다. 
 			추상메서드의 강제성을 확보하여 하위클래스의 재정의메서드
 			통일성을 추구할 수 있다. ]
 			
 	추상클래스에는 body{}가 구현되지 않은 추상메서드가 한개이상있다. 
 	추상클래스를 상속받으면 이 추상메서드를 필수적으로 오버라이딩 해줘야한다. 
 	따라서 상속받은 클래스에서 추상메서드를 강제적으로 쓰게 하는 효과가 있다. 
 
 2. 추상클래스에서는 두가지 유형의 메서드를 사용할 수 있다. 
 
 	[ 실제메서드: 공통부분을 활용하여, 효과적으로 개발을 할 수 있다. 
 	  추상메서드: 상위 클래스에서 상속받아 하위에서는 기능적으로 차이가 
 	  			필요한 부분을 재정의하여 사용할 수 있다. 
 	  			하위 객체에서 다형성을 추구할 수 있는 기능적인 내용을 처리한다. ]
 	  		
  실제 메서드와 추상메서드 
  하위클래스에서 이 클래스를 어떤 경우에 활용하는지를 예제를 통해서 기술하세요.
 
  */
 	abstract class Animal{
 		abstract void sound(); 
 		public void run(){
 			System.out.println("뛰다"); //공통 기능메서드 
 		}
 	}
 	class Dog extends Animal{

		@Override
		void sound() { //추상메서드는 재정의해서 사용한다. 
			System.out.println("멍멍");
		}
 	}
 	Dog d = new Dog();
 	d.sound();
 	d.run(); 
 
 	/*
 3. 추상클래스로 Starcraft의 Zerg종족의 초기 유닛 Larba 를 선언하고
 	필드명 유닉명, 재정의할 메서드 attack()으로 선언하여, 
 	하위 실제클래스로 Zerggling, Hydra, Mutal.. 계층구조화된 내용으로
 	실제 객체를 선언하고, 공격방식에 따른 처리를 하세요 
 	|| Robot 을 추상클래스(kind,attack())로 하위에 Mz, Dagan, Tv 로 
 	공격방법을 다양하게 처리하는 것을 처리하세요. 
 	*/
 	Robot r1 = new Mz();
 	r1.setKind("마징가제트");
 	r1.attack();
 	Robot r2 = new Dagan();
 	r2.setKind("다간");
 	r2.attack();
 	Robot r3 = new Tv();
 	r3.setKind("태권브이");
 	r3.attack();
 	
 	Larba l1  = new Dron();
 	l1.move(); //상위 공통메서드 
 	l1.attack(); // 재정의한 메서드 
 	ArrayList<Larba> list = new ArrayList<Larba>();
 	list.add(new Dron());
 	list.add(new Zerggling());
 	list.add(new Hydra());
 	list.add(new Lurker());
 	for(Larba li : list) {
 		li.move();
 		li.attack();
 	}
 	
 	
 	/*
 4. 인터페이스와 추상클래스와의 차이를 멤버를 위주로 기술하세요. 
 	
 	[ 인터페이스는 목적이 객체의 재활용을 위한 내용이 많다. 
 		멤버: 
 		1) 필드: 추상메서드는 일반필드와 동일하게 사용되지만 인터페이스는 
 			항상 [public static final]이 default로 붙은것과 동일한 작동
 			인터페이스는 static final 상수만 사용할 수 있다. 
 			
 		2) 메서드
 			- 추상메서드 : 추상메서드를 활용하는 것은 동일하나, 
 				인터페이스는 [public abstract]가 붙은 것과 동일한 작동
 				즉, 생략가능하다. 
 			- default메서드 : 인터페이스는 default명시한 메서드가 지원된다. 
 			- static 메서드 : 인터페이스에서는 객체생성없이 static메서드를
 							활용할 수 있다. 
 							
 	추상클래스의 멤버는 멤버변수,추상메서드, 일반기능메서드이다. 
 	추상메서드 이외에도 일반 변수나, 일반메서드가 있다. 
 	인터페이스의 모든 변수는 static, final 이고 
 	인터페이스의 모든메서드는 abstract 이며, public으로 , 
 	기술 하지 않아도 디폴트로 처리된다. 
 
 5. DataAccessObj라는 데이터베이스를 처리하는 인터페이스를 
 	추상메서드(조회,수정,삭제,등록)으로 선언하고, 
 	이를 상속받은 MySqlDao, OracleDao 실제 클래스를 선언하여 
 	각 클래스마다 다른 처리를 구현하여 호출할 수 있도록 하세요
 	*/
 	DataAccessObj da = new MySqlDao();
 	da.search();
 	da.update();
 	da.delete();
 	da.insert();
 	DataAccessObj da2 = new OracleDao();
 	da2.search();
 	da2.update();
 	da2.delete();
 	da2.insert();
 	
 	/*
 6. 추상클래스와 인터페이스를 통한 익명클래스를 생성하여, 처리하는 예제구현
 	Larba/Robot DataAccessObj를 활용하여 처리 
 	
 	[ 추상클래스나 인터페이스를 상속받는 하위 실제 클래스를 통해서 해당 내용을 
 		사용하는게 일반적이지만, main()이나 호출하는 곳에서 바로 이름없이 
 		정의하여 재정의된 메서드나 공통메서드를 사용하는 것을 말한다.]
 */
 	Robot rb2 = new Robot() {

		@Override
		public void attack() {
			// TODO Auto-generated method stub
			System.out.println("잽을 날리다");
		}
 	};
 	rb2.attack();
 	//상속받은 하위 클래스를 하위 객체 이름없이 바로 선언하여 처리 
 	// 추상클래스, 인터페이스가 객체가 생성된 것이 아니고, 
 	// 폴리모피즘(상위 = 하위) 에 의해서 이름없는 실제 객체를 정의 및 생성 해놓은 것이다. 
 	//정의된 내용을 메서드나 생성자를 통해서 사용할수 있다. 
 	Larba al = new Larba("뮤탈리스크") {

		@Override
		public void attack() {
			// TODO Auto-generated method stub
			System.out.println("날으면서 원거리 공격을 하다.");
		}
 	}; //선언과 동시에 객체 생성 
 	al.move();
 	al.attack();
 	
 	//안드로이드에서 이벤트(마우스핸들링,클릭)에서 쓰이는 프로그래밍 방식이다. 
 	DataAccessObj da3 = new DataAccessObj() {

		@Override
		public void search() {
			// TODO Auto-generated method stub
			System.out.println("새로운 조회");
		}

		@Override
		public void update() {
			// TODO Auto-generated method stub
			System.out.println("새로운 수정");
		}

		@Override
		public void delete() {
			// TODO Auto-generated method stub
			System.out.println("새로운 삭제");
		}

		@Override
		public void insert() {
			// TODO Auto-generated method stub
			System.out.println("새로운 등록");
		}
 	};
 	da3.search();
 	da3.update();
 	da3.delete();
 	da3.insert();
 	
 	
	}
}

interface DataAccessObj{
	  void search();	//public abstract 생략가능 
	  void update();	
	  void delete();
	  void insert();
}
class MySqlDao implements DataAccessObj{

	@Override
	public void search() {
		// TODO Auto-generated method stub
		System.out.println("Mysql DB 서버에 접속해서 조회를 하다.");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Mysql DB 서버에 접속해서 수정을 하다.");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("Mysql DB 서버에 접속해서 삭제를 하다.");
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("Mysql DB 서버에 접속해서 등록을 하다.");
	}
	
}
class OracleDao implements DataAccessObj{

	@Override
	public void search() {
		System.out.println("ORACLE DB서버에 접속해서 조회를 하다");
	}

	@Override
	public void update() {
		System.out.println("ORACLE DB서버에 접속해서 수정을 하다");
	}

	@Override
	public void delete() {
		System.out.println("ORACLE DB서버에 접속해서 삭제를 하다");
	}

	@Override
	public void insert() {
		System.out.println("ORACLE DB서버에 접속해서 등록을 하다");
	}
	
}
abstract class Robot {
	private String kind;

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getKind() {
		return kind;
	}

	public abstract void attack();
}

class Mz extends Robot {
	
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println(getKind()+" 공격하다");
	}
}
class Dagan extends Robot{

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println(getKind()+" 공격하다");
	}
}
class Tv extends Robot{

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println(getKind()+" 공격하다");
	}
	
}

abstract class Larba {
	private String kind; // 상속받은 모든 객체에서 사용할 변수 지정.

	public Larba(String kind) { // 상위에 생성자를 통해서 할당.
		super();
		this.kind = kind;
		System.out.println(kind+"유닛생성");
	}

	public abstract void attack(); // 추상메서드가 1개라도 포함되면 추상클래스가 된다.

	public void move() {// 공통메서드
		System.out.println(kind + " 이동하다");
	}
}

class Dron extends Larba {

	public Dron() {
		super("드론"); // 상위 선언된 생성자에 이 객체가 가지고 있는
						// 이름을 매개변수로 전달하여 kind에 할당
	}

	@Override
	public void attack() {
		System.out.println("자원채집을 하고, 공격력은 미약");
	}
	
}

class Zerggling extends Larba {

	public Zerggling() {
		super("저글링");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("빠르게 근접공격을 하다");
	}

}

class Hydra extends Larba {

	public Hydra() {
		super("히드라");
		// TODO Auto-generated constructor stub
	}

	public Hydra(String kind) {
		super(kind);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println(" 원거리 공격을 하다");
	}

}

class Lurker extends Hydra {

	public Lurker() {
		super("러커");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("땅밑에서 공격하다");
	}

}
