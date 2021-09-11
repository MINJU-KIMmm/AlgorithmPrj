package Level2;

import java.util.*;
//이분탐색 
public class 입국심사 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static long solution(int n, int[] times) {
		long answer=Long.MAX_VALUE;
		Arrays.sort(times);
		
		long left=1;
		long right=(long)times[times.length-1]*(long)n;
		
		long mid, key;
		
		while(left<=right) {
			mid=(left+right)/2;
			key=0; //mid 시간 동안 심사 가능한 사람 
			
			for(int i=0;i<times.length;i++) {
				key+=mid/times[i];
			}
			
			if(key>=n) {
				answer=Math.min(answer, mid);
				right=mid-1;
			}
			else {
				left=mid+1;
			}
		
		}
		
		return answer;
	}
}
