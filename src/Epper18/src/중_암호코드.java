import java.util.*;
import java.io.*;
public class 중_암호코드 {
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String str=br.readLine();
		int answer=solution(str, str.length());
		
		System.out.println(answer);
	}

	static int solution(String str, int n) {
		long[] dp=new long[n+1];
		if(str.charAt(0)=='0') return 0;
		
		dp[0]=dp[1]=1;
		
		for(int i=2;i<n+1;i++) {
			int idx=i-1;
			
			if(str.charAt(idx)=='0'&&(str.charAt(idx-1)<'1'||str.charAt(idx-1)>'2')) return 0;
			
			if(str.charAt(idx)!='0') dp[i]+=dp[i-1];
			
			if(str.charAt(idx-1)=='1'||(str.charAt(idx-1)=='2'&&str.charAt(idx)<='6')) dp[i]+=dp[i-2];
			
			dp[i]%=1000000;
		}
		
		return (int)dp[n];
	}
}
