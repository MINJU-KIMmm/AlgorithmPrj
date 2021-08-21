package 이분탐색;

import java.util.*;
import java.io.*;
public class No2805_나무자르기 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		int[] arr=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		long left=0;
		long right=arr[N-1];
		long mid=0;
		
		while(left<=right) {
			mid=(left+right)/2;
			
			long sum=0;
			for(int i=0;i<arr.length;i++) {
				long cut=arr[i]-mid;
				if(cut>0) {
					sum+=cut;
				}
			}
			
			if(sum<M) {
				right=mid-1;
			} else {
				left=mid+1;
			}
		}
		
		System.out.println(right);
	}

}
