package 큐_덱;

import java.util.*;
import java.io.*;
public class No10866_덱{

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		ArrayDeque<Integer>dq=new ArrayDeque<>();
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(br.readLine());
		
		while(N-->0) {
			String[] str=br.readLine().split(" ");
			
			switch(str[0]) {
			case "push_front":
				dq.addFirst(Integer.parseInt(str[1]));
				break;
			case "push_back":
				dq.addLast(Integer.parseInt(str[1]));
				break;
			case "pop_front":
				if(!dq.isEmpty())
					sb.append(dq.pollFirst()).append('\n');
				else
					sb.append(-1).append('\n');
				break;
			case "pop_back":
				if(!dq.isEmpty())
					sb.append(dq.pollLast()).append('\n');
				else
					sb.append(-1).append('\n');
				break;
			case "size":
				sb.append(dq.size()).append('\n');
				break;
			case "empty":
				if(!dq.isEmpty())
					sb.append(0).append('\n');
				else
					sb.append(1).append('\n');
				break;
			case "front":
				if(!dq.isEmpty())
					sb.append(dq.peekFirst()).append('\n');
				else
					sb.append(-1).append('\n');
				break;
			case "back":
				if(!dq.isEmpty())
					sb.append(dq.peekLast()).append('\n');
				else
					sb.append(-1).append('\n');
				break;
			}
		}
		
		System.out.println(sb);
	}

}
