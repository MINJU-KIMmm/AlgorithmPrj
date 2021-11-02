package Level1;

public class 약수와개수와덧셈 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(24, 27));
	}
	
	//i%Math.sqrt(i)==0 을 이용하면 더 쉽게 풀 수 있다.

	public static int solution(int left, int right) {
		int answer=0;
		for(int i=left;i<=right;i++) {
			if(check(i)) answer+=i;
			else answer-=i;
		}
		
		return answer;
	}
	
	static boolean check(int num) {
		boolean flag=true;
		for(int i=1;i<=num;i++) {
			if(i*i==num) {
				flag=false;
				break;
			} else if(i*i>num) {
				break;
			}
		}
		
		return flag;
	}
}	
