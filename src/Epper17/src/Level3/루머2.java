package Level3;

import java.util.*;
public class 루머2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[] solution(int N, int[][] adj, int M, int[] first) {
		int[] answer=new int[N];
		int[] turn=new int[N];
		
		Queue<Integer>q=new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			answer[i]=-1;
		}
		
		for(int i=1;i<=N;i++) {
			turn[i-1]=(adj[i].length)/2;
		}
		
		for(int f:first) {
			q.offer(f);
			turn[f-1]=0;
		}
		
		while(!q.isEmpty()) {
			int current=q.poll();
			
			for(Integer next:adj[current]) {
				if(next==0)continue;
				
				turn[next-1]--;
				if(answer[next-1]==-1&&turn[next-1]<=0) {
					q.offer(next);
					answer[next-1]=answer[current-1]+1;
				}
			}
		}
		
		return answer;
		
	}
}
