package a04_inherit.a02_abstract;

import a04_inherit.a01_basic.Father2;

public class Son2 extends Father2{
/*
 String charac="성격이 원만하다";
	private int age =25;
	protected String favFood ="짜장면";
	public String announce = "자랑";

 */
	public void callMember() {
	//	System.out.println(age);	//private 접근불가
	//	System.out.println(charac); //default 같은패키지만. 
		System.out.println(favFood);//상속관계 있는 다른패키지도 가능. 
		System.out.println(announce);//모두 다 가능
	}
}
