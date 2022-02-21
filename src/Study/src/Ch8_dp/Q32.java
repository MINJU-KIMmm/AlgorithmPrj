package Ch8_dp;

import java.io.*;
import java.util.*;
public class Q32 {
	
	static int[][] arr;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		
		arr=new int[n][n];
		dp=new int[n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<i+1;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<n;i++) {
			dp[n-1][i]=arr[n-1][i];
		}
		
		for(int i=n-2;i>=0;i--) {
			for(int j=0;j<=i;j++) {
//				if(j==i) dp[i][j]=arr[i][j]+dp[i+1][j];
				dp[i][j]=Math.max(dp[i+1][j],dp[i+1][j+1])+arr[i][j];
			}
		}
		
		System.out.println(dp[0][0]);
	}
}
