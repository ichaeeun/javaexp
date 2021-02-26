package a02_object.a07_oneVsmulti;

public class Product {
	//1. field명은 일반적으로 접근제어자가 private로 설정된다. 
	//   직접적으로 설정하지 않고, 특별한 루트(메서드)를 통해서 저장하고 호출함. 
	private String name; 
	private int price;
	private int cnt;
	
	//2. 생성자는 외부에서 사용하기 때문에 public으로 사용된다. 
	public Product(String name, int price, int cnt) {
		super();
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}
	//3. 각각의 field에 입력할 데이터 setXXX, 
	//	 각각의 field에 있는 데이터를 가져오는 멤서드 getXXX
	//	 로 설정해서 처리한다. 
	//   간접적으로 필드에 있는 데이터를 저장하고, 호출해주는 메서드를 구현
	//	 각 메서드의 접근제어자가 public이기 때문에 
	//	 외부 패키지 에서도 접근하여 처리할 수 있다. 
	
	public String getName() { //메서드를 통해서 호출 
		return name;
	}

	public void setName(String name) { //메서드를 통해서 저장 
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
}
