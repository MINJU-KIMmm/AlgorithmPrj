package Ch2_Implementation;

import java.util.*;
import java.io.*;

public class Q11_뱀 {
	static int[] dx= {0, 1, 0, -1};
	static int[] dy= {1, 0, -1, 0};
	static int N;
	static ArrayList<position> snake=new ArrayList<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		N=Integer.parseInt(br.readLine());
		int K=Integer.parseInt(br.readLine());
		
		int[][] arr=new int[N][N];
		
		for(int i=0;i<K;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			arr[x-1][y-1]=1;
			
		}
		
		int L=Integer.parseInt(br.readLine());
		Map<Integer, String> rotate=new HashMap<>();
		for(int i=0;i<L;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int time=Integer.parseInt(st.nextToken());
			String turn=st.nextToken();
			
			rotate.put(time, turn);
		}
		
		
		int time=0;
		int dir=0;
		int x=0;
		int y=0;
		
		int idx=0;

		snake.add(new position(0,0));
		
		while(true) {
			time++;
			int nx=x+dx[dir];
			int ny=y+dy[dir];
			
			if(check(nx, ny)) break;
			
			if(arr[nx][ny]==1) {
				arr[nx][ny]=0;
				snake.add(new position(nx, ny));
			}else {
				snake.add(new position(nx, ny));
				snake.remove(0);
			}
			
			x=nx;
			y=ny;
			
			if(rotate.containsKey(time)) {
				String d=rotate.get(time);
				dir=rotateDir(dir, d);
				
			}
		}
		
		System.out.println(time);
	}
	
	static int rotateDir(int cur, String dir) {
		int next=cur;
		if(dir.equals("D")) {
			next+=1;
			if(next>=4) {
				next=0;
			}
		}else {
			next-=1;
			if(next<0) {
				next=3;
			}
		}
		
		return next;
	}
	
	static boolean check(int x, int y) {
		if(x<0||x>=N||y<0||y>=N) return true;
		
		for(int i=0;i<snake.size();i++) {
			position p=snake.get(i);
			if(p.x==x&&p.y==y) return true;
		}
		
		return false;
	}

}

class position{
	int x;
	int y;
	
	public position(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
