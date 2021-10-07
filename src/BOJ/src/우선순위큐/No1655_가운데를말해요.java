package 우선순위큐;

import java.util.*;
import java.io.*;
//우선순위를 사용하여 중앙값을 찾는 문제 
public class No1655_가운데를말해요 {

	//예제
	//input -> [maxHeap] [minHeap] => 출력 값
	//1 -> [1][] => 1
	//5 -> [1][5] => 1
	//2 -> [1 2][5] => 2
	//10 ->[1 2][5 10] => 2
	//-99 -> [-99 1 2][5 10] => 2
	//7 -> [-99 1 2][5 7 10] => 2
	//5 -> [-99 1 2 5][5 7 1-] => 5
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		StringBuilder sb=new StringBuilder();
		
		//최대힙의 peek값 < 최소힙의 peek값이 성립해야 함 
		PriorityQueue<Integer> minHeap=new PriorityQueue<>(); //작은 값이 우선순위 가짐
		PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Comparator.reverseOrder()); //큰 값이 우선순위 가짐 
		
		for(int i=0;i<N;i++) {
			int num=Integer.parseInt(br.readLine());
			
			//두 pq의 크기가 같다면 maxHeap에 offer -> 입력한 값이 minHeap의 최솟값보다 크면 둘이 swap
			if(minHeap.size()==maxHeap.size()) {
				maxHeap.offer(num);
				if(!minHeap.isEmpty()&&maxHeap.peek()>minHeap.peek()) {
					minHeap.offer(maxHeap.poll());
					maxHeap.offer(minHeap.poll());
				}
			}
			//두 pq의 크기가 다르면 minHeap에 offer -> 입력한 값이 maxHeap의 최댓값보다 작으면 둘이 swap
			else {
				minHeap.offer(num);
				
				if(maxHeap.peek()>minHeap.peek()) {
					minHeap.offer(maxHeap.poll());
					maxHeap.offer(minHeap.poll());
				}
			}
			
			
			
			//최종적으로 maxHeap의 top 부분이 중간값이 된다.(peek을 통해 출력) 
			sb.append(maxHeap.peek()).append('\n');
		}
		
		System.out.println(sb);
	}

}
