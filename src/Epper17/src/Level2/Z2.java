package Level2;

import java.util.Scanner;

public class Z2 {
	// 2 3 1 -> 11
	// 3 7 7 -> 63
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int r=sc.nextInt();
		int c=sc.nextInt();
		
		System.out.println(solution(N, r, c));
	}
	
	public static int solution(int n, int r, int c) {
		int size=1;
		for(int i=0;i<n;i++) {
			size*=2;
		}
		
		int cnt=0;
		int x=0;
		int y=0;
		
		while(size>0) {
			size/=2;
			if(r<x+size&&c<y+size) {
				cnt+=size*size*0;
			}else if(r<x+size&&c>=y+size) {
				cnt+=size*size*1;
				y+=size;
			}else if(r>=x+size&&c<y+size) {
				cnt+=size*size*2;
				x+=size;
			}else {
				cnt+=size*size*3;
				x+=size;
				y+=size;
			}
			
			if(size==1) break;
		}
		
		return cnt;
		
	}

}
