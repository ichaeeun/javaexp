package a02_object.a06_access.a02_acc_friendship;

public class Deer {
	
	void callWoodCutter() {
		WoodCutter w1 = new WoodCutter();
//		System.out.println(w1.cacheDress);// private 
		System.out.println("사슴이 숨은곳:"+w1.cacheDeer);//default 
		System.out.println("결혼날짜: "+w1.weddingDate);
		//접근이 가능하다는 말은 외부 다른 객체에 해당 멤버를 
		//참조변수.멤버 : 호출하는 것이 가능한지 여부. 
	}
}
