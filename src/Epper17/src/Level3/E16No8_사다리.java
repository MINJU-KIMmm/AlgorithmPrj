package Level3;

import java.util.Scanner;

public class E16No8_사다리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] finalArray=new int[n];
		
		for(int i=0;i<n;i++) {
			finalArray[i]=sc.nextInt();
		}
		
		System.out.println(solution(n, finalArray));
	}
	
	static long solution(int n, int[] finalArray) {
		long bridge=0;
		
		//버블정렬 이용 
		//swap 필요하면 bridge 개수 증가
		for(int i=0;i<n;i++) {
			for(int j=i-1;j>=0;j--) {
				if(finalArray[j]>finalArray[i]) {
					bridge++;
				}
			}
		}
		
		return bridge;
	}
}
