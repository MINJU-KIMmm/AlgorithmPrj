package Level1;

import java.util.*;

public class OX퀴즈 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		System.out.println(solution(str));
	}

	public static int solution(String str) {
		int answer=0;
		int temp=0;
		
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			
			if(c=='O') {
				temp++;
				answer+=temp;
			}else {
				temp=0;
			}
	
		}
		
		return answer;
	}
}
