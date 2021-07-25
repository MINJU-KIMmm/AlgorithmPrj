package 정수론및조합론;

import java.util.Scanner;
public class No1010_다리놓기 {
	
	static int[][]dp=new int[30][30];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0;i<T;i++) {
			int n=sc.nextInt();
			int m=sc.nextInt();
			
			System.out.println(solution(m,n));
		}
		
	}
	
	static int solution(int n, int r) {
		if(dp[n][r]>0)
			return dp[n][r];
		if(n==r||r==0)
			return dp[n][r]=1;
		
		return solution(n-1, r-1)+solution(n-1, r);
	}

}
