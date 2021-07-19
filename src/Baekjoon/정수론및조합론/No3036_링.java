package 정수론및조합론;

import java.util.Scanner;
public class No3036_링 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		
		int first=sc.nextInt();
		int[] arr=new int[N];
		for(int i=1;i<N;i++)
			arr[i]=sc.nextInt();
		
		for(int i=1;i<N;i++) {
			int gcd=gcd(first, arr[i]);
			System.out.println(first/gcd + "/" + arr[i]/gcd);
		}
	}

	static int gcd(int a, int b) {
		if(b==0) return a;
		else return gcd(b, a%b);
	}
}
