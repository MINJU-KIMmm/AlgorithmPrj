import java.util.*;
import java.io.*;
public class No1697_숨바꼭질 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		if(N==K) System.out.println(0);
		else bfs(N, K);
	}

	static void bfs(int N, int K) {
		Queue<Integer> q=new LinkedList<>();
		
		int[] arr=new int[100001];
		arr[N]=1;
		
		q.offer(N);
		
		while(!q.isEmpty()) {
			int x=q.poll();
			if(K==x) {
				System.out.println(arr[x]-1);
				return;
			}
			
			for(int i=0;i<3;i++) {
				
				int nx=0;
				if(i==0) nx=x-1;
				else if(i==1) nx=x+1;
				else nx=2*x;
				
				
				if(nx<0||nx>=arr.length) continue;
				
				if(arr[nx]==0) {
					arr[nx]=arr[x]+1;
					q.offer(nx);
				}
			}
		}
	}
}
