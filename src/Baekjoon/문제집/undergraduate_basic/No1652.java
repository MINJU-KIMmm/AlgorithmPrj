import java.util.Scanner;
public class No1652 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String[][]arr=new String[n][n];
		
		for(int i=0;i<n;i++) {
			String input=sc.next();
			for(int j=0;j<n;j++) {
				arr[i][j]=Character.toString(input.charAt(j));
			}
		}

		solution(arr, n);
	
	}
	
	public static void solution(String[][] arr, int n) {
		int cnt=0;
		int place=0;
		
		//가로
		for(int i=0;i<n;i++) {
			place=0;
			for(int j=0;j<n;j++) {
				//빈공간
				if(arr[i][j].equals("."))
					place++;
				//짐
				else {
					//누울자리가 있는 경우
					if(place>=2)
						cnt++;
					place=0;
				}
			}
			//벽
			if(place>=2) cnt++;
		}
		
		System.out.print(cnt+" ");
		
		//세로
		cnt=0;
		for(int j=0;j<n;j++) {
			place=0;
			for(int i=0;i<n;i++) {
				//빈공간
				if(arr[i][j].equals("."))
					place++;
				//짐
				else {
					//누울자리가 있는 경우
					if(place>=2)
						cnt++;
					place=0;
				}
			}
			//벽
			if(place>=2) cnt++;
		}
		
		System.out.print(cnt);
	}
}
