package 그리디알고리즘;
import java.util.Scanner;
public class No13305_주유소 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int[]road=new int[N-1];
		int[]cost=new int[N];
		
		for(int i=0;i<N-1;i++)
			road[i]=sc.nextInt();
		for(int i=0;i<N;i++)
			cost[i]=sc.nextInt();
		
		int minCost=0;
	
		int idx=0;
		int jdx=0;
		while(true) {
			if(idx==N-1)
				break;
			
			jdx=0;
			
			while(cost[idx]<=cost[idx+jdx]) {
				minCost+=(cost[idx]*(road[idx+jdx]));
				jdx++;
				
				if(idx+jdx==N-1)
					break;
			}
			
			idx+=jdx;
		}
		
		System.out.println(minCost);
	}

}
