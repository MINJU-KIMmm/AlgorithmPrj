package DFS와BFS;

import java.util.*;
import java.io.*;
public class No7562_나이트의이동 {
	static int[] dx= {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] dy= {-1, 1, -2, 2, -2, 2, -1, 1}; 
	static int N;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			N=Integer.parseInt(br.readLine());
			int[][] cnt=new int[N][N];
			int startX, startY, endX, endY;
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			startX=Integer.parseInt(st.nextToken());
			startY=Integer.parseInt(st.nextToken());
			
			st=new StringTokenizer(br.readLine());
			endX=Integer.parseInt(st.nextToken());
			endY=Integer.parseInt(st.nextToken());
			
			Point start=new Point(startX, startY);
			Point end=new Point(endX, endY);
			
			bfs(start, end, cnt);
		}

	}
	
	
	static void bfs(Point start, Point end, int[][] cnt) {
		Queue<Point> q=new LinkedList<>();
		q.offer(start);
		visited=new boolean[N][N];
		visited[start.x][start.y]=true;
		
		while(!q.isEmpty()) {
			Point temp=q.poll();
			int x=temp.x;
			int y=temp.y;
			
			if(x==end.x&&y==end.y) {
				System.out.println(cnt[temp.x][temp.y]);
				return;
			}
			
			for(int i=0;i<8;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				if(nx>=0&&nx<N&&ny>=0&&ny<N&&!visited[nx][ny]) {
					Point next=new Point(nx, ny);
					cnt[nx][ny]=cnt[x][y]+1;
					q.offer(next);
					visited[nx][ny]=true;
				}
			}
		}
		
		
	}
}

class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
