package Level2;

import java.util.*;

public class 기능개발 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = solution(new int[] { 93, 30, 55 }, new int[] { 1, 30, 5 });
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		int cnt = 0;
		ArrayList<Integer> cntList = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();

		int days = 0;
		for (int i = 0; i < progresses.length; i++) {
			int p = 100 - progresses[i];
			int s = speeds[i];
			if (p % s == 0)
				days = p / s;
			else
				days = p / s + 1;
			q.offer(days);
		}

		int day = q.poll();
		cnt = 1;
		for (int i = 0; i < progresses.length; i++) {
			if (q.isEmpty()) {
				cntList.add(cnt);
				break;
			}
			if (q.peek() <= day) {
				cnt++;
				q.poll();
			} else {
				cntList.add(cnt);
				cnt = 1;
				day = q.poll();
			}
		}

		answer = new int[cntList.size()];
		for (int i = 0; i < cntList.size(); i++) {
			answer[i] = cntList.get(i);
		}

		return answer;
	}
}
