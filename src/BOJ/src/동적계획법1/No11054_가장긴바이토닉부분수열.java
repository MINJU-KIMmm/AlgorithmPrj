package 동적계획법1;

import java.util.Scanner;
public class No11054_가장긴바이토닉부분수열 {
	
	static int[] A;
	static Integer[] dp1;
	static Integer[] dp2;
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		
		A=new int[N];
		dp1=new Integer[N];
		dp2=new Integer[N];
		
		for(int i=0;i<N;i++)
			A[i]=sc.nextInt();
		
		for(int i=0;i<N;i++) {
			MaxLen1(i);
			MaxLen2(i);
		}
		
		int max=-1;
		for(int i=0;i<N;i++)
			max=Math.max(dp1[i]+dp2[i], max);
		
		//기준값 원소를 중복해서 세는 경우를 방지하기 위해 -1
		System.out.println(max-1);
	}
	
	public static int MaxLen1(int n) {
		if(dp1[n]==null) {
			dp1[n]=1;
			for(int i=0;i<n;i++) {
				if(A[i]<A[n])
					dp1[n]=Math.max(dp1[n], MaxLen1(i)+1);
			}
		}
		
		return dp1[n];
	}
	
	public static int MaxLen2(int n) {
		if(dp2[n]==null) {
			dp2[n]=1;
			for(int i=n+1;i<N;i++) {
				if(A[i]<A[n])
					dp2[n]=Math.max(dp2[n], MaxLen2(i)+1);
			}
		}
		
		return dp2[n];
	}
}
