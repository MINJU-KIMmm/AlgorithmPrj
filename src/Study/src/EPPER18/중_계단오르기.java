package EPPER18;
//dp

import java.util.*;
public class 중_계단오르기 {

	static int[]arr=new int[301];
	static int[]dp=new int[301];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		for(int i=1;i<N+1;i++) {
			arr[i]=sc.nextInt();
		}
		
		int answer=solution(N, arr);
		
		System.out.println(answer);
	}

	
	static int solution(int N, int[] arr) {
		dp[1]=arr[1];
		dp[2]=arr[1]+arr[2];
		//dp[3]=Math.max(arr[1]+arr[3], arr[2]+arr[3]);
		
		for(int i=3;i<301;i++) {
			dp[i]=Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i-1]+arr[i]);
		}
		
		return dp[N];
	}
}
