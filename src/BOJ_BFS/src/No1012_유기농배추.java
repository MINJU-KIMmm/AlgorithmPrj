import java.util.*;
import java.io.*;

public class No1012_유기농배추 {

	static int[][] arr;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int count = 0;
	static int N, M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			arr = new int[N][M];
			visited = new boolean[N][M];

			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				arr[b][a] = 1;

			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 1 && !visited[i][j]) {
						count++;
						bfs(i, j);
					}
				}
			}
			
			System.out.println(count);
			count=0;
		}
	}

	static void bfs(int px, int py) {
		Queue<veg> q = new LinkedList<>();
		q.offer(new veg(px, py));
		visited[px][py]=true;

		while (!q.isEmpty()) {
			veg v = q.poll();
			int x = v.x;
			int y = v.y;
			visited[x][y] = true;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;

				if (arr[nx][ny] == 1 && !visited[nx][ny]) {
					q.offer(new veg(nx, ny));
					visited[nx][ny]=true;
				}
			}
		}

	}

}


class veg {
	int x;
	int y;

	public veg(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
