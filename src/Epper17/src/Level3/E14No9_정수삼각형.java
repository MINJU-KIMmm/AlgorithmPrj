package Level3;
import java.util.Scanner;
public class E14No9_정수삼각형 {
	
	static int[][]dp;
	static int[][]arr;
	static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		dp=new int[n][n];
		arr=new int[n][n];
		
		//삼각형 입력 
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		//dp 시작점 초기화 
		for(int i=0;i<n;i++) {
			dp[n-1][i]=arr[n-1][i];
		}
		
		System.out.println(solution(0,0));
	}
	
	static int solution(int i, int j) {
		if(i==n-1) {
			return dp[i][j];
		}
		
		if(dp[i][j]==0) {
			dp[i][j]=arr[i][j]+Math.max(solution(i+1, j+1), solution(i+1, j));
		}
		
		return dp[i][j];
	}

}
