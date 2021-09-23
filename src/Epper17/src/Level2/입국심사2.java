package Level2;

import java.util.*;
public class 입국심사2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(6, new int[] {7,10}));

	}
	
	public static long solution(int n, int[] times) {
		long answer=Long.MAX_VALUE;
		
		long left, mid, right;
		long key=0;
		
		left=1;
		right=(long) times[times.length-1]*(long) n;
		
		while(left<=right) {
			mid=(left+right)/2;
			key=0;
			
			for(int i=0;i<times.length;i++) {
				key+=(mid/times[i]);
			}
			
			if(key>=n) {
				answer=Math.min(answer, mid);
				right=mid-1;
			}else {
				left=mid+1;
			}
		}
		
		return answer;
	}
}
