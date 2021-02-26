package a00_exp.a02_1214;

import java.util.ArrayList;

public class A01_Exp {
/*
 # 월요일 과제
 1. 동적 배열이 무엇인지 기술하세요.
 	
  	자바의 배열에서는 초기화된 배열의 크기를 변경할 수 없는데, 
  	ArrayList는 배열을 동적으로 변경할 수 있어서, 
  	배열을 추가, 삭제, 변경할 수 있다. 
  	
  	동적배열이란? 배열이 동적으로 추가/변경이 가능한 것을 말한다. 
  	프로그래밍에서 배열을 동적으로 변경해주는 것이 많은데, 자바는 따로 
  	동적배열을 지원하는 객체를 만들어서 사용한다. 
  	ArrayList가 대표적인 동적배열을 지원하는 객체이다. 
  2. ArrayList에 지원하는 기능 메서드를 예제와 함께 기술하세요. 
  
  	ArrayList list = new ArrayList(); 
  	list.add("홍길동"); //배열에 추가하는 기능
  	list.get(0); //index 0번에 있는 데이터를 호출하는 기능
  	list.set(0,"김길동"); //index 0번 데이터를 변경하는 기능
  	list.remove(0); // index 0번 데이터를 삭제하는 기능
  	list.size(); //list의 사이즈를 확인해주는 기능. 
  3. ArrayList 할당 시, default 데이터 유형과 
  	generic 이용 시 장단점을 기술하세요
  	
  	ArrayList list = new ArrayList();
  	==>
  	ArrayList <Object>list = new ArrayList<Object>();
  	<Object> : generic 으로 특정한 type의 객체만 들어올 수 있게끔 설정.
  	Object는 상속상 자바의 최상위 클래스 이기 때문에 모든 클래스를 다 할당할 수 있다.
  	ArrayList의 default 데이터 유형은 Object형이다. 
  	그러므로, 초기 default ArrayList는 모든 객체를 추가할 수 있는 특징을 가지고있다. 
  	ArrayList list = new ArrayList();
	list.add("안녕하세요");		//문자열 객체
	list.add(new Person());		//사용자 정의 객체
	list.add(new Integer(25));  //wrapper 클래스 객체 
	1. default ArrayList의 장점: 모든 객체를 할당 할 수 있다. 
	2. default ArrayList의 단점: 다시 호출해서 사용하려면 type casting이 필요하다.
		Person p = (Person)list.get(1);
	일반적으로 하나의 데이터 유형을 동적 배열로 만드는 경우에는 
	generic 개념을 활용하여 ArrayList<객체유형> 형태로 사용한다. 
	해당 type의 객체만 할당할 수 있게끔 초기에 처리해 놓으면, 가져올때 type casting을
	하지 않아도 바로 활용할 수 있다. 
	ArrayList<Person>plist = new ArrayList<Person>();
	plist.add(new Person("홍길동",25));
	plist.add(new Person("김길동",20));
	plist.add(new Person("신길동",27));
	Person p01 = plist.get(0);
	
	
  	ArrayList 할당시 Object 가 default 데이터 유형으로 할당된다. 
  	generic을 이용하면 데이터 유형으로 처음에 지정해준 유형만을 할당할 수 있다. 
  	처음에 타입을 지정해주었기 때문에 새로운 객체를 할당할때, type casting을 해줄필요가 없다.
  4. ArrayList의 generic Type으로 String과 Food(음식명, 선호도 -5점만점)
  	로 선언하고 활용 예제를 작성하세요. 
  5. 1:다 관계 처리로 학교의 반 (class01) 속성 ex) 1-1반 객체에
  	Student(이름,국어영어)로 설정하여 학생등록과 성적리스트를 출력하는
  	기능메서드를 구현하세요. 
  		1) 1:다 관계의 클래스를 설정. 
  			- 여러개의 객체의 단위 클래스를 선언, 
  			- 여러 단위 클래스를 ArrayList<객체>로 해서 포함하는 클래스 선언
  			
  			
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <String>strlist = new ArrayList<String>();
		ArrayList <Food>flist = new ArrayList<Food>();
		strlist.add("파이");
		strlist.add("막내");
		System.out.println(strlist);
		flist.add(new Food("치킨",5));
		flist.add(new Food("피자",5));
		flist.add(new Food("햄버거",5));
		
		for(Food f : flist) {
			f.show();
		}
		
		for(int idx=0;idx<flist.size();idx++) {
			flist.get(idx).show();
		}
		
		System.out.println("음식선호도: "+flist);
		
		Class01 c01 = new Class01("3학년 1반");//반이름, ArrayList<Student> 객체 생성
		c01.addStudent(new Student("홍길동",90,80));//ArrayList에 단위객체추가
		c01.addStudent(new Student("김길동",85,70));
		c01.addStudent(new Student("신길동",80,85));
		c01.allRecords();
		
		//1:다 관계라는 것은 전체 객체를 포함하는 객체가 있고, 
		//그 하위에 단위객체들이 모인 ArrayList<단위객체>가 포함되어 있는 것을 말한다.
		
		Class01 c02 = new Class01("3학년 2반"); 
		c02.addStudent(new Student("박길동",98,90));
		c02.addStudent(new Student("마길동",70,60));
		c02.addStudent(new Student("이길동",80,75));
		c02.allRecords();
		
		c02.addStudent(new Student("가길동",60,50));
		c02.allRecords();
		
		
		
	}
}
class Food{
	private String name;
	private int pref;
	public Food(String name, int pref){
		this.name = name;
		this.pref = pref;
	}
	@Override
	public String toString() {
		return  name + ": " + pref;
	}
	public void show() {
		System.out.println(name+"\t"+pref);
	}
}
//5. 1:다 관계 처리로 학교의 반 (class01) 속성 ex) 1-1반 객체에
//	Student(이름,국어,영어)로 설정하여 학생등록과 성적리스트를 출력하는
//	기능메서드를 구현하세요. 

class Class01{
	
	private String clsName;
	private ArrayList <Student> slist;
	//반이름과 ArrayList를 초기 생성처리 
	
	public Class01(String clsName) {
		super();
		this.clsName = clsName;
		//하나씩 Student를 등록하기 위해서 생성자에서 ArrayList객체를
		//생성처리한다. 
		slist = new ArrayList<Student>();
	}
	//학생 정보 추가 메서드
	public void addStudent(Student s) {
		slist.add(s);
		System.out.println(s.getName()+"학생 정보 추가");
	}
	
	//전체 반의 데이터를 출력 
	public void allRecords() {
		//1:다에서 
		//1에 해당하는 반정보를 출력하고, 
		//다에 해당하는 학생정보를 for 구문을 통해서 처리한다. 
		System.out.println("## "+clsName+"성적표 ##");
		System.out.println("이름\t국어성적\t영어성적");
		for(Student s: slist) {
			s.record();
		}
	}
}
class Student{
	private String name;
	private int enggrade;
	private int korgrade;
	public Student(String name, int enggrade, int korgrade) {
		super();
		this.name = name;
		this.enggrade = enggrade;
		this.korgrade = korgrade;
	}
	public void record() {
		System.out.println(name+"\t"+korgrade+"\t"+enggrade);
	}
	
	public String getName() {
		return name;
	}
	
	
}