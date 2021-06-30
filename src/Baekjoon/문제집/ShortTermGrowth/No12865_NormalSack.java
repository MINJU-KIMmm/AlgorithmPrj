//백준 12865 평범한 배낭
/*배낭문제
 * 1.짐을 쪼갤 수 있는 경우 Fraction knapsack Problem : 그리디
 * 2.짐을 쪼갤 수 없는 경우 0/1 Knapsack Problem : dp
 * 
 * 이 문제는 2번에 해당
 */
import java.util.*;

public class No12865_NormalSack {
	static Integer[][] dp;
	static int[] w;
	static int[] v;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		
		w=new int[n];
		v=new int[n];
		
		dp=new Integer[n][k+1];
		
		for(int i=0;i<n;i++) {
			w[i]=sc.nextInt();
			v[i]=sc.nextInt();
		}
		
		System.out.println(knapsack(n-1,k));
	}
	
	static int knapsack(int i, int k) {
		if(i<0) return 0;
		
		//아직 탐색 안 됨
		if(dp[i][k]==null) {
			//수용 가능 무게보다 무거운 경우(추가로 담지 못함)
			if(w[i]>k)
				dp[i][k]=knapsack(i-1, k);
			else 
				dp[i][k]=Math.max(knapsack(i-1, k-w[i])+v[i], knapsack(i-1, k));
		}
		return dp[i][k];
	}

}
