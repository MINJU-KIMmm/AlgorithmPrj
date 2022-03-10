package EPPER18;

import java.io.*;
import java.util.*;
public class 중_뱀 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		int k=Integer.parseInt(br.readLine());
		int[][] apple=new int[k][2];
		
		for(int i=0;i<k;i++) {
			String input=br.readLine()	;
			StringTokenizer st=new StringTokenizer(input);
			apple[1][0]=Integer.parseInt(st.nextToken());
			apple[i][1]=Integer.parseInt(st.nextToken());
		
		}
		int l=Integer.parseInt(br.readLine());
		String[][]rotation=new String[l][2];
		for(int i=0;i<l;i++) {
			String input=br.readLine();
			StringTokenizer st=new StringTokenizer(input);
			rotation[i][0]=st.nextToken();
			rotation[i][1]=st.nextToken();
		}
		
		int answer=solution(n,k,l,apple,rotation);
		System.out.println(answer);
	}
	
	static int playGame(int n, int[][] board, HashMap<Integer, String> cmd) {
		int[] dx= {0,-1,0,1};
		int[] dy= {1,0,-1,0};
		int t=0, head=0;
		
		Deque<Integer> snakeX=new ArrayDeque<>();
		Deque<Integer> snakeY=new ArrayDeque<>();
		snakeX.addFirst(0);
		snakeY.addFirst(0);
		board[0][0]=1;
		
		while(true) {
			t++;
			int nx=snakeX.getFirst()+dx[head];
			int ny=snakeY.getFirst()+dy[head];
			
			if(nx<0||nx>=n||ny<0||ny>=n||board[nx][ny]==1) break;
			
			if(board[nx][ny]!=2) {
				board[snakeX.pollLast()][snakeY.pollLast()]=0;
			}
			
			snakeX.addFirst(nx);
			snakeY.addFirst(ny);
			board[nx][ny]=1;
			
			if(Objects.equals(cmd.get(t), "L")) head=(head+1)%4;
			if(Objects.equals(cmd.get(t), "D")) head=(head+3)%4;
		}
		return t;
	}
	
	static int solution(int n, int k, int l, int[][]apple, String[][]rotation) {
		int[][] board=new int[n][n];
		HashMap<Integer, String>cmd=new HashMap<>();
		for(int i=0;i<k;i++) {
			board[apple[i][0]-1][apple[i][1]-1]=2;
		}
		
		for(int i=0;i<l;i++) {
			cmd.put(Integer.parseInt(rotation[i][0]), rotation[i][1]);
		}
		
		int answer=playGame(n,board, cmd);
		return answer;
	}

}
