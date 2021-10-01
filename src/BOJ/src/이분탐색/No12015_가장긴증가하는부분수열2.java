package 이분탐색;

import java.util.*;
import java.io.*;

public class No12015_가장긴증가하는부분수열2 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] arr=new int[n];
		List<Integer> list=new ArrayList<>();
		
		//첫번째 입력되는 수도 비교될 수 있도록 입력값보다 작은 값 추가 해놓음.
		list.add(0);
		
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			//입력된 수가 list 내의 가장 큰 수보다 큰 경우 list에 추가 
			if(arr[i]>list.get(list.size()-1)) list.add(arr[i]); 
			//그렇지 않다면 이분탐색 
			else {
				int left=1; //가장 작은 값의 인덱스 
				int right=list.size()-1; //가장 큰 값의 인덱스 
				
				while(left<right) { //left<=right 라고 하면 시간초과 됨(?) 
					int mid=(left+right)/2;
					if(list.get(mid)>=arr[i]) right=mid; //right=mid-1이라 하면 인덱스 오류남(?)
					else left=mid+1;
				}
				
				list.set(right, arr[i]); //right위치에 arr[i] 삽입. 
			}
		}
		
		System.out.println(list.size()-1); //list의 size 출력. 단, 처음에 넣은 0을 처리하기 위해 -1 
	}

}
