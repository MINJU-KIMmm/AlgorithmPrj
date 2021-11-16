package No1000;

import java.util.*;
public class No1002_터렛 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		
		while(T-->0) {
			int x1=sc.nextInt();
			int y1=sc.nextInt();
			int r1=sc.nextInt();
			
			int x2=sc.nextInt();
			int y2=sc.nextInt();
			int r2=sc.nextInt();
			
			System.out.println(solution(x1, y1, r1, x2, y2, r2));
		}
	}
	
	
	static int solution(int x1, int y1, int r1, int x2, int y2, int r2) {
		//접점 개수 무한대일 때 (같은 원)
		if(x1==x2&&y1==y2&&r1==r2) {
			return -1;
		}
		//접점없을 때 - 1 : 두원이 아예 떨어져 있는 경우 
		else if(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2)>Math.pow(r2+r1, 2)) {
			return 0;
		}
		//작은 원이 큰 원 안에 들어가는 경우 
		else if(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2)<Math.pow(r2-r1, 2)) {
			return 0;
		}
		//접점 한개 : 접함 - 내접 
		else if(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2)==Math.pow(r2-r1, 2)) {
			return 1;
		}
		//외접 
		else if(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2)==Math.pow(r2+r1, 2)) {
			return 1;
		}
		//접점 두개 
		else {
			return 2;
		}
	}
}
