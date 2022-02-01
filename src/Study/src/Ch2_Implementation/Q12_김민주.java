package Ch2_Implementation;

import java.util.*;
import java.io.*;
public class Q12_김민주 {
	
	
	static class Point {
		int c=0;
		int b=0;
		
//		public Point(int c, int b) {
//			this.c=c;
//			this.b=b;
//		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[][] answer=solution(5, new int[][] {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}});
		//int[][] answer=solution(5, new int[][] {{0,0,0,1}, {2,1,0,1}, {3, 3, 1, 1}, {0,0,0,0}});
		int[][] answer=solution(5, new int[][] {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}});
		for(int i=0;i<answer.length;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(answer[i][j]);
			}
			System.out.println();
		}
	}
	
	public static int[][] solution(int n, int[][] build_frame) {
        Point[][] arr=new Point[n+1][n+1];
        ArrayList<int[]> answer=new ArrayList<>();
        
        for(int i=0;i<arr.length;i++) {
        	for(int j=0;j<arr.length;j++) {
        		arr[i][j]=new Point();
        	}
        }
        for(int[] frame:build_frame) {
        	int x=frame[0];
        	int y=frame[1];
        	int a=frame[2];
        	int b=frame[3];
        	
        	if(a==0) {
        		if(b==1) {
        			arr[n-y][x].c+=1;
        			arr[n-y-1][x].c+=1;
        			
        			if(buildC(arr, x, y)) {
        				answer.add(new int[]{x, y, a});
        			}
        			else {
        				arr[n-y][x].c-=1;
        				arr[n-y-1][x].c-=1;
        			}
        		}
        		
        		else {
        			arr[n-y][x].c-=1;
        			arr[n-y-1][x].c-=1;
        			
        			if(deleteC(arr, x, y)) {
        		        answer=listRemove(answer, new int[] {x,y,a});
        			}else {
        				arr[n-y][x].c+=1;
        				arr[n-y-1][x].c+=1;
        			}
        		}
        	}
        	
        	else {
        		if(b==1) {
        			arr[n-y][x].b+=1;
        			arr[n-y][x+1].b+=1;
        			
        			if(buildB(arr, x, y)) {
        				answer.add(new int[] {x, y, a});
        			}
        			else {
        				arr[n-y][x].b-=1;
        				arr[n-y][x+1].b-=1;
        			}
        		}
        		
        		else {
        			arr[n-y][x].b-=1;
        			arr[n-y][x+1].b-=1;
        			
        			if(deleteB(arr, x, y)) {
        		        answer=listRemove(answer, new int[] {x,y,a});


        			}else {
        				arr[n-y][x].b+=1;
        				arr[n-y][x+1].b+=1;

        			}
        		}
        
        	}
        }
        
        int[][] ans=new int[answer.size()][3];
        for(int i=0;i<answer.size();i++) {
        	ans[i]=answer.get(i);
        }
        
        
        
        Arrays.sort(ans, new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		if(o1[0]==o2[0]) {
        			if(o1[1]==o2[0]) {
        				return o1[2]-o2[2];
        			}
        			else {
        				return o1[1]-o2[1];
        			}
        		}
        		
        		return o1[0]-o2[0];
        	}
        });
        
        return ans;
    }
	
	static boolean buildC(Point[][] arr, int x, int y) {
		int n=arr.length-1;
		
		if(y==0) return true;
		
		if(arr[n-y][x].b>0) return true;
		
		if(arr[n-y][x].c==2) return true;
		
		return false;
	}
	
	static boolean deleteC(Point[][]arr, int x, int y) {
		int n=arr.length-1;
		
		if(arr[n-y][x].c!=0) {
			if(!buildC(arr, x, y)) return false;
		}
		
		if(arr[n-y-1][x].c!=0) {
			if(!buildC(arr, x, y+1)) return false;
		}
		
		if(arr[n-y][x].b!=0) {
			if(!buildB(arr, x, y)) return false;
		}
		
		if(arr[n-y-1][x].b!=0) {
			if(!buildB(arr, x, y+1)) return false;
		}
		
		return true;
	}

	static boolean buildB(Point[][] arr, int x, int y) {
		int n=arr.length-1;
		
		if(arr[n-y][x].c!=0||arr[n-y][x+1].c!=0) return true;
		
		if(arr[n-y][x].b==2&&arr[n-y][x+1].b==2) return true;
		
		return false;
	}
	
	static boolean deleteB(Point[][] arr, int x, int y) {
		int n=arr.length-1;
		
		if(arr[n-y][x].c!=0) {
			if(!buildC(arr, x, y)) return false;
		}
		
		if(arr[n-y][x+1].c!=0) {
			if(!buildC(arr, x+1, y)) return false;
		}
		
		if(arr[n-y][x].b!=0) {
			if(!buildB(arr, x, y)) return false;
		}
		
		if(arr[n-y][x+1].b!=0) {
			if(!buildB(arr, x+1, y)) return false;
		}
		
		return true;
	}
	
	static ArrayList<int[]> listRemove(ArrayList<int[]> list, int[] arr) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i)[0]==arr[0]&&list.get(i)[1]==arr[1]&&list.get(i)[2]==arr[2]) {
				list.remove(i);
			}
		}
		
		return list;
	}
}
