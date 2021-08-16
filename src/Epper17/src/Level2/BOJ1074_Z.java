package Level2;

import java.util.Scanner;
public class BOJ1074_Z {
	
	static int[][]arr;
	static int cnt=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int r=sc.nextInt();
		int c=sc.nextInt();
		
		int size=1;
		for(int i=0;i<N;i++	) {
			size*=2;
		}
		
		int cnt=0;
		int x=0;
		int y=0;
		
		while(size>0) {
			size/=2;
			
			if(r<x+size&&c<y+size) {
				cnt+=size*size*0;
			} else if(r<x+size&&c>=y+size) {
				cnt+=size*size*1;
				y+=size;
			} else if(r>=x+size&&c<y+size) {
				cnt+=size*size*2;
				x+=size;
			} else {
				cnt+=size*size*3;
				x+=size;
				y+=size;
			}
			
			if(size==1) {
				System.out.println(cnt);
				break;
			}
		}
		
	}
	
//	static void solution(int row, int col, int size) {
//		if(size==2) {
//			arr[row][col]=cnt++;
//			arr[row][col+1]=cnt++;
//			arr[row+1][col]=cnt++;
//			arr[row+1][col+1]=cnt++;
//			
//			return;
//		}
//		
//		int newSize=size/2;
//		solution(row, col, newSize);
//		solution(row, col+newSize, newSize);
//		solution(row+newSize, col, newSize);
//		solution(row+newSize, col+newSize, newSize);
//	}
//	
	
}
