package Level2;

import java.util.*;
public class 조이스틱 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int solution(String name) {
		int answer=0;
		int len=name.length();
		
		int min=len-1; // 좌우 계산 최솟값 (왔다갔다하지 않고 그냥 쭉 가는 거)
		for(int i=0;i<len;i++) {
			char c=name.charAt(i);
			int move=(c-'A' < 'Z' - c+1)? (c-'A'):('Z'-c+1);
			
			answer+=move;
			
			int next=i+1;
			while(next<len && name.charAt(next)=='A')
				next++;
			
			//중간까지 왔다가 다시 돌아가는 게 더 빠른 경우 고려
			//i*2 : 중간까지 왔다가 다시 뒤로 돌아갈 때 조이스틱 이동 횟수
			// len - next  : A아닌 알파벳 위치 구하기 위함 
			min=Math.min(min, (i*2)+len-next);
		}
		
		answer+=min;
		
		return answer;
	}
}
