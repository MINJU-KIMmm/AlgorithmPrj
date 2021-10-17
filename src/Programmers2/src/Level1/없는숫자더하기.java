package Level1;

import java.util.*;
public class 없는숫자더하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] {1,2,3,4,6,7,8,0}));
	}

	public static int solution(int[] numbers) {
		int[] arr= {0,1,2,3,4,5,6,7,8,9};
		int sum=0;
		
		ArrayList<Integer> numArr=new ArrayList<>();
		for(int i=0;i<numbers.length;i++) {
			numArr.add(numbers[i]);
		}
		
		for(int i=0;i<arr.length;i++) {
			int num=arr[i];
			if(!numArr.contains(num)) {
				sum+=num;
			}
		}
		
		return sum;
	}
}
