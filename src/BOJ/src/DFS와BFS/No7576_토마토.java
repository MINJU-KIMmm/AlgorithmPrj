package DFS와BFS;

import java.util.*;
import java.io.*;
public class No7576_토마토 {

	static int[]dx= {-1, 1, 0, 0};
	static int[]dy= {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] str=br.readLine().split(" ");
		int M=Integer.parseInt(str[0]);
		int N=Integer.parseInt(str[1]);
		
		int [][] arr=new int[N][M];
		
		for(int i=0;i<N;i++) {
			str=br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(str[j]);
			}
		}
		
		System.out.println(bfs(arr, N, M));
	}

	
	public static int bfs(int[][]arr, int N, int M) {
		Queue<int[]> q=new LinkedList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==1) {
					//익은 토마토 위치 큐에 담음 
					q.offer(new int[] {i, j});
				}
			}
		}
		
		while(!q.isEmpty()) {
			//현재 토마토좌표 
			int[] tomato=q.poll();
			int x=tomato[0];
			int y=tomato[1];
			for(int i=0;i<4;i++) {
				//다음 토마토 좌표 구하기 
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				//범위 체크 
				if(nx>=0&&nx<N&&ny>=0&&ny<M) {
					//아직 익지 않은 토마토인 경우 
					if(arr[nx][ny]==0) {
						q.offer(new int[] {nx, ny});
						//이전 토마토의 날짜에서 +1 
						arr[nx][ny]=arr[x][y]+1;
					}
				}
			}
		}
		
		int day=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				//아직도 익지 않은 토마토가 있는 경우 -1 return
				if(arr[i][j]==0) return -1;
				day=Math.max(day, arr[i][j]); //최대 일수 구하기 
			}
		}
		
		return day-1;
	}
}
