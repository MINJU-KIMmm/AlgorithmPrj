import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class No2667_apartNum_bfs {
	static int dx[]= {-1, 0, 1, 0};
	static int dy[]= {0, -1, 0, 1};
	static int [] address=new int[25*25];
	static int n;
	static int apartNum=0;
	static boolean[][] visited; //방문
	static int[][] arr;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		
		arr=new int[n][n];
		visited=new boolean[n][n];
		
		//사각형 입력
		for(int i=0;i<n;i++) {
			String input=sc.next();
			for(int j=0;j<n;j++) {
				arr[i][j]=input.charAt(j)-'0';
				visited[i][j]=false;
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]==1&&!visited[i][j]) {
					apartNum++;
					bfs(i,j);
				}
			}
		}
		
		Arrays.sort(address);
		System.out.println(apartNum);
		for(int i=0;i<address.length;i++) {
			if(address[i]!=0)
				System.out.println(address[i]);
		}

	}
	
	public static void bfs(int x, int y) {
		Queue<Point>q=new LinkedList<>();
		q.add(new Point(x,y));
		visited[x][y]=true;
		address[apartNum]++;
		
		while(!q.isEmpty()) {
			Point p=q.poll();
			int px=p.x;
			int py=p.y;
			
			for(int i=0;i<4;i++) {
				int nextX=px+dx[i];
				int nextY=py+dy[i];
				
				if(nextX<0||nextY<0||nextX>=n||nextY>=n)
					continue;
				if(visited[nextX][nextY]||arr[nextX][nextY]==0)
					continue;
				
				q.add(new Point(nextX, nextY));
				visited[nextX][nextY]=true;
				address[apartNum]++;
			}
		}
	}

}

class Point{
	int x, y;
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
}