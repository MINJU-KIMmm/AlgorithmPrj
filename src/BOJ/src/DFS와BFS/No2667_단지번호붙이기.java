package DFS와BFS;

import java.util.*;
public class No2667_단지번호붙이기 {

	static int[][] arr;
	static boolean[][] visited;
	
	static int[] dx= {1, -1, 0, 0};
	static int[] dy= {0, 0, 1, -1};

	static int[] cntArr=new int[25*25];
	static int cnt=0;
	
	static int n;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		arr=new int[n][n];
		visited=new boolean[n][n];
		for(int i=0;i<n;i++) {
			String str=sc.next();
			for(int j=0;j<n;j++) {
				int num=str.charAt(j)-'0';
				arr[i][j]=num;
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]==1&&!visited[i][j]) {
					cnt++;
					//bfs(i,j);
					dfs(i,j);
				}
			}
		}

		Arrays.sort(cntArr);
		System.out.println(cnt);
		
		for(int i=0;i<cntArr.length;i++) {
			if(cntArr[i]!=0) {
				System.out.println(cntArr[i]);
			}
		}
		
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> q=new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y]=true;
		cntArr[cnt]++;
		
		while(!q.isEmpty()) {
			int px=q.peek()	[0];
			int py=q.peek()[1];
			q.poll();
			
			for(int i=0;i<4;i++) {
				int nx=px+dx[i];
				int ny=py+dy[i];
				
				if(nx>=0&&nx<n&&ny>=0&&ny<n	) {
					if(arr[nx][ny]==1&&!visited[nx][ny]) {
						q.offer(new int[] {nx, ny});
						visited[nx][ny]=true;
						cntArr[cnt]++;
					}
				}
			}
		}
	}
	
	static void dfs(int x, int y) {
		visited[x][y]=true;
		cntArr[cnt]++;
		
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(nx>=0&&nx<n&&ny>=0&&ny<n) {
				if(arr[nx][ny]==1&&!visited[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
	}
}
