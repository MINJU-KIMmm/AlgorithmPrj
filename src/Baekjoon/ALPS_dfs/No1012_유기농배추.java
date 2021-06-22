package ALPS_dfs;
import java.util.*;

public class No1012_유기농배추 {

	static int m; //가로
	static int n; //세로
	static int k; //간선 개수
	static int[][] arr;
	static boolean[][]visited;
	
	static int[]dx= {-1, 1, 0, 0};
	static int[]dy= {0,0,-1,1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		for(int i=0;i<t;i++) {
			m=sc.nextInt();
			n=sc.nextInt();
			k=sc.nextInt();
			
			arr=new int[m][n];
			visited=new boolean[m][n];
			
			for(int j=0;j<k;j++) {
				arr[sc.nextInt()][sc.nextInt()]=1;
			}
			
			int cnt=0;
			
			for(int p=0;p<m;p++) {
				for(int q=0;q<n;q++) {
					if(arr[p][q]==1&&!visited[p][q]) {
						dfs(p,q);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
	}

	public static void dfs(int i, int j) {
		visited[i][j]=true;
		
		for(int p=0;p<4;p++) {
			int x=i+dx[p];
			int y=j+dy[p];
			
			if(x>=0&&x<m&&y>=0&&y<n) {
				if(arr[x][y]==1&&!visited[x][y])
					dfs(x,y);
			}
		}
	}
}
