package Level2;

public class _124나라의숫자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(1));
	}
	
	public static String solution(int n) {
		String answer="";
		String []nums= {"4","1", "2"};
		StringBuilder sb=new StringBuilder();
		
		while(n>0) {
			sb.append(nums[n%3]);
			n=(n-1)/3;
		}
		
		sb.reverse();
		
		answer=sb.toString();
		return answer;
	}
}
