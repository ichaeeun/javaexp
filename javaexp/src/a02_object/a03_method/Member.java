package a02_object.a03_method;

public class Member {
	//필드 선언 

	String id;
	String pass;
	String name;
    String auth;
	int point;
	
	//생성자 선언
	Member(String id, String pass, String name){
		this.id = id;
		this.pass = pass;
		this.name = name;
	}
	
	//출력을 처리하는 기능메서드
	void showInfo() {
		System.out.println("# 회원정보 #");
		System.out.println("아이디: "+id);
		System.out.println("패스워드: "+ pass);
		System.out.println("이름: "+name);
	}
	/*
	 # 메서드란? 
	 1. 객체의 구성요소로, 객체가 필요로 하는 기능처리를 위해서 사용한다.
	 2. 기능처리란?
	 	1) 데이터를 저장처리(매개변수로 받아 필드값에 저장처리)
	 	2) 특정한 데이터를 조건이나 반복에 의해서 return해준다. 
	 	3) 출력처리(현재 가지고 있는 데이터에 대한 화면표시) 
	 	ex) 자판기에서 돈을 입력하고, 화면에 입력된 돈을 표기, 
	 		선택한 버튼에 의해서 음료와 나머지 돈이 나온다. 
	 */
	//1. 데이터를 저장하는 메서드 선언
	void setId(String id) {
		//외부에서 id값을 문자열로 입력하면 입력된 id가 
		//필드에 할당된다. 
		this.id=id;
	}
	// 두개의 값을 받아서 저장하는 메서드 처리
	void setIdPass(String id, String pass) {
		this.id= id;
		this.pass=pass;
	}
	// name을 저장해주는 메서드  
	void setName(String name) {
		this.name = name;
	}
	
	void setAuth(String auth) {
		this.auth = auth;
	}
	//매개변수를 통해서 필드값의 저장을 처리 
	void setAuthPoint(String auth, int point) {
		this.auth = auth;
		this.point = point;
	}
	//ex1) name값을 저장하는 메서드를 선언하고 변경된 name을 출력하세요.
	//ex2) 필드로 auth(권한)을 추가하여, 메서드로 auth권한을 변경하는 처리
	//ex3) 필드 point(정수)를 추가하여, auth와 point를 같이 변경할수있게 처리 

}
