package Level3;

import java.util.*;
import java.io.*;

public class 톱니바퀴 {

	static int[][] wheel = new int[4][8];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		for(int i=0;i<4;i++) {
			String str=sc.next();
			for(int j=0;j<8;j++) {
				int c=str.charAt(j)-'0';
				wheel[i][j]=c;
			}
		}
		
		int k=sc.nextInt();
		int[][] move_dir=new int[k][2];
		for(int i=0;i<k;i++) {
			move_dir[i][0]=sc.nextInt();
			move_dir[i][1]=sc.nextInt();
		}
		
		System.out.println(solution(wheel, k, move_dir));
	}

	// 9시방향은 2, 3시 방향은 6
	static void play(int num, int dir) {
		int pre_pole=wheel[num][6];
		int tmp_dir=dir;
		for(int i=num-1;i>=0;i--) {
			tmp_dir*=-1;
			if(pre_pole==wheel[i][2]) break;
			pre_pole=wheel[i][6];
			move_wheel(i, tmp_dir);
		}
		
		pre_pole=wheel[num][2];
		tmp_dir=dir;
		for(int i=num+1;i<4;i++) {
			tmp_dir*=-1;
			if(pre_pole==wheel[i][6]) break;
			pre_pole=wheel[i][2];
			move_wheel(i, tmp_dir);
		}
		
	}
	
	static void move_wheel(int id, int dir) {
		if(dir==-1) {
			int[] temp=new int[8];
			for(int i=0;i<8;i++) {
				temp[i]=wheel[id][i];
			}
			for(int i=0;i<7;i++) {
				wheel[id][i]=temp[i+1];
			}
			wheel[id][0]=temp[7];
		}
		
		else {
			int[] temp=new int[8];
			for(int i=0;i<8;i++) {
				temp[i]=wheel[id][i];
			}
			for(int i=1;i<8;i++) {
				wheel[id][i]=temp[i+1];
			}
			wheel[id][7]=temp[0];
		}
	}
	
	public static int solution(int[][]wheel, int k, int[][] move_dir) {
        int answer=0;
        
        for(int i=0;i<k;i++) {
        	int num=move_dir[i][0];
        	int dir=move_dir[i][1];
        	
        	play(num-1, dir);
        }
        
        int plus=1;
        for(int i=0;i<4;i++) {
        	if(wheel[i][0]==1) answer+=plus;
        	plus*=2;
        }
        
        return answer;
    }
}
