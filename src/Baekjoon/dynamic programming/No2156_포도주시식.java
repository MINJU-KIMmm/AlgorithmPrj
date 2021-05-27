
public class 포도주시식 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] {6, 10, 13, 9, 8, 1}));
	}
	
	public static int solution(int[]arr) {
		int[]dp=new int[arr.length];
		int N=arr.length;
		
		if(N>=1)
			dp[0]=arr[0];
		if(N>=2)
			dp[1]=arr[0]+arr[1];
		if(N>=3)
			dp[2]=Math.max(dp[1], Math.max(dp[0]+arr[2], arr[1]+arr[2]));
		
		for(int i=3;i<N;i++) {
			dp[i]=Math.max(dp[i-1], Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i-1]+arr[i]));
		}
		
		return dp[N-1];
	}
}
