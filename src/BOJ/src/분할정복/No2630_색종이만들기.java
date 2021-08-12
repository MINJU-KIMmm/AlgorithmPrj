package 분할정복;

import java.util.Scanner;
public class No2630_색종이만들기 {
	
	public static int white=0;
	public static int blue=0;
	public static int[][] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		arr=new int[N][N];
		
		//색깔 입력받
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		solution(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}
	
	static void solution(int row, int col, int size) {
		//색상이 같은 경
		if(color(row, col, size)) {
			if(arr[row][col]==0)
				white++;
			else
				blue++;
			return;
		}
		
		//색상이 다른 경우 -> 또 네 개의 색종이로 나
		int newSize=size/2;
		solution(row, col, newSize);
		solution(row+newSize, col, newSize);
		solution(row, col+newSize, newSize);
		solution(row+newSize, col+newSize, newSize);
		
	}
	
	static boolean color(int row, int col, int size) {
		int c=arr[row][col];
		
		for(int i=row;i<row+size;i++) {
			for(int j=col;j<col+size;j++) {
				if(arr[i][j]!=c)
					return false;
			}
		}
		
		return true;
	}
}
