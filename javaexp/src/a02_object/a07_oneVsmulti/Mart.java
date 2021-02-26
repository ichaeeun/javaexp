package a02_object.a07_oneVsmulti;

import java.util.ArrayList;

public class Mart {
	private String name;
	// # 1:다중의 데이터를 설정하는 방법
	// 1) 배열로 설정
	private Product[] pArray;
	// 2) ArrayList<객체> list
	private ArrayList<Product> plist;

	// 생성자를 통해서는 마트이름 설정
	public Mart(String name) {
		super();
		this.name = name;
		//물건을 하나씩 담는 처리 
		//1. 생성자 객체 ArrayList 선언 
		plist = new ArrayList<Product>();
	}
	public void buy(Product p) {
		plist.add(p); //하나씩 물건담기 
	}
	

	public Product[] getpArray() {
		return pArray;
	}

	public void setpArray(Product[] pArray) {
		this.pArray = pArray;
	}

	public ArrayList<Product> getPlist() {
		return plist;
	}

	public void setPlist(ArrayList<Product> plist) {
		this.plist = plist;
	}

	public void buyList() {
		System.out.println("# " + name + " 마트에서 구매한 물건<ArrayList> #");

		if (plist != null) {// ArrayList로 객체가 할당 되었을 때
			int tot = 0;
			for (Product p : plist) {
				System.out.print(p.getName() + "\t");
				System.out.print(p.getPrice() + "\t");
				System.out.print(p.getCnt() + "\n");
				tot += p.getPrice() * p.getCnt();
			}
			System.out.println("총 비용: "+ tot);
		}else {
			System.out.println("구매한 물건이 없습니다.");
		}
	}

	public void buyArray() {
		System.out.println("# " + name + " 마트에서 구매한 물건(배열) #");

		if (pArray != null) { // 배열로 객체가 할당 되었을 때
			for (Product p : pArray) {
				System.out.print(p.getName() + "\t");
				System.out.print(p.getPrice() + "\t");
				System.out.print(p.getCnt() + "\n");
			}
		}
	}
}
