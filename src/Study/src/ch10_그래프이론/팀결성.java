package ch10_그래프이론;

import java.util.*;
import java.io.*;
public class 팀결성 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int m=sc.nextInt();
		
		int[] parent=new int[n+1];
		
		for(int i=0;i<n+1;i++) {
			parent[i]=i;
		}
		
		for(int i=0;i<m;i++) {
			int flag=sc.nextInt();
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			if(flag==0) {
				union(parent, a, b);
			}
			else {
				if(find(parent, a)==find(parent, b)) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
		}
	}

	//특정 원소가 속한 집합(루트) 찾기 
	static int find(int[] parent, int x) {
		//루트 아니라면 루트 찾을 때까지 재귀 
		if(parent[x]!=x) {
			parent[x]=find(parent, parent[x]);
		}
		return parent[x];
	}
	
	static void union(int[] parent, int a, int b) {
		a=find(parent, a);
		b=find(parent, b);
		
		// 작은 게 부모가 되도록 
		if(a<b) {
			parent[b]=a;
		}
		else {
			parent[a]=b;
		}
	}
	
}
