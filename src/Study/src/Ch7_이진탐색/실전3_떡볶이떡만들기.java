package Ch7_이진탐색;

import java.util.*;
import java.io.*;
public class 실전3_떡볶이떡만들기 {

	static int[] arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		arr=new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		//end 값 처음에 배열 길이로 했다가 틀림 
		System.out.println(solution(M, 0, arr[arr.length-1]));
	}
	
	
	static int solution(int target, int start, int end) {
		int answer=0;
		
		while(start<=end) {
			long total=0;
			int mid=(start+end)/2;
			for(int num:arr) {
				if(num>mid) total+=num-mid; 
			}
			
			if(total<target) {
				end=mid-1;
			}
			else {
				answer=mid;
				start=mid+1;
			}
		}
		
		return answer;
	}
}
