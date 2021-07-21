package 정수론및조합론;

import java.util.Scanner;
public class No11050_이항계수1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int factN = fact(N);
		int factK = fact(K);
		
		int factNK = fact(N-K);
		
		int ans = factN/(factNK*factK);
		
		System.out.println(ans);
	}
	
	static int fact(int N) {
		int num=1;
		for(int i=2;i<=N;i++)
			num*=i;
		
		return num;
	}
}
