package EPPER18;

import java.util.*;

public class 중_컬러링북 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	static ArrayList<Integer> answer;
	static boolean[][] visited;
	public int[] solution(int m, int n, int[][] picture) {
		answer=new ArrayList<>();
		visited=new boolean[m][n];
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(picture[i][j]!=0&&!visited[i][j]) {
					visited[i][j]=true;
					bfs(picture, i,j);
				}
			}
		}
		
		Collections.sort(answer);
		
		int[] sol=new int[2];
		sol[0]=answer.size();
		sol[0]=answer.get(answer.size()-1);
		
		return sol;
	}



	static void bfs(int[][] picture, int px, int py) {
		int[] dx= {-1,1,0,0};
		int[] dy= {0,0,-1,1};
		
		Queue<Point> q=new LinkedList<>();
		q.offer(new Point(px,py));
		
		int color=picture[px][py];
		int count=0;
		
		while(!q.isEmpty()) {
			Point p=q.poll();
			int x=p.x;
			int y=p.y;
			
			count++;
			
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				if(nx>=0&&nx<picture.length&&ny>=0&&ny<picture[0].length) {
					if(!visited[nx][ny]&&picture[nx][ny]==color) {
						q.offer(new Point(nx,ny));
						visited[nx][ny]=true;
					}
				}
			}
		}
		
		answer.add(count);
		
	}	


	static class Point {
		int x;
		int y;
	
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

