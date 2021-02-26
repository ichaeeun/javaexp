package a04_inherit.a01_basic;

public class Worker{
	String kind;

	public Worker(String kind) {
		this.kind = kind;
	}
	public void work() {
		System.out.println(kind+"이 일을 합니다.");
	}
	
}
class PoliceMan extends Worker{

	public PoliceMan() {
		super("경찰관");
	}
	//상속된 내용의 하위 클래스가 동일한 work()내용을 각각 다르게 재정의 해서 
	// 사용할 필요가 있다. 
	//=> overriding 
	public void work() {
		super.work(); //상위에 정의된 메서드 처리
		System.out.println("치안을 담당하다."); 
	}
}
class FireMan extends Worker{
	public FireMan() {
		super("소방관");
	}
	public void work() {
		super.work();
		System.out.println("불을 끄다");
	}
}
