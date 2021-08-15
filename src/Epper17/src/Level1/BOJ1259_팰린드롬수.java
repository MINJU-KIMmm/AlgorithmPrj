package Level1;

import java.util.Scanner;

public class BOJ1259_팰린드롬수 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			String str=sc.nextLine();
			if(str.equals("0")) break;
			
			boolean ans=solution(str);
			if(ans) System.out.println("yes");
			else System.out.println("no");
			}
	}
	
	static boolean solution(String str) {
		int left=0;
		int right=str.length()-1;
		boolean ans=true;
		
		while(left<=right) {
			if(str.charAt(left)!=str.charAt(right)){
				ans=false;
			}
			
			left++;
			right--;
		}
		
		return ans;
	}
}
