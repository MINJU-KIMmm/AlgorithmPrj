package Level1;

import java.util.*;

public class 모의고사 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] answers= {1,2,3,4,5};
		for(int i=0;i<1;i++) {
			System.out.println(solution(answers)[i]);
		}
	}

	 public static int[] solution(int[] answers) {
	        int[] answer = {};
	        int a[]={1,2,3,4,5};
	        int b[]={2,1,2,3,2,4,2,5};
	        int c[]={3,3,1,1,2,2,4,4,5,5};
	        
	        int score[]=new int[3];
	        
	        for(int i=0;i<answers.length;i++){
	            if(answers[i]==a[i%5])
	            	score[0]++;
	        }
	        
	        for(int i=0;i<answers.length;i++){
	            if(answers[i]==b[i%8])
	                score[1]++;
	        }
	        
	        for(int i=0;i<answers.length;i++){
	            if(answers[i]==c[i%10])
	                score[2]++;
	        }
	        
	        int max=score[0];
	        for(int i=0;i<3;i++) {
	        	if(max<score[i])
	        		max=score[i];
	        }
	        
	        List<Integer> student=new ArrayList<>();
	        
	        for(int i=0;i<3;i++) {
	        	if(max==score[i])
	        		student.add(i+1);
	        }
	        
	        answer=new int[student.size()];
	        
	        for(int i=0;i<student.size();i++) {
	        	answer[i]=student.get(i);
	        }
	        
	        return answer;
	    }
}

class Solution {
   
}