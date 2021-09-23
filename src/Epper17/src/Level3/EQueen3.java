package Level3;

import java.util.Scanner;

public class EQueen3 {
	static int[] col=new int[15];
	static int[][] xy=new int[15][15];
	static int N;
	static int ans=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, k, a;
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		k=sc.nextInt();
		
		int[] x=new int[k];
		int[] y=new int[k];
		
		for(int i=0;i<k;i++) {
			x[i]=sc.nextInt();
		}
		
		for(int i=0;i<k;i++) {
			y[i]=sc.nextInt();
		}
		
		System.out.println(solution(n, k, x, y));
		
	}
	
	static boolean check(int i) {
		int j=1;
		boolean flag=true;
		
		while(j<i&&flag) {
			if(col[i]==col[j]||Math.abs(col[i]-col[j])==i-j) flag=false;
			j++;
		}
		
		return flag;
	}
	
	static void queens(int i) {
		int j;
		
		if(check(i)) {
			if(i==N)ans++;
			else {
				for(j=1;j<=N;j++) {
					if(xy[i][j]==1) continue;
					col[i+1]=j;
					queens(i+1);
				}
			}
		}
	}
	
	static int solution(int n, int k, int[] x, int[] y) {
		N=n;
		for(int i=0;i<k;i++) {
			xy[x[i]-1][y[i]]=1;
		}
		
		queens(0);
		
		return ans;
	}
}
