package Ch3_DfsBfs;

import java.util.*;
import java.io.*;
public class Q19_김민주 {
	
	static int[] nums;
	static int plus, minus, mult, div;
	static int[] dx= {-1, 1, 0, 0};
	static int[] dy= {0, 0, -1, 1};
	static int min=Integer.MAX_VALUE;
	static int max=Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();

		nums=new int[N];
		
		for(int i=0;i<N;i++) {
			nums[i]=sc.nextInt();
		}
	
		
		plus=sc.nextInt();
		minus=sc.nextInt();
		mult=sc.nextInt();
		div=sc.nextInt();
		
	
		dfs(1, N, nums[0]);
		
		System.out.println(max);
		System.out.println(min);
		
	}

	static void dfs(int depth, int N, int result) {
		if(depth==N) {
			min=Math.min(min, result);
			max=Math.max(max, result);
			return;
		}
		
		if(plus>0) {
			plus--;
			dfs(depth+1, N, result+nums[depth]);
			plus++;
		}
		
		if(minus>0) {
			minus--;
			dfs(depth+1, N, result-=nums[depth]);
			minus++;
		}
		
		if(mult>0) {
			mult--;
			dfs(depth+1, N, result*=nums[depth]);
			mult++;
		}
		
		if(div>0) {
			div--;
			dfs(depth+1, N, result/=nums[depth]);
			div++;
		}
	}
}
