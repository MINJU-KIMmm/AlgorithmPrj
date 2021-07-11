package 정수론및조합론;

import java.util.*;
public class No1037_약수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int[] nums=new int[N];
		
		for(int i=0;i<N;i++)
			nums[i]=sc.nextInt();
		
		Arrays.sort(nums);
		
		int ans=nums[0]*nums[N-1];
		
		System.out.println(ans);
	}

}
