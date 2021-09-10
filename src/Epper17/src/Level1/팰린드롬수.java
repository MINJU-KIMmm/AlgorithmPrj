package Level1;

import java.util.Scanner;

public class 팰린드롬수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			String input=sc.next();
			if(input.equals("0")) break;
			
			boolean flag=solution(input);
			if(flag) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
	
	public static boolean solution(String str) {
		int left=0;
		int right=str.length()-1;
		boolean flag=true;
		
		while(left<=right) {
			if(str.charAt(left)!=str.charAt(right)) {
				flag=false;
			}
			
			left++;
			right--;
		}
		
		return flag;
	}
}
