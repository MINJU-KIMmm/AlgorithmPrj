package Level1;

import java.util.*;
public class 로또의최고순위와최저순위 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] answer=solution(new int[] {44,1,0,0,31,25}, new int[] {31,10, 45, 1, 6, 19});
		
		System.out.println(answer[0]);
		System.out.println(answer[1]);
	}
	
	public static int[] solution(int[] lottos, int[] win_nums) {
		int cnt=0;
		int zeroCnt=0;
		
		for(int l:lottos) {
			if(l==0) zeroCnt++;
			else {
				for(int w:win_nums) {
					if(l==w) {
						cnt++;
						break;
					}
				}
			}
		}
		
		int[]answer=new int[2];
		answer[0]=Math.min(6, 7-(cnt+zeroCnt));
		answer[1]=Math.min(6, 7-cnt);
		
		return answer;
	}
}
