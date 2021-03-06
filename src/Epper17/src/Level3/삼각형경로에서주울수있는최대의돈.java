package Level3;

import java.util.*;
public class 삼각형경로에서주울수있는최대의돈 {
	
	static long arr[][];
	static long dp[][];
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		arr=new long[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<=i;j++) {
				arr[i][j]=sc.nextLong();
			}
		}
		
		System.out.println(solution(N));
	}
	
	static long solution(int n) {
		long answer=0;
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<=i;j++) {
				if(j==0) arr[i][j]=arr[i][j]+arr[i-1][j];
				else if(i==j) arr[i][j]=arr[i][j]+arr[i-1][j-1];
				else arr[i][j]=arr[i][j]+Math.max(arr[i-1][j], arr[i-1][j-1]);
				
				answer=Math.max(answer, arr[i][j]);
			}
		}
		
		return answer;
	}

}
