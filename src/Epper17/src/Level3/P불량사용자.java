package Level3;

import java.util.*;
public class P불량사용자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[] {"fr*d*", "abc1**"}));
	}
	
	//dfs 함수 
	static HashSet<String>dfs(int b, boolean[] visited, HashSet<String> s, String[] user_id, String[] banned_id){
		if(b==banned_id.length) {
			String str="";
			for(int i=0;i<user_id.length;i++)
				if(visited[i]) str+=i; //문자열 조합 생성 
			s.add(str);//중복되지 않게 문자열 조합 저장 
			return s;
		}
		
		for(int i=0;i<user_id.length;i++) {
			if(visited[i]) continue; //제재된 아이디 제외 
			if(user_id[i].length()!=banned_id[b].length()) continue; //문자열의 길이가 다르면 해당 제재 아이디와 관계 없으므로 제외.
			
			boolean temp=true;
			for(int j=0;j<user_id[i].length();j++	) {
				if(user_id[i].charAt(j)==banned_id[b].charAt(j)||banned_id[b].charAt(j)=='*') continue;
				else {
					temp=false;
					break;
				}
			}
			
			//제재사용자에 포함되는 아이디일 때 
			if(temp) {
				visited[i]=true; //응모자 아이디 사용 표시 
				s=dfs(b+1, visited, s, user_id, banned_id);
				visited[i]=false; //응모자 아이디 사용 표시 해
			}
		}
		
		return s;
		
	}
	
	static int solution(String[] user_id, String[] banned_id) {
		int answer=0;
		
		//문자열 조합을 저장할 집합 
		HashSet<String >s=new HashSet<>();
		
		//응모자 아이디 사용표시를 저장할 배열 
		boolean visited[]=new boolean[8];
		Arrays.fill(visited, false);
		
		s=dfs(0, visited, s, user_id, banned_id);
		answer=s.size(); //문자열 조합의 개수 저장
		
		return answer;
	}
}
