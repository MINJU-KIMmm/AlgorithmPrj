package Ch3_DfsBfs;

public class Q18_괄호변환 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("()))((()"));
	}
	
	public static String solution(String p) {
		String answer="";
		if(p.length()==0) return answer;
		
		if(check(p)) return p;
		
		String[] uv=makeU(p);
		String u=uv[0];
		String v=uv[1];
		
		String temp="";
		if(check(u)) {
			u+=solution(v);
			answer+=u;
		}else {
			temp+='(';
			temp+=solution(v);
			temp+=')';
			u=u.substring(1, u.length()-1);
			for(int i=0;i<u.length();i++) {
				if(u.charAt(i)=='(') temp+=')';
				else temp+='(';
			}
			
			answer+=temp;
		}
		
		return answer;
	}
	
	public static String[] makeU(String p) {
		int sum=0;
		String u="";
		u+=p.charAt(0);
		if(p.charAt(0)=='(') sum++;
		else sum--;
		
		int i=1;
		for(i=1;i<p.length();i++) {
			if(sum==0) break;
			
			if(p.charAt(i)=='(') sum++;
			else sum--;
			
			u+=p.charAt(i);
		}
		
		String v=p.substring(i);
		
		return new String[] {u,v};
		
	}
	public static boolean check(String p) {
		int sum=0;
		
		for(int i=0;i<p.length();i++) {
			if(sum<0) return false;
			if(p.charAt(i)=='(') sum++;
			else sum--;
		}
		
		return true;
	}
}
