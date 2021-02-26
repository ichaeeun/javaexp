package a02_object.a07_oneVsmulti;

import java.util.ArrayList;

public class Z02_ArrayList {
/*
# 동적 배열을 처리하는 선형구조 객체 ArrayList 
1. 기본 개념
	1) 동적 배열: 배열은 일반적으로 초기에 크기가 정해지면,
				배열의 크기를 추가하거나 축소할 수 없다. 
				그래서, 동적 배열에 대한 필요성 증가
				=> 선형구조 객체인 ArrayList가 사용됨 
				동적 배열이라는 말 그대로, 배열이 동적으로 변경가능한 것을 말한다. 
	2) ArrayList의 기본 기능 
		할당할 default데이터는 Object형이 객체이다. 
		Object는 java의 api뿐만 아니라 사용자 정의 클래스 등 모든 객체를 
		상속하는 최상위 객체이다. 
		모든 객체는 Object에 할당가능하다.(상속개념에 의해서) 
	3) ArrayList는 객체를 할당, 호출, 변경, 삭제 등을 할 수 있다. 
2. ArrayList의 사용
	1) java.lang.* 패키지 하위에 있는 클래스가 아니기 때문에 import하여야 한다. 
	2) 지원되는 메서드 
		.add(객체) : 해당 객체를 추가할 때, 쓰인다. 
		.get(index) : 객체가 추가되면 index로 저장이 된다. 
			선형구조 0,1,2, ... 
		.set(index, 변경할 객체) : 특정한 위치에 있는 객체를 변경처리한다. 
		.remove(index): 특정한 위치에 있는 객체를 삭제한다. 
			삭제처리 되는 순간, 크기가 하나씩 줄어든다. 
		.size(): ArrayList의 전체 크기를 가져올 수 있다. 
		
*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] array = new String[5]; 
		//초기에 배열의 크기가 고정화 된다. 
		//array라는 참조변수로 배열의 크기를 변경할 수 없다.
		//할당만 가능. 
		//자바에서는 배열에 대한 동적변경이 불가능하다. 
		//새로운 메모리와 기능 util API 를 통해서 가능은 하다. 
		Object ob = new Object();
		Object ob1 = new String();
		Object ob2 = new ArrayList();
		Object ob3 = new Person();
		// String은 Object의 toString() 문자열을 처리하기에 바로 사용 
		// 될 수 있다. 
		// 1. ArrayList 선언
		ArrayList strList = new ArrayList();
		strList.add("사과");
		strList.add("바나나");
		strList.add("딸기");
		strList.add(new Person());
		strList.add(new String("롸"));
		Object ob4 = "사과";
		//String만 참조변수로 호출하면 해당 문자열 데이터를 확인할 수 있다. 
		System.out.println("String object의 참조변수: "+ob4);
		Object ob5 = new Person();
		System.out.println("Person object의 참조변수: "+ob5);
		// ArrayList에 있는 데이터 가져오기 
		System.out.println(strList.get(0));
		System.out.println(strList.get(1));
		System.out.println(strList.get(2));
		System.out.println(strList.get(3));
		System.out.println(strList.get(4));
		// Q1) ArrayList는 어떤 유형의 객체의 default로 할당하는가? 
		//	 	Object 객체를 default로 할당. 
		// Q2) ArrayList에 할당한 String과 다른 객체의 할당의 차이점은 무엇인가?
		//		String은 호출 시 문자열 그대로 가져오고
		//		다른 객체는 주소값 
		// Q3) ArrayList에서 제공하는 추가와 가져오는 메서드는 무엇인가? 
		//		ArrayList.add(객체);
		//		ArrayList.get(index);
		// ex1) 문자열 객체 할당해서 가져오기 
		//		- 좋아하는 스포츠 스타 이름 3명 할당
		// ex2) ArrayList 일반 Person()객체 할당해서 가져오기 
		//		- Person 객체 할당해서 가져오기 
		ArrayList sportStars = new ArrayList();
		sportStars.add("김연경");
		sportStars.add("김연아");
		sportStars.add("박세리");
		for(int idx= 0; idx<sportStars.size();idx++) {
			System.out.println(idx+1+") "+sportStars.get(idx));
		}
		ArrayList plist = new ArrayList();
		plist.add(new Person("홍길동",25));
		plist.add(new Person("신길동",27));
		plist.add(new Person("마길동",28));
		
		for(int idx=0; idx<plist.size();idx++) {
			//plist.get(idx)는 object 타입이다. 
			//plist.get(idx)가 object타입이므로 person객체로 사용하려면 
			//type casting 필요 
			//Object 라는 상속 받은 상위내용으로는 세부 객체의 속성을 활용할 수 없기 때문에
			// typecasting 필요. 
			
			Person p = (Person) plist.get(idx);
			p.show();
		}
		for(Object p : plist) {
			System.out.println(p);
		}
		//이와 같이 객체는 Object로 할당된 것은 그대로 사용할 수 없다. 
		//이 때 필요한 것이 두가지. 
		//1) Object ==> type casting을 통해서 필요로 하는 객체로 만들어서 사용하는 방법
		//2) 초기에 ArrayList에 default인 Object가 아닌 
		//   실제 들어갈 데이터 유형 객체를 선언(generic으로 선언)하여 
		//   호출하여 사용. ArrayList<만들type> 
		// 		- 일반 ArrayList는 Object이기에, typecasting이 필요하지만,
		//			generic은 ArrayList 생성시에, 해당type으로 선언하여 사용하기 때문에
		//			바로 사용이 가능하다. 
		
		ArrayList<Person> plist2 = new ArrayList<Person>();
		plist2.add(new Person("홍길동",25));
		plist2.add(new Person("김길동",27));
		plist2.add(new Person("신길동",29));
		for(int idx=0; idx<plist2.size();idx++) {
			Person p = plist2.get(idx); //타입 casting 필요없다. generic이기 때문.
			p.show();
		}
		// Q1) generic은 왜 typecasting을 할 필요가 없는가 
		//		ArrayList 선언 시에 들어갈 type을 지정해주기 때문 
		// ex) Fruit 클래스에 필드 과일명과 가격, 메서드 buy()를 설정하고, 
		//     ArrayList generic으로 3개를 할당한 후 출력하세요.
		
		ArrayList<Fruit>flist = new ArrayList<Fruit>();
		flist.add(new Fruit("바나나",10000));
		flist.add(new Fruit("사과",15000));
		flist.add(new Fruit("딸기",20000));
		for(int idx=0;idx<flist.size();idx++) {
			System.out.println(flist.get(idx).buy());
		}
		for(Fruit f: flist) {
			System.out.println(f.buy());
		}
		
		//변경처리
		flist.set(0, new Fruit("포도",20000)); //0: 첫번째를 포도 객체 변경처리 
		System.out.println("변경후");
		for(Fruit f: flist) {
			System.out.println(f.buy());
		}
		System.out.println("삭제후");
		flist.remove(1);
		System.out.println(flist.size());
		for(Fruit f: flist) {
			System.out.println(f.buy());
		}
		
		
		
	}
}
class Fruit{
	private String name;
	private int price;
	
	public Fruit(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String buy() {
		return "["+ this.name+": "+this.price+"원]";
	}
	
	
}
class Person{
	
	private String name;
	private int age;
	public Person() {}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public void show() {
		System.out.println(name+"\t"+age);
	}
}
