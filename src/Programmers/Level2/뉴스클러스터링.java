package Level2;

import java.util.*;

public class 뉴스클러스터링 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("aa1+aa2", "AAAA12"));
	}

	public static int solution(String str1, String str2) {
		int answer = 0;

		ArrayList<String> s1 = new ArrayList<>();
		ArrayList<String> s2 = new ArrayList<>();
		
		str1=str1.toLowerCase();
		str2=str2.toLowerCase();

		for (int i = 0; i < str1.length() - 1; i++) {
			char c1=str1.charAt(i);
			char c2=str1.charAt(i+1);
			if(Character.isAlphabetic(c1)&&Character.isAlphabetic(c2)) {
				s1.add(c1+""+c2);
			}
		}

		for (int i = 0; i < str2.length() - 1; i++) {
			char c1=str2.charAt(i);
			char c2=str2.charAt(i+1);
			if(Character.isAlphabetic(c1)&&Character.isAlphabetic(c2)) {
				s2.add(c1+""+c2);
			}
		}	
		
		ArrayList<String> inter=new ArrayList<>();
		ArrayList<String> union=new ArrayList<>();
		
		//합집합
		for(int i=0;i<s1.size();i++) {
			union.add(s1.get(i));
		}
		for(int i=0;i<s2.size();i++) {
			union.add(s2.get(i));
		}
		
		int union_size=s1.size()+s2.size();
		
		//교집합
		int inter_size=0;
		Collections.sort(union);
		Collections.sort(s1);
		Collections.sort(s2);
		int idx=0;
		int s1_idx=0;
		int s2_idx=0;
		
		while(s1_idx<s1.size()&&s2_idx<s2.size()&&idx<union.size()) {
			if(s1.get(s1_idx).equals(union.get(idx))&&s2.get(s2_idx).equals(union.get(idx))) {
				inter_size++;
				s1_idx++;
				s2_idx++;
				idx++;
			}
			else if(s1.get(s1_idx).equals(union.get(idx))&&!s2.get(s2_idx).equals(union.get(idx))) {
				s1_idx++;
				idx++;
			}
			else if(!s1.get(s1_idx).equals(union.get(idx))&&s2.get(s2_idx).equals(union.get(idx))) {
				s2_idx++;
				idx++;
			}
			else
				idx++;
		}
		
		union_size-=inter_size;
		if(union_size==0) answer=65536;
		else answer=inter_size*65536/union_size;
		return answer;
	}
	
}
