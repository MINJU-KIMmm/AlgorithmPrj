
import java.util.Arrays;
import java.util.Scanner;
public class minSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[]x=new int[n];
		for(int i=0;i<n;i++) {
			x[i]=sc.nextInt();
		}
		
		System.out.printf("%.6f",solution(x));
	}
	
	static double solution(int[]x) {
		//Arrays.sort(x);
		int n=x.length;
		int tmp=0;
		for(int i=0;i<n-1;i++) {
			for(int j=1;j<n;j++) {
				if(x[i]>x[j]) {
					tmp=x[i];
					x[i]=x[j];
					x[j]=tmp;
				}
			}
		}
		double sum=x[0]+x[1];
		sum/=2;
		for(int i=2;i<x.length;i++) {
			sum+=x[i];
			sum/=2;
		}
		
		return sum;
	}

}
