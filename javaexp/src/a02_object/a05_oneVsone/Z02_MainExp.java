package a02_object.a05_oneVsone;

public class Z02_MainExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 # 객체를 메서드의 매개변수로 할당하여 사용하기
 1. 클래스 내에 객체나 변수는 일반적으로 보안적인 문제와 코드의 안정성 때문에
 	접근제어자를 이용하여 접근이 가능한 방법(메서드)으로만 처리를 한다. 
 2. 객체는 일반적으로 메서드의 매개변수로 할당을 한다. 
 3. 형식 
 	1) 클래스 선언 
 	2) 메서드의 매개변수를 통해서 할당 처리 
 		class Robot{
 			String kind;
 			Weapon wp;
 			void setWeapon(Weapon wp){
 				this.wp = wp;
 			}
 			void setKind(String kind){
 				this.kind = kind;
 			}
 		}
 		class Weapon{
 			String name; 
 			int attackPt;
 		}
 	main()
 		Robot rb1 = new Robot("MZ");
 		rb1.wp = new Weapon("로켓포",80); // (X)
 		//바로 할당하는 것보다는 기능 메서드를 통해서 할당하고, 
 		//기능메서드를 통해서 호출한다. 
 		rb1.setWeapon(new Weapon("레이저빔",95));
 		rb1.setKind("다간");
 */
		A09_Robot r1 = new A09_Robot("MZ");
		r1.attack();
		r1.setWeapon(new A10_Weapon("로켓포",80));
		r1.attack();
		//A09_Robot의 필드에 변경해서 처리. 
		/*
		 A09_Robot 안에 있는 필드의
		 	kind도 메서드에 의해 변경이 되면 다음 데이터가 할당 되듯이
		 	weapon도 변경된다. 
		 */
		r1.setWeapon(new A10_Weapon("레이저빔",80));
		r1.attack();
	}
}
