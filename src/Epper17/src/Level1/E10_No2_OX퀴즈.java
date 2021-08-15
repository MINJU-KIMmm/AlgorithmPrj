package Level1;

import java.util.*;
public class E10_No2_OX퀴즈 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		
		System.out.println(solution(str));
	}
	
	static int solution(String str) {
		int cnt=0;
		int sum=0;
		
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			if(c=='O') {
				cnt++;
				sum+=cnt;
			} else {
				cnt=0;
			}
		}
				
		return sum;
	}
}
