package DFS와BFS;

import java.util.*;
public class No1707_이분그래프 {
	static int v, e;
	static int[] color;
	static int RED=1, BLUE=-1;
	static ArrayList<ArrayList<Integer>> list;
	static String answer;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int k=sc.nextInt();
		for(int i=0;i<k;i++) {
			answer="";
			v=sc.nextInt();
			e=sc.nextInt();
			
			list=new ArrayList<>();
			for(int j=0;j<v;j++) {
				list.add(new ArrayList<Integer>());
			}
			
			//연결되는 정점을 서로에게 표시 
			for(int j=0;j<e;j++) {
				int a=sc.nextInt()-1;
				int b=sc.nextInt()-1;
				list.get(a).add(b);
				list.get(b).add(a);
			}
			
			color=new int[v];
			for(int j=0;j<v;j++) {
				if(color[j]==0) {
					boolean chk=bfs(j);
					if(!chk) break; //false면 (= NO로 끝났으면) break 
				}
			}
			
			System.out.println(answer);
		}
	}
	
	public static boolean bfs(int idx) {
		Queue<Integer> q=new LinkedList<>();
		q.offer(idx);
		color[idx]=RED;
		
		while(!q.isEmpty()) {
			int temp=q.poll();
			for(int i:list.get(temp)) {
				int tempColor=color[temp];
				
				//처음 방문한다면 color값 temp노드의 color와 다른 색으로 
				if(color[i]==0) {
					color[i]=tempColor*-1;
					q.offer(i);
				}
				//temp 노드와 연결된 노드가 같은 색상이라면 이분 그래프가 아님 -> NO
				else if(color[i]==tempColor) {
					answer="NO";
					return false;
				}
			}
		}
		
		answer="YES";
		return true;
	}
	

}
