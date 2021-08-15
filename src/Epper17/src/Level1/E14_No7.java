package Level1;

import java.util.*;

public class E14_No7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r, c, zr, zc;

		r = sc.nextInt();
		c = sc.nextInt();
		zr = sc.nextInt();
		zc = sc.nextInt();
		String[] words = new String[r];

		for (int i = 0; i < r; i++) {
			words[i] = sc.next();
			if (words[i].length() > c) {
				System.out.println("입력 범위를 초과하였습니다.\n");
				System.exit(1);
			}
		}

		List<String> answer = solution(r, c, zr, zc, words);

		for (int i = 0; i < answer.size(); i++) {
			System.out.println(answer.get(i));
		}

		sc.close();
	}

	// r : 문장 개수
	// c : 문자 개수
	// zr : 몇 문장 반복 출력
	// zc : 몇 문자 반복 출력
	public static List<String> solution(int r, int c, int zr, int zc, String[] words) {
		List<String> answer = new ArrayList<>();
		// 코드를 작성해주세요.
		for(String word:words) {
			for(int i=0;i<zr;i++) {
				for(int j=0;j<c;j++) {
					for(int k=0;k<zc;k++) {
						System.out.print(word.charAt(j));
					}
				}
				System.out.println();
			}
		}

		return answer;
	}
}
