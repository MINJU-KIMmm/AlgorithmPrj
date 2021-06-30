package 동적계획법1;
import java.util.*;
public class No1149_RGB거리 {

	static int[][]dp;
	static int[][]cost;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		
		dp=new int[N][3];
		cost=new int[N][3];
		for(int i=0;i<N;i++) {
			cost[i][0]=sc.nextInt();
			cost[i][1]=sc.nextInt();
			cost[i][2]=sc.nextInt();
		}
		
		dp[0][0]=cost[0][0];
		dp[0][1]=cost[0][1];
		dp[0][2]=cost[0][2];
		
		System.out.println(Math.min(CalcCost(N-1, 0), Math.min(CalcCost(N-1,1), CalcCost(N-1,2))));
		
	}

	public static int CalcCost(int N, int c) {
		if(dp[N][c]==0) {
			if(c==0)
				dp[N][0]=Math.min(CalcCost(N-1,1), CalcCost(N-1, 2))+cost[N][0];
			else if(c==1)
				dp[N][1]=Math.min(CalcCost(N-1,0), CalcCost(N-1, 2))+cost[N][1];
			else
				dp[N][2]=Math.min(CalcCost(N-1, 0), CalcCost(N-1, 1))+cost[N][2];
		}
		
		return dp[N][c];
	}
}
