package a02_object.a05_oneVsone;

public class A09_Robot {
	String kind;
	A10_Weapon weapon;
	public A09_Robot(String kind) {
		super();
		this.kind = kind;
	}
	//1:1 관계에서 메서드를 통해서 할당  
	//
	//메서드에 의해서 장착 처리 
	void setWeapon(A10_Weapon weapon) {//A10_Weapon weapon= new A10_Weapon("니킥",80)
		this.weapon = weapon;	//전역필드에 있는 A10_Weapon weapon 에 할당처리 
	}
	
	/*
	 main() 
	 	A09_Robot r1 = new A09_Robot("로봇1");
	 	// 로봇객체가 생성이 되고, field kind에 문자열 "로봇1" 할당. 
	 	r1.attack();//할당되지 않는 결과가 나온다. 
	 	
	 		if(weapon!=null){ //heap메모리가 할당되었을때. 
	 						    //null 없이 객체의 메서드를 사용하면 
	 							A10_Weapon weapon;에 객체가 할당되지 않았기 때문에
	 							NullPointerException이 발생. 
	 							
	 	 
	 	  		}else{ // heap 메모리에 할당되지 않았을 때. 
	 	  		
	 	  		}
	 	r1.setWeapon(new A10_weapon("니킥",80));
	 
	 	
	 */
	
	void attack() {
		System.out.println(kind+" 공격!!!");
		if(weapon!=null) {
			System.out.println("무기로 공격!!!");
			weapon.show();
		}else {
			//무기가 할당되지 않음.
			//void setWeapon(A10_Weapon weapon)를 통해서,
			//객체가 할당되지 않는 경우
			//조건문이 없으면 할당되지 않을경우도 weapon.show()
			//가 호출되기 때문에 NullPointerException발생 
			System.out.println("무기가없다...");
		}
	}
}
