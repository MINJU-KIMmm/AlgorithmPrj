package ch09_최단경로;

import java.util.*;
public class 실전2_미래도시 {

	public static final int INF=(int)1e9; //무한을 의미하는 값 (10억)
	public static int n,m,x,k; //노드개수, 간선개수, 거쳐갈 노드, 최종목적지노드 
	public static int[][] arr=new int[101][101];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		m=sc.nextInt();
		
		//최단 거리 테이블 무한으로 초기화 
		for(int i=0;i<101;i++) {
			Arrays.fill(arr[i], INF);
		}
		
		//자기 자신에서 자기자신으로 가는 비용 0으로 초기화 
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i==j) arr[i][j]=0;
			}
		}
		
		//각 간선에 대한 정보 입력 받고 초기화 
		for(int i=0;i<m;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			//양방향, 가는 비용 1
			arr[a][b]=1;
			arr[b][a]=1;
		}
		
		x=sc.nextInt();
		k=sc.nextInt();
		
		for(int k=1;k<=n;k++) {
			for(int a=1;a<=n;a++) {
				for(int b=1;b<=n;b++) {
					//a->b 직행 비용과 a->k->b거쳐가는 비용 비교 
					arr[a][b]=Math.min(arr[a][b], arr[a][k]+arr[k][b]);
				}
			}
		}
		
		//수행 결과 
		int dist=arr[1][k]+arr[k][x];
		
		//도달할 수 없는 경우 
		if(dist>=INF) {
			System.out.println(-1);
		}
		//도달할 수 있는 우 
		else {
			System.out.println(dist);
		}
	}

}
