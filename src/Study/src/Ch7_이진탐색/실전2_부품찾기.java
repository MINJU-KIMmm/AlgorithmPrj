package Ch7_이진탐색;

import java.util.*;
import java.io.*;
public class 실전2_부품찾기 {
	
	static int[] arr;
	static int[] request;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		arr=new int[N];
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int M=Integer.parseInt(br.readLine());
		request=new int[M];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			request[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		StringBuilder sb=new StringBuilder();
		for(int search:request) {
			if(solution(search, 0, arr.length-1)==-1)sb.append("no").append(" ");
			else sb.append("yes").append(" ");
		}
		
		System.out.println(sb);
		
		ArrayList<Integer> list=new ArrayList<>();
		N=Integer.parseInt(br.readLine());
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		ArrayList<Integer> requestList=new ArrayList<>();
		M=Integer.parseInt(br.readLine());
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			requestList.add(Integer.parseInt(st.nextToken()));
		}
		
		
		for(int i=0;i<requestList.size();i++) {
			int target=requestList.get(i);
			if(list.contains(target)) System.out.print("yes ");
			else System.out.print("no ");
		}
		
	}
	
	static int solution(int search, int start, int end) {
		while(start<=end) {
			int mid=(start+end)/2;
			
			if(arr[mid]==search) {
				return mid;
			}
			else if(arr[mid]<search) {
				start=mid+1;
			}
			else {
				end=mid-1;
			}
		}
		
		return -1;
	}
}
