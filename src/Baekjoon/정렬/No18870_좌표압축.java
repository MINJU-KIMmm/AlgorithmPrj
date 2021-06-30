package Sorting;

import java.util.*;
import java.io.*;
public class No18870_좌표압축 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		String[] input=br.readLine().split(" ");
		int[]nums=new int[N];
		for(int i=0;i<N;i++) {
			nums[i]=Integer.parseInt(input[i]);
		}
		
		//원래 위치,새로운 좌표 
		HashMap<Integer, Integer>map=new HashMap<>();
		
		int[] nums2=new int[N];
		nums2=nums.clone();
		Arrays.sort(nums2);
		
		int idx=0;
		for(int i=0;i<N;i++) {
			if(!map.containsKey(nums2[i]))
				map.put(nums2[i], idx++);
		}
		
		StringBuilder sb=new StringBuilder();
		for(int n:nums) {
			sb.append(map.get(n)).append(' ');
		}
		
		System.out.println(sb.toString());
	}
	
}

/*
 * import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		int num[]=new int[n];
		
		for(int i=0;i<n;i++) {
			num[i]=sc.nextInt();
		}
		
		int[] answer=new int[n];
		Arrays.fill(answer, n);
		for(int i=0;i<n;i++) {
			int a=num[i];
			for(int j=0;j<n;j++) {
				if(a<=num[j])
					answer[i]--;
			}
		}
		
		for(int i=0;i<n;i++) {
			System.out.print(answer[i]+" ");
		}
	}

}

 */
