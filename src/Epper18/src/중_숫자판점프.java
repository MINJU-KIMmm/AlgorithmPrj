import java.util.*;
import java.io.*;
public class 중_숫자판점프 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int[][] arr=new int[5][5];
		
		String[] str;
		int answer=0;
		
		for(int i=0;i<5;i++) {
			str=br.readLine().split(" ");
			for(int j=0;j<5;j++) {
				arr[i][j]=Integer.parseInt(str[j]);
			}
		}
		
		answer=solution(arr);
		System.out.println(answer);
	}
	
	static int solution(int[][] arr) {
		int[]check=new int[1000000];
		
		for(int i=0;i<5;i++	) {
			for(int j=0;j<5;j++) {
				dfs(arr, check, i, j, arr[i][j], 0);
			}
		}
		
		int answer=0;
		for(int i=0;i<check.length;i++) {
			if(check[i]==1) {
				answer++;
			}
		}
		return answer;
	}
	
	static void dfs(int[][] arr, int[] check, int px, int py, int sum, int depth) {
		if(depth==5) {
			if(check[sum]==0) {
				check[sum]=1;
			}
			return;
		}
		
		int[]dx= {-1,1,0,0};
		int[]dy= {0,0,-1,1};
		
		for(int i=0;i<4;i++) {
			int nx=px+dx[i];
			int ny=py+dy[i];
			
			if(nx<0||nx>=5||ny<0||ny>=5) continue;
			
			dfs(arr, check, nx, ny, sum*10+arr[nx][ny], depth+1);
		}
		
		return;
	}

}
