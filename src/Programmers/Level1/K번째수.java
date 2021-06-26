package Level1;
import java.util.*;
public class K¹øÂ°¼ö {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array= {1,5,2,6,3,7,4};
		int commands[][]= {{2,5,3},{4,4,1},{1,7,3}};
		
		int[] ans=solution(array, commands);
		
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i]);
		}
	}
	
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        
        answer=new int[commands.length];
        for(int i=0;i<commands.length;i++){
            int temp[]=new int[commands[i][1]-commands[i][0]+1];
            for(int j=0;j<temp.length;j++){
                int index=commands[i][0]-1+j;
                temp[j]=array[index];
            }
            
            Arrays.sort(temp);
            
            answer[i]=temp[commands[i][2]-1];
        }
        return answer;
    }
}
