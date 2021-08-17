package Level2;

import java.util.Scanner;
public class BOJ13305_주유소 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		
		long[] road=new long[N-1];
		for(int i=0;i<N-1;i++) {
			road[i]=sc.nextLong();
		}
		
		long[] price=new long[N];
		for(int i=0;i<N;i++) {
			price[i]=sc.nextLong();
		}
		
		long total=0L;
		
		int i=0;
		int j=0;
		
		while(true) {
			if(i==N-1)
				break;
			j=0;
			
			while(price[i]<=price[i+j]) {
				total+=(price[i]*road[i+j]);
				j++;
				if(i+j==N-1)
					break;
			}
			
			i+=j;
		}
		
		System.out.println(total);
	}

}
