import java.util.*;
import java.io.*;

public class No1520_내리막길 {

	static int[][] dp;

	static int[][] arr;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int N, M;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		arr = new int[M][N];

		dp = new int[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}

		System.out.println(dfs(0, 0));
	}

	static int dfs(int x, int y) {
		// 도착했을 때
		if (x == M - 1 && y == N - 1) {
			return 1;
		}
		// -1이 아닌 경우 이미 방문
		if (dp[x][y] != -1) {
			return dp[x][y];
		} else {
			dp[x][y] = 0;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= M || ny < 0 || ny >= N)
					continue;

				if (arr[x][y] > arr[nx][ny]) {
					dp[x][y] += dfs(nx, ny);
				}
			}
		}

		return dp[x][y];
	}

}

class Road {
	int x;
	int y;

	public Road(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
