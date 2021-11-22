package 동적계획법1;

import java.util.*;
import java.io.*;
public class No1003_피보나치함수 {
	static Integer[][] dp =new Integer[41][2]; // N이 40이하의 자연수 , 0혹은1 -> [41][2]
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		dp[0][0]=1;
		dp[0][1]=0;
		dp[1][0]=0;
		dp[1][1]=1;
		
		StringBuilder sb=new StringBuilder();
		while(T-->0) {
			int N=Integer.parseInt(br.readLine());
			fib(N);
			sb.append(dp[N][0]+" "+dp[N][1]).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static Integer[] fib(int N) {
		if(dp[N][0]==null||dp[N][1]==null) {
			dp[N][0]=fib(N-1)[0]+fib(N-2)[0];
			dp[N][1]=fib(N-1)[1]+fib(N-2)[1];
		}
		
		return dp[N];
	}
}
