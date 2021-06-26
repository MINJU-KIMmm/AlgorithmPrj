package Level2;

import java.util.*;
public class 가장큰수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public static String solution(int[] numbers) {
		String answer="";
		String[] strNum=new String[numbers.length];
		
		for(int i=0;i<numbers.length;i++) {
			strNum[i]=Integer.toString(numbers[i]);
		}
		
		Arrays.sort(strNum, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return (o2+o1).compareTo(o1+o2);
			}
			
		});
		
		for(int i=0;i<strNum.length;i++)
			answer+=strNum[i];
		
		if(answer.startsWith("0"))
			answer="0";
		
		return answer;
	}
}
