import java.util.*;
public class 하_비슷한단어 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int solution(int n, String[] words) {
		int answer=0;
		
		String start=words[0];
		int[] startAlpha=new int[26];
		int[] otherAlpha=new int[26];
		
		count(startAlpha, start);
		
		int cnt=0;
		
		for(int i=1;i<words.length;i++) {
			cnt=0;
			Arrays.fill(otherAlpha, 0);
			count(otherAlpha, words[i]);
			
			for(int j=0;j<26;j++) {
				cnt+=Math.abs(startAlpha[j]-otherAlpha[j]);
			}
			
			if(cnt==0||cnt==1||cnt==2&&words[i].length()==start.length()) answer++;
		}
		
		return answer;
	}
	
	static void count(int[]alpha, String word) {
		for(int i=0;i<word.length();i++) {
			alpha[word.charAt(i)-'A']++;
		}
	}
}
