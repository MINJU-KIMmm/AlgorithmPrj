package Ch4_Sorting;

import java.util.*;
import java.io.*;
public class Q23_김민주 {
	
	static class student implements Comparable<student>{
		String n;
		int k;
		int e;
		int m;
		
		public student(String n, int k, int e, int m) {
			this.n=n;
			this.k=k;
			this.e=e;
			this.m=m;
		}
		
		@Override
		public int compareTo(student o) {
			if(this.k==o.k) {
				if(this.e==o.e) {
					if(this.m==o.m) {
						return this.n.compareTo(o.n);
					}
					
					return o.m-this.m;
				}
				
				return this.e-o.e;
			}
			
			return o.k-this.k;
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		student[] arr=new student[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			student s=new student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			arr[i]=s;
		}
		
		Arrays.sort(arr);
		
		for(int i=0;i<N;i++) {
			System.out.println(arr[i].n);
		}
	}

}
