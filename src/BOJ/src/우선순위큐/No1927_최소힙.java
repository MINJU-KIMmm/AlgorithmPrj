package 우선순위큐;

import java.util.*;
import java.io.*;

//최소힙 : 최솟값을 빠르게 뽑는 자료구조 
//PriorityQueue가 기본적으로 최소힙 구조임 
//연산
//1. 배열에 자연수 x를 넣는다.(offer, add)
//2. 배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거한다.(poll)
public class No1927_최소힙 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> q=new PriorityQueue<>();
		
		for(int i=0;i<n;i++) {
			int num=Integer.parseInt(br.readLine());
			if(num==0) {
				if(q.isEmpty()) System.out.println("0");
				else System.out.println(q.poll());
			}
			else {
				q.add(num);
			}
		}
	}

}
