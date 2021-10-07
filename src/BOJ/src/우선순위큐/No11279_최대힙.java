package 우선순위큐;

import java.io.*;
import java.util.*;
public class No11279_최대힙 {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		//Queue<Integer> q=new PriorityQueue<>(Comparator.reverseOrder());
		Queue<Integer> q=new PriorityQueue<>((o1, o2)-> o2-o1);
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<n;i++) {
			int k=Integer.parseInt(br.readLine());
			if(k==0) {
				if(q.isEmpty()) {
					sb.append(0+"\n");
				}else {
					sb.append(q.poll()+"\n");
				}
			}else {
				q.add(k);
			}
		}
		
		System.out.println(sb.toString());
	}

}
