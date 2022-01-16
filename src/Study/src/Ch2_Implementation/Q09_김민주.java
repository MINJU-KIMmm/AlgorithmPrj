package Ch2_Implementation;
import java.io.*;
import java.util.*;
public class Q09_김민주 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		
		System.out.println(solution(str));
	}

	static int solution(String s) {
        int answer = 0;
        ArrayList<String> split=new ArrayList<>();
        ArrayList<Integer> lens=new ArrayList<>();
        
        for(int i=1;i<=s.length()/2;i++) {        	
        	int count=1;
        	String current=s.substring(0,i);
        	StringBuilder sb=new StringBuilder();
        	
        	for(int j=i;j<=s.length();j+=i) {
        		String next="";
        		if(j+i>s.length()) {
        			next=s.substring(j, s.length());
        		}else {
        			next=s.substring(j, j+i);
        		}
        		
        		if(current.equals(next)) count++;
        		else {
        			if(count!=1) sb.append(count);
        			sb.append(current);
        			current=next;
        			count=1;
        		}
        	}
        	
        	sb.append(current);
        	lens.add(sb.toString().length());
        }
        
        Collections.sort(lens);

        answer=lens.get(0);
        return answer;
    }
	
	static boolean check(int n, int len) {
		if(len%n==0) return true;
		return false;
	}
}
