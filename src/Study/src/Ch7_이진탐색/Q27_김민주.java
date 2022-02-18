package Ch7_이진탐색;

import java.util.*;
import java.io.*;
public class Q27_김민주 {

	static int[] arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int x=Integer.parseInt(st.nextToken());
		
		arr=new int[N];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++	) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int count_start=solution_first(x, 0, arr.length-1);
		int count_end=solution_last(x, 0, arr.length-1);
		
		if(count_start==-1&&count_end==-1) System.out.println(-1);
		else System.out.println(count_end-count_start+1);
	}
	
	//시작점 구하기 
	static int solution_first(int x, int start, int end) {
		
		while(start<=end) {
			int mid=(start+end)/2;
			
			//시작점인 경우 (인덱스가 0이고 값이 일치하거나 0이 이나면 인덱스-1의 값은 x보다 작음)
			if(mid==0&&arr[mid]==x||mid!=0&&arr[mid]==x&&arr[mid-1]<x) {
				return mid;
			}
			else if(arr[mid]<x) {
				start=mid+1;
			}
			else if(arr[mid]>x) {
				end=mid-1;
			}
			//x와 같지만 시작점은 아닌 경우 시작점을 찾기위해 mid-1 
			else {
				end=mid-1;
			}
		}
		
		return -1;
	}
	
	static int solution_last(int x, int start, int end) {
		while(start<=end) {
			int mid=(start+end)/2;
			
			if(mid==arr.length-1&&arr[mid]==x||mid!=arr.length-1&&arr[mid]==x&&arr[mid+1]>x) {
				return mid;
			}
			else if(arr[mid]<x) {
				start=mid+1;
			}
			else if(arr[mid]>x) {
				end=mid-1;
			}
			else {
				start=mid+1;
			}
		}
		
		return -1;
	}
}
