package Level2;
import java.util.*;

public class 프린터 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] {2,1,3,2}, 2));
	}

	public static int solution(int[] priorities, int location) {
		int answer=0;
		Queue<Wait>q=new LinkedList<>();
		
		for(int i=0;i<priorities.length;i++) {
			Wait w=new Wait(i, priorities[i]);
			q.offer(w);
		}
		
		Arrays.sort(priorities);
		int max=priorities[priorities.length-1];
		
		Wait[]arr=new Wait[priorities.length];
		int idx=0;
		while(!q.isEmpty()) {
			max=priorities[priorities.length-1-idx];
			Wait out=q.poll();
			if(out.priority<max)
				q.offer(out);
			else {
				arr[idx++]=out;
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			if(location==arr[i].num) {
				answer=i+1;
			}
		}
		return answer;
	}
	
}

class Wait{
	int priority;
	int num;
	
	public Wait(int num, int priority) {
		this.num=num;
		this.priority=priority;
	}
}
