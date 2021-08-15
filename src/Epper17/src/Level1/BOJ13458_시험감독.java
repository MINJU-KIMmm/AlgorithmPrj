package Level1;

import java.util.Scanner;

public class BOJ13458_시험감독 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}

		int B = sc.nextInt();
		int C = sc.nextInt();

		long cnt = N;

		for (int i = 0; i < N; i++) {
			int person = A[i] - B;
			if (person > 0) {
				if (person % C == 0) {
					cnt += (person / C);
				} else {
					cnt += (person / C + 1);
				}
			}
		}

		System.out.println(cnt);
	}

}
