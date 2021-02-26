package a01_basic;

public class A03_PriData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 # 기본 데이터 타입
 1. byte 
 2. short 
 3. int : 정수형 default 데이터 유형 
 4. char : 문자형 데이터 'a', 저장은 정수형으로 되어 있다. 
 			unicode값에 의해서 문자를 불러온다. 
 			int와 type casting으로 문자와 숫자를 확인할 수 있다. 
 			==> char[]	 (문자배열) ==> String(데이터유형 추가)
 			ex) id,pass 분실시, 임시패스워드 발송시, 
 				숫자,문자 random => 알파벳 유니코드값 범위.
 				64(a) ~ (Z)
 5. long : 정수형에서 가장 큰 데이터 유형
 
 6. float : 실수형 데이터 유형 
 7. double : 실수형 default 데이터 유형
 8. boolean : true/false 로 데이터를 할당하는 데이터 유형 
 #
 */
		System.out.println("문자 unicode코드 번호");
		System.out.println("a: "+(int)'a');
		System.out.println("z: "+(int)'z');
		System.out.println("A: "+(int)'A');
		System.out.println("Z: "+(int)'Z');
		for(int cnt=1;cnt<=8;cnt++) {
			int ran = (int)(Math.random()*26+65);
			System.out.print((char)ran);
		}
		System.out.println();
		
		byte num01 = 25; // 1bit ==> 8bits => 1byte 
		short num02 = 50; 
		char ch01 = 'A';
		char ch02 = '안';
		// # 연산에서 java의 특징 
		//정수형/정수형==>정수형 4/3 ==> 1 
		//정수형/실수형==>실수형 	4/3.0 =>1.333...
		//실수형/정수형==>실수형 	4.0/3=>1.333...
		System.out.println("num01: "+num01);
		System.out.println("num02: "+num02);
		System.out.println("ch01: "+ch01);
		System.out.println("ch02: "+ch02);
		int ch02Num = ch02;
		System.out.println("문자에 대한 유니코드값: "+ch02Num);
		
		int num03 = 64;
		char ch03 = (char)num03;//코드에 맞는 문자를 확인
		System.out.println("64번 코드의 문자: "+ch03);
		// 정수형의 데이터 long 에 대한 할당
		long num04 = 90L; //90은 default int형이므로 L을 붙여서 long 식별하여 데이터할당.
		
		float num05 = 175.5F; //float 유형의 데이터를 할당할때는 F라고 구분하여 입력.
		
		System.out.println("실수형 num05:"+num05);
		
		double num06 = 3.1457;
		System.out.println("실수형 num06:"+num06);
		/*
		 ex) 기본 유형의 데이터를 이용해서, 국어, 영어, 수학의 점수와 총점과 평균값, 학점을 할당하여
		 		출력하세요 
		 */
		int kook = 80;
		int young = 70;
		int soo = 90;
		int sum = kook+young+soo;
		double avg = sum/3.0; //실수로 연산을 해야 정확한 실수값으로 처리가 된다.
		char grade;
		if(avg>=90)grade='A';
		else if(avg>=80)grade='B';
		else if(avg>=70)grade ='C';
		else grade = 'F';
		System.out.println("국어점수:"+kook);
		System.out.println("영어점수:"+young);
		System.out.println("수학점수:"+soo);
		System.out.println("총점:"+sum);
		System.out.println("평균:"+avg);
		System.out.println("학점:	"+grade);
		
	/*
	 # 형변환
	 1. 데이터의 유형의 작은 유형에서 큰 유형으로 변경이 일어나거나(할당,promote),
	 	큰 유형에서 작은유형으로 변경할 때 발생한다(할당, casting). 
	 */
		int num07 = 35;
		double num08 = num07; //promote
		System.out.println("promote가 일어난 데이터:"+num08);
		double num09 = 37.5;
		int num10 = (int) num09; //큰데이터 유형은 명시적으로 casting하지 않으면 
								 // 데이터를 사용할 수 없다.
		System.out.println("캐스팅한 데이터:"+num10);
	/*
	 ex) byte 유형으로 물건가격과 갯수를 선언하고,
	 	 int 유형으로 promote로 할당한 총계를 출력하세요
	 	 임의의 소숫점 1자리까지 있는 3명의 평균을 캐스팅하여 출력하세요
	 	 
	 */
		byte price = 100;
		byte cnt = 3;
		int total = price*cnt;
		System.out.println("총계:"+total);
		
		double num1 = (int)(Math.random()*1001)/10; //0<= Math.random() <1.0 *101
		double num2 = (int)(Math.random()*1001)/10;
		double num3 = (int)(Math.random()*1001)/10;
		System.out.println("점수1:"+num1);
		System.out.println("점수2:"+num2);
		System.out.println("점수3:"+num3);
		int avg2 = (int) ((num1+num2+num3)/3);
		
		System.out.println("평균:"+avg2);
	}
}
