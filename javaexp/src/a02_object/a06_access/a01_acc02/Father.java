package a02_object.a06_access.a01_acc02;

public class Father {
	String name="김뫄뫄";
	private int age=50;
	void favorite() {
		System.out.println("바나나");
	}
	
	
	private String sec01= "비밀1";
	String familyTravel="가족여행계획";
	
//	private Father() {} //생성자를 private로 선언 
						//하면 같은패키지 내 다른 클래스에서 사용불가. 
	
	public void callMother() {
		Mother m1 = new Mother();
		System.out.println(m1.dinnerFood); //default : 같은패키지에서 접근 가능
		System.out.println(m1.announce); //public 
		
	}
}
