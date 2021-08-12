package 동적계획법1;

import java.util.Scanner;
public class No1912_연속합 {

	static Integer[] dp;
	static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		arr=new int[N];
		dp=new Integer[N];
		
		for(int i=0;i<N;i++)
			arr[i]=sc.nextInt();
		
		dp[0]=arr[0];
		int max=dp[0];
		for(int i=1;i<N;i++)
			if(max<MaxSum(i))
				max=MaxSum(i);
		
		System.out.println(max);
	}

	public static int MaxSum(int n) {
		if(dp[n]==null) {
			dp[n]=arr[n];
			dp[n]=Math.max(MaxSum(n-1)+arr[n], dp[n]);
		}
		
		return dp[n];
	}
}
