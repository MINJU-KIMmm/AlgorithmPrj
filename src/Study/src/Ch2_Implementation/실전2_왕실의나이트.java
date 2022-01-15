package Ch2_Implementation;

import java.io.*;
import java.util.*;
public class 실전2_왕실의나이트 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String str=br.readLine();
		int x=str.charAt(0)-'a';
		int y=str.charAt(1)-'1';

		int count=0;
		
		int[] dx= {-1, -1, 1, 1, -2, -2, 2, 2};
		int[] dy= {-2, 2, -2, 2, -1, 1, -1, 1};
		
		for(int i=0;i<8;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(check(nx, ny)) {
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	static boolean check(int col, int row) {
		if(col<0||col>8||row<0||row>8) return false;
		return true;
	}
}
