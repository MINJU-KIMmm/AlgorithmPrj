import java.util.*;
import java.io.*;
public class No2644_촌수계산 {

	static int[][] arr;
	static int[] answer;
	static boolean[] visited;
	static int n;
	static int count=0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		
		int m=Integer.parseInt(br.readLine());
		
		arr=new int[n][n];
		answer=new int[n];
		visited=new boolean[n];
		while(m-->0) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			arr[x-1][y-1]=1;
			arr[y-1][x-1]=1;
		}
		
		dfs(a-1, b-1, 0);
		
		if(count==0) System.out.println(-1);
		else System.out.println(count);
	}
	
	static void bfs(int start, int end) {
		Queue<Integer> q=new LinkedList<>();
		q.offer(start);
		
		while(!q.isEmpty()) {
			int tmp=q.poll();
			if(tmp==end) break;
			
			for(int i=0;i<n;i++) {
				if(arr[tmp][i]==1&&answer[i]==0) {
					answer[i]=answer[tmp]+1;
					q.offer(i);
				}
			}
		}
	}
	
	static void dfs(int start, int end, int cnt) {
		if(start==end) {
			count=cnt;
			return;
		}
		visited[start]=true;
		for(int i=0;i<n;i++) {
			if(arr[start][i]==1&&!visited[i]) {
				visited[i]=true;
				dfs(i, end, cnt+1);
				visited[i]=false;
			}
		}
	}

}
