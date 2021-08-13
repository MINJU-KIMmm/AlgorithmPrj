package 분할정복;
import java.util.Scanner;
public class No1992_쿼드트리 {
	
	public static int[][] arr;
	public static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		//입력 
		int N=sc.nextInt();
		arr=new int[N][N];
		for(int i=0;i<N;i++) {
			String str=sc.next();
			for(int j=0;j<N;j++)
				arr[i][j]=str.charAt(j)-'0';
		}
		
		partition(0, 0, N);
		
		System.out.println(sb); 
		
	}

	static void partition(int row, int col, int size) {
		if(sameNumber(row, col, size)) {
			sb.append(arr[row][col]);
			return;
		}
		
		sb.append('('); 
		int newSize=size/2;
		partition(row, col, newSize); //왼쪽 위 
		partition(row, col+newSize, newSize); //오른쪽 위 
		partition(row+newSize, col, newSize);//왼쪽 아래 
		partition(row+newSize, col+newSize, newSize); //오른쪽 아래 
		
		sb.append(')'); 
	}
	
	//영역이 같은 수로 이루어져있는지 
	static boolean sameNumber(int row, int col, int size) {
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
