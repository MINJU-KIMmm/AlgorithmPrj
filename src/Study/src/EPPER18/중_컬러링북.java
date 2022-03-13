package EPPER18;

import java.util.*;

public class 중_컬러링북 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	
	static int[]dx= {-1,1,0,0};
	static int[]dy= {0,0,-1,1};
	static boolean[][] visited;
	
	static int[] solution(int m, int n, int[][] picture) {
		int area=0;
		int max=0;
		visited=new boolean[m][n];
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(picture[i][j]!=0&&!visited[i][j]) {
					max=Math.max(bfs(m,n,i,j,picture), max); //최대 개수 계산 
					area++; //영역 개수 계산 
				}
			}
		}
		
		return new int[] {area, max};
	}
	
	static int bfs(int m, int n, int px, int py, int[][] picture) {
		//처음 시작점부터 이미 하나를 세고 시작해야 하므로 count를 1부터 시작 
		int count=1;
		int color=picture[px][py];
		Queue<Point> q=new LinkedList<>();
		
		visited[px][py]=true;
		q.offer(new Point(px,py));
		
		while(!q.isEmpty()) {
			Point p=q.poll();
			int x=p.x;
			int y=p.y;
			
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				if(nx<0||nx>=m||ny<0||ny>=n) continue;
				
				if(color==picture[nx][ny]&&!visited[nx][ny]) {
					q.offer(new Point(nx,ny));
					visited[nx][ny]=true;
					count++;
				}
			}
		}
		
		return count;
	}
}

