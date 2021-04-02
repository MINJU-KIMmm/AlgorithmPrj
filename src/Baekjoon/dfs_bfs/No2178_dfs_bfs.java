//백준 2178번 미로 탐색
//토마토문제랑 비슷한듯
import java.util.*;

public class No2178_dfs_bfs {
	static int [][] arr;
	static boolean [][]visited;
	static int[] dx= {-1, 0, 1, 0};
	static int[] dy= {0, -1, 0, 1};
	static int n, m;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		
		sc.nextLine(); //버퍼 비움
		arr=new int[n][m];
		visited=new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			String str=sc.next();
			for(int j=0;j<m;j++) {
				arr[i][j]=str.charAt(j)-'0';
				visited[i][j]=false;
			}
		}
		
		visited[0][0]=true;
		bfs(0,0);
		System.out.println(arr[n-1][m-1]);
	}
	
	public static void bfs(int x, int y) {
		Queue<point>q=new LinkedList<>();
		q.add(new point(x, y));
		
		while(!q.isEmpty()) {
			point p=q.poll();
			for(int i=0;i<4;i++) {
				int nextX=p.x+dx[i];
				int nextY=p.y+dy[i];
				
				//범위체크
				if(nextX<0||nextY<0||nextX>=n||nextY>=m) 
					continue;
				
				//방문체크, 갈 수 있는 곳인지 체크
				if(visited[nextX][nextY]||arr[nextX][nextY]==0)
					continue;
				
				//다음 방문할 point 큐에 삽입
				q.add(new point(nextX, nextY));
				
				//다음 건 한칸 더 간 상태이므로 +1
				arr[nextX][nextY]=arr[p.x][p.y]+1;
				visited[nextX][nextY]=true;
			}
		}
		
	}

}

class point{
	int x;
	int y;
	
	public point(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
