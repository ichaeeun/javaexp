package a02_object.a04_methodExp;

/*
필드: id, pass, name, point
생성자: 필드값 할당
기능메서드1: 회원정보변경.. 매개변수3
			id, pass, name 변경
			변경된 내용 출력
기능메서드2: 패스워드변경 매개변수1
		변경된 패스워드 내용 출력
기능메서드3: 포인트 추가(매개변수 만큼 포인트 추가)
		추가된 포인트:@@
		현재 포인트:@@
기능메서드4: 구매처리(구매할 물건, 차감할 point 매개변수)
	@@를 @@point 에 구매하여 현재포인트 @@
	return 차감후 포인트 
 */
class Member {
	String id;
	String pass;
	String name;
	int point;
	String product;

	Member(String id, String pass, String name, int point) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.point = point;
	}

	void changeInfo(String id, String pass, String name) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		System.out.println("# 회원정보변경 #");
		System.out.println("ID: " + this.id);
		System.out.println("PASSWORD: " + this.pass);
		System.out.println("이름: " + this.name);
	}

	void changePass(String pass) {
		this.pass = pass;
		System.out.println("# 패스워드변경 #");
		System.out.println("PASSWORD: " + pass);
	}

	void plusPoint(int point) {
		this.point += point;
		System.out.println("# 포인트 추가 #");
		System.out.println("추가된 포인트: " + point);
		System.out.println("현재 포인트: " + this.point);
	}

	int buy(int point, String product) {
		System.out.println("# 구매정보 #");
		if (this.point < point) {
			System.out.println("point가 부족합니다. " + product + " 구매실패");
		} else {
			this.point -= point;
			System.out.println(product + "를 " + point + "에 구매하여 현재포인트: " + this.point);
		}
		return this.point;
	}
}

public class A01_MethodExp {
	public static void main(String[] args) {
		Member m = new Member("chaenee", "1234", "이채은", 3000);
		m.changeInfo("pi", "5678", "이파이");
		m.changePass("12345678");
		m.plusPoint(2000);
		System.out.println("포인트잔액: " + m.buy(3000, "과자"));
		System.out.println("포인트잔액: " + m.buy(5000, "아이스크림"));
		m.plusPoint(5000);
		System.out.println("포인트잔액: " + m.buy(5000, "아이스크림"));

	}
}
