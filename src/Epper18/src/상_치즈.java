import java.util.*;
import java.io.*;

public class 상_치즈 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		board = new int[n][m];

		for (int i = 0; i < n; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = solution(n, m, board);

		System.out.println(answer);
	}
	
	static int[][] board;
	static int[]dx= {-1,1,0,0};
	static int[]dy= {0,0,-1,1};
	
	static void dfs(int x, int y, int n, int m) {
		if(x<0||x>=n||y<0||y>=m||board[x][y]!=0) return;
		
		board[x][y]=-1;
		for(int i=0;i<4;i++) {
			dfs(x+dx[i], y+dy[i], n, m);
		}
	}
	
	static Boolean canMelt(int x, int y) {
		int cnt=0;
		
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(board[nx][ny]==-1) cnt++;
		}
		
		return cnt>=2;
	}
	
	static ArrayList<Cheese> findMelt(int n, int m){
		ArrayList<Cheese> list=new ArrayList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(board[i][j]==1&&canMelt(i,j)) {
					list.add(new Cheese(i,j));
				}
			}
		}
		
		return list;
	}
	
	static int solution(int n, int m, int[][] bd) {
		int answer=0;
		board=bd;
		dfs(0,0,n,m);
		
		while(true) {
			ArrayList<Cheese> list=findMelt(n,m);

			if(list.size()==0) break;
			
			for(int i=0;i<list.size();i++) {
				int x=list.get(i).x;
				int y=list.get(i).y;
				
				board[x][y]=0;
				dfs(x,y,n,m);
			}
			
			answer++;
		}
		
		return answer;
	}
}

class Cheese {
	int x, y;

	public Cheese(int x, int y) {
		this.x = x;
		this.y = y;
	}
}