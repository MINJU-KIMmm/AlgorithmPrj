package EPPER18;

import java.util.*;
import java.io.*;
public class 상_합승택시요금 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static int INF=100000000;
	
	public static int[][] fillGraph(int n, int[][] fares){
		int[][] graph=new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			Arrays.fill(graph[i], INF); //처음엔 다 INF로 초기화 해준다. 
			graph[i][i]=0; //자기 자신 비용 
		}
		
		//양방향 그래프 
		for(int i=0;i<fares.length;i++) {
			graph[fares[i][0]][fares[i][1]]=fares[i][2];
			graph[fares[i][1]][fares[i][0]]=fares[i][2];
		}
		
		
		return graph;
	}
	
	public static void floydWarshall(int[][] graph, int n) {
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					graph[i][j]=Math.min(graph[i][j], graph[i][k]+graph[k][j]);
				}
			}
		}
	}

	public static int solution(int n, int s, int a, int b, int[][] fares) {
		int answer=INF;
		int[][] graph=fillGraph(n,fares); // 초기화 
		
		floydWarshall(graph, n); //플로이드 워셜 
		
		for(int i=1;i<=n;i++) {
			answer=Math.min(answer,  graph[s][i]+graph[i][a]+graph[i][b]);
		}
		
		return answer;
	}
	
	
}
