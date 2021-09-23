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
		String str="";
		if(input.charAt(0)=='1') str+=1;
		
		int cnt=(int)'A';
		for(int i=0;i<input.length()-1;i++) {
			char cur=input.charAt(i);
			char next=input.charAt(i+1);
			
			if(cur==next) {
				cnt++;
			} else {
				str+=(char)cnt;
				cnt=(int)'A';
			}
		}
		
		str+=(char)cnt;
		
		return str;
	}
}
