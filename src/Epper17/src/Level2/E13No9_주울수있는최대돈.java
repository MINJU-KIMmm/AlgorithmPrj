package Level2;

import java.util.Scanner;

public class E13No9_주울수있는최대돈 {
	
	static int[] dp;
	public static int solution(int n, int[] M) {
		dp=new int[n];
		
		if(n>=1) dp[0]=M[0];
		if(n>=2) dp[1]=M[0]+M[1];
		if(n>=3) dp[2]=M[2]+Math.max(M[0], M[1]);
		
		for(int i=3;i<n;i++) {
			dp[i]=Math.max(dp[i-1], Math.max(M[i]+M[i-1]+dp[i-3], M[i]+dp[i-2]));
		}
		
		return dp[n-1];
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] M = new int[n];

		for (int i = 0; i < n; i++) {
			M[i] = sc.nextInt();
		}
		int ans = solution(n, M);
		System.out.println(ans);
	}
}
