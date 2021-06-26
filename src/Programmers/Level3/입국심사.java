package Level3;
import java.util.*;

public class 입국심사 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(6, new int[] {7,10}));
	}
	
	//key(비교할 값)=사람(n), mid(탐색할것)=심사받는 데 걸리는 시간
	public static long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long left, right, mid, key;
        left=0; //시간이 제일 조금 걸릴 경우
        right=(long)times[times.length-1]*n; //시간이 제일 많이 걸릴 경우
        
        answer=right;
        
        while(left<=right) {
        	mid=(left+right)/2;
        	key=0;
        	
        	for(int i=0;i<times.length;i++) {
        		key+=mid/times[i]; //mid동안 검사할 수 있는 심사 받을 수 있는 사람 수
        	}
        	
        	//n명 검사 다 했을 경우 = 시간이 남을 경우 -> 더 많이 검사할 수 있음
        	if(key>=n) {
        		if(mid<answer) answer=mid;
        		right=mid-1;
        	}
        	//n명 검사 다 하지 못했을 경우 = 시간이 남지 않을 경우(시간 부족) -> 시간 더 추가
        	else left=mid+1;
        }
        
        return answer;
    }
	
	//이분탐색
	static int BinarySearch(int arr[], int key) {
		int left=0;
		int right=arr.length-1;
		int	mid;
		
		while(left<=right) {
			mid=(left+right)/2;
			if(arr[mid]==key) return mid;
			else if(arr[mid]>key) left=mid-1;
			else right=mid+1;
		}
		
		return -1; //key 못찾은 경우
	}
}
