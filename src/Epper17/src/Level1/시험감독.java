package Level1;

import java.util.Scanner;
public class 시험감독 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int[]A=new int[N];
		
		for(int i=0;i<N;i++) {
			A[i]=sc.nextInt();
		}
		
		int B=sc.nextInt();
		int C=sc.nextInt();
		
		System.out.println(solution(N, A, B, C));
	}
	
	public static long solution(int N, int[]A, int B, int C) {
		long answer=0;
		for(int i=0;i<A.length;i++) {
			A[i]-=B;
			answer++;
		}
		
		for(int i=0;i<A.length;i++) {
			if(A[i]%C==0) {
				answer+=A[i]/C;
			} else {
				answer+=A[i]/C+1;
			}
		}
		
		return answer;
	}
}
