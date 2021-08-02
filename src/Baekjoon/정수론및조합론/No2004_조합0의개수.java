package 정수론및조합론;

import java.util.Scanner;
public class No2004_조합0의개수 {

	static long[][] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		long n=sc.nextLong();
		long m=sc.nextLong();
		
		long cnt_five=five(n)-five(n-m)-five(m);
		long cnt_two=two(n)-two(n-m)-two(m);
		
		System.out.println(Math.min(cnt_five, cnt_two));
	}
	
	static long five(long n) {
		int cnt=0;
		while(n>=5) {
			cnt+=(n/5);
			n/=5;
		}
		
		return cnt;
	}
	
	static long two(long n) {
		int cnt=0;
		while(n>=2) {
			cnt+=n/2;
			n/=2;
		}
		
		return cnt;
	}
}
