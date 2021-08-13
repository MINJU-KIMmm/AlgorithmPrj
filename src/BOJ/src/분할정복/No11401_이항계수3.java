package 분할정복;

import java.util.Scanner;
public class No11401_이항계수3 {
	
	//a%p의 역원은 a^(p-2)%p
	public static long r=1000000007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		long N=sc.nextLong();
		long K=sc.nextLong();
		
		long nFact=fact(N);
		long kFact=fact(K);
		long nkFact=fact(N-K);
		
		long calc=kFact*nkFact%r;
		
		System.out.println(nFact*solution(calc, r-2)%r);
	}
	
	public static long solution(long base, long expo) {
		if(expo==1)
			return base%r;
		
		long half=solution(base, expo/2);
		if(expo%2==1)
			return (half*half%r)*base%r;
		else
			return half*half%r;
		
	}
	
	public static long fact(long N) {
		long ans=1L;
		for(int i=2;i<=N;i++) {
			ans=(ans*i)%r;
		}
		
		return ans;
	}
}
