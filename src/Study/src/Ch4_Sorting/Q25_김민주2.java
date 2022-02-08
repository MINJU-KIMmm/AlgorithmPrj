package Ch4_Sorting;

import java.util.*;
public class Q25_김민주2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Stage implements Comparable<Stage>{
		int stage;
		double fail;
		
		public Stage(int stage, double fail) {
			this.stage=stage;
			this.fail=fail;
		}
		
		@Override
		public int compareTo(Stage o) {
			if(this.fail==o.fail) return Integer.compare(this.stage, o.stage);
			return Double.compare(o.fail, this.fail);
		}
	}
	public static int[] solution(int N, int[] stages) {
		int[]answer= new int[N];
		
		int length=stages.length;
		ArrayList<Stage>arr=new ArrayList<>();
		
		
		for(int i=1;i<N+1;i++) {
			int count=0;
			for(int j=0;j<stages.length;j++) {
				if(stages[j]==i) {
					count++;
				}
			}
			
			double fail=0;
			if(length>=1) {
				fail=(double)count/length;
			}
			
			arr.add(new Stage(i, fail));
			length-=count;
		}
		
		Collections.sort(arr);
		
		for(int i=0;i<N;i++) {
			answer[i]=arr.get(i).stage;
		}
		
		return answer;
	}

}
