import java.util.*;

//백준 2667 단지번호붙이기
//dfs풀이
public class No2667_apartNum_dfs {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int[] address=new int[25*25];
	static int n;
	static int apartNum=0; //단지 번호의 수
	static boolean[][]visited=new boolean[25][25];
	static int[][] arr=new int[25][25];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		arr=new int[n][n];
		visited=new boolean[n][n];
		
		//arr입력받기
		for(int i=0;i<n;i++) {
			String input=sc.next();
			for(int j=0;j<input.length();j++)
				arr[i][j]=input.charAt(j)-'0';
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]==1&&!visited[i][j]) {
					apartNum++;
					dfs(i, j);
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
	
	static void dfs(int x, int y) {
		visited[x][y]=true;
		address[apartNum]++;
		
		for(int i=0;i<4;i++) {
			int nextX=x+dx[i];
			int nextY=y+dy[i];
			
			if(nextX<0||nextY<0||nextX>=n||nextY>=n)
				continue;
			
			if(arr[nextX][nextY]==0||visited[nextX][nextY])
				continue;
			
			dfs(nextX, nextY);
		}
	}

}
