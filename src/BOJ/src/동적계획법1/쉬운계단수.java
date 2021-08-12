package 동적계획법1;
import java.util.Scanner;

public class 쉬운계단수 {
	
	static Long[][]dp;
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		dp=new Long[N+1][10];
		for(int i=0;i<10;i++) {
			dp[1][i]=1L;
		}
		
		long result=0;
		//0으로 시작하는 수가 없기 때문에 i는 1부터시작  
		for(int i=1;i<10;i++) {
			result+=CountNum(N, i);
		}
		
		System.out.println(result%1000000000);
	}
	
	public static long CountNum(int n, int i) {
		if(n==1)
			return dp[n][i];
		if(dp[n][i]==null) {
			if(i==9)
				dp[n][i]=CountNum(n-1, 8);
			else if(i==0)
				dp[n][i]=CountNum(n-1, 1);
			else
				dp[n][i]=CountNum(n-1, i-1)+CountNum(n-1, i+1);
		}
		
		return dp[n][i]%1000000000;
	}

}
