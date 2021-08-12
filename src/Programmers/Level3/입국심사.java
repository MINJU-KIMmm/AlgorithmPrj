package Level3;
import java.util.*;

public class �Ա��ɻ� {

public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(6, new int[] {7,10}));
		}

//key(���� ��)=���(n), mid(Ž���Ұ�)=�ɻ�޴� �� �ɸ��� �ð�
public static long solution(int n, int[] times) {
		long answer = 0;
		Arrays.sort(times);

		long left, right, mid, key;
		left=0; //�ð��� ���� ���� �ɸ� ���
		right=(long)times[times.length-1]*n; //�ð��� ���� ���� �ɸ� ���

		answer=right;

		while(left<=right) {
		mid=(left+right)/2;
		key=0;

		for(int i=0;i<times.length;i++) {
		key+=mid/times[i]; //mid���� �˻��� �� �ִ� �ɻ� ���� �� �ִ� ��� ��
		}

		//n�� �˻� �� ���� ��� = �ð��� ���� ��� -> �� ���� �˻��� �� ����
		if(key>=n) {
		if(mid<answer) answer=mid;
		right=mid-1;
		}
		//n�� �˻� �� ���� ������ ��� = �ð��� ���� ���� ���(�ð� ����) -> �ð� �� �߰�
		else left=mid+1;
		}

		return answer;
		}

//�̺�Ž��
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

		return -1; //key ��ã�� ���
		}
		}
