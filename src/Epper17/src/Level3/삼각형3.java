package Level3;

import java.util.*;
public class 삼각형3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[][] arr=new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<=i;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		long answer=solution(N, arr);
		System.out.println(answer);
	}

	public static long solution(int n, int[][] arr) {
		long answer=0;
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<=i;j++) {
				if(j==0) arr[i][j]=arr[i][j]+arr[i-1][j];
				else if(j==i) arr[i][j]=arr[i][j]+arr[i-1][j-1];
				else arr[i][j]=arr[i][j]+Math.max(arr[i-1][j], arr[i-1][j-1]);
				
				answer=Math.max(answer, arr[i][j]);
			}
		}
		
		return answer;
	}
}
