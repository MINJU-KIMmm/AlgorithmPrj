import java.util.*;
import java.io.*;
public class No7562_나이트의이동 {

	static int[][] arr;
	static int[] dx= {-2, -2, 2, 2, -1, -1, 1, 1};
	static int[] dy= {1, -1, 1, -1, 2, -2, 2, -2};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		
		while(T-->0) {
			int l=Integer.parseInt(br.readLine());
			
			arr=new int[l][l];
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			int startX=Integer.parseInt(st.nextToken());
			int startY=Integer.parseInt(st.nextToken());
			
			st=new StringTokenizer(br.readLine());
			int endX=Integer.parseInt(st.nextToken());
			int endY=Integer.parseInt(st.nextToken());
			
			Knight start=new Knight(startX, startY);
			Knight end=new Knight(endX, endY);
			
			bfs(l, start, end);
		}
	}

	static void bfs(int l, Knight start, Knight end) {
		Queue<Knight> q=new LinkedList<>();
		boolean[][] visited=new boolean[l][l];
		visited[start.x][start.y]=true;
		q.offer(start);
		
		while(!q.isEmpty()) {
			Knight k=q.poll();
			int x=k.x;
			int y=k.y;
			
			if(x==end.x&&y==end.y) {
				System.out.println( arr[end.x][end.y]);
				return;
			}
			
			for(int i=0;i<8;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				if(nx<0||nx>=l||ny<0||ny>=l) continue;
				
				if(!visited[nx][ny]) {
					visited[nx][ny]=true;
					q.offer(new Knight(nx, ny));
					arr[nx][ny]=arr[x][y]+1;
				}
			}
		}
		 
	}
}

class Knight{
	int x;
	int y;
	
	public Knight(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
