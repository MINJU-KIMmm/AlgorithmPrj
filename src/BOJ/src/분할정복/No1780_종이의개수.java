package 분할정복;
import java.util.Scanner;
public class No1780_종이의개수 {

	public static int[][]arr;
	public static int minusOne=0;
	public static int one=0;
	public static int zero=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		
		arr=new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		partition(0,0,N);
		System.out.println(minusOne);
		System.out.println(zero);
		System.out.println(one);
		
	}
	
	static void partition(int row, int col, int size) {
		if(isSame(row, col, size)) {
			if(arr[row][col]==-1)
				minusOne++;
			else if(arr[row][col]==0)
				zero++;
			else
				one++;
			
			return;
		}
		
		int newSize=size/3;
		partition(row, col, newSize);
		partition(row, col+newSize, newSize);
		partition(row, col+2*newSize, newSize);
		partition(row+newSize, col, newSize);
		partition(row+newSize, col+newSize, newSize);
		partition(row+newSize, col+2*newSize, newSize);
		partition(row+2*newSize, col, newSize);
		partition(row+2*newSize, col+newSize, newSize);
		partition(row+2*newSize, col+2*newSize, newSize);
		
	}
	
	static boolean isSame(int row, int col, int size) {
		int num=arr[row][col];
		
		for(int i=row;i<row+size;i++) {
			for(int j=col;j<col+size;j++) {
				if(arr[i][j]!=num)
					return false;
			}
		}
		
		return true;
	}
}
