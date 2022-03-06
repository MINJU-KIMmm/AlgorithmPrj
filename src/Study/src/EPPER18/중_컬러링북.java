package EPPER18;

import java.util.*;

public class 중_컬러링북 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] solution(int m, int n, int[][] picture) {
		int[] answer = bfs(picture, m, n);
		return answer;
	}



	static int[] bfs(int[][] picture, int m, int n) {
		Queue<Point>q=new LinkedList<>();
		int area=0;
		int max=0;
		
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(picture[i][j]!=0) {
					q.offer(new Point(i,j));
					area++;
					int count=0;
					int color=picture[i][j];
					picture[i][j]=0;
					
					while(!q.isEmpty()) {
						count++;
						Point p=q.poll();
						int x=p.x;
						int y=p.y;
						
						for(int d=0;d<4;d++) {
							int nx=x+dx[d];
							int ny=y+dy[d];
							
							if(nx>=0&&nx<m&&ny>=0&&ny<n) {
								if(color==picture[nx][ny]) {
									q.offer(new Point(nx,ny));
									picture[nx][ny]=0;
								}
							}
						}
					}
					max=Math.max(max, count);

					
				}
			}
		}

	return new int[]{area,max};
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

