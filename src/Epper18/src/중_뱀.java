import java.util.*;
public class 중_뱀 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int playGame(int[][]board, HashMap<Integer,String>cmd, int n) {
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
	static int play(int[][] board, HashMap<Integer, String>cmd, int n) {
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
			
			if(board[nx][ny]!=2) board[snakeX.pollLast()][snakeY.pollLast()]=0;
			
			snakeX.addFirst(nx);
			snakeY.addFirst(ny);
			board[nx][ny]=1;
			
			if(Objects.equals(cmd.get(t),"L"))head=(head+1)%4;
			if(Objects.equals(cmd.get(t),"D"))head=(head+3)%4;
		}
		
		return t;
	}
	static int solution(int n, int k, int l, int[][]apple, String[][]rotation) {
		HashMap<Integer, String>cmd=new HashMap<>();
		int[][] board=new int[n][n];
		for(int i=0;i<k;i++) {
			board[apple[i][0]-1][apple[i][1]-1]=2;
		}
		
		for(int i=0;i<l;i++) {
			cmd.put(Integer.parseInt(rotation[i][0]), rotation[i][1]);
		}
		
		int answer=play(board,cmd,n);
		
		return answer;
	}
}
