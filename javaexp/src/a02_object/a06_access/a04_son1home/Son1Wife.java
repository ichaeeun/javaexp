package a02_object.a06_access.a04_son1home;
import a02_object.a06_access.a03_woodhome.WoodCutter;
//상속관계 있지 않는 외부 클래스

public class Son1Wife {
	void callFather() {

		WoodCutter c1 = new WoodCutter();
//		System.out.println("private: "+c1.priv);  
		//다른 클래스 접근불가.
//		System.out.println("default: "+c1.familyPlan);
		//다른 패키지 접근불가. 
//		System.out.println("protected: "+c1.cacheInheritMoney);
		//상속관계가 아니므로 접근불가. 
		System.out.println("public: "+c1.weddingDate);
		//모든패키지에서 접근 가능. 
	}
}