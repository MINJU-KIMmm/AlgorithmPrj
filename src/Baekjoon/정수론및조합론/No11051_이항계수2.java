package 정수론및조합론;

import java.util.*;
import java.io.*;

public class No11051_이항계수2 {

	static int[][] dp;
	static int div = 10007;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		
		int N=Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		dp=new int[N+1][K+1];
		
		System.out.println(answer(N,K));
	}

	static int answer(int n, int k) {
		if(dp[n][k]>0)
			return dp[n][k];
		
		if(k==0 || n==k)
			return dp[n][k]=1;
		
		return dp[n][k] = answer(n-1, k-1)+answer(n-1,k)%div;
	}
	
}
