
import java.util.*;
import java.io.*;

public class No1012_유기농배추_dfs {
	static int[][] arr;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int count = 0;
	static int N, M;

	public static void main(String[] args) throws IOException{
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
						dfs(i, j);
					}
				}
			}

			System.out.println(count);
			count = 0;
		}
	}
	
	static void dfs(int px, int py) {
		visited[px][py]=true;
		
		for(int i=0;i<4;i++) {
			int nx=px+dx[i];
			int ny=py+dy[i];
			
			if(nx<0||nx>=N||ny<0||ny>=M) continue;
			
			if(arr[nx][ny]==1&&!visited[nx][ny]) {
				dfs(nx, ny);
			}
		}
		
	}
}
