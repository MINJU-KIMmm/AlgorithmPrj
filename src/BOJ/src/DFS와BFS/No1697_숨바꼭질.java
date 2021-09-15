package DFS와BFS;

import java.util.*;
public class No1697_숨바꼭질 {
	
	static int N;
	static int K;
	static int[] arr=new int[100001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();
		
		if(N==K) {
			System.out.println(0);
		}else {
			bfs(N);
		}
	}
	
	static void bfs(int n) {
		Queue<Integer>q=new LinkedList<>();
		
		q.offer(n);
		arr[n]=1;
		
		while(!q.isEmpty()) {
			int temp=q.poll();
			
			for(int i=0;i<3;i++) {
				int next=0;
				
				if(i==0) next=temp+1;
				else if(i==1) next=temp-1;
				else next=temp*2;
				
				if(next==K) {
					System.out.println(arr[temp]);
					return;
				}
				
				//범위내에 있고 처음 방문하는 곳 
				if(next>=0&&next<arr.length&&arr[next]==0) {
					q.offer(next);
					arr[next]=arr[temp]+1;
				}
			}
		}
	}
}
