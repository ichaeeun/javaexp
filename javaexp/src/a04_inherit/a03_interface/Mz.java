package a04_inherit.a03_interface;

public class Mz {
	private String name;
	private Flyway flyway; 
	private AttackWay attackway;
	public Mz() {
		super();
		name = "마징가Z";
	} 
	//날개 실제 객체가 들어올수 있게 선언
	//Flyway flyway = new Wing01();
	public void setFlyway(Flyway flyway) {
		this.flyway = flyway;
	}
	
	public void setAttackway(AttackWay attackway) {
		this.attackway = attackway;
	}
	public void run() {
		System.out.println(name+" 뛰어다닌다");
	}
	public void attack() {
		System.out.println(name+" 공격을 한다. ");
		if(attackway!=null) {
			attackway.attack();
		}else {
			System.out.println("무기없음");
		}
	}
	public void fly() {
		//인터페이스에 setFlyway()에 의해 실제 객체가
		//할당 되었을때 
		if(flyway!=null) {
			System.out.print(name+" ");
			flyway.fly();
		}else {
			System.out.println(name+"에 날개가 아직 장착되지 않음");
		}
	}
}
