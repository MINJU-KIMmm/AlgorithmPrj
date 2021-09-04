package Level3;

import java.util.*;
import java.io.*;

public class B14891_톱니바퀴 {

	// 톱니바퀴[번호][방향]
	static char[][] wheel = new char[4][8]; // 8개의 톱니를 가지고 있는 4개의 톱니바퀴

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			for (int j = 0; j < 8; j++) {
				wheel[i][j] = s.charAt(j);
			}
		}
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken()); // 톱니바퀴 번호는 1~4, 인덱스는 0~3 play(num - 1, dir);
		}
		int plus = 1; // 점수계산 : 더할 값 
		int total = 0;
		for (int i = 0; i < 4; i++) {
			if (wheel[i][0] == '1')
				total += plus;
			plus *= 2;
		}
		System.out.println(total);
	}

	// 9시 방향은 2, 3시방향은 6
	static void play(int num, int dir) {
		char pre_pole = wheel[num][6];
		int tmp_dir = dir;
		for (int i = num - 1; i >= 0; i--) {
			tmp_dir *= -1;
			if (wheel[i][2] == pre_pole)
				break;
			pre_pole = wheel[i][6];
			move_wheel(i, tmp_dir);
		}

		pre_pole = wheel[num][2];
		tmp_dir = dir;
		for (int i = num + 1; i < 4; i++) {
			tmp_dir *= -1;
			if (wheel[i][6] == pre_pole)
				break;
			pre_pole = wheel[i][2];
			move_wheel(i, tmp_dir);
		}

		move_wheel(num, dir);
	}

	// dir =1 : 시계방향 , dir=-1 : 반시계방향
	// id : 톱니 , dir: 방향
	static void move_wheel(int id, int dir) {
		// 반시계방향
		if (dir == -1) {
			char[] temp = new char[8];
			for (int i = 0; i < 8; i++) {
				temp[i] = wheel[id][i];
			}
			for (int i = 0; i < 7; i++) {
				wheel[id][7] = temp[i + 1]; // pop_front
			}
			wheel[id][7] = temp[0]; // push_back
		} else {
			char[] temp = new char[8];
			for (int i = 0; i < 8; i++) {
				temp[i] = wheel[id][i];
			}
			for (int i = 1; i < 8; i++) {
				wheel[id][i] = temp[i - 1]; // pop_back
			}
			wheel[id][0] = temp[7];// push_front
		}
	}
}
