package 동적계획법1;

import java.util.*;

public class No1932_정수삼각형 {

	static int[][] tri;
	static Integer[][] dp;
	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dp = new Integer[n][n];
		tri = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i + 1; j++)
				tri[i][j] = sc.nextInt();
		}

		for (int i = 0; i < n; i++)
			dp[n - 1][i] = tri[n - 1][i];

		System.out.println(CalcSum(0, 0));
	}

	public static int CalcSum(int i, int j) {
		if (i == n - 1)
			return dp[i][j];

		if (dp[i][j] == null) {
			dp[i][j]=Math.max(CalcSum(i+1, j), CalcSum(i+1, j+1))+tri[i][j];
		}

		return dp[i][j];
	}

}
