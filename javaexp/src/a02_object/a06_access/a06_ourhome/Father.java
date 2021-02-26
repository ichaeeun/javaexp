package a02_object.a06_access.a06_ourhome;

import a02_object.a06_access.a05_grandhome.GrandFather;


public class Father extends GrandFather {
	void callGrandFather() {
		System.out.println("protected: "+earnMoney);
	}
}
