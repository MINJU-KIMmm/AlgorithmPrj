package 동적계획법1;
import java.util.Scanner;

public class _1로만들기 {
	static Integer[]dp;
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		
		dp=new Integer[N+1];
		dp[0]=0;
		dp[1]=0;
		
		System.out.println(MinCount(N));
	}
	
	public static int MinCount(int n) {
		if(dp[n]==null) {
			if(n%6==0)
				dp[n]=Math.min(MinCount(n/3), Math.min(MinCount(n/2), MinCount(n-1)))+1;
			else if(n%3==0)
				dp[n]=Math.min(MinCount(n/3), MinCount(n-1))+1;
			else if(n%2==0)
				dp[n]=Math.min(MinCount(n/2), MinCount(n-1))+1;
			else
				dp[n]=MinCount(n-1)+1;
		}
		
		return dp[n];
	}

}
