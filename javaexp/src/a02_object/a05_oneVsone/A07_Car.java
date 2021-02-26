package a02_object.a05_oneVsone;
/*
#1:1 관계 설정 연습
1. Car 필드: 자동차명, 최고속도, 메서드: showInfo() 
2. Driver 필드: 이름, Car 
	메서드 divingCar() @@가 차가 없다.
					 @@가 @@차를 최고속도 @@키로 주행.
*/
public class A07_Car {
	String carName;
	int maxSpeed;
	A07_Car(String carName, int maxSpeed){
		this.carName=carName;
		this.maxSpeed=maxSpeed;
	}
	void showInfo(){
		System.out.println("자동차명: "+carName);
		System.out.println("최고속도: "+maxSpeed);
	}
}
