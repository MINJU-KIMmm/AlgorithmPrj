package Level3;

import java.util.*;
public class P불량사용자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[] {"fr*d*", "abc1**"}));
	}
	
	//dfs 함수 
	static HashSet<String> dfs(int b, boolean[] visited, HashSet<String>s, String[] user, String[] banned){
		if(b==banned.length) {
			String str="";
			
			for(int i=0;i<user.length;i++) {
				if(visited[i]) str+=i;
			}
			
			s.add(str);
			return s;
		}
		
		for(int i=0;i<user.length;i++) {
			if(visited[i]) continue;
			if(user[i].length()!=banned[b].length()) continue;
			
			boolean temp=true;
			for(int j=0;j<user[i].length();j++) {
				if(user[i].charAt(j)==banned[b].charAt(j)||banned[b].charAt(j)=='*') continue;
				else {
					temp=false;
					break;
				}
			}
			
			if(temp) {
				visited[i]=true;
				s=dfs(b+1, visited, s, user, banned);
				visited[i]=false;
			}
		}
		
		return s;
	}
	
	public static int solution(String[] user, String[] banned) {
		int answer=0;
		
		HashSet<String> s=new HashSet<>();
		boolean[] visited=new boolean[8];
		
		s=dfs(0, visited, s, user, banned);
		
		answer=s.size();
		
		return answer;
	}
}
