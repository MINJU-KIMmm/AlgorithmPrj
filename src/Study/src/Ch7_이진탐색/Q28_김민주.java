package Ch7_이진탐색;

import java.util.*;
import java.io.*;
public class Q28_김민주 {

	
	static int[] arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		arr=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		System.out.println(solution(0, arr.length-1));
		
	}
	
	static int solution(int start, int end) {
		
		while(start<=end) {
			int mid=(start+end)/2;
			
			if(arr[mid]==mid) {
				return mid;
			}
			else if(arr[mid]<mid) {
				start=mid+1;
			}
			else {
				end=mid-1;
			}
		}
		
		return -1;
	}

}
