package Ch7_이진탐색;

import java.util.*;
import java.io.*;
public class Q29_김민주 {

	static int[] arr;
	static int N,C;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		
		arr=new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		//left 와 right 가 거리 최솟값,최댓 
		int left=1;
		int right=arr[arr.length-1]-arr[0];
		int mid=0;
		
		int dist=0;
		int answer=0;
		
		while(left<=right) {
			mid=(left+right)/2; //현재단계에서 가장 인접한 거리 
			
			int start=arr[0];
			int cnt=1; //공유기 설치 개수 
			
			for(int i=0;i<N;i++) {
				dist=arr[i]-start;
				if(dist>=mid) {
					cnt++;
					start=arr[i];
				}
			}
			
			//인접한 거리의 최댓값을 찾기 위해 설치해야하는 경우보다 더 많이 설치가 가능하다면 범위 증가  
			if(cnt>=C) {
				answer=mid;
				left=mid+1;
			}
			//C개 이상을 설치할 수 없는 경우 
			else {
				right=mid-1;
			}
		}
		
		System.out.println(answer);
	}
	
	
}
