import java.util.*;
import java.io.*;
public class 하_분해합 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//입력
		int n = Integer.parseInt(br.readLine());
		//연산
		int answer = solution(n);
		//출력
		System.out.println(answer);
	}
	
	static int solution(int n) {
		int answer=0;
		int sum=0;
		for(int i=1;i<n;i++) {
			int calc=i;
			sum=calc;
			
			while(calc>0) {
				sum+=(calc%10);
				calc/=10;
			}
			
			if(sum==n) {
				answer=i;
				break;
			}
		}
		
		return answer;
	}
}
