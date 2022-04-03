package DFS와BFS;

import java.util.*;
import java.io.*;
public class No9205_맥주마시면서걸어가기 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		
		
		while(t-->0) {
			int n=Integer.parseInt(br.readLine());
			
			Spot[] spots=new Spot[n+2];
			
			for(int i=0;i<n+2;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				spots[i]=new Spot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			//초기화 
			ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
			for(int i=0;i<n+2;i++) {
				graph.add(new ArrayList<>());
			}
			
			
			//맥주 양으로 갈 수 있는 거리를 찾아서 양방향 그래프로 이어 줌 
			for(int i=0;i<n+2;i++) {
				for(int j=i+1;j<n+2;j++) {
					if(dist(spots[i], spots[j])<=1000) {
						graph.get(i).add(j);
						graph.get(j).add(i);
					}
				}
			}
			
			System.out.println((bfs(graph, n)? "happy":"sad"));
		}
	}
	
	//맨해튼 거리 게산 
	static int dist(Spot a, Spot b) {
		return Math.abs(a.x-b.x)+Math.abs(a.y-b.y);
	}
	
	static boolean bfs(ArrayList<ArrayList<Integer>>graph, int n) {
		Queue<Integer> q=new LinkedList<>();
		//시작점 삽입 
		q.offer(0);
		
		boolean[] visited=new boolean[n+2];
		visited[0]=true;
		
		while(!q.isEmpty()) {
			int curr=q.poll();
			
			//도착 
			if(curr==n+1) return true;
			
			//curr과 이어진 노드들을 방문함 
			for(int next:graph.get(curr)) {
				if(!visited[next]) {
					q.offer(next);
					visited[next]=true;
				}
			}
		}
		
		return false;
	}
}

class Spot{
	int x, y;
	
	public Spot(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
