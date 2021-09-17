package DFS와BFS;

import java.util.*;
import java.io.*;
public class No2206_벽부수고이동하기 {
	
	static int N, M, ans;
	static int[][] map, visited;
	
	static int[] dx= {0, 0, -1, 1};
	static int[] dy= {-1, 1, 0, 0};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String [] str=br.readLine().split(" ");
		
		N=Integer.parseInt(str[0]);
		M=Integer.parseInt(str[1]);
		
		map=new int[N][M];
		visited=new int[N][M];
		
		for(int i=0;i<N;i++) {
			str=br.readLine().split("");
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(str[j]);
				visited[i][j]=Integer.MAX_VALUE;
			}
		}
		
		ans=Integer.MAX_VALUE;
		
		bfs(0,0);
		
		if(ans==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}
	
	static class spot{
		int x;
		int y;
		int dist;
		int cnt;
		
		public spot(int x, int y, int dist, int cnt) {
			this.x=x;
			this.y=y;
			this.dist=dist;
			this.cnt=cnt;
		}
	}
	
	public static void bfs(int x, int y	) {
		Queue<spot> q=new LinkedList<>();
		
		q.offer(new spot(x, y, 1, 0));
		visited[x][y]=0;
		
		while(!q.isEmpty()) {
			spot s=q.poll()	;
			
			if(s.x==N-1&&s.y==M-1) {
				ans=s.dist;
				break;
			}
			
			for(int i=0;i<4;i++) {
				int nx=s.x+dx[i];
				int ny=s.y+dy[i];
				
				if(nx>=0&&nx<N&&ny>=0&&ny<M&&visited[nx][ny]>s.cnt) {
					if(map[nx][ny]==0) { //벽 x
						visited[nx][ny]=s.cnt;
						q.offer(new spot(nx, ny, s.dist+1, s.cnt));
					}
					else {
						if(s.cnt==0) {
							visited[nx][ny]=s.cnt+1;
							q.offer(new spot(nx, ny, s.dist+1, s.cnt+1));
						}
					}
				}
			}
		}
	}
}
