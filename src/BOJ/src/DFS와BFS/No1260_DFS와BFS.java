package DFS와BFS;

import java.util.*;
import java.io.*;
public class No1260_DFS와BFS {
	
	static int[][] map; //간선 연결 상태 
	static boolean[] visited; //방문여부 
	static int n; //정점개수 
	static int m; //간선개수 
	static int start; //시작정점 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		start=sc.nextInt();
		
		map=new int[1001][1001];
		visited=new boolean[1001];
		
		//간선 연결 상태 입력 	
		for(int i=0;i<m;i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			
			map[x][y]=map[y][x]=1;
		}
		
		//dfs
		dfs(start);
		
		visited=new boolean[1001]; //초기화 
		System.out.println();
		
		//bfs
		bfs();
	}
	
	static void dfs(int i){
		visited[i]=true;
		System.out.print(i+" ");
		
		for(int j=1;j<=n;j++) {
			if(map[i][j]==1&&!visited[j]) {
				dfs(j);
			}
		}
	}
	
	static void bfs() {
		Queue<Integer>q=new LinkedList<>();
		q.offer(start); //시작점 큐에 삽입 
		visited[start]=true;
		System.out.print(start+" ");
		
		while(!q.isEmpty()) {
			int tmp=q.poll();
			
			for(int j=1;j<=n;j++) {
				if(map[tmp][j]==1&&!visited[j]) {
					q.offer(j);
					visited[j]=true;
					System.out.print(j+" ");
				}
			}
		}
	}
}
