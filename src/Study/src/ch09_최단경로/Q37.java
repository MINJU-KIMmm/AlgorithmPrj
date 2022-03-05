package ch09_최단경로;

import java.util.*;
public class Q37 {
	
	static final int INF=(int)1e9;
	static int n,m;
	static int[][] arr=new int[101][101];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		m=sc.nextInt();
		
		for(int i=0;i<101;i++) {
			Arrays.fill(arr[i], INF);
		}
		
		for(int x=1;x<=n;x++) {
			for(int y=1;y<=n;y++) {
				if(x==y) {
					arr[x][y]=0;
				}
			}
		}
		
		for(int i=0;i<m;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			
			if(c<arr[a][b])arr[a][b]=c; //가장 최소의 비용 저장 
		}
		
		//플로이드 게산 
		for(int i=1;i<=n;i++) {
			for(int a=1;a<=n;a++) {
				for(int b=1;b<=n;b++) {
					arr[a][b]=Math.min(arr[a][b], arr[a][i]+arr[i][b]);
				}
			}
		}
		
		for(int a=1;a<=n;a++) {
			for(int b=1;b<=n;b++) {
				if(arr[a][b]==INF) {
					System.out.println(0+" ");
				}
				else {
					System.out.println(arr[a][b]+" ");
				}
				
				System.out.println();
			}
			
		}
	}

}
