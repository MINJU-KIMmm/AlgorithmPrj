package EPPER18;

import java.util.*;
import java.io.*;
public class 중_암호코드 {
	
	static final int MOD=1000000;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String str=br.readLine();
		int answer=solution(str, str.length());
		System.out.println(answer);
	}

	static int solution(String str, int n) {
		int answer;
		long[] dp=new long[n+1];
		
		if(str.charAt(0)=='0') return 0;
		
		//뒤에 반복문을 편하게 수행하기 위해 더미인덱스 dp[[0]마련 (인덱스 에러 방지)
		dp[0]=dp[1]=1;
		
		for(int i=2;i<=n;i++) {
			int idx=i-1;
			
			//해석 불가능한 경우 (10, 20이 아닌 00, 30, 40등)
			if(str.charAt(idx)=='0'&&(str.charAt(idx-1)>'2'||str.charAt(idx-1)<'1')) return 0;
		
			//dp[i-1]에 이어서 한글자만 해석하는 경우 
			if(str.charAt(idx)!='0') dp[i]+=dp[i-1];
			
			//dp[i-2]에 이어서 두글자 해석하는 경우 
			if(str.charAt(idx-1)=='1'||(str.charAt(idx-1)=='2'&&str.charAt(idx)<='6')) dp[i]+=dp[i-2];
			
			dp[i]%=MOD;
		}
		
		answer=(int)dp[n];
		return answer;
	}
}
