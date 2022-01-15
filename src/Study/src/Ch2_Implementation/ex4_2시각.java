package Ch2_Implementation;

import java.util.*;
import java.io.*;
public class ex4_2시각 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		int count=0;
		
		for(int i=0;i<=N;i++) {
			for(int j=0;j<60;j++) {
				for(int k=0;k<60;k++) {
					boolean h=Integer.toString(i).contains("3");
					boolean m=Integer.toString(j).contains("3");
					boolean s=Integer.toString(k).contains("3");
					
					if(h||m||s) count++;
				}
			}
		}
		
		System.out.println(count);
	}

}
