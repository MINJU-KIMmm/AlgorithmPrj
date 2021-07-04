package 그리디알고리즘;

import java.util.Scanner;
public class No11047_동전0 {

	static int[]value;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int K=sc.nextInt();
		
		value=new int[N];
		for(int i=0;i<N;i++)
			value[i]=sc.nextInt();
		
		int cnt=0;
		int idx=N-1;
		while(K>0) {
			while(K>=value[idx]) {
				K-=value[idx];
				cnt++;
			}
			idx--;
		}
		
		System.out.println(cnt);
	}

}
