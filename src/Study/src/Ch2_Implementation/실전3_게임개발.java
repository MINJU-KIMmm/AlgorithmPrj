package Ch2_Implementation;

import java.util.*;
import java.io.*;

public class 실전3_게임개발 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		int A=Integer.parseInt(st.nextToken());
		int B=Integer.parseInt(st.nextToken());
		int d=Integer.parseInt(st.nextToken());
		
		int[][] arr=new int[N][M];
		boolean[][] visited=new boolean[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		visited[A][B]=true;
		
		int[] db= {0, 1, 0, -1}; //북동남서 
		int[] da= {-1, 0, 1, 0};
		
		int count=1;
		int turn=0;
		while(true) {
			if(--d<0) d=3; //1단계 방향회전 
			int na=A+da[d];
			int nb=B+db[d];
			
			// 회전한 이후 정면에 가보지 않은 칸이 존재하는 경우 
			if(arr[na][nb]==0&&!visited[na][nb]) {
				visited[na][nb]=true;
				count++;
				A=na;
				B=nb;
				turn=0;
				continue;
			}
			//회전한 이후 정면에 가보지 않은 칸이 없거나 바다인 경우 
			else turn++;
			
			//네 방향 모두 갈 수 없는 경우 
			if(turn==4) {
				na=A-da[d];
				nb=B-db[d];
				
				//뒤로 이동 
				if(arr[na][nb]==0) {
					A=na;
					B=nb;
				}
				//뒤로 이동할 수 없는 경우(바다)
				else break;
				
				turn=0;
			}
			
			
		}
		
		System.out.println(count);
	}

}
