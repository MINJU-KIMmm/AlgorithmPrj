package Level1;

import java.util.Scanner;
public class 신규아이디추천 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		System.out.println(solution(str));
	}
	
	public static String solution(String new_id) {
		String answer="";
		
		//1단계 소문자
		new_id=new_id.toLowerCase();
		
		//2단계 정규식 => 소문자, ., _, -, 숫자
		new_id=new_id.replaceAll("[^-_.a-z0-9]","");
		
		//3단계 . 두번 이상
		while(new_id.contains("..")) {
			new_id	=new_id.replace("..", ".");
		}
		
		//4단계 양 끝 . 제거
		if(new_id.length()>0) {
			if(new_id.charAt(0)=='.') {
				new_id=new_id.substring(1, new_id.length());
			}
		}
		
		if(new_id.length()>0) {
			if(new_id.charAt(new_id.length()-1)=='.')
				new_id=new_id.substring(0, new_id.length());
		}
		
		//5단계 new_id가 빈 문자열이면 a 대입
		if(new_id.length()==0) {
			new_id="a";
		}
		
		//6단계 16자 미만
		if(new_id.length()>=16) {
			new_id=new_id.substring(0,15);
		}
		if(new_id.charAt(new_id.length()-1)=='.') {
			new_id=new_id.substring(0, new_id.length()-1);
		}
		
		//7단계 2자 이하인 경우 
		if(new_id.length()<=2) {
			while(new_id.length()<3) {
				new_id+=new_id.charAt(new_id.length()-1);
			}
		}
		
		return new_id;
	}
}
