package 이분탐색;

import java.util.*;
public class No2110_공유기설치 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int C=sc.nextInt();
		
		int[] x=new int [N];
		for(int i=0;i<N;i++) {
			x[i]=sc.nextInt();
		}
		Arrays.sort(x);
		
		int right=x[N-1]-x[0]; //가능한 최대 거리 
		int left=1; //가능한 최소 거리 
		int mid=0;
		int d=0; //거리 계산 
		int ans=0;
		
		while(left<=right) {
			mid=(right+left)/2; // 비교 기준 
			int start=x[0];
			int cnt=1; // 설치 되는 공유기 개수 
			
			for(int i=0;i<N;i++	) {
				d=x[i]-start; //거리계산 
				if(d>=mid) { //공유기 설치 가능 여부 체크 
					cnt++;
					start=x[i];
				}
			}
			
			//공유기 수를 줄여야한다면 간격을 늘림 
			if(cnt>=C) {
				ans=mid;
				left=mid+1;
			}
			//공유기 수를 늘려야한다면 간격을 줄임 
			else {
				right=mid-1;
			}
		}
		
		System.out.println(ans);
	}

}
