package 정수론및조합론;

import java.util.Scanner;
public class No1676_팩토리얼0의개수 {
	
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		System.out.println(solution(n));
	}
	
	public static int solution(int n) {
		int cnt=0;
		if(n==0)
			return cnt;
		
		for(int i=2;i<=n;i++) {
			if(i%5==0) cnt++;
			if(i%25==0) cnt++;
			if(i%125==0) cnt++;
		}
		
		return cnt;
	}
}
