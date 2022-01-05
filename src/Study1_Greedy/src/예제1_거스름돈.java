import java.util.*;
import java.io.*;
public class 예제1_거스름돈 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
//		<책 답안>
		int count=0;
		int[] coins= {500, 100, 50, 10}; // 큰 단위의 화폐부터 차례대로 확인 
		
		for(int coin:coins) {
			count+=N/coin;
			N%=coin;
		}
		
		System.out.println(count);
		
//		<내 답안>
//		int cnt=0;
//		while(N>0) {
//			if(N>=500) {
//				cnt+=(N/500);
//				N%=500;
//			}
//			
//			if(N>=100) {
//				cnt+=(N/100);
//				N%=100;
//			}
//			
//			if(N>=50) {
//				cnt+=(N/50);
//				N%=50;
//			}
//			
//			if(N>=10) {
//				cnt+=(N/10);
//				N%=10;
//			}
//		}
//		
//		System.out.println(cnt);
	}

}
