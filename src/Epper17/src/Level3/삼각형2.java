package Level3;

import java.util.*;
public class 삼각형2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		long[][] arr=new long[n][n];
		long[][] dp=new long[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				arr[i][j]=sc.nextLong();
			}
		}
		
		long answer=solution(n, arr);
		System.out.println(answer);
	}

	public static long solution(int n, long[][] arr) {
		long answer=0;
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<=i;j++) {
				if(j==0) arr[i][j]=arr[i][j]+arr[i-1][j];
				else if(i==j) arr[i][j]=arr[i][j]+arr[i-1][j-1];
				else arr[i][j]=Math.max(arr[i][j]+arr[i-1][j-1], arr[i][j]+arr[i-1][j]);
				
				answer=Math.max(answer, arr[i][j]);
			}
		}
		
		return answer;
	}
}
