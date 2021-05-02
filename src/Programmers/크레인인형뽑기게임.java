import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer=0;
		Stack<Integer>st=new Stack<>();
		
		for(int move:moves) {
			for(int i=0;i<board.length;i++) {
				if(board[i][move-1]!=0) {
					int item=board[i][move-1];
					if(!st.isEmpty()&&st.peek()==item) {
						answer+=2;
						st.pop();
					}
					else st.push(item);
					
					board[i][move-1]=0;
					break;
				}
			}
		}
		
		return answer;
    }
}