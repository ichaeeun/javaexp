package a05_exception;

import java.io.IOException;
import java.io.InputStream;

public class A03_Throws {
	
	/*
	 # 예외 위임
	 1. 위임을 할 경우
	 2. 자바에서 예외 위임은 메서드 단위로 위임된 곳에서 공통적으로 해당 예외를
		한번에 처리함으로써 코드의 재활용과 효율성을 유지할 수 있기 때문에 처리를 한다. 
		1) 메서드 단위로 동일한 예외를 다른 메서드의 호출과 함께 동시에 처리할 때,
			사용된다. 
		2) 동시에 처리하는 곳에서는 tryp{}catch(){}블럭을 이용해서 한꺼번에 
			예외를 처리할 수 있다. 
	 3. 기본형식. 
	 	1) public void 메서드명1()throws 예외클래스1, 예외클래스2...{
	 		발생할 가능성이 있는 예외 ==> 메서드명 옆에 throws 위임 처리 
	 		필수 컴파일 예외 ==> 메서드명 옆에 throws 위임 처리 
	 	}
	*/
	// findClass1(), findClass2(), findClass3() 메서드 안에서 발생하는 
	// ClassNotFoundException 예외를 각 메서드 마다 처리하는 것이 아니라 
	// 예외를 위임시켜, 해당 메서드가 호출되는 곳에 일괄적으로 처리되게 하였다. 
	
	public static void findClass1() throws ClassNotFoundException {
		//필수예외발생 
			Class cls = Class.forName("java.lang.String1");
		}
	public static void findClass2() throws ClassNotFoundException {
		//필수예외발생 
			Class cls = Class.forName("java.lang.String2");
		}
	public static void findClass3() throws ClassNotFoundException {
		//필수예외발생 
			Class cls = Class.forName("java.lang.String3");
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			findClass1(); 
			//static 메서드이고, main()를 포함하는 클래스이기 때문에 클래스명 없고,  
			//객체 생성없이 바로 사용 가능하다. 
			findClass2();
			findClass3(); //한번에 예외 처리 
			
			//호출하는 곳에서 한번에 예외를 처리한다. 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("예외발생: "+e.getMessage());
		}
		
		ExcepEx e = new ExcepEx();
		try {
			e.call1();
			e.call2();
			e.call3();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
		//e.getMessage(): 예외의 내용에 대하여 문자열로 가져온다. 
			System.out.println("예외발생(IOException): "+e1.getMessage());
		}catch(NullPointerException e1){
			System.out.println("예외발생(NullPointerException):"+e1.getMessage());
		}catch(Exception e1) {
			System.out.println("기타예외(Exception): "+e1.getMessage());
		}
		finally {
			System.out.println("예외처리완료");
		}
	}
}	
//연습예제  
class ExcepEx{
	//call1(), call2(), call3() 메서드를 선언하고, 
	// 아래와 같은 내용을 필수예외처리를 예외 위임에 의해 처리하고, 
	// main()에서 호출하여 처리하세요 
	public void call1() throws IOException {
		InputStream s = System.in;
		System.out.println("입력1: ");
		System.out.println((char)s.read());
		
	}
	public void call2() throws IOException,NullPointerException {
		String name = null;
		System.out.println(name.toString());
		InputStream s = System.in;
		System.out.println("입력2: ");
		System.out.println((char)s.read());
	}
	public void call3() throws IOException {
		InputStream s = System.in;
		System.out.println("입력3: ");
		System.out.println((char)s.read());
	}
}
