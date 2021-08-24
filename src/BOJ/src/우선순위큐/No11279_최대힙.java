package 우선순위큐;

import java.io.*;
import java.util.*;
public class No11279_최대힙 {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		Queue<Integer> q=new PriorityQueue<>();
		
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<n;i++) {
			int k=Integer.parseInt(br.readLine());
			if(k==0) {
				if(q.isEmpty()) {
					sb.append(0+"\n");
				}else {
					sb.append(q.poll()*-1+"\n");
				}
			}else {
				//원래는 최소값을 삭제하기 때문에 최댓값을 삭제하기 위해선(최대힙으로 만들기 위해선) -1을 곱해준다 
				q.add(k*-1);
			}
		}
		
		System.out.println(sb.toString());
	}

}
