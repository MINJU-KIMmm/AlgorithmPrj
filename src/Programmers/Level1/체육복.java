package Level1;

import java.util.*;

public class 체육복 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(5, new int[]{2,3, 4}, new int[]{1,3,5}));
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = n-lost.length;
		
		//여분 있지만 잃어버린 경우
		for(int i=0;i<lost.length;i++) {
			for(int j=0;j<reserve.length;j++) {
				if(lost[i]==reserve[j]) {
					answer++;
					lost[i]=reserve[j]=-1;
					break;
				}
			}
		}
		
		for(int i=0;i<lost.length;i++) {
			for(int j=0;j<reserve.length;j++) {
				if(lost[i]==reserve[j]-1||lost[i]==reserve[j]+1) {
					answer++;
					reserve[j]=-1;
					break;
				}
			}
		}
		return answer;
	}
}
