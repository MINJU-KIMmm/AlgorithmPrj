package 이분탐색;
import java.util.*;

public class No1654_랜선자르기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int K=sc.nextInt();
		int N=sc.nextInt();
		int[]arr=new int[K];
		
		for(int i=0;i<K;i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		long right=arr[K-1];
		long left=1; //랜선 길이가 자연수이기 때문에 최소값을 1로 세팅해야함(0안됨) 
		long mid=0; 
		
		while(left<=right) {
			mid=(left+right)/2;
			
			long cnt=0; //자른 개수 합 
			
			for(int j=0;j<arr.length;j++) {
				cnt+=arr[j]/mid;
			}
			
			if(cnt>=N) { //구하려는 랜선보다 더 많은 랜선이 나오면 자르는 길이를 늘림 
				left=mid+1;
			} else {
				right=mid-1;
			}
		}
		
		System.out.println(right);
	}

	
}
