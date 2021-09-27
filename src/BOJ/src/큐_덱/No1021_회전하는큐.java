package 큐_덱;

import java.util.*;
public class No1021_회전하는큐 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int M=sc.nextInt();
		
		LinkedList<Integer> dq=new LinkedList<>();
		
		int cnt=0;
		
		for(int i=1;i<=N;i++) {
			dq.offer(i);
		}
		
		int[]arr= new int[M]; //뽑을 수 담을 배열
		for(int i=0;i<M;i++) {
			arr[i]=sc.nextInt();
		}
		
		for(int i=0;i<M;i++) {
			int idx=dq.indexOf(arr[i]);
			int mid;
			
			//dq 사이즈가 짝수개면 중간 인덱스 값 -1 감소 
			if(dq.size()%2==0) {
				mid=dq.size()/2-1;
			}
			else {
				mid=dq.size()/2;
			}
			
			//중간지점보다 뒤에 있는 건 뒤에서 뽑아내는 게 최소 연산이고 
			//앞에 있는 건 앞에서 뽑아내는 게 최소 연산이므로 
			//뒤에 있는 경우 target원소보다 뒤에 있는 원소들을 앞으로 보내는 3번 연산을 실행하고 
			//앞에 있는 경우 target원소보다 앞에 있는 원소들을 뒤로 보내는 2번 연산을 실행 
			if(idx<=mid) {
				//중간지점이거나 중간지점보다 앞인 경우 2번 연산 (뒤로보냄)
				for(int j=0;j<idx;j++) {
					int tmp=dq.pollFirst();
					dq.offerLast(tmp);
					cnt++;
				}
			}
			else {
				//중간 지점보다 뒤에 있는 경우 3번연산(앞으로 보냄)
				for(int j=0;j<dq.size()-idx;j++) {
					int tmp=dq.pollLast();
					dq.offerFirst(tmp);
					cnt++;
				}
			}
			
			dq.pollFirst(); //연산 끝나면 맨 앞원소 poll (1번 연산) 
		}
		
		System.out.println(cnt);
	}

}
