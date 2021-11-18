package DFS와BFS;

import java.util.*;
public class No2583_영역구하기 {
	static int M;
	static int N;
	static int K;
	
	static int[] dx= {-1, 1, 0, 0};
	static int[] dy= {0, 0, -1, 1};
	
	static int [][] arr;
	static int count=0;
	
	static ArrayList<Integer> list=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		M=sc.nextInt();
		N=sc.nextInt();
		K=sc.nextInt();
		
		arr=new int[M][N];
		
		for(int i=0;i<K;i++) {
			int x1=sc.nextInt();
			int y1=sc.nextInt();
			int x2=sc.nextInt();
			int y2=sc.nextInt();
			
			for(int ii=y1;ii<y2;ii++) {
				for(int jj=x1;jj<x2;jj++) {
					arr[ii][jj]=1;
				}
			}
		}
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]==0) {
					count=0;
					dfs(i,j);
					list.add(count);
				}
			}
		}
		
		System.out.println(list.size());
		Collections.sort(list);
		
		for(Integer num:list) {
			System.out.print(num+" ");
		}
	}
	
	
	static void dfs(int x, int y) {
		arr[x][y]=1;
		count++;
		
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(nx>=0&&nx<M&&ny>=0&&ny<N) {
				if(arr[nx][ny]==0) dfs(nx, ny);
			}
		}
	}

}
