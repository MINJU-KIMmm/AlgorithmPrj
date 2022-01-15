package Ch2_Implementation;
import java.io.*;
import java.util.*;
public class Q09_김민주 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(String s) {
        int answer = 0;
        ArrayList<Integer> lens=new ArrayList<>();
        
        for(int i=1;i<=s.length();i++) {
        	if(!check(i, s.length())) continue;
        	
        	for(int j=0;j<s.length();j+=i) {
        		
        	}
        }
        return answer;
    }
	
	static boolean check(int n, int len) {
		if(len%n==0) return true;
		return false;
	}
}
