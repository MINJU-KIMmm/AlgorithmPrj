package Level2;
import java.io.*;

public class E15No5_문자열압축 {

	static String solution(String input){
		String answer="";
		//코드를 작성해주세요
		char c='A';
		if(input.charAt(0)=='1')
			answer+="1";
		
		for(int i=1;i<input.length();i++) {
			if(input.charAt(i)!=input.charAt(i-1)) {
				answer+=Character.toString(c);
				c='A';
			} else {
				c++;
			}
		}
		
		answer+=Character.toString(c);
		return answer;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		String answer= solution(input);
		
		System.out.println(answer);
	}
}
