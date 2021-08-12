package 정수론및조합론;
import java.util.*;

public class No9375_패션왕신해빈 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=0;t<T;t++) {
			int n=sc.nextInt();
			HashMap<String, Integer> map=new HashMap<>();
			
			for(int i=0;i<n;i++	) {
				String name = sc.next();
				String kind = sc.next();
				
				if(map.containsKey(kind))
					map.put(kind, map.get(kind)+1);
				else
					map.put(kind, 1);
				
			}
			
			int answer=1;
			//+1하는 이유 : null까지 포함(해당 종류 옷 안입는 경우)
			for(int val:map.values())
				answer*=(val+1);
			
			System.out.println(answer-1); //모두 null 선택하는 경우 제외 
		}
	}

}
