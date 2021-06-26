package Level2;

public class 올바른괄호 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(")()"));
	}
	
	static boolean solution(String s) {
		boolean answer=true;
		char[]c=new char[s.length()];
		
		for(int i=0;i<s.length();i++) {
			c[i]=s.charAt(i);
		}
		
		int sum=0;
		for(char ch:c) {
			if(sum<0)
				return false;
			if(ch=='(')
				sum++;
			else if(ch==')')
				sum--;
		}
		
		if(sum!=0)
			return false;
		return answer;
	}
}
