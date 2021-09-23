package Level3;

import java.util.*;

public class 불량사용자2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	static HashSet<String> dfs(int b, HashSet<String> s, boolean[] visited, String[] user, String[] banned){
		if(b==banned.length) {
			String str="";
			
			for(int i=0;i<user.length;i++) {
				if(visited[i]) str+=i;
			}
			
			s.add(str);
			return s;
		}
		
		for(int i=0;i<user.length;i++) {
			if(visited[i])continue;
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
				s=dfs(b+1, s, visited, user, banned);
				visited[i]=false;
			}
		}
		
		return s;
	}
	
	public static int solution(String[] user, String[] banned) {
		int answer=0;
		
		HashSet<String> s=new HashSet<>();
		boolean[] visited=new boolean[8];
		Arrays.fill(visited, false);
		
		s=dfs(0, s, visited, user, banned);
		answer=s.size();
		
		return answer;
	}
}
