package 큐_덱;

import java.util.*;
public class No2164_카드2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Queue<Integer> q=new LinkedList<>();
		
		int N=sc.nextInt();
		for(int i=1;i<=N;i++) {
			q.offer(i);
		}
		
		while(q.size()>1) {
			q.poll();
			q.offer(q.poll());
		}
		
		System.out.println(q.peek());
	}

}
