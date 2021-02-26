package a02_object.a06_access;
import a02_object.a06_access.a02_acc_friendship.*;
public class Hunter {
	
	void whereDeer() {
		WoodCutter w = new WoodCutter();
		//public class WoodCutter 이고, 
		//default 생성자 이기에 객체생성까지는 가능. 
//		System.out.println(w.cacheDeer); // default 
//		System.out.println(w.cacheDress); // private
		System.out.println(w.weddingDate); //public 
		
	}
}
