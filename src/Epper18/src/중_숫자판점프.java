import java.util.*;
import java.io.*;
public class 중_숫자판점프 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int[][] arr=new int[5][5];
		
		String[] str;
		int answer=0;
		
		for(int i=0;i<5;i++) {
			str=br.readLine().split(" ");
			for(int j=0;j<5;j++) {
				arr[i][j]=Integer.parseInt(str[j]);
			}
		}
		
		answer=solution(arr);
		System.out.println(answer);
	}
	
	static void dfs(int[][] v, int[] visited, int x, int y, int sum, int cnt) {
		int[] dx= {-1,1,0,0};
		int[] dy= {0,0,-1,1};
		
		if(cnt==5) {
			if(visited[sum]==0) visited[sum]=1;
			return;
		}
		
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(nx<0||nx>=5||ny<0||ny>=5) continue;
			
			dfs(v,visited,nx,ny,sum*10+v[nx][ny],cnt+1);
		}
		
		return;
	}
	
	static void dfs1(int[][] v, int[] visited, int x, int y, int sum, int cnt) {
		if(cnt==5) {
			if(visited[sum]==0) visited[sum]=1;
			return;
		}
		
		int[] dx= {-1,1,0,0};
		int[] dy= {0,0,-1,1};
		
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(nx<0||nx>=5||ny<0||ny>=5)continue;
			
			dfs(v,visited,nx,ny,sum*10+v[nx][ny],cnt+1);
		}
		
		return;
	}
	
	static int solution1(int[][] v) {
		int answer=0;
		
		int[] visited=new int[1000000];
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				dfs1(v,visited,i,j,v[i][j],0);
			}
		}
		
		for(int i=0;i<visited.length;i++) {
			if(visited[i]==1) answer++;
		}
		
		return answer;
	}
	
	static int solution(int[][]v) {
		int answer=0;
		
		int[] visited=new int[1000000];
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				dfs(v,visited,i,j,v[i][j],0);
			}
		}
		
		for(int i=0;i<visited.length;i++) {
			if(visited[i]==1) answer++;
		}
		
		return answer;
	}
}
