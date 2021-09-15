package Level3;

import java.util.*;
public class 루머 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=7;
		int [][] a = { {0}, { 2,3,0 },{ 1,3,0 },{ 1,2,4,0 },{ 3,5,0 },{ 4,0 },{ 0 },{ 0 } };
		int M=2;
		int [] first_id= {1,6};
		int[] answer;
		answer=solution(N, a, M, first_id);
		
		for(int i=0;i<answer.length;i++) {
			System.out.print(answer[i]+" ");
		}
	}
	
	public static int[] solution(int N, int[][] adj, int M, int[] firstInfected) {
		int[] answer=new int[N];
		int[] turn=new int[N];
		Queue<Integer>q=new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			answer[i]=-1;
		}
		
		for(int i=1;i<=N;i++) {
			turn[i-1]=adj[i].length/2;
		}
		
		for(int f:firstInfected) {
			q.offer(f);
			answer[f-1]=0;
		}
		
		while(!q.isEmpty()) {
			int temp=q.poll();
			
			for(Integer next:adj[temp]) {
				if(next==0) continue;
				
				turn[next-1]-=1;
				if(answer[next-1]==-1&&turn[next-1]<=0) {
					q.offer(next);
					answer[next-1]=answer[temp-1]+1;
				}
			}
		}
		
		return answer;
	}
}
