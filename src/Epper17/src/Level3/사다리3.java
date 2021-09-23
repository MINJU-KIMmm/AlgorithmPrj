package Level3;

import java.util.Scanner;

public class 사다리3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		
		System.out.println(solution(n, arr));
	}
	public static long solution(int n, int[] arr) {
		long cnt=0;
		
		for(int i=0;i<n;i++) {
			for(int j=i-1;j>=0;j--) {
				if(arr[i]<arr[j])cnt++;
			}
		}
		
		return cnt;
	}
}
