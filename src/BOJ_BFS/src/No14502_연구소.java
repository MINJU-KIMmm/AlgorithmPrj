import java.util.*;
import java.io.*;

//0번행이 1행 
public class No14502_연구소 {
	
	static int[] dx= {-1, 1, 0, 0};
	static int[] dy= {0, 0, -1, 1};
	static int result=Integer.MIN_VALUE;
	static int[][] arr;
	static int[][] copyArr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		arr=new int[N][M];
		copyArr=new int[N][M];
	
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				copyArr[i][j]=arr[i][j];
			}
		}
		

		
		dfs(0, N, M);

		System.out.println(result);

	}
	
	//depth == 세운 벽 개수 
	static void dfs(int depth, int N, int M) {
		//System.out.println(depth);
		if(depth==3) {
			bfs(N, M);
			return;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copyArr[i][j]==0) {
					copyArr[i][j]=1;
					dfs(depth+1, N, M);
					copyArr[i][j]=0;
				}
			}
		}
	}
	
	static void bfs(int N, int M) {
		Queue<Virus> q=new LinkedList<>();
		int[][] tempArr=new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				tempArr[i][j]=copyArr[i][j];
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(tempArr[i][j]==2) q.offer(new Virus(i, j));
			}
		}
		
		while(!q.isEmpty()) {
			Virus virus=q.poll();
			int x=virus.x;
			int y=virus.y;
			
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				if(nx<0||nx>=N||ny<0||ny>=M) continue;
				
				if(tempArr[nx][ny]==0) {
					tempArr[nx][ny]=2;
					q.offer(new Virus(nx, ny));
				}
			}
		}
		
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++	) {
				if(tempArr[i][j]==0) cnt++;
			}
		}
		
		result=Math.max(cnt, result);
		
	}
}


class Virus{
	int x;
	int y;
	
	public Virus(int x, int y){
		this.x=x;
		this.y=y;
	}
}