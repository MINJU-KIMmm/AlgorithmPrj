package ch09_최단경로;

import java.util.*;
public class 실전3_전보 {

	public static final int INF=(int)1e9;
	public static int n, m, start; //노드 개수, 간선 수 , 노드 번호
	public static ArrayList<ArrayList<Node>> arr=new ArrayList<ArrayList<Node>>(); //각 노드에 연결되 있는 노드에 대한 정보를 담는 배열 
	public static int[] d=new int[30001]; //최단 거리 테이블 
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		m=sc.nextInt();
		start=sc.nextInt();
		
		//그래프 초기화 
		for(int i=0;i<=n;i++) {
			arr.add(new ArrayList<Node>());
		}
		
		//모든 간선 정보 입력 받기 
		for(int i=0;i<m;i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			int z=sc.nextInt();
			
			//x번 노드에서 y번 노드로 가는 비용이 z라는 의미
			arr.get(x).add(new Node(y,z));
		}
		
		//최단 거리 테이블을 모두 무한으로 초기화 
		Arrays.fill(d, INF);
		
		//다익스트라 알고리즘 수행 
		dijkstra(start);
		
		//도달할 수 있는 노드 개수 
		int count=0;
		//도달할 수 있는 노드 중에서, 가장 멀리 있는 노드와의 최단 거리 
		int maxDistance=0;
		for(int i=1;i<=n;i++) {
			//도달할 수 있는 노드인 경우 
			if(d[i]!=INF) {
				count+=1;
				maxDistance=Math.max(maxDistance, d[i]);
			}
		}
		
		//시작 노드 제외 (-1)
		System.out.println((count-1)+" "+maxDistance);
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq=new PriorityQueue<>();
		
		//시작 노드로 가기 위한 최단 경로 0으로설정해서 큐에 삽입 
		pq.offer(new Node(start,0));
		d[start]=0;
		
		while(!pq.isEmpty()) {
			//최단 거리가 가장 짧은 노드 정보 꺼내기 
			Node node=pq.poll();
			int dist=node.getDistance();//현재 노드까지의 비용
			int now=node.getIndex();// 현재 노드 
			//현재 노드가 이미 처리된 적이 있는 노드라면 무시 
			if(d[now]<dist) continue;
			//현재 노드와 연결된 다른 인접한 노드들을 확인 
			for(int i=0;i<arr.get(now).size();i++) {
				int cost=d[now]+arr.get(now).get(i).getDistance();
				
				if(cost<d[arr.get(now).get(i).getIndex()]) {
					d[arr.get(now).get(i).getIndex()]=cost;
					pq.offer(new Node(arr.get(now).get(i).getIndex(), cost));
				}
			}
			
		}
	}
	

}

class Node implements Comparable<Node>{
	private int index;
	private int distance;
	
	public Node(int index, int distance) {
		this.index=index;
		this.distance=distance;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public int getDistance() {
		return this.distance; 
	}
	
	//거리 짧은 게 우선순위 
	@Override
	public int compareTo(Node o) {
		if(this.distance<o.distance) {
			return -1;
		}
		return 1;
	}
}
