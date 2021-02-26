package a02_object.a06_access.a01_acc02;

public class Sister {
	String name = "김땡땡";
	private int age = 25;
	
	void callMother() {
		Mother m1 = new Mother();
		System.out.println(m1.dinnerFood);
	//	System.out.println(m1.sec01); private는 접근이 불가능 
		
	}
}
