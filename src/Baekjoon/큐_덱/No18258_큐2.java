package 큐_덱;

import java.util.*;
import java.io.*;
public class No18258_큐2 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		
		int N=Integer.parseInt(br.readLine());
		StringTokenizer command;
		Queue<Integer> q=new LinkedList<>();
		
		int last=0;

		for(int i=0;i<N;i++) {
			command=new StringTokenizer(br.readLine()," ");
			switch(command.nextToken()) {
			case "push":
				int num=Integer.parseInt(command.nextToken());
				last=num;
				q.offer(num);
				break;
			case "front":
				if(!q.isEmpty())
					sb.append(q.peek()).append('\n');
				else
					sb.append(-1).append('\n');
				break;
			case "back":
				if(!q.isEmpty()) 
					sb.append(last).append('\n');
				else
					sb.append(-1).append('\n');
				break;
			case "size":
				sb.append(q.size()).append('\n');
				break;
			case "empty":
				if(q.isEmpty())
					sb.append(1).append('\n');
				else
					sb.append(0).append('\n');
				break;
			case "pop":
				if(!q.isEmpty())
					sb.append(q.poll()).append('\n');
				else
					sb.append(-1).append('\n');
				break;
			}
		}
		
		System.out.println(sb);
	}

}
