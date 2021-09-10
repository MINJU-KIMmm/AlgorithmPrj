package Level2;

import java.util.*;
public class 문자열압축 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		String input=sc.next();
		System.out.println(solution(input));
	}

	public static String solution(String input) {
		String answer="";
		//첫문자 
		char first=input.charAt(0);
		if(first=='1') {
			answer+="1";
		}
		
		int cnt=(int)'A';
		for(int i=1;i<input.length();i++) {
			char before=input.charAt(i-1);
			char cur=input.charAt(i);
			
			if(before==cur) {
				cnt++;
			} else {
				answer+=(char)cnt;
				cnt=(int)'A';
			}
		}
		
		answer+=Character.toString(cnt);
		
		return answer;
	}
}
