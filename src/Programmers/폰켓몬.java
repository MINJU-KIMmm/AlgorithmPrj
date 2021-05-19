package Level1;
import java.util.*;
public class 폰켓몬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] {2,2,3,3,3,4}));
	}

	public static int solution(int[] nums) {
		int answer=0;
		int cnt=0;
		int max=nums.length/2;
		
		Arrays.sort(nums);
	
		//종류 개수 구함
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i]==nums[i+1]) {
				continue;
			}
			cnt++;
		}
		
		cnt++;
		
		if(cnt>=max) answer=max;
		else answer=cnt;
		
		return answer;
	}
}
