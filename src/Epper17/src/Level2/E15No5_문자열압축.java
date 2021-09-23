package Level2;
import java.io.*;

public class E15No5_문자열압축 {

	static String solution(String input){
		String answer="";
		
		if(input.charAt(0)=='1') answer+=1;
		int cnt=(int)'A';
		
		for(int i=0;i<input.length()-1;i++) {
			char current=input.charAt(i);
			char next=input.charAt(i+1);
			
			if(current!=next) {
				answer+=(char)cnt;
				cnt=(int)'A';
			} else {
				cnt++;
			}
		}
		
		answer+=(char)cnt;
		
		return answer;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		String answer= solution(input);
		
		System.out.println(answer);
	}
}
