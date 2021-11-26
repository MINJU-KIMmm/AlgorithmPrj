package 동적계획법1;

import java.util.*;
import java.io.*;
public class No1904_01타일 {
	
	static Integer[] dp = new Integer[1000001]; 
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		//1 : 1
		//00, 11 :2
		//001, 100, 111 : 3
		//0000, 0011, 1100, 1001, 1111 : 5
		//00001, 00100, 10000, 11001, 11100, 00111, 10011 , 11111 : 8
		//00*3개 : 1, 00*2개 + 1*2개 : 6, 00*1개 +1*4개 : 4, 1*6개 : 1 -> 11
		
		
		dp[0]=0;
		dp[1]=1;
		dp[2]=2;
		
		System.out.println(solution(N));
		
	}
	
	static Integer solution(int N) {
		if(dp[N]==null) {
			dp[N]=(solution(N-1)+solution(N-2))%15746;
		}
		
		return dp[N];
	}

}
