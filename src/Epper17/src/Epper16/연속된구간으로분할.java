package Epper16;

import java.util.*;
public class 연속된구간으로분할 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> arr=solution("pizza");
		
		for(int i=0;i<arr.size();i++) {
			System.out.println(arr.get(i));
		}
	}
	
	public static ArrayList<String> solution(String s) {
		boolean flag=false;
		ArrayList<String>arr=new ArrayList<>();

		String put="";
		for(int i=0;i<s.length()-1;i++) {
			char c=s.charAt(i);
			int j=i+1;
			while(!flag&&j<s.length()) {
				char next=s.charAt(j);
				if(next==c) {
					
				}
				else {
					put+=next;
					flag=true;
				}
				
				j++;
			}
			
		}
		
		if(s.charAt(0)==s.charAt(1)) arr.add(0, "");
		if(s.charAt(s.length()-1)==s.charAt(s.length()-2)) arr.add(arr.size()-1, "");
		
		return arr;
	}
}
