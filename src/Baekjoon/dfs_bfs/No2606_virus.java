import java.util.*;
//백준 2606 바이러스
public class No2606_virus {
	static int[][] arr;//그래프
	static boolean[] visited; //방문 배열

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt(); //컴퓨터 수
		int m=sc.nextInt(); //간선(연결된 컴퓨터쌍)수
		
		arr=new int[n+1][n+1];
		visited=new boolean[n+1];
		
		for(int i=0;i<m;i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			
			arr[x][y]=arr[y][x]=1;
		}
		
		bfs(1);
	}
	
	//bfs
	static void bfs(int start) {
		Queue<Integer>q=new LinkedList<>();
		
		q.offer(start);
		visited[start]=true;
		int ans=0;
		
		while(!q.isEmpty()) {
			int x=q.poll();
			
			for(int i=1;i<arr.length;i++) {
				if(arr[x][i]==1&&!visited[i]) {
					q.offer(i);
					visited[i]=true;
					ans++;
				}
			}
		}
		
		System.out.println(ans);
	}
}
