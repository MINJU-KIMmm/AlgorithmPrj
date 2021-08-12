package 동적계획법1;
import java.util.Scanner;

public class 포도주시식 {
	
	static Integer[] dp;
	static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		
		arr=new int[N];
		for(int i=0;i<N;i++)
			arr[i]=sc.nextInt();
		
		dp=new Integer[N];
		if(N>=1)
			dp[0]=arr[0];
		if(N>=2)
			dp[1]=arr[1]+arr[0];
		if(N>=3)
			dp[2]=Math.max(Math.max(arr[1]+arr[0], arr[0]+arr[2]), arr[1]+arr[2]);
		
		for(int i=3;i<N;i++) {
			dp[i]=Math.max(Math.max(dp[i-3]+arr[i-1]+arr[i], dp[i-1]), arr[i]+dp[i-2]);
		}
		
		System.out.println(dp[N-1]);
	}
	

}
