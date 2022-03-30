import java.io.*;
import java.util.*;
public class 상_합승택시요금 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

	}
	
	static final int INF=100000000;
	
	static int[][] fillGraph(int n, int[][] fares){
		int[][] graph=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			Arrays.fill(graph[i], INF);
			graph[i][i]=0;
		}
		
		for(int i=0;i<fares.length;i++) {
			graph[fares[i][0]][fares[i][1]]=fares[i][2];
			graph[fares[i][1]][fares[i][0]]=fares[i][2];
		}
		
		return graph;
	}
	
	static void floydWarshall(int[][] graph, int n) {
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					graph[i][j]=Math.min(graph[i][j], graph[i][k]+graph[k][j]);
				}
			}
		}
	}
	
	static int solution(int n, int s, int a, int b, int[][] fares) {
		int answer=INF;
		int[][] graph=fillGraph(n,fares);
		floydWarshall(graph, n);
		
		for(int i=1;i<=n;i++) {
			answer=Math.min(answer, graph[s][i]+graph[i][a]+graph[i][b]);
		}
		
		return answer;
	}
	
	static int[][] fillGraph1(int n, int[][] fares){
		int[][] graph=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			Arrays.fill(graph, INF);
			graph[i][i]=0;
		}
		
		for(int i=0;i<fares.length;i++) {
			graph[fares[i][0]][fares[i][1]]=fares[i][2];
			graph[fares[i][1]][fares[i][0]]=fares[i][2];
		}
		
		return graph;
	}
	
	static void floyd(int[][] graph, int n) {
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					graph[i][j]=Math.min(graph[i][j], graph[i][k]+graph[k][j]);
				}
			}
		}
	}
	
	static int solution1(int n, int s, int a, int b, int[][] fares) {
		int[][] graph=fillGraph1(n,fares);
		int answer=INF;
		floyd(graph, n);
		
		for(int i=1;i<=n;i++) {
			answer=Math.min(answer, graph[s][i]+graph[i][a]+graph[i][b]);
		}
		
		return answer;
	}
}
