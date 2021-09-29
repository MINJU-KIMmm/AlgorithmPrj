package 이분탐색;

import java.util.*;
public class No1300_K번째수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();
		
		long left=1;
		long right=K;
		long key=0;
		long mid;
		
		//이분탐색 
		while(left<=right){
			mid=(left+right)/2;
			long cnt=0;
			
			//mid보다 작거나 같은 수 계산(mid가 몇번째 위치에 속하는 수인지 알기 위해) 
			for(int i=1;i<=N;i++)
				cnt+=Math.min(mid/i, N); //mid/i는 항상 N보다 작거나 같음 
			
			if(cnt<K) {
				left=mid+1;
			}else {
				right=mid-1;
				key=mid;
			}
		}
		
		System.out.println(key);
	}
	
	

}
