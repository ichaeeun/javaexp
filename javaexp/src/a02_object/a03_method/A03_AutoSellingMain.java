package a02_object.a03_method;

import java.util.Scanner;

public class A03_AutoSellingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AutoSellingMachine am = new AutoSellingMachine();
		am.inputMoney(1000);
		am.inputMoney(500);
		am.inputMoney(1000);
		am.showMenu();
		String bev=am.choiceButton(2);
		System.out.println("자판기를 통해 나온 음료: "+bev);
		System.out.println("자판기를 통해 나온 음료: "+am.choiceButton(3));
		
		
/*
 ex)Mart클래스 
 	1) 메서드1 showProduct() 마트에서 판매하는 물건 
 		1.컵라면 2.음료 3.제과 
 	2) 메서드2 buy() 선택한 물건 번호로 선택 return 값으로 선택한 물건이 
 		나오게 처리  
 */
		System.out.println("------예제------");
		Mart m = new Mart();
		m.showProduct();
		System.out.println("선택한물건:"+m.buy(1));
		System.out.println("번호를 입력하세요.");
		System.out.println("선택한물건: "+m.buy2());
	}
}
class Mart{
	void showProduct(){
		System.out.println("# 마트에서 파는 물건 #");
		System.out.println("1. 컵라면");
		System.out.println("2. 음료");
		System.out.println("3. 제과");
	}
	
	String buy2() {
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt()	;
		if(input==1) return "컵라면";
		else if(input==2) return "음료";
		else if(input==3) return "제과";
		else return "다시 입력하세요.";
	}
	String buy(int product) {
		String chMenu="";
		if(product==1)
			chMenu= "컵라면";
		else if (product==2)
			chMenu= "음료";
		else if(product==3)
			chMenu= "제과";
		else 
			chMenu= "없음";
		return chMenu;
	}
}
