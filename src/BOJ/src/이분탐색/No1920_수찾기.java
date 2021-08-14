package 이분탐색;

import java.util.*;

public class No1920_수찾기 {

	static int[] A;
	static int[] B;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}

		Arrays.sort(A);

		int M = sc.nextInt();
		B = new int[M];
		for (int i = 0; i < M; i++) {
			B[i] = sc.nextInt();
		}
		
		for(int compare:B) {
			System.out.println(solution(0, (N-1)/2, N-1, compare));
		}
	}

	static int solution(int left, int mid, int right, int compare) {
		while (left<=right) {
			if (compare == A[mid]) {
				return 1;
			} else if (compare < A[mid]) {
				return solution(left, (left + mid-1) / 2, mid - 1, compare);
			} else {
				return solution(mid+1, (mid+1+right)/2, right, compare);
			}
		}
		
		return 0;
	}

}
