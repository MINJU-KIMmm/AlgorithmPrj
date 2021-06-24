package Level2;

import java.util.*;

public class 행렬테두리회전하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]ans=solution(6, 6, new int[][] {{2,2,5,4}});
		for(int i=0;i<1;i++) {
			System.out.println(ans[i]);
		}
	}

	public static int[] solution(int rows, int columns, int[][]queries) {
		int[] answer= {};
		answer=new int[queries.length];

		//행렬만들기
		int[][] arr=new int[rows][columns];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				arr[i][j]=(i)*columns+j+1;
			}
		}
		
		
		for(int i=0;i<queries.length;i++) {
			int row1=queries[i][0]-1;
			int col1=queries[i][1]-1;
			int row2=queries[i][2]-1;
			int col2=queries[i][3]-1;
			
			ArrayList<Integer>move=new ArrayList<>();
			
			int tmp=arr[row1][col1];
			for(int r=row1;r<row2;r++) {
				arr[r][col1]=arr[r+1][col1];
				move.add(arr[r][col1]);
			}			
			for(int c=col1;c<col2;c++) {
				arr[row2][c]=arr[row2][c+1];
				move.add(arr[row2][c]);
			}
			
			for(int r=row2;r>row1;r--) {
				arr[r][col2]=arr[r-1][col2];
				move.add(arr[r][col2]);
			}
			
			for(int c=col2;c>col1+1;c--) {
				arr[row1][c]=arr[row1][c-1];
				move.add(arr[row1][c]);
			}
			arr[row1][col1+1]=tmp;
			move.add(arr[row1][col1+1]);
			
			Collections.sort(move);
			answer[i]=move.get(0);
		}

		
		return answer;
	}
}
