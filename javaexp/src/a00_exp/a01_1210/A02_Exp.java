package a00_exp.a01_1210;

public class A02_Exp {
	public static void main(String[] args) {
		System.out.println("======예제1=======");
		Person p = new Person("챈", "서울");
		p.personalPhone(new Phone("아이폰", "010-1234-1234"));
		Person p1 = new Person("파이", "경기도");
		Phone ph = new Phone("삼성", "010-2345");
		p1.personalPhone(ph);

		System.out.println("======예제2=======");
		Computer c1 = new Computer("맥북", "애플");
		c1.showComputer();
		System.out.println();
		Computer c2 = new Computer("그램", "LG");
		c2.cpu = new Cpu("intel", 3.6);
		c2.showComputer();
		System.out.println();
		Computer c3 = new Computer("데스크탑","삼성");
		c3.cpu = new Cpu("AMD",3.2);
		c3.ram = new Ram("삼성",16);
		c3.showComputer(); 

		System.out.println("=======예제3======");
		Person2 per1 = new Person2("챈");
		per1.showFriend(new Friend("파이", "장난감으로 놀았다."));
		per1.showFriend(new Friend("막내", "산책을 했다. "));
		Person2 per2 = new Person2("센");
		per2.showFriend(new Friend("똥개", "담소를 나눴다."));
		
	}
}

/*
 * # 1:1 관련 연습예제 1. 사람(이름, 주소, 핸드폰) vs 핸드폰(전화번호, 제조사) 관계를 메서드로 할당해서 출력 2.
 * 컴퓨터(종류, 제조사) vs cpu(클럭속도, 제조사) 메서드로 할당하고, cpu 장착 여부에 대한 처리 3. Person(이름,
 * Friend) vs Friend(이름, 좋은기억)
 */

class Person {
	String name;
	String address;
	Phone phone;

	public Person(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	void personalPhone(Phone phone) {
		this.phone = phone;
		System.out.println(address + " " + name + " 핸드폰정보");
		phone.showPhone();
	}

}

class Phone {
	String number;
	String company;

	public Phone(String company, String number) {
		super();
		this.number = number;
		this.company = company;
	}

	void showPhone() {
		System.out.println("제조사: " + company);
		System.out.println("번호: " + number);

	}
}

class Computer {
	String kind;
	String company;
	Cpu cpu;
	Ram ram; //1:다 관계 => 하나의 객체가 여러개의 객체로 구성되어 있을때. 

	public Computer(String kind, String company) {
		super();
		this.kind = kind;
		this.company = company;
	}

	// 메서드로 할당 (객체가 메모리 할당)
	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}

	void showComputer() {
		System.out.println("컴퓨터의 종류: " + kind);
		System.out.println("컴퓨터의 제조사: " + company);
		if (cpu != null) {
			cpu.info();
		} else {
			System.out.println("CPU가 장착되지 않았습니다.");
		}
		if (ram != null) {
			ram.info();
		} else {
			System.out.println("RAM이 장착되지 않았습니다.");
		}
	}
}
class Ram{
	String company;
	int memory;
	public Ram(String company, int memory) {
		super();
		this.company = company;
		this.memory = memory;
	}
	void info() {
		System.out.println(" # RAM 정보 #");
		System.out.println("메모리 용량: "+memory+"G");
		System.out.println("제조사: "+company);
	}
}

class Cpu {
	String company;
	double clockspeed;

	public Cpu(String company, double clockspeed) {
		super();
		this.company = company;
		this.clockspeed = clockspeed;
	}

	void info() {
		System.out.println("# CPU 정보 #");
		System.out.println("제조사: " + company);
		System.out.println("클럭속도: " + clockspeed + "GHz");
	}
}

class Person2 {
	String name;
	Friend friend;
	int cnt = 1;

	public Person2(String name) {
		super();
		this.name = name;
	}

	void showFriend(Friend friend) {
		this.friend = friend;
		System.out.println(name + "의 친구" + cnt++);
		System.out.println("친구이름: " + friend.name);
		System.out.println("좋은기억: " + friend.event);
	}

}

class Friend {
	String name;
	String event;

	public Friend(String name, String event) {
		super();
		this.name = name;
		this.event = event;
	}

}
