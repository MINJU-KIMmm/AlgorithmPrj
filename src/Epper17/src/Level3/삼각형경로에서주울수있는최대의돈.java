package Level3;

import java.util.*;
public class 삼각형경로에서주울수있는최대의돈 {
	
	static long arr[][];
	static long dp[][];
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		arr=new long[N][N];
		dp=new long[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<=i;j++) {
				arr[i][j]=sc.nextLong();
			}
		}
		
		for(int i=0;i<N;i++) {
			dp[N-1][i]=arr[N-1][i];
		}
		
		System.out.println(solution(0, 0));
	}
	
	static long solution(int i, int j) {
		if(i==N-1) return dp[i][j];
		
		if(dp[i][j]==0) {
			dp[i][j]=Math.max(solution(i+1, j+1), solution(i+1, j))+arr[i][j];
		}
		
		return dp[i][j];
	}

}
