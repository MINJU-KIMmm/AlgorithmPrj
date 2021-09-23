package Level2;

import java.util.*;

public class 주유소2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int cities = scanner.nextInt();
		int[] distance = new int[cities - 1];
		long answer;
		for (int i = 0; i < cities - 1; i++) {
			distance[i] = scanner.nextInt();
		}
		int[] price = new int[cities];
		for (int i = 0; i < cities; i++) {
			price[i] = scanner.nextInt();
		}
		answer = solution(cities, distance, price);
		System.out.println(answer);
	}

	public static long solution(int n, int[] dist, int[] cost) {
		long total=0;
		long minCost=cost[0];
		
		for(int i=0;i<n-1;i++) {
			if(minCost>cost[i]) minCost=cost[i];
			total+=minCost*dist[i];
		}
		
		return total;
	}
}
