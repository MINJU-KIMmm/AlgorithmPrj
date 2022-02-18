package Ch8_dp;
import java.util.*;
import java.io.*;
public class 실전2_1로만들기 {

	static int[] dp=new int[30001];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		
		for(int i=2;i<=x;i++) {
			dp[i]=dp[i-1]+1;

			if(i%5==0) dp[i]=Math.min(dp[i/5]+1, dp[i]);
			if(i%3==0) dp[i]=Math.min(dp[i/3]+1, dp[i]);
			if(i%2==0) dp[i]=Math.min(dp[i/2]+1, dp[i]);
		}
		
		System.out.println(dp[x]);
	}
	
}
