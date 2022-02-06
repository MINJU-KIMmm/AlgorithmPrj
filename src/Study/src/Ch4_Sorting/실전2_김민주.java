package Ch4_Sorting;

import java.util.*;
import java.io.*;
public class 실전2_김민주 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		Integer[] arr=new Integer[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		
		for(int i=0;i<N;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
