import java.util.*;
import java.io.*;
public class No10026_적록색약 {

	static char[][] arr;
	static boolean[][] visited;
	static int count=0;
	static int N;
	static int[] dx= {-1, 1, 0, 0};
	static int[] dy= {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		arr=new char[N][N];
		visited=new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			String str=br.readLine();
			for(int j=0;j<N;j++) {
				arr[i][j]=str.charAt(j);
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					bfs(i, j);
					count++;
				}
			}
		}
		
		System.out.print(count+" ");
		
		count=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]=='G') arr[i][j]='R';
			}
		}
		
		visited=new boolean[N][N];
		
		for(int i=0;i<N;i++	) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					bfs(i,j);
					count++;
				}
			}
		}
		System.out.println(count);
	}
	
	static void bfs(int px, int py) {
		Queue<Color> q=new LinkedList<>();
		q.offer(new Color(px, py));
		visited[px][py]=true;
				
		while(!q.isEmpty()) {
			Color color=q.poll();
			int x=color.x;
			int y=color.y;
			
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				if(nx<0||nx>=N||ny<0||ny>=N) continue;
				
				if(arr[nx][ny]==arr[x][y]&&!visited[nx][ny]) {
					q.offer(new Color(nx, ny));
					visited[nx][ny]=true;
				}
			}
		}
		
	}
}

class Color{
	int x;
	int y;
	
	public Color(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
