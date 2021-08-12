package 동적계획법1;
import java.util.*;
public class No2579_계단오르기 {
	
	static Integer[] dp;
	static int N;
	static int[] value;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		dp=new Integer[N+1];
		value=new int[N+1];
		
		for(int i=1;i<=N;i++)
			value[i]=sc.nextInt();
		dp[0]=0;
		
		dp[1]=value[1];
		if(N>=2) {
			dp[2]=value[1]+value[2];
		}
		System.out.println(CalcMax(N));
	}
	
	public static int CalcMax(int n) {
		if(dp[n]==null) {
			dp[n]=Math.max(CalcMax(n-2), CalcMax(n-3)+value[n-1])+value[n];
		}
		
		return dp[n];
	}
}
