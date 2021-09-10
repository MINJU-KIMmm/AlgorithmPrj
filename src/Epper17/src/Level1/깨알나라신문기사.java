package Level1;

import java.util.*;

public class 깨알나라신문기사 {

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

	//원본크기 ; r(행), c(열)/ 확대방법 :zr(몇줄), zc(문자몇번 반복)
	public static List<String> solution(int r, int c, int zr, int zc, String[] words) {
		List<String> answer = new ArrayList<>();
		// 코드를 작성해주세요.
		for(int i=0;i<r;i++) {
			String str=words[i];
			for(int j=0;j<zr;j++) {
				for(int k=0;k<c;k++) {
					for(int t=0;t<zc;t++) {
						System.out.print(str.charAt(k));
					}
				}
				System.out.println();
			}
		}
		
		return answer;
	}
}
