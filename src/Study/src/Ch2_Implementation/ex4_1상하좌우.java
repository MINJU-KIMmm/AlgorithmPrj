package Ch2_Implementation;

import java.util.*;
import java.io.*;
public class ex4_1상하좌우 {

	static int[] dx= {-1, 1, 0, 0};
	static int[] dy= {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		ArrayList<String> arr=new ArrayList<>();
		for(int i=0;st.hasMoreTokens();i++) {
			arr.add(st.nextToken());
		}
		
		int col=1;
		int row=1;
		String[] types= {"L", "R", "U", "D"};
		for(int i=0;i<arr.size();i++) {
			for(int j=0;j<types.length;j++) {
				if(types[j].equals(arr.get(i))) {
					if(check(col+dx[j], row+dy[j], N)) {
						col+=dx[j];
						row+=dy[j];
					}
				}
			}
		}
		
		System.out.println(row+" "+col);
//		int col=1;
//		int row=1;
//		
//		
//		for(int i=0;i<arr.size();i++) {
//			if(arr.get(i).equals("R")) {
//				if(check(col+1, row, N)) col++;
//			} else if(arr.get(i).equals("L")) {
//				if(check(col-1, row, N)) col--;
//			} else if(arr.get(i).equals("U")) {
//				if(check(col, row-1, N)) row--;
//			} else {
//				if(check(col, row+1, N)) row++;
//			}
//		}
//		
//		System.out.println(row+" "+col);
		
		
	}
	
	static boolean check(int col, int row, int N) {
		if(col>N||row>N||col<1||row<1) return false;
		else return true;
	}
}
