package Ch1_Greedy;
import java.util.*;
import java.io.*;
public class Q04_만들수없는금액 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		int[] arr=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int goal=1; //있는지 없는지 체크할 값 
		for(int coin:arr) {
			if(goal<coin) break; //없으면 break (만들 수 없는 최솟값을 구하는 문제이므로 coin보다 작을때 break한다)
			goal+=coin; //만들 수 있으면 coin을 더해 goal 갱신 => 새로운 goal 에 대해 체크  
		}
		
		System.out.println(goal);
	}

}
