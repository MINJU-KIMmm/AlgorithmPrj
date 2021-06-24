package Level2;
import java.util.*;

public class 전화번호목록 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new String[]{"119", "97964223", "1195524421"}));
	}

	//해시 쓰지 않는 방법 = startWith -> 효율성 테스트에서 걸림
//	public static boolean solution(String[] phone_book) {
//		boolean answer=true;
//		for(int i=0;i<phone_book.length-1;i++) {
//			for(int j=i+1;j<phone_book.length;j++) {
//				if(phone_book[i].startsWith(phone_book[j])) return false;
//				if(phone_book[j].startsWith(phone_book[i])) return false;
//			}
//		}
//		return answer;
//	}
	
	public static boolean solution(String[] phone_book) {
		boolean answer=true;
		HashMap<String, Integer>map=new HashMap<>();
		
		for(int i=0;i<phone_book.length;i++) {
			map.put(phone_book[i], i);
		}
		
		for(int i=0;i<phone_book.length;i++) {
			for(int j=1;j<phone_book[i].length();j++) {
				if(map.containsKey(phone_book[i].substring(0, j))) {
					answer=false;
					return answer;
				}
			}
		}
		
		return answer;
	}

}
