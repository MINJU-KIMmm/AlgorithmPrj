package 그리디알고리즘;
import java.util.*;

public class No1931_회의실배정 {
	
	static int[][] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		arr=new int[N][2];
		
		for(int i=0;i<N;i++) {
			arr[i][0]=sc.nextInt();
			arr[i][1]=sc.nextInt();
		}
		
		int max=1;
		
		Arrays.sort(arr, new Comparator<int[]>(){
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1])
					return o1[0]-o2[0];
				return o1[1]-o2[1];
			}
		});
		
		
		int time=arr[0][1];
		for(int i=1;i<N;i++) {
			if(time<=arr[i][0]) {
				max++;
				time=arr[i][1];
			}
		}
		
		System.out.println(max);
	}

}
