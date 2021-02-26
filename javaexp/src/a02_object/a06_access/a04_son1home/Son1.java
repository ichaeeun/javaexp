package a02_object.a06_access.a04_son1home;
import a02_object.a06_access.a03_woodhome.WoodCutter;
//다른 package에 있는 상속관계 있는 클래스 
public class Son1 extends WoodCutter{
	void callFather() {

//		System.out.println("private: "+priv);  
		
//		System.out.println("default: "+familyPlan);
		//default 다른패키지에서 접근 불가. 
		System.out.println("protected: "+cacheInheritMoney);
		// 다른 패키지라도 상속관계 있는 클래스 접근 가능. 
		System.out.println("public: "+weddingDate);
	}
}
