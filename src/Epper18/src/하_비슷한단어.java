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
		
		count(start, startAlpha);
		
		for(int i=1;i<n;i++	) {
			int diff=0;
			Arrays.fill(otherAlpha, 0);
			count(words[i], otherAlpha);
			
			for(int j=0;j<26;j++) {
				diff+=Math.abs(otherAlpha[i]-startAlpha[i]);
			}
			
			if(diff==0||diff==1||diff==2&&words[i].length()==start.length()) answer++;
			
		}
		
		return answer;
	}
	
	static void count(String str, int[] alpha	) {
		for(int i=0;i<str.length();i++) {
			alpha[str.charAt(i)-'A']++;
		}
	}
}
