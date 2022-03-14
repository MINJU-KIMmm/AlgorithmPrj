package EPPER18;

import java.util.*;
import java.io.*;
public class 상_스도쿠 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int sudoku[][]=new int[9][9];
		for(int i=0;i<9;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				sudoku[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int[][] answer=solution(sudoku);
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(answer[i][j]+" ");
			}
			System.out.println();

		}
	}
	
	static int[][] answer=new int[9][9];
	
	static int[][] solution(int sudoku[][]) {
		solve(sudoku,0,0);
		return answer;
	}
	
	static void solve(int[][]arr, int row, int col) {
		// 행기준으로 시작 (1행-1열, 1행-2열 ...2행-1열 ..의 순서)
		
		//해당 행의 모든 열을 다 돌았을 경우 다음 행 0열부터 시작 
		if(col==9) {
			solve(arr, row+1, 0);
			return;
		}
		
		//행을 다돌았을 경우 정답 배열에 복사 후 종료 
		if(row==9) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					answer[i][j]=arr[i][j];
				}
			}
			
			return;
		}
		
		//일반 탐색 
		//스도쿠의 해당 칸이 빈칸이라면 
		if(arr[row][col]==0) {
			//i=채워넣을 숫자 
			for(int i=1;i<=9;i++) {
				//채워넣을 수 있는 수라면 스도쿠에 숫자를 채워 넣고 재귀로 다음 탐색 진행 
				if(check(arr, row,col,i)) {
					arr[row][col]=i;
					solve(arr, row,col+1);
				}
			}
			
			//다른 탐색을 위해 초기화 
			arr[row][col]=0;
			return;
		}
		
		//다음 단계 
		solve(arr, row,col+1);
	}
	
	static boolean check(int[][] arr, int row, int col, int num) {
		//같은행에 같은 숫자가 있는지 확인 
		for(int i=0;i<9;i++) {
			if(arr[row][i]==num)return false;
		}
		
		//같은 열에 같은 숫자가 있는지 확인  
		for(int i=0;i<9;i++) {
			if(arr[i][col]==num)return false;
		}
		
		int x=(row/3)*3; //행의영역의 시작점  계산 
		int y=(col/3)*3; //열의 영역의 시작 계산 
		
		//같은 칸(3x3)내에 같은 숫자가 있는지 확인 
		for(int i=x;i<x+3;i++) {
			for(int j=y;j<y+3;j++) {
				if(arr[i][j]==num) return false;
			}
		}
		
		return true;
	}
}

