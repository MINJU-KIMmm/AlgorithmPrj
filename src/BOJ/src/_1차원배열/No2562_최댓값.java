package _1차원배열;

import java.util.Scanner;
public class No2562_최댓값 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int[]arr=new int[9];
		int max=0;
		
		for(int i=0;i<9;i++) {
			arr[i]=sc.nextInt();
		}
		
		max=arr[0];
		int max_idx=0;
		for(int i=1;i<9;i++) {
			if(max<arr[i]) {
				max=arr[i];
				max_idx=i;
			}
		}
		
		System.out.println(max);
		System.out.println(max_idx+1);
	}

}
