package EPPER18;

import java.io.*;
import java.util.*;
public class 상_치즈 {
	
	static int[][] board;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String input=br.readLine();
		StringTokenizer st=new StringTokenizer(input);
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		board=new int[n][m];
		
		for(int i=0;i<n;i++) {
			input=br.readLine();
			st=new StringTokenizer(input);
			for(int j=0;j<m;j++) {
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int answer=solution(n,m);
		
		System.out.println(answer);
	}
	
	//외부/내부 구분(외부공기=-1)
	static void dfs(int n, int m, int x, int y) {
		if(x<0||x>=n||y<0||y>=m||board[x][y]!=0) return;
		board[x][y]=-1;
		for(int i=0;i<4;i++) {
			dfs(n,m,x+dx[i],y+dy[i]);
		}
	}
	
	//녹을 수있는 치즈인지 확인 (맞닿아 있는 면 두개이상)
	static Boolean canMelt(int x, int y) {
		int cnt=0;
		
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(board[nx][ny]==-1) cnt++;
		}
		
		return cnt>=2;
	}
	
	//녹을 치즈 리스트로 반환 
	static ArrayList<Point> findMelt(int n, int m){
		ArrayList<Point> list=new ArrayList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(board[i][j]==1&&canMelt(i,j)) {
					list.add(new Point(i,j));
				}
			}
		}
		
		return list;
	}
	
	static int solution(int n, int m) {
		int answer=0;
		dfs(n,m,0,0);
		while(true) {
			ArrayList<Point>list=findMelt(n,m);
			if(list.size()==0) break; //더이상 녹일 치즈 없음 
			
			for(int i=0;i<list.size();i++) {
				Point cheese=list.get(i);
				int x=cheese.x;
				int y=cheese.y;
				
				board[x][y]=0;//치즈 녹임 
				dfs(n,m,x,y);//영역 다시 계산 
			}
			
			answer++;
		}
		
		return answer;
	}
}

class Point{
	int x,y;
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
}