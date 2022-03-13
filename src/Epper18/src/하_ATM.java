import java.util.*;
import java.io.*;
public class 하_ATM {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		int[] arr=new int[n];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int answer=solution(n, arr);
		System.out.println(answer);
	}
	
	static int solution(int n, int[] arr) {
		Arrays.sort(arr);
		
		int sum=0;
		int totalSum=0;
		for(int i=0;i<n;i++) {
			sum+=arr[i];
			totalSum+=sum;
		}
		
		return totalSum;
	}

}
