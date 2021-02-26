package a05_exception;

public class A02_Hierarchy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 #	예외의 계층 구조
 1. 예외는 Exception을 최상위로 하여, 상속받는 하위의 여러가지 예외클래스로
 	계층구조화 될 수 있다. 예외에 대한 메모리 처리를 효과적으로 하기 위하여 
 	계층화 한다. 
 2. 이런 계층 구조화된 예외는 
 	try{
 		
 	}catch(최하위예외){
 	
 	}catch(하위 예외){
 	
 	}catch(상위 예외){
 	
 	}//형식으로 계층화된 예외를 처리하여야 한다. 
 	F11: 디버그 모드 
 	ctrl + f11: 실행모드 
 	
 */
		System.out.println(" # 입력한 과일 #");
		try {
			for(int idx=0;idx<3;idx++) {
				System.out.println(idx+1+"번째 과일"+args[idx]);
			}
			System.out.println(4/0);
		}catch(ArrayIndexOutOfBoundsException e) {//하위 예외 
			System.out.println("예외 처리1: "+e.getMessage());
		}catch(Exception e) {//상위 예외 
			System.out.println("예외처리2: "+e.getMessage());
		}finally {
			System.out.println("예외상관없이수행");
		}
		
		
	}
}
