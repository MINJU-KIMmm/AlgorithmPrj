package Ch8_dp;

import java.io.*;
import java.util.*;
public class 실전4_바닥공사 {

	static int[] dp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		dp=new int[N+1];
		
		dp[1]=1;
		dp[2]=3;
		
		//i-1을 채우는 방법 1개 & i-2를 채우는 방법 2개 
		for(int i=3;i<=N;i++) {
			dp[i]=(dp[i-1]+2*dp[i-2])%796796;
		}
		
		System.out.println(dp[N]);
		
	}
	
	
}
