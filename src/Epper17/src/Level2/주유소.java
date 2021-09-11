package Level2;

import java.util.*;
//그리디 알고리즘 
public class 주유소 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int[] dis=new int[N-1];
		long answer;
		
		for(int i=0;i<N-1;i++) {
			dis[i]=sc.nextInt();
		}
		
		int[] cost=new int[N];
		for(int i=0;i<N;i++) {
			cost[i]=sc.nextInt();
		}
		
		answer=solution(N, dis, cost);
		System.out.println(answer);
		
	}
	
	public static long solution(int N, int[] dis, int[] cost) {
		long total=0;
		long minCost=cost[0];
		
		for(int i=0;i<N-1;i++) {
			if(minCost>cost[i])
				minCost=cost[i];
			
			total+=minCost*dis[i];
		}
		
		return total;
	}
}
