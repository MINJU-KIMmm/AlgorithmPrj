import java.util.*;
import java.io.*;
public class 상_스토쿠 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int[][] answer=new int[9][9];
	
	static int[][] solution(int[][] sudoku) {
		solve(sudoku,0,0);
		return answer;
	}
	
	static void solve(int[][] sudoku, int x, int y) {
		if(y==9) {
			solve(sudoku, x+1, 0);
			return;
		}
		
		if(x==9) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					answer[i][j]=sudoku[i][j];
				}
			}
			
			return;
		}
		
		if(sudoku[x][y]==0) {
			for(int i=1;i<=9;i++) {
				if(check(sudoku, x, y, i)) {
					sudoku[x][y]=i;
					solve(sudoku, x, y+1);
				}
			}
			
			sudoku[x][y]=0;
			return;
		}
		
		solve(sudoku, x, y+1);
	}
	
	static boolean check(int[][]sudoku, int x, int y, int num) {
		for(int i=0;i<9;i++) {
			if(sudoku[x][i]==num) return false;
		}
		
		for(int i=0;i<9;i++) {
			if(sudoku[i][y]==num) return false;
		}
		
		int x_area=(x/3)*3;
		int y_area=(y/3)*3;
		
		for(int i=x_area;i<x_area+3;i++) {
			for(int j=y_area;j<y_area+3;j++) {
				if(sudoku[i][j]==num) return false;
			}
		}
		
		return true;
	}
}
