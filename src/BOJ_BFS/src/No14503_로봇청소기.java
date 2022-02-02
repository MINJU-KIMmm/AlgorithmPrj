import java.util.*;
import java.io.*;
public class No14503_로봇청소기 {
	
	static int r, c, d, N, M;
	static int[][] arr;
	static int count=0;
	static int[] dx= {-1, 0, 1, 0};
	static int[] dy= {0, 1, 0, -1};

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[N][M];
		
		st=new StringTokenizer(br.readLine());
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		d=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		dfs(r,c,d);
		System.out.println(count);
	}
	
	static void dfs(int x, int y, int d) {
		if(arr[x][y]==0) {
			arr[x][y]=-1;
			count++;
		}
		
		boolean flag=false;
		int temp_dir=d;
		for(int i=0;i<4;i++	) {
			int nd=(d+3)%4;
			int nx=x+dx[nd];
			int ny=y+dy[nd];
			
			if(nx>=0&&nx<N&&ny>=0&&ny<M) {
				if(arr[nx][ny]==0) {
					dfs(nx,ny,nd);
					flag=true;
					break;
				}
			}
			
			d=nd;
		}
		
		if(!flag) {
			int nd=(temp_dir+2)%4;
			int nx=x+dx[nd];
			int ny=y+dy[nd];
			
			if(nx>=0&&nx<N&&ny>=0&&ny<M) {
				if(arr[nx][ny]!=1) {
					dfs(nx,ny,temp_dir);
				}
			}
		}
	}

}
