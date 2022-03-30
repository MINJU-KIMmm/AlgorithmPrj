package ch10_그래프이론;

import java.util.*;
import java.io.*;
public class 도시분할계획 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int v=sc.nextInt();
		int e=sc.nextInt();
		
		int[] parent=new int[v+1];
		
		ArrayList<Edge> edges=new ArrayList<>(); //모든 간선 담을 배열
		int finalCost=0; //최종 비용 
		
		for(int i=0;i<v+1;i++) {
			parent[i]=i;
		}
		
		for(int i=0;i<e;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int cost=sc.nextInt();
			
			edges.add(new Edge(a,b,cost));
		}
		
		Collections.sort(edges);
		int last=0;
		
		for(Edge edge:edges) {
			int cost=edge.cost;
			int a=edge.a;
			int b=edge.b;
			
			if(find(parent,a)!=find(parent,b)) {
				union(parent, a,b);
				finalCost+=cost;
				last=cost;
			}
		
		}
		System.out.println(finalCost-last);
	}

	static int find(int[] parent, int x) {
		if(parent[x]!=x) {
			parent[x]=find(parent, parent[x]);
		}
		return parent[x];
	}
	
	static void union(int[] parent, int a, int b) {
		a=find(parent, a);
		b=find(parent, b);
		
		if(a<b) {
			parent[b]=a;
		}
		else {
			parent[a]=b;
		}
	}
	
	
}

class Edge implements Comparable<Edge>{
	int a, b, cost;
	
	public Edge(int a, int b, int cost) {
		this.a=a;
		this.b=b;
		this.cost=cost;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		if(o.cost<cost) {
			return 1;
		}
		else if(o.cost>cost) {
			return -1;
		}
		return 0;
	}
	
	
}
