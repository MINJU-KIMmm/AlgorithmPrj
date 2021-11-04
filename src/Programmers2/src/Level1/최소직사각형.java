package Level1;

import java.util.*;
public class 최소직사각형 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int[][] sizes) {
		int answer = 0;
        int v = 0;
        int h = 0;
        
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0]>=sizes[i][1]){
                v = Math.max(sizes[i][0], v);
                h = Math.max(sizes[i][1], h);
            }else{
                v = Math.max(sizes[i][1], v);
                h = Math.max(sizes[i][0], h);
            }
        }
        answer = v * h;
        return answer;
	}
}
