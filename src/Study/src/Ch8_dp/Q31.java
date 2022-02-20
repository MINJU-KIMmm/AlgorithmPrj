package Ch8_dp;

import java.util.*;
import java.io.*;
public class Q31 {

	static int[][]arr;
	static int[][] dp;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Scanner sc=new Scanner(System.in);
		
		int T=Integer.parseInt(br.readLine());
		
		while(T-->0) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			
			arr=new int[n][m];
			dp=new int[n][m];
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			
			dp[0][0]=arr[0][0];
			dp[1][0]=arr[1][0];
			dp[2][0]=arr[2][0];
			
			
			for(int j=1;j<m;j++) {
				for(int i=0;i<n;i++) {
					if(i==0) {
						dp[i][j]=arr[i][j]+Math.max(dp[i][j-1], dp[i+1][j-1]);
					}
					else if(i==n-1) {
						dp[i][j]=arr[i][j]+Math.max(dp[i-1][j-1], dp[i][j-1]);
					}
					else {
						dp[i][j]=arr[i][j]+Math.max(dp[i][j-1], Math.max(dp[i+1][j-1], dp[i-1][j-1]));
					}
			
				}
			}
			
			int max=dp[0][m-1];
			for(int i=0;i<n;i++) {
				if(dp[i][m-1]>max) max=dp[i][m-1];
			}
			
			System.out.println(max);
		}
	}

}
