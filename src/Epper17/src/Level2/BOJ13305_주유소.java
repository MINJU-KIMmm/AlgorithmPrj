package Level2;

import java.util.Scanner;
public class BOJ13305_주유소 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int cities=sc.nextInt();
		int[] dist=new int[cities-1];
		long answer;
		
		for(int i=0;i<cities-1;i++) {
			dist[i]=sc.nextInt();
		}
		
		int[] price=new int[cities];
		for(int i=0;i<cities;i++) {
			price[i]=sc.nextInt();
		}
		
		answer=solution(cities, dist, price);
		
		System.out.println(answer);
	}

	public static long solution(int n, int[] dist, int[] cost) {
		long total=0;
		long minCost=cost[0];
		
		for(int i=0;i<n-1;i++) {
			if(minCost>cost[i]) {
				minCost=cost[i];
			}
			
			total+=minCost*dist[i];
		}
		
		return total;
	}
}
