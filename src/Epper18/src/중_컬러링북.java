import java.util.*;
import java.io.*;
public class 중_컬러링북 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static boolean[][] visited;
	static int[] solution(int m, int n, int[][] picture) {
		visited=new boolean[m][n];
		int max=Integer.MIN_VALUE;
		int area=0;
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(picture[i][j]!=0&&!visited[i][j]) {
					max=Math.max(max, bfs(m,n,i,j,picture));
					area++;
				}
			}
		}
		
		return new int[] {area,max};
	}
	
	static int[]dx= {-1,1,0,0};
	static int[]dy= {0,0,-1,1};
	static int bfs(int m, int n, int x, int y, int[][] picture) {
		Queue<Point>q=new LinkedList<>();
		
		q.offer(new Point(x,y));
		visited[x][y]=true;
		int color=picture[x][y];
		
		int count=1;
		while(!q.isEmpty()) {
			Point p=q.poll();
			int px=p.x;
			int py=p.y;
			
			for(int i=0;i<4;i++) {
				int nx=px+dx[i];
				int ny=py+dy[i];
				
				if(nx<0||nx>=m||ny<0||ny>=n) continue;
				
				if(picture[nx][ny]==color&&!visited[nx][ny]) {
					q.offer(new Point(nx,ny));
					visited[nx][ny]=true;
					count++;
				}
			}
		}
		
		return count;
	}

}

class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
