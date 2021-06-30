package ALPS_dfs;

import java.util.*;
public class No4963_섬의개수 {

	static int[][]arr;
	static boolean[][]visited;
	static int w;//너비
	static int h;//높이
	
	static int[] dx= {0,0,1,-1,-1,1,-1,1};
	static int[] dy= {1,-1, 0, 0, -1, 1, 1, -1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			w=sc.nextInt();
			h=sc.nextInt();
			
			if(w==0&&h==0)
				System.exit(0);;
			
			//0은 바다 1은 땅
			arr=new int[h+1][w+1];
			visited=new boolean[h+1][w+1];
			for(int i=1;i<=h;i++) {
				for(int j=1;j<=w;j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			
			int cnt=0; //섬 개수
			for(int i=1;i<=h;i++) {
				for(int j=1;j<=w;j++) {
					if(arr[i][j]==1&&!visited[i][j]) {
						dfs(i,j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
	}
	
	
	public static void dfs(int i, int j) {
		
		
		visited[i][j]=true;
		
		for(int p=0;p<8;p++) {
			int x=i+dx[p];
			int y=j+dy[p];
			
			if(x>0&&x<=h&&y>0&&y<=w) {
				if(arr[x][y]==1&&!visited[x][y])
					dfs(x,y);
			}
		}
		
	}
}
