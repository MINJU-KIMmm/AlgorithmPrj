package Level2;

import java.util.*;
public class 더맵게 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] {1,2,3,9,10,12}, 7));
	}
	
	public static int solution(int[] scoville, int K) {
		int answer=0;
		
		PriorityQueue<Integer>heap=new PriorityQueue<>();
		for(int s:scoville) {
			heap.offer(s);
		}
		
		while(heap.peek()<K) {
			if(heap.size()<2)return -1;
			int t1=heap.poll();
			int t2=heap.poll();
			
			int newSco=t1+2*t2;
			heap.offer(newSco);
			answer++;
		}
		
		
		return answer;
	}
}
