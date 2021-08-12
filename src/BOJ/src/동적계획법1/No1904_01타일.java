package 동적계획법1;
import java.util.*;

public class No1904_01타일 {

	public static int []dp=new int[1000001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		
		//1 -> 1개 
		//00 11 -> 2개 
		//001 100 111 -> 3개 
		//0000 0011 1100 1001 1111 -> 5개 
		//00001 00100 10000 00111 10011 11001 11100 11111-> 8개 
		
		//=> 피보나치 수열  
		dp[0]=0;
		dp[1]=1;
		dp[2]=2;
		
		for(int i=3;i<dp.length;i++) 
			dp[i]=-1;
		
		System.out.println(solution(N));
	}
	
	public static int solution(int N) {
		if(dp[N]==-1)
			dp[N]=(solution(N-1)+solution(N-2))%15746;
		
		return dp[N];
	}

}
