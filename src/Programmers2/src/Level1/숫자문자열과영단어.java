package Level1;
import java.util.*;
public class 숫자문자열과영단어 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("one4seveneight"));
	}
	
	public static int solution(String s) {
		int answer=0;
		StringBuilder sb=new StringBuilder();
		String ans_str="";
		
		String[] words= {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		ArrayList<String> arr=new ArrayList<>();
		for(String word:words) {
			arr.add(word);
		}
		
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			
			//숫자 자체인 경우 (0~9)
			if(c>='0'&&c<='9') {
				ans_str+=c;
				continue;
			}
			
			//알파벳인 경우 
			sb.append(c);
			String str=sb.toString();
			if(arr.contains(str)) { //준비해둔 알파벳숫자의 배열에 속하는 경우 
				int index=arr.indexOf(str); //인덱스값과 알파벳숫자의 숫자값이 같으므로 indexOf을 사용 
				ans_str+=Integer.toString(index);
				sb=new StringBuilder(); //댜음 글자를 위한 StringBuilder 초기화 
			}
			
		}
		
		answer=Integer.parseInt(ans_str);
		return answer;
	}
	
	//다른사람 풀이 
	//replaceAll을 쓰면 한번에 바꿀 수 있다.
}
