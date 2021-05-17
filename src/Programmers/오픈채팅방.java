package Level2;
import java.util.*;

public class 오픈채팅방 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s=solution(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
		for(String str:s) {
			System.out.println(str);
		}
	}
	
	public static String[] solution(String[]record) {
		String[]answer= {};
		ArrayList<String> result=new ArrayList<>();
		HashMap<String, String>user=new HashMap<>();
		
		for(String r:record) {
			String[] splits=r.split(" ");
			
			switch(splits[0]) {
			case "Enter":
				user.put(splits[1], splits[2]);
				result.add(splits[1]+"님이 들어왔습니다.");
				break;
			case "Leave":
				result.add(splits[1]+"님이 나갔습니다.");
				break;
			case "Change":
				user.put(splits[1], splits[2]);
				break;
			}
			
			
		}
		answer=new String[result.size()];
		for(int i=0;i<result.size();i++) {
			String str=result.get(i);
			int last=str.indexOf("님");
			String key=str.substring(0, last);
			
			answer[i]=str.replace(key, user.get(key));
		}
		return answer;
	}
}
