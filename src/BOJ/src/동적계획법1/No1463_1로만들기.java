package 동적계획법1;

import java.util.Scanner;
public class No1463_1로만들기 {
	static Integer[]dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		dp=new Integer[N+1];
		
		dp[0]=0;
		dp[1]=0;
		
		System.out.println(MakeOne(N));
	}

	public static int MakeOne(int i) {
		if(dp[i]==null) {
			if(i%6==0) {
				dp[i]=Math.min(MakeOne(i-1), Math.min(MakeOne(i/3), MakeOne(i/2)))+1;
			}
			else if(i%3==0) {
				dp[i]=Math.min(MakeOne(i/3), MakeOne(i-1))+1;
			}
			else if(i%2==0) {
				dp[i]=Math.min(MakeOne(i/2), MakeOne(i-1))+1;
			}
			else {
				dp[i]=MakeOne(i-1)+1;
			}
		}
		
		return dp[i];
	}
}
