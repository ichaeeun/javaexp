package a02_object;

class Television{
	static String company = "삼성전자";
	static String model = "LED";
	static String info;
	//static 블럭을 통해서 static 변수 데이터를 할당하여 사용할 수 있다.  
	static {	
		info = company+" - "+model; 
	}
}
class Student{
	static int grade=3;
	static int classnum=6;
	static int num=18;
	static String name="이채은";
	static String studinfo;
	static {
		studinfo = grade+"학년 "+classnum+"반 "+num+"번 "+name;
	}
}

public class A08_StaticBlock {
/*
 # static변수는 static block으로 변수를 변경할 때, 
 	사용할 수 있다. 
 ex) student 클래스 선언하고 static 변수로 학년 반 번호 이름을 선언할당하고,
 	 studinfo static변수 선언 
 	 static block을 통해 위 정보 할당하고, 확인하는 코드 작성 
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Television.company);
		System.out.println(Television.model);
		System.out.println(Television.info);
		
		System.out.println(Student.studinfo);
		
	}
}
