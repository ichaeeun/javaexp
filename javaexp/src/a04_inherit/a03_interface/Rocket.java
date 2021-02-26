package a04_inherit.a03_interface;

public class Rocket implements AttackWay{

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("로켓포공격");
	}
	
}
class Missile implements AttackWay{
	public void attack() {
		System.out.println("미사일 공격");
	}
}