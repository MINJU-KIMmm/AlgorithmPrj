package 큐_덱;

import java.util.*;
public class No11866_요세푸스문제0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int K=sc.nextInt();
		
		Queue<Integer> q=new LinkedList<>();
		ArrayList<Integer> arr=new ArrayList<>();
		
		for(int i=1;i<=N;i++) {
			q.offer(i);
		}
		
		while(q.size()>0) {
			for(int i=0;i<K-1;i++) {
				q.offer(q.poll());
			}
			
			arr.add(q.poll());
		}
		
		System.out.print("<");
		for(int i=0;i<arr.size()-1;i++) {
			System.out.print(arr.get(i)+", ");
		}
		System.out.print(arr.get(arr.size()-1)+">");
	}

}
