package 동적계획법1;

import java.util.*;
public class No9184_신나는함수실행 {
	//주어진 w 함수에서 20을 넘어가면 w(20, 20, 20) 을 반환하기 때문에 21 21 21
	static int[][][] dp=new int[21][21][21];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			
			if(a==-1&&b==-1&&c==-1) break;
			int result = w(a,b,c);
			
			System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, result);
		}
	}
	
	static int w(int a, int b, int c) {
		if(a>=0&&b>=0&&c>=0 && a<21&&b<21&&c<21 && dp[a][b][c]!=0)
			return dp[a][b][c]; 
		
		if(a<=0||b<=0||c<=0)
			return 1;
		
		if(a>20||b>20||c>20)
			return dp[20][20][20]=w(20, 20, 20);
		
		if(a<b&&b<c)
			return dp[a][b][c]=w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		
		
		//그외 
		return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
	}
	

	
}
