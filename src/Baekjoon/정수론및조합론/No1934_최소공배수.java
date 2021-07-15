package 정수론및조합론;

import java.util.Scanner;
public class No1934_최소공배수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int i=0;i<T;i++) {
			int A=sc.nextInt();
			int B=sc.nextInt();
			
			int gcd= gcd(A, B);
			
			System.out.println((A*B)/gcd);
		}
	}
	
	public static int gcd(int a, int b) {
		if(b==0) return a;
		else return gcd(b, a%b);
	}

}
