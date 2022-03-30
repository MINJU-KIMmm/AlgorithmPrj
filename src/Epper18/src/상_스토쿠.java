import java.util.*;
import java.io.*;
public class 상_스토쿠 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int[][] answer=new int[9][9];
	static int[][] solution(int[][] sudoku) {
		solve(0,0,sudoku);
		return answer;
	}
	
	static void solve(int row, int col, int[][] sudoku) {
		if(col==9) {
			solve(row+1, 0, sudoku);
			return;
		}
		
		if(row==9) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					answer[i][j]=sudoku[i][j];
				}
			}
			return;
		}
		
		if(sudoku[row][col]==0) {
			for(int i=1;i<=9;i++) {
				if(check(row,col,i,sudoku)) {
					sudoku[row][col]=i;
					solve(row,col+1,sudoku);
				}
			}
			
			sudoku[row][col]=0;
			return;
		}
		
		solve(row,col+1,sudoku);
	}
	
	static boolean check(int row, int col, int num, int[][] sudoku) {
		for(int i=0;i<9;i++) {
			if(sudoku[i][col]==num) return false;
		}
		
		for(int i=0;i<9;i++) {
			if(sudoku[row][i]==num) return false;
		}
		
		int x=(row/3)*3;
		int y=(col/3)*3;
		
		for(int i=x;i<x+3;i++) {
			for(int j=y;j<y+3;j++) {
				if(sudoku[i][j]==num) return false;
			}
		}
		
		return true;
	}

}
