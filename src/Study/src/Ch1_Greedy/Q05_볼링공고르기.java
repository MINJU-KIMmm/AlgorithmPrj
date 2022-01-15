package Ch1_Greedy;
import java.util.*;
import java.io.*;
public class Q05_볼링공고르기 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		int[] arr=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int count=0;
		
		for(int i=0;i<N-1;i++) {
			if(arr[i]==M) break;
			for(int j=i+1;j<N;j++) {
				if(arr[i]!=arr[j]) count++;
			}
		}
		
		System.out.println(count);
	}

}
