package Level2;

import java.util.*;
public class Z {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int r=sc.nextInt();
		int c=sc.nextInt();
		
		solution(N, r, c);
	}
	
	public static void solution(int N, int r, int c) {
		int size=1;
		
		for(int i=0;i<N;i++) {
			size*=2;
		}
		
		int x=0;
		int y=0;
		int cnt=0;
		while(size>0) {
			size/=2;
			
			
			if(r<x+size&&c<y+size) {
				cnt+=(size*size*0);
			} else if(r<x+size&&c>=y+size) {
				cnt+=(size*size*1);
				y+=size;
			} else if(r>=x+size&&c<y+size) {
				cnt+=(size*size*2);
				x+=size;
			} else {
				cnt+=(size*size*3);
				x+=size;
				y+=size;
			}
			
			if(size==1) {
				System.out.println(cnt);
				break;
			}
		}
	}

}
