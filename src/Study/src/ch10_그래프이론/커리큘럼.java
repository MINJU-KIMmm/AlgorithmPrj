package ch10_그래프이론;

import java.util.*;
public class 커리큘럼 {
	static int N;
	static int[] indegree=new int[501]; //모든 노드에 대한 진입차수 0으로 초기화
	static ArrayList<ArrayList<Integer>> graph=new ArrayList<>(); //각 노드에 연결된 간선 정보를 담기 위한 리스트 
	static int[] times=new int[501]; // 강의 시간 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		
		//그래프 초기화 
		for(int i=0;i<=N;i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		//방향 그래프 간선정보 입력 
		for(int i=1;i<=N;i++) {
			int x=sc.nextInt();
			times[i]=x;
			
			//선수과목 입력 
			while(true) {
				x=sc.nextInt();
				if(x==-1) break;
				indegree[i]++;
				graph.get(x).add(i);
			}
		}
		
		topology();
	}
	
	//위상정렬 
	static void topology() {
		int[] result=new int[501];
		for(int i=1;i<=N;i++) {
			result[i]=times[i];
		}
		
		Queue<Integer> q=new LinkedList<>();
		
		//진입 차수가 0인 노드 삽입 
		for(int i=1;i<=N;i++) {
			if (indegree[i]==0) q.offer(i);
		}
		
		while(!q.isEmpty()) {
			int curr=q.poll();
			//curr과 연결된 노드들의 진입차수 -1
			for(int i=0;i<graph.get(curr).size();i++) {
				result[graph.get(curr).get(i)]=Math.max(result[graph.get(curr).get(i)], result[curr]+times[graph.get(curr).get(i)]);
				indegree[graph.get(curr).get(i)]--;
				//새롭게 진입차수가 0이 되는 노드를 삽입 
				if(indegree[graph.get(curr).get(i)]==0) {
					q.offer(graph.get(curr).get(i));
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			System.out.println(result[i]);
		}
	}

}
