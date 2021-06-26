package Level1;

public class _2016년 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(5, 24));
	}

	public static String solution(int a, int b) {
		String answer = "";
		String day[] = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
		int last[] = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int first_day[] = new int[12];

		first_day[0] = 5;
		int index = 5;
		for (int i = 0; i < 11; i++) {
			index = (last[i] + index) % 7;
			first_day[i + 1] = index;
		}

		int first_day_ans = first_day[a - 1];
		// b-1
		answer = day[(first_day_ans + (b - 1)) % 7];
		return answer;

	}
}
