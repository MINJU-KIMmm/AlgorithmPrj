package Ch8_dp;

import java.util.*;
import java.io.*;
public class 실전3_개미전사 {

	static int[] arr;
	static int[] dp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		arr=new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		dp=new int[N];
		dp[0]=arr[0];
		dp[1]=Math.max(arr[0], arr[1]);
		
		System.out.println(solution());
	}

	static int solution() {
		for(int i=2;i<dp.length;i++) {
			dp[i]=Math.max(dp[i-1], arr[i]+dp[i-2]);
		}
		
		return dp[dp.length-1];
	}
}
