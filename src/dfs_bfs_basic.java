import java.util.*;
import java.io.*;

//dfs : 스택 or 재귀(재귀를 이용하는 게 좀 더 보편적)
//bfs : 큐

public class dfs_bfs_basic {
	static int[][]check; //간선 연결 상태
	static boolean[] visited; //방문 여부
	static int n, m; //n: 정점개수  m: 간선개수
	static int start; //시작 정점
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		start=sc.nextInt();
		
		check=new int[1001][1001];
		visited=new boolean[1001];//초기값 false
		
		//간선 연결 상태
		for(int i=0;i<m;i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			
			check[x][y]=check[y][x]=1;
		}
		
		dfs(start);
		
		visited=new boolean[1001]; //초기화
		System.out.println();
		
		bfs();
	}
	
	public static void dfs(int i) {
		visited[i]=true;
		System.out.print(i+" ");
		
		for(int j=1;j<=n;j++) {
			if(check[i][j]==1&&visited[j]==false)
				dfs(j);
		}
	}
	
	public static void bfs() {
		Queue<Integer>q=new LinkedList<>();
		
		q.offer(start);
		visited[start]=true;
		System.out.print(start+" ");
		
		while(!q.isEmpty()) {
			int tmp=q.poll();
			
			for(int j=1;j<=n;j++) {
				if(check[tmp][j]==1&&visited[j]==false) {
					q.offer(j);
					visited[j]=true;
					System.out.print(j+" ");
				}
			}
		}
	}
}
