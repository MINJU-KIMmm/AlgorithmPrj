package Ch4_Sorting;

import java.util.*;
import java.io.*;
public class Q24_김민주 {
	

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		int[] arr=new int[N];
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int half=arr.length%2==0? arr.length/2-1:arr.length/2;
		
		System.out.println(arr[half]);
	}

}
