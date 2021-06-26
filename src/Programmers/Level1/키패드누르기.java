package Level1;

import java.util.Scanner;
public class 키패드누르기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
	}
	
	public static String solution(int [] numbers, String hand) {
		String answer="";
		StringBuilder sb=new StringBuilder();
		
		int rd=0;
		int ld=0;
		
		int x_rLoc=3;
		int x_lLoc=1;
		
		int y_rLoc=4;
		int y_lLoc=4;
		
		int[] xLoc= {2,1,2,3,1,2,3,1,2,3};
		int[] yLoc= {4,1,1,1,2,2,2,3,3,3};
		
		for(int num:numbers) {
			if(num==1||num==4||num==7) {
				sb.append("L");
				y_lLoc=yLoc[num];
				x_lLoc=xLoc[num];
			}
			else if(num==3||num==6||num==9) {
				sb.append("R");
				y_rLoc=yLoc[num];
				x_rLoc=xLoc[num];
			}
			else if(num==2||num==5||num==8||num==0) {
				rd=Math.abs(y_rLoc-yLoc[num])+Math.abs(x_rLoc-xLoc[num]);
				ld=Math.abs(y_lLoc-yLoc[num])+Math.abs(x_lLoc-xLoc[num]);
				
				if(rd<ld) {
					sb.append("R");
					y_rLoc=yLoc[num];
					x_rLoc=xLoc[num];
				}
				else if(rd>ld) {
					sb.append("L");
					y_lLoc=yLoc[num];
					x_lLoc=xLoc[num];
				}
				else {
					if(hand.equals("left")) {
						sb.append("L");
						y_lLoc=yLoc[num];
						x_lLoc=xLoc[num];
					}
					else {
						sb.append("R");
						y_rLoc=yLoc[num];
						x_rLoc=xLoc[num];
					}
				}
			}
			
			answer=sb.toString();
		}
		return answer;
	}
}
