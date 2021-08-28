package DFS와BFS;

import java.util.*;
public class No2606_바이러스 {
	static int[][] arr;
	static boolean[] visited;
	static int n;
	static int m;
	static int cnt=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		m=sc.nextInt();
		
		arr=new int[n+1][n+1];
		visited=new boolean[n+1];
		
		for(int i=0;i<m;i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			
			arr[x][y]=arr[y][x]=1;
		}
		
		//bfs로 풀었을 떄 
		bfs(1);
		
		//dfs로 풀었을 떄 
		//dfs(1);
		//System.out.println(cnt-1);
	}
	
	
	static void dfs(int i) {
		if(visited[i])
			return;
		
		visited[i]=true;
		cnt++;
		
		for(int j=1;j<=n;j++) {
			if(arr[i][j]==1&&!visited[j])
				dfs(j);
		}
	}
	
	static void bfs(int i) {
		Queue<Integer>q=new LinkedList<>();
		
		visited[i]=true;
		q.offer(i);
		
		while(!q.isEmpty()) {
			int x=q.poll();
			
			for(int j=1;j<=n;j++) {
				if(arr[x][j]==1&&!visited[j]) {
					q.offer(j);
					visited[j]=true;
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
