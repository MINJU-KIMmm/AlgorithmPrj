package 이분탐색;
import java.util.*;
import java.io.*;
public class No10815_숫자카드 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] card=new int[N];
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			card[i]=Integer.parseInt(st.nextToken());
		}
		
		int M=Integer.parseInt(br.readLine());
		int[] target=new int[M];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			target[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(card);
		for(int t:target) {
			System.out.print(solution(card, t, 0, card.length-1)+" ");
		}
	}
	
	static int solution(int[] card, int target, int left, int right) {
		
		while(left<=right) {
			int mid=(left+right)/2;
			
			if(target<card[mid]) {
				right=mid-1;
			}
			else if(target>card[mid]) {
				left=mid+1;
			}
			else {
				return 1;
			}
		}
		
		return 0;
	}
}
