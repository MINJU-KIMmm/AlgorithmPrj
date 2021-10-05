package 우선순위큐;

import java.util.*;

public class No11286_절댓값힙 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		PriorityQueue<Integer> q = new PriorityQueue<>(
				(o1, o2) -> Math.abs(o1) == Math.abs(o2) ? Integer.compare(o1, o2)
						: Integer.compare(Math.abs(o1), Math.abs(o2)));

		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if (num == 0) {
				if (q.isEmpty())
					System.out.println(0);
				else {
					System.out.println(q.poll());
				}
			} else {
				q.add(num);
			}

		}

	}

}
