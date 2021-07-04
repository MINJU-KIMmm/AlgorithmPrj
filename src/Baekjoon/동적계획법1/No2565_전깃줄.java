package 동적계획법1;

import java.util.*;
public class No2565_전깃줄 {

	static Integer[] dp;
	static int[][] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		arr=new int[N][2];
		dp=new Integer[N];
		
		for(int i=0;i<N;i++) {
			arr[i][0]=sc.nextInt();
			arr[i][1]=sc.nextInt();
		}
		
		//첫번째 전봇대 기준으로 정렬 
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1, int[]o2) {
				return o1[0]-o2[0];
			}
		});
		
		int max=0;
		for(int i=0;i<N;i++)
			max=Math.max(find(i), max);
		
		System.out.println(N-max);
	}
	
	//설치할 수 있는 전봇대 개수 구하기 
	static int find(int N) {
		if(dp[N]==null) {
			dp[N]=1;
			for(int i=N+1;i<dp.length;i++) {
				if(arr[N][1]<arr[i][1])
					dp[N]=Math.max(dp[N], find(i)+1);
			}
		}
		
		return dp[N];
	}

}
