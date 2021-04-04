//���� 12865 ����� �賶
/*�賶����
 * 1.���� �ɰ� �� �ִ� ��� Fraction knapsack Problem : �׸���
 * 2.���� �ɰ� �� ���� ��� 0/1 Knapsack Problem : dp
 * 
 * �� ������ 2���� �ش�
 */
import java.util.*;

public class No12865_NormalSack {
	static Integer[][] dp;
	static int[] w;
	static int[] v;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		
		w=new int[n];
		v=new int[n];
		
		dp=new Integer[n][k+1];
		
		for(int i=0;i<n;i++) {
			w[i]=sc.nextInt();
			v[i]=sc.nextInt();
		}
		
		System.out.println(knapsack(n-1,k));
	}
	
	static int knapsack(int i, int k) {
		if(i<0) return 0;
		
		//���� Ž�� �� ��
		if(dp[i][k]==null) {
			//���� ���� ���Ժ��� ���ſ� ���(�߰��� ���� ����)
			if(w[i]>k)
				dp[i][k]=knapsack(i-1, k);
			else 
				dp[i][k]=Math.max(knapsack(i-1, k-w[i])+v[i], knapsack(i-1, k));
		}
		return dp[i][k];
	}

}
