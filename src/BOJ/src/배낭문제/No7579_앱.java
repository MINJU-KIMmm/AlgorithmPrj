package 배낭문제;

import java.io.*;
import java.util.*;

public class No7579_앱 {

	static int[][] dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int answer = Integer.MAX_VALUE;

		int[] memory = new int[n];
		int[] cost = new int[n];
		dp = new int[n][100001];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			int c = cost[i];
			int mem = memory[i];

			for (int j = 0; j <= 100000; j++) {
				if (i == 0) { //첫번째 열인 경우 -> j가 c 이상이면 mem 값을 담는다 
					if (j >= c)
						dp[i][j] = mem;
				} else { //첫번째 열이 아닌 경우 
					if (j >= c) // j가 c 이상이면 최댓값 계산 ( 1. 이전 행에서 c비용 안쓰고 확보한 메모리 값 + 이번 행에서 c비용으로 확보한 메모리 vs 이전 행에서 같은 비용 써서 확보한 메모리)
						dp[i][j] = Math.max(dp[i - 1][j - c] + mem, dp[i - 1][j]);
					else //j가 c 이상이 아니라면 이전 행 
						dp[i][j] = dp[i - 1][j];
				}
				
				//m바이트 이상의 메모리를 확보하는 최소의 비용 구하기 
				if (dp[i][j] >= m)
					answer = Math.min(answer, j);

			}
		}

		System.out.println(answer);
	}

}
