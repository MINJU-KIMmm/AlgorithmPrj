package Level2;

public class 문자열압축 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("aabbaccc"));
	}

	public static int solution(String s) {
		int S=s.length();
		int min=1001;//return값
		
		if(S==1) return 1;
		
		//i : 문자 쪼개는 길이
		for(int i=1;i<=S/2;i++) {
			String compare="";
			String newStr="";
			int cnt=1;
						
			for(int j=0;j<S/i;j++) {
				String compareNext=s.substring(i*j, i*(j+1));
				
				if(compare.equals(compareNext)) 
					cnt++;
				else {
					if(cnt>1)
						newStr+=(cnt+compare);
					else
						newStr+=compare;
					
					compare=compareNext;
					cnt=1;
				}
			}
			
			if(cnt>1)
				newStr+=(cnt+compare);
			else
				newStr+=compare;
			
			//나머지 남았을 경우
			if(S%i!=0)
				newStr+=s.substring(S-(S%i), S);
			
			min=Math.min(newStr.length(), min);
			
		}
		
		return min;
	}

}
