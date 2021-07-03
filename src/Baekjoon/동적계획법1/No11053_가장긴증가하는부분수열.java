package 동적계획법1;

import java.util.Scanner;
public class No11053_가장긴증가하는부분수열 {

	static int[]A;
	static Integer[]dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		A=new int[N];
		dp=new Integer[N];
		
		for(int i=0;i<N;i++)
			A[i]=sc.nextInt();
		

		for(int i=0;i<N;i++)
			TotalLen(i);
		
		int max=dp[0];
		for(int i=1;i<N;i++)
			max=Math.max(max, dp[i]);
		
		System.out.println(max);
		
	}

	public static int TotalLen(int n) {
		if(dp[n]==null) {
			dp[n]=1;
			for(int i=0;i<=n-1;i++) {
				if(A[i]<A[n])
					dp[n]=Math.max(dp[n], TotalLen(i)+1);
			}
		}
		return dp[n];
	}
	
}
