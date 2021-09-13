package DFS와BFS;

import java.io.*;
import java.util.*;

public class No7569_토마토 {

	static int[][][] arr;
	static int[] dx = { -1, 0, 1, 0, 0, 0 };
	static int[] dy = { 0, 1, 0, -1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };

	static int M, N, H;
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		arr = new int[H][N][M];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
					if (arr[i][j][k] == 1)
						q.offer(new int[] { i, j, k }); // 시작 노드를 큐에 넣고 bfs 시작
				}
			}
		}

		System.out.println(bfs());

	}

	public static int bfs() {
		while (!q.isEmpty()) {
			int[] temp = q.poll();

			int h = temp[0];
			int n = temp[1];
			int m = temp[2];

			for (int i = 0; i < 6; i++) {
				int nh = h + dx[i];
				int nn = n + dy[i];
				int nm = m + dz[i];

				if (nh >= 0 && nh < H && nn >= 0 && nn < N && nm >= 0 && nm < M) {
					if (arr[nh][nn][nm] == 0) {
						q.offer(new int[] { nh, nn, nm });
						arr[nh][nn][nm] = arr[h][n][m] + 1;
					}
				}
			}
		}

		int answer = Integer.MIN_VALUE;

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (arr[i][j][k] == 0)
						return -1; // 익지 못한 토마토 있는 경우
					answer = Math.max(answer, arr[i][j][k]);
				}
			}
		}

		if (answer == 1)
			return 0;
		else
			return answer - 1;
	}

}
