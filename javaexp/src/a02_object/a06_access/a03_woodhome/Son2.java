package a02_object.a06_access.a03_woodhome;

public class Son2 extends WoodCutter{
	
	void callFather() {
//		상속해주는 WoodCutter객체의 필드에 대한 접근
//		 1. 상속이란? 상위 있는 멤버(필드,생성자,메서드)를 그대로 
//		 접근제어자 범위 한계 내에서 사용할 수 있는 의미이다. 
//		System.out.println("private: "+priv);  
		//접근제어자 private 로 설정되어 있기 때문에 상속하더라도 접근 불가. 
		System.out.println("default: "+familyPlan);
		System.out.println("protected: "+cacheInheritMoney);
		// 상속관계 있는 클래스 접근 가능. 
		System.out.println("public: "+weddingDate);
	}
}
