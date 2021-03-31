import java.util.*;
import java.io.*;

//dfs : ���� or ���(��͸� �̿��ϴ� �� �� �� ������)
//bfs : ť

public class dfs_bfs_basic {
	static int[][]check; //���� ���� ����
	static boolean[] visited; //�湮 ����
	static int n, m; //n: ��������  m: ��������
	static int start; //���� ����
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		start=sc.nextInt();
		
		check=new int[1001][1001];
		visited=new boolean[1001];//�ʱⰪ false
		
		//���� ���� ����
		for(int i=0;i<m;i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			
			check[x][y]=check[y][x]=1;
		}
		
		dfs(start);
		
		visited=new boolean[1001]; //�ʱ�ȭ
		System.out.println();
		
		bfs();
	}
	
	public static void dfs(int i) {
		visited[i]=true;
		System.out.print(i+" ");
		
		for(int j=1;j<=n;j++) {
			if(check[i][j]==1&&visited[j]==false)
				dfs(j);
		}
	}
	
	public static void bfs() {
		Queue<Integer>q=new LinkedList<>();
		
		q.offer(start);
		visited[start]=true;
		System.out.print(start+" ");
		
		while(!q.isEmpty()) {
			int tmp=q.poll();
			
			for(int j=1;j<=n;j++) {
				if(check[tmp][j]==1&&visited[j]==false) {
					q.offer(j);
					visited[j]=true;
					System.out.print(j+" ");
				}
			}
		}
	}
}
