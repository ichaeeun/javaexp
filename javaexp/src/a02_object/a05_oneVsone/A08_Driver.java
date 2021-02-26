package a02_object.a05_oneVsone;
/*
#1:1 관계 설정 연습
1. Car 필드: 자동차명, 최고속도, 메서드: showInfo() 
2. Driver 필드: 이름, Car 
	메서드 divingCar() @@가 차가 없다.
					 @@가 @@차를 최고속도 @@키로 주행.
*/
public class A08_Driver {
	String name;
	A07_Car car;
	A08_Driver(String name){
		this.name = name;
	}
	void drivingCar() {
		if(car==null) {
			System.out.println(name+"은 차가없다. ");
			
		}else {
			System.out.println(name+"주행");
			car.showInfo();
		}
	}
}
