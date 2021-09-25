package DFS와BFS;

import java.util.*;
import java.io.*;
public class No7562_나이트의이동 {
	static int[] dx= {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] dy= {-1, 1, -2, 2, -2, 2, -1, 1}; 
	static int N;
	static boolean[][] visited; //방문 여부 
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//테스트 케이스 개수 입력 
		int T=Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			N=Integer.parseInt(br.readLine());
			int[][] cnt=new int[N][N]; //이동 횟수 세는 배열 
			int startX, startY, endX, endY;
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			startX=Integer.parseInt(st.nextToken());
			startY=Integer.parseInt(st.nextToken());
			
			st=new StringTokenizer(br.readLine());
			endX=Integer.parseInt(st.nextToken());
			endY=Integer.parseInt(st.nextToken());
			
			Point start=new Point(startX, startY); //시작점 
			Point end=new Point(endX, endY); //목적지 
			
			bfs(start, end, cnt); //bfs 실행 
		}

	}
	
	
	static void bfs(Point start, Point end, int[][] cnt) {
		Queue<Point> q=new LinkedList<>();
		q.offer(start); //시작점 큐에 삽입 
		visited=new boolean[N][N]; //방문 배열
		visited[start.x][start.y]=true;//시작점 방문 표시 
		
		while(!q.isEmpty()) {
			Point temp=q.poll();
			int x=temp.x;
			int y=temp.y;
			
			//temp의 x,y가 목적지의 x, y와 같다면 이동 횟수 출력 후 함수 종료 
			if(x==end.x&&y==end.y) {
				System.out.println(cnt[temp.x][temp.y]);
				return;
			}
			
			//방향에 따라(dx, dy배열) 좌표 이동 
			for(int i=0;i<8;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				//유효한 좌표인지 + 아직 방문하지 않은 좌표인지 확인 
				if(nx>=0&&nx<N&&ny>=0&&ny<N&&!visited[nx][ny]) {
					Point next=new Point(nx, ny);
					cnt[nx][ny]=cnt[x][y]+1; //이동 횟수 구하기 (이전 좌표의 횟수에 +1) 
					q.offer(next); //큐에 삽입 
					visited[nx][ny]=true; //방문 완료 표시 
				}
			}
		}
		
		
	}
}

class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
