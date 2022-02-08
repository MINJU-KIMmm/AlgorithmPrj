package Ch4_Sorting;

import java.util.*;
import java.io.*;
public class Q25_김민주 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sol=solution(5, new int[] {});
		for(int i=0;i<2;i++	) {
			System.out.println(sol[i]);
		}
	}
	
	static class Stage{
		int index;
		double fail;
		
		public Stage(int index, double fail) {
			this.index=index;
			this.fail=fail;
		}
		
//		@Override
//		public int compareTo(Stage o) {
////			if(this.fail==o.fail) {
////				return this.index-o.index;
////			}
//			
//			return (int) (o.fail-this.fail);
//		}
	}
	
	public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Stage[] stage_arr=new Stage[N];
        for(int i=0;i<N;i++) {
        	stage_arr[i]=new Stage(i+1, 0);
        }
        Arrays.sort(stages);
        
        int total_try=0;
        int fail=0;
        
        
        int jump=0;
        for(int i=0;i<stages.length;i+=jump) {
        	jump=0;
        	fail=0;
        	total_try=stages.length-i;
        	loop:
        		for(int j=i;j<stages.length;j++) {
        			if(stages[i]!=stages[j]) {	
        				break loop;
        			}
        			
        			if(stages[j]==N+1) {
        				fail=0;
        				stages[j]=N;
        				jump++;
        				break loop;
        			}
        			
        			
        			fail++;
        			jump++;
        			
        		}
        	//ystem.out.println(fail+" "+total_try);
        	Stage s=new Stage(stages[i], (double)fail/(double)total_try);
        	
    		stage_arr[stages[i]-1]=s;
    		
//    		total_try=0;
        }
        
//        if(total_try!=0) {
//        	System.out.println(fail+" "+total_try);
//        	Stage s=new Stage(stages[stages.length-1], (double)fail/(double)total_try);
//        	stage_arr[stages[stages.length-1]]=s;
//        }
        
        for(int i=0;i<N;i++) {
        	System.out.println(stage_arr[i].index+" "+stage_arr[i].fail);
        }
        Arrays.sort(stage_arr, new Comparator<Stage>() {
        	@Override
        	public int compare(Stage s1, Stage s2) {
        		if(s1.fail==s2.fail) {
        			return Integer.compare(s1.index, s2.index);
        		}
        		
        		return -Double.compare(s1.fail, s2.fail);
        	}
        });
        
        
        for(int i=0;i<N;i++) {
        	answer[i]=stage_arr[i].index;
        }
        
        return answer;
    }
}
