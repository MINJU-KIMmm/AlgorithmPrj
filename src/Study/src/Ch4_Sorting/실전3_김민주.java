package Ch4_Sorting;

import java.util.*;
import java.io.*;
public class 실전3_김민주 {
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		
		String[][] arr=new String[N][2];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			arr[i][0]=st.nextToken();
			arr[i][1]=st.nextToken();
		}
	
		Arrays.sort(arr, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				int obj1=Integer.parseInt(o1[1]);
				int obj2=Integer.parseInt(o2[1]);
				return obj1-obj2;
			}
		});
		
		for(int i=0;i<N;i++) {
			System.out.print(arr[i][0]+" ");
		}
		
		HashMap<String, Integer> map=new HashMap<>();
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
		}
		
		List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());

		
		Collections.sort(entryList, (o1, o2)-> o1.getValue().compareTo(o2.getValue()));
		
		for(int i=0;i<N;i++) {
			System.out.print(entryList.get(i).getKey()+" ");
		}
	}

}
