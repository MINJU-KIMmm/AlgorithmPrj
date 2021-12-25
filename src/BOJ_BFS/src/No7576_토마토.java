
import java.util.*;
import java.io.*;
public class No7576_토마토 {
	
	static int[] dx= {-1, 1, 0, 0};
	static int[] dy= {0, 0, -1, 1};

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int M=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		
		int[][] arr=new int[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(bfs(arr, N, M));
	}
	

	public static int bfs(int[][] arr, int N, int M) {
		Queue<Tomato1> q=new LinkedList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==1) {
					q.offer(new Tomato1(i,j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Tomato1 tomato=q.poll();
			int x=tomato.x;
			int y=tomato.y;
			
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				if(nx<0||nx>=N||ny<0||ny>=M) continue;
				
				if(arr[nx][ny]==0) {
					q.offer(new Tomato1(nx, ny));
					arr[nx][ny]=arr[x][y]+1;
				}
			}
		}
		
		
		int day=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==0) return -1;
				day=Math.max(day, arr[i][j]);
			}
		}
		
		return day-1;
	}
}



class Tomato1{
	int x;
	int y;
	
	public Tomato1(int x, int y) {
		this.x=x;
		this.y=y;
	}
}