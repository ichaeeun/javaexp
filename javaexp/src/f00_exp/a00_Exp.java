package f00_exp;
import java.util.Arrays;

public class a00_Exp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] iArr = {1,2,3,4,5,6};
		System.out.println(Arrays.toString(iArr));
		int max=iArr[0];
		int min=iArr[0];
		for(int i=0;i<iArr.length;i++) {
			if(iArr[i]>max) {
				max = iArr[i];
			}else if(iArr[i]<min) {
				min =iArr[i];
			}
		}
		System.out.println("최댓값:"+max);
		System.out.println("최솟값:"+min);
		for(int i =0;i<100;i++) {
			int n = (int)(Math.random()*6);
			int tmp =iArr[0];
			iArr[0]=iArr[n];
			iArr[n]=tmp;
		}
		System.out.println(Arrays.toString(iArr));
		
		System.out.println("매개변수의 갯수:"+args.length);
		for(int i =0;i<args.length;i++) {
			System.out.println("args["+i+"]: "+args[i]);
		}
	}

}
