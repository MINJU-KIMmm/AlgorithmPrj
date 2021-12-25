import java.util.*;
import java.io.*;
public class No7569_토마토 {
	static int[] dx= {-1, 1, 0, 0, 0, 0};
	static int[] dy= {0, 0, -1, 1, 0, 0};
	static int[] dz= {0, 0, 0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int M=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		int H=Integer.parseInt(st.nextToken());
		
		int[][][] arr=new int[H][N][M];
		
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				st=new StringTokenizer(br.readLine());

				for(int k=0;k<M;k++) {
					arr[i][j][k]=Integer.parseInt(st.nextToken());
				}
			}
		}
		
		System.out.println(bfs(arr, H, N, M));
	}
	
	static int bfs(int[][][] arr, int H, int N, int M) {
		Queue<Tomato> q=new LinkedList<>();
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					if(arr[i][j][k]==1) q.offer(new Tomato(i, j, k));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Tomato tomato=q.poll();
			int x=tomato.x;
			int y=tomato.y;
			int z=tomato.z;
			
			for(int i=0;i<6;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				int nz=z+dz[i];
				
				if(nx<0||nx>=H||ny<0||ny>=N||nz<0||nz>=M) continue;
				
				if(arr[nx][ny][nz]==0) {
					q.offer(new Tomato(nx, ny, nz));
					arr[nx][ny][nz]=arr[x][y][z]+1;
				}
			}
		}
		
		int day=Integer.MIN_VALUE;
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					if(arr[i][j][k]==0) return -1;
					day=Math.max(day, arr[i][j][k]);
				}
			}
		}
		
		return day-1;
	}
}

class Tomato{
	int x;
	int y;
	int z;
	
	public Tomato(int x, int y, int z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
}
