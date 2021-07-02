package 동적계획법1;

import java.util.Scanner;

public class No10844_쉬운계단수 {
	
	static Long[][]dp; //[자릿수][숫자]
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner (System.in);
		int N=sc.nextInt();
		
		dp=new Long[N+1][10];
		for(int i=0;i<10;i++) {
			dp[1][i]=1L;
		}
		
		long result=0;
		for(int i=1;i<10;i++) {
			result+=Count(N, i);
		}
		
		System.out.println(result%1000000000);
	}

	public static long Count(int digit, int val) {
		if(digit==1)
			return dp[digit][val];
		
		if(dp[digit][val]==null) {
			if(val==9)
				dp[digit][val]=Count(digit-1, 8);
			else if(val==0)
				dp[digit][val]=Count(digit-1, 1);
			else
				dp[digit][val]=Count(digit-1, val-1)+Count(digit-1, val+1);
		}
		
		return dp[digit][val]%1000000000;
	}
}
