package 동적계획법1;

import java.util.*;
public class No9461_파도반수열 {
	
	static long[] dp=new long[101];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		while(T-->0) {
			
			dp[0]=1L;
			dp[1]=1L;
			dp[2]=1L;
			dp[3]=2L;
			dp[4]=2L;
			dp[5]=3L;
			dp[6]=4L;
			dp[7]=5L;
			dp[8]=7L;
			dp[9]=9L;
			
			int n=sc.nextInt();
			for(int i=10;i<dp.length;i++) {
				dp[i]=-1L;
			}
			System.out.println(solution(n-1));
		}
	}
	
	static long solution(int n) {
		if(dp[n]==-1)dp[n]=solution(n-5)+solution(n-1);
		
		return dp[n];
	}

}
