package Level3;

//bfs이용 

import java.util.*;
public class B19538_루머 {

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
		int[] turn=new int[N]; //몇명이상이 감염되어야 i번 사람이 감염되는지 -> turn[i]의 값이 0 이하일 때 감염
		
		Queue<Integer>q=new LinkedList<>();
		
		//answer 배열을 -1로 초기화 (처음 감염된 것인지 아닌지 구분하기 위함)
		for(int i=0;i<N;i++) {
			answer[i]=-1;
		}
		//최초생성자 처리 
		for(int t:firstInfected) {
			q.offer(t);
			answer[t-1]=0;
		}
		
		//몇명이상이 감염되어야 i번 사람이 감염되는지계산 
		for(int i=1;i<=N;i++) {
			turn[i-1]=adj[i].length/2;
		}
		
		while(!q.isEmpty()) {
			int temp=q.poll();
			
			for(Integer next : adj[temp]) {
				if(next==0)continue;
				
				//감염까지 남은 사람 빼줌 
				turn[next-1]-=1; //리턴배열은 0부터 사용하므로 1번 사람을 0번으로 저장하기 위해 인덱스 조정
				//answer[i]가 -1(새로 감염)이고 turn[i]가 0이하일 때
				if(answer[next-1]==-1&& turn[next-1]<=0) {
					q.offer(next);
					answer[next-1]=answer[temp-1]+1;
				}
			}
		}
		
		return answer;
	}
	
}
