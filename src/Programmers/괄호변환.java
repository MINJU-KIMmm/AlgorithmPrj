package Level2;

public class 괄호변환 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("()))((()"));
	}
	
	public static String solution(String p) {
		String answer="";
		if(p.length()==0)
			return "";
		if(right(p)) {
			return p;
		}
		
		String u="";
		int u1=0, u2=0;
		int idx=0;
		do {
			if(p.charAt(idx)=='(') {
				u+="(";
				u1++;
				idx++;
			}
			else if(p.charAt(idx)==')') {
				u+=")";
				u2++;
				idx++;
			}
		}while(u1!=u2);
		
		
		String v="";
		v+=p.substring(idx);
		
		String tmp="";
		if(right(u)) {
			u+=solution(v);
			answer+=u;
		}
		else {
			tmp+="(";
			tmp+=solution(v);
			tmp+=")";
			String new_u="";
			String new_u2="";
			if(u.length()<=2)
				new_u="";
			else {
				new_u=u.substring(1, u.length()-1);
				for(int i=0;i<new_u.length();i++) {
					if(new_u.charAt(i)=='(')
						new_u2+=")";
					else
						new_u2+="(";
				}
			}
		
			tmp+=new_u2;
			answer+=tmp;
		}
		
		return answer;
	}
	
	public static boolean right(String p) {
		boolean b=true;
		int sum=0;
		for(int i=0;i<p.length();i++) {
			if(sum<0)
				return false;
			char c=p.charAt(i);
			if(c=='(')sum++;
			else if(c==')')sum--;
		}
		
		return b;
	}
}
