package Level1;

import java.util.*;
public class 예산 {
	
	public static int cnt=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] {1,3,2,5,4}, 9));
	}
	//1 2 3 4 5 
	public static int solution(int[] d, int budget) {
		int answer=0;
		Arrays.sort(d);
		int sum=0;
		
		for(int num:d) {
			sum+=num;
			if(sum>budget) {
				return answer;
			}
			else 
				answer++;
		}
		
		return answer;
	}
	
}
