package Level1;

import java.util.*;

public class 삼진법뒤집기 {
	public static void main(String[] args) {
		System.out.println(solution(45));
	}

	public static int solution(int n) {
		int answer = 0;
		ArrayList<Integer> arr = new ArrayList<>();

		// 45 3*15 + 0
		// 15 3*5 +0
		// 5 3*1 +2
		// 1 3*0 +1
		while (n > 0) {
			arr.add(n % 3);
			n /= 3;
		}

		int exp = arr.size()-1;
		for(int i:arr) {
			answer+=(i*Math.pow(3, exp));
			exp--;
		}
		return answer;
	}

}
