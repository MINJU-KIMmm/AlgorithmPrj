package 동적계획법2;

import java.util.*;
import java.io.*;
public class No11066_파일합치기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		while(T-->0) {
			int K=sc.nextInt();
			int[] arr=new int[K+1];
			int[] sum=new int[K+1];
			int[][] dp=new int[502][502];
			
			for(int i=1;i<=K;i++) {
				arr[i]=sc.nextInt();
				sum[i]=sum[i-1]+arr[i];
			}
			
			for(int i=1;i<=K;i++) {
				dp[i-1][i]=0;
			}
			
			//j에서 i까지의 최소비용(j<k<i)
			for(int i=2;i<=K;i++) {
				for(int j=i-1;j>0;j--) {
					dp[j][i]=Integer.MAX_VALUE;
					for(int k=j;k<=i;k++) {
						dp[j][i]=Math.min(dp[j][i], dp[j][k]+dp[k+1][i]);
					}
					
					dp[j][i]+=sum[i]-sum[j-1];
				}
			}
			
			System.out.println(dp[1][K]);
		}
	
	}
	

	
}
