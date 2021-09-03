package Level3;

import java.util.Scanner;
public class E15No8_EQueen {
	
	static int N;
	static int[] col=new int[15]; //col[n] = n번째 행의 몇번째 열에 퀸이 놓여 있는지
	static int[][] xy=new int[15][15];
	static int ans;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, k, a;
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		k=sc.nextInt();
		
		int[]X=new int[k];
		int[]Y=new int[k];
		
		for(int i=0;i<k;i++) {
			X[i]=sc.nextInt();
		}
		
		for(int i=0;i<k;i++) {
			Y[i]=sc.nextInt();
		}
		
		System.out.println(solution(n, k, X, Y));
	}
	
	//절댓값 
	static int abs(int a, int b) {
		return a-b>0? a-b:b-a;
	}
	
	//현재 상태 확인(퀸이 서로 공격하지 않게 놓아진 상황인지)
	static boolean promising(int i) {
		int k=1;
		boolean flag=true;
		
		while(k<i&&flag) {
			if(col[i]==col[k]||abs(col[i],col[k])==i-k) {
				flag=false;
			}
			k++;
		}
		
		return flag;
	}
	
	static void queens(int i) {
		int j;
		
		if(promising(i)) {
			if(i==N) {
				ans++;
			}else {
				for(j=1;j<=N;j++) {
					if(xy[i][j]==1) continue; //불가능한 위치에 놓은 경우 : 패스(추가)
					col[i+1]=j; //(i+1, j)에 퀸을 놓았다고 가정 
					queens(i+1);//퀸을 놓은 후 다음행으로 넘어감 
				}
			}
		}
	}
	
	static int solution(int n, int k, int X[], int Y[]) {
		int xLen=X.length;
		int yLen=Y.length;
		
		N=n; //n=체스판 사이즈 
		//놓을 수 없는 (x, y) 를 1로 표시 
		for(int i=0;i<k;i++) {
			xy[X[i]-1][Y[i]]=1;
		}
		
		queens(0);
		
		return ans;
	}
}
