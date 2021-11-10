package DFS;
import java.util.*;
public class 연결요소의개수 {
	
	static int N, M;
	static int[][] arr;
	static boolean[] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		
		arr=new int[1001][1001];
		visited=new boolean[1001];
		
		for(int i=0;i<M;i++) {
			int u=sc.nextInt();
			int v=sc.nextInt();
			
			arr[u][v]=arr[v][u]=1;
		}
		
		int cnt=0;
		//dfs
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				dfs(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	static void dfs(int i) {
		if(visited[i]) return;
		else {
			visited[i]=true;
			for(int j=1;j<=N;j++	) {
				if(arr[i][j]==1) dfs(j);
			}
		}
	}

}
