package Level1;

public class 소수만들기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] {1,2,3,4}));
	}
	
	public static int solution(int [] nums) {
		int answer=0;
		
		for(int i=0;i<nums.length-2;i++) {
			for(int j=i+1;j<nums.length-1;j++) {
				for(int k=j+1;k<nums.length;k++) {
					int sum=nums[i]+nums[j]+nums[k];
					if(isPrime(sum)) {
						answer++;
					}
				}
			}
		}
		
		return answer;
	}
	
	public static boolean isPrime(int n) {
		boolean test=true;
		
		for(int i=2;i*i<=n;i++) {
			if(n>1&&n%i==0) {
				test=false;
				break;
			}
		}
		
		if(n<=1) test=false;
		
		return test;
	}
	
}
