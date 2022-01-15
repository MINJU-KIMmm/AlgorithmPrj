package Ch1_Greedy;
import java.util.*;
import java.io.*;
public class Q03_문자열뒤집기 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		
		//내 풀이
		int count=1; //구분되는 지점 개수 
		for(int i=0;i<str.length()-1;i++) {
			char c1=str.charAt(i);
			char c2=str.charAt(i+1);
			
			if(c1!=c2) count++;
		}

		System.out.println(count/2);

		//답지 풀이 
		int count0=0; // 전부 0으로 바꾸는 경우 
		int count1=0; // 전부 1로 바꾸는 경우 
		
		if(str.charAt(0)=='1') count0++;
		else count1++;
		
		//두번째부턴 모든 원소를 확인
		for(int i=0;i<str.length()-1;i++) {
			if(str.charAt(i)!=str.charAt(i+1)) {
				if(str.charAt(i+1)=='1') count0++;
				else count1++;
			}
		}
		
		System.out.println(Math.min(count0, count1));
	}

}
