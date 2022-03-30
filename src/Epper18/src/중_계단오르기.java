import java.util.*;
public class 중_계단오르기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	static int[]dp=new int[301];
	public static int solution(int n, int[] score) {
		dp[1]=score[1];
		dp[2]=score[2];
		
		for(int i=3;i<n+1;i++) {
			dp[i]=Math.max(dp[i-2]+score[i], score[i-1]+score[i]+dp[i-3]);
		}
		
		return dp[n];
	}
}
