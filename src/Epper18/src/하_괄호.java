
public class 하_괄호 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String[] solution(int T, String[] inputs) {
		String answer[]=new String[T];
		
		for(int i=0;i<T;i++) {
			String str=inputs[i];
			
			boolean flag=check(str);
			if(flag) answer[i]="YES";
			else answer[i]="NO";
		}
		return answer;
	}
	
	static boolean check(String str) {
		int sum=0;
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			
			if(c=='(') sum++;
			else sum--;
			
			if(sum<0) return false;
		}
		
		if(sum>0) return false;
		
		return true;
	}
}
