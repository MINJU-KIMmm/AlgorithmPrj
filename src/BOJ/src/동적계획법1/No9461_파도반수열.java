package 동적계획법1;

import java.util.Scanner;

//N이 커지면 결과값이 엄청 커지기 때문에 배열을 int로 선언하면 안되고 long으로 선언해야함

public class No9461_파도반수열 {

	public static long[] dp = new long[101];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		int[]N=new int[T];
		for(int t=0;t<T;t++) 
			N[t]=sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			dp[0] = 1L;
			dp[1] = 1L;
			dp[2] = 1L;
			dp[3] = 2L;// 1+1
			dp[4] = 2L;
			dp[5] = 3L;// 1+2
			dp[6] = 4L;// 1+3
			dp[7] = 5L;// 1+4
			dp[8] = 7L;// 2+5
			dp[9] = 9L;// 2+7
			// 12 dp[10]=dp[5]+dp[9]
			// 16
			// 21
			// 28

			// 12(3+9) 16(4+12) 21(5+16) 7+21
			int n=N[t];
			for (int i = 10; i < dp.length; i++)
				dp[i] = -1L;

			System.out.println(solution(n - 1));
		}
	}

	public static Long solution(int N) {
		if (dp[N] == -1)
			dp[N] = solution(N - 5) + solution(N - 1);
		return dp[N];
	}

}
