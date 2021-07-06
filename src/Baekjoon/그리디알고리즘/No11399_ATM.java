package 그리디알고리즘;

import java.util.*;
public class No11399_ATM {
	static int[] time;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		time=new int[N];
		for(int i=0;i<N;i++)
			time[i]=sc.nextInt();
		
		Arrays.sort(time);
		
		int sum=0;
		int ans=0;
		for(int i=0;i<N;i++) {
			sum+=time[i];
			ans+=sum;
		}
		
		System.out.println(ans);
	}

}
