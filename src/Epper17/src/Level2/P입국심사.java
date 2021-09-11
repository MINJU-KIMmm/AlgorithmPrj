package Level2;

import java.util.*;

public class P입국심사 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(6, new int[] {7,10}));
	}
	
	public static long solution(int n, int[] times) {
		long answer=0;
		Arrays.sort(times);
		
		long left, right, mid;
		long key;
		
		left=0;  
		right=(long)times[times.length-1]*n; 
		
		answer=right;
		
		while(left<=right) {
			mid=(left+right)/2;
			key=0;
			
			for(int i=0;i<times.length;i++) {
				key+=mid/times[i];
			}
			
			//받을 수 있는 사람의 수가 기다리는 수보다많은 경우 => 할당시간 줄이기 
			if(key>=n) {
				if(mid<answer) answer=mid;
				right=mid-1;
			}
			//할당 시간 내에 처리할 수 있는 사람이 기다리는 사람 수보다 적은 경우 -> 할당시간 늘리기 
			else {
				left=mid+1;
			}
		}
		
		return answer;
	}
}
