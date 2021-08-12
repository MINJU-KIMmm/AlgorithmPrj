package 동적계획법1;

import java.util.Scanner;
import java.io.*;

public class No2156_포도주시식 {

	static int[] dp;
	static int[] value;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		dp=new int[n];
		value=new int[n];
		
		for(int i=0;i<n;i++) {
			value[i]=Integer.parseInt(br.readLine());
		}
		
		if(n>=1)
			dp[0]=value[0];
		if(n>=2)
			dp[1]=value[0]+value[1];
		if(n>=3) {
			dp[2]=Math.max(Math.max(dp[1], value[0]+value[2]), value[1]+value[2]);
		}
		
		for(int i=3;i<n;i++) {
			dp[i]=Math.max(dp[i-3]+value[i-1]+value[i], Math.max(dp[i-1],dp[i-2]+value[i]));
		}
		System.out.println(dp[n-1]);
	}
	

}
