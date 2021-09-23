package Level3;

import java.util.*;
public class 루머3 {

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
	
	public static int[] solution(int n, int[][]adj, int m, int[] first) {
		int[] answer=new int[n];
		int[] turn=new int[n];
		Queue<Integer> q=new LinkedList<>();
		for(int i=0;i<n;i++)
			answer[i]=-1;
		for(int i=1;i<=n;i++)
			turn[i-1]=adj[i].length/2;
		
		for(int f:first) {
			q.offer(f);
			answer[f-1]=0;
		}
		
		
		while(!q.isEmpty()) {
			int temp=q.poll();
			
			for(Integer next:adj[temp]) {
				if(next==0) continue;
				
				turn[next-1]-=1;
				if(turn[next-1]<=0&&answer[next-1]==-1) {
					q.offer(next);
					answer[next-1]=answer[temp-1]+1;
				}
			}
		}
		
		return answer;
	}
}
