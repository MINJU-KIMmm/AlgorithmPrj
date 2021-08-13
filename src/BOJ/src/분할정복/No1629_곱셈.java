package 분할정복;

import java.util.Scanner;
public class No1629_곱셈 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		long a=sc.nextLong();
		long b=sc.nextLong();
		long c=sc.nextLong();
		
		System.out.println(solution(a,b,c));
	}
	
	//모듈러 법칙 = (a*b)%c = (a%c*b%c)%c
	static long solution(long a, long b, long c) {
		if(b==1)
			return a%c;
		
		long half=solution(a, b/2, c);
		if(b%2==0) {
			return half*half%c;
		}else {
			return (half*half%c)*a%c;
		}
	}
}
