package a05_exception;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class A01_Exception {
/*
 # 예외(Exception)?
 1. 사용자의 잘못된 조작 또는 개발자의 잘못된 코딩으로 인한 오류를 발생하는 것을
	말한다. 
	==> error나 예외(Exception) 
 2.	예외처리: 에러가 발생하는 것에 대하여 자바에 있는 api로 정상작동으로 안정성을
 			확보하는 것  
 	==> java내부에 있는 api로 에러나 오류를 보완하는 개념 
 3. java는 이러한 예외에 대하여, 예외를 처리함으로써 프로그램의 안정성과 
 	신뢰성을 확보하고자 한다. 
 	1) 기본 예외 처리 - 개발자의 코딩에 의한 예외 처리. 
 		예외 발생 가능성이 있어, api에 있는 예외 클래스를 적용하여 처리 
 	2) 필수 예외 처리 - 자바프로그램에서 너무나 자주 발생하는 내용이라, 
 					 반드시 예외처리를 하지 않으면 컴파일 자체가 되지 않게 
 					 처리해놓은 것을 말한다. 
 		ex) IO(데이터의 input/output 가 일어나거나, 파일전송, 네트웍을 통한 데이터 처리)
 			기타 클래스 메모리 로딩 처리 시 등등.. 
 			ex) Scanner: 내부적으로 지원처리.. 
 				InputStream in = System.in;
 				in.read(); //필수예외처리 해줘야함. 
 4. 예외처리 기본 형식
 	Exception : 모든 예외 처리의 상위 api 클래스 
 	try{
 		예외가 발생할 가능성 있는 코드(기본예외/필수예외)
 		1. 
 		2. 예외가 발생하면 명시적으로 코딩하지 않더라도 catch문에 있는 
 			매개 객체(Exception)를 던진다. 
 			던지는 순간, 이 다음 라인은 수행되지 않는다. throw 예외 
 		3. 
 		4. 
 	}catch(Exception e){
 		예외가 발생하면 매개변수에 의해서 예외를 받아, 
 		Exception하위에 있는 메서드로 처리하든지, 
 		예외가 발생했을 때 처리할 코드 기술 ...
 	}finally{
 		//예외가 발생해도, 발생하지 않아도 처리해야할 코드 
 	}
 5. 예외 처리 코딩 프로세스(사용자 정의 예외 처리- 실행시, 결과에 의해 발생하는 예외)  
 	1) 코드 수행
 	2) 강제로 예외가 나올 수 밖에 없는 코드 기입 
 		- 에러가 날 수 있는 코드 실행 
 	3) 에러에서 예외 Exception클래스를 copy 
 		- 실행에 의해서 나타난 에러 내용 카피 
 	4) 위에 기본 예외 처리 block으로 처리 
 		try{
 		
 		}catch(실행결과카피한예외 e){
 		
 		} 
 
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		
		InputStream in = System.in;
	//	in.read(); //예외처리하지 않으면 컴파일 에러발생 
		try {
			in.read();  //Stream에 의해 입력을 처리하는 메서드 호출..IO발생(필수예외처리)
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		
		
		try {
		System.out.println("수행1");
		System.out.println("수행2");
		System.out.println("수행: "+1/0);
		System.out.println("수행3");
		
		}catch(ArithmeticException ae) {
			System.out.println("예외발생:"+ae.getMessage());
		}finally {
			System.out.println("예외상관없이수행");
		}
		System.out.println("수행4");
		System.out.println("수행5");
		
		//ex) 아래 내용으로 예외를 확인하고, try{}catch문으로 예외를 처리하세요 
		String name = null;
		try {
		System.out.println(name.toString());
		}catch(NullPointerException ne) {
			System.out.println(ne.getMessage());
		}finally{
			System.out.println("예외발생상관없이수행");
		}
		
		
	}
}
