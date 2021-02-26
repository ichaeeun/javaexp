package a02_object.a05_oneVsone;

public class A06_Buyer {
	String name;
	A05_Product prod;

	public A06_Buyer(String name) {
		super();
		this.name = name;
	}
	void showBuyInfo() {
		System.out.println("# "+name+"이 구매한 물건 #");
		if(prod!=null) { //구매한 물건 정보 표시. 
			System.out.println("구매한 물건이 있습니다.");
			prod.showProdInfo(); 
		}else {
			System.out.println("구매한 물건이 없습니다.");
		}
		
	}
}
