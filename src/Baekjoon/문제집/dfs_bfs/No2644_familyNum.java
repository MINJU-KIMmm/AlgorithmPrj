import java.util.*;
//���� 2644 �̼����
public class No2644_familyNum {
	static int[][] arr;
	static int n, m, start, end;
	static boolean []visited;
	static int[] nums;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();//��ü ��� ��
		start=sc.nextInt();//�̼� ��� ���1
		end=sc.nextInt();//�̼� ��� ���2
		m=sc.nextInt(); //�θ�-�ڽ� ���� ����
		
		arr=new int[n][n];
		nums=new int[n];
		visited=new boolean[n];
		
		for(int i=0;i<m;i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			
			arr[x-1][y-1]=1;
			arr[y-1][x-1]=1;
		}
		
		bfs(start-1, end-1);
		
		if(nums[end-1]==0) System.out.println(-1);
		else System.out.println(nums[end-1]);
	}
	
	static void bfs(int start, int end) {
		Queue<Integer> q=new LinkedList<>();
		q.add(start);
		visited[start]=true;
		
		while(!q.isEmpty()) {
			int tmp=q.poll();
			
			if(tmp==end) break;
			
			for(int i=0;i<n;i++) {
				if(arr[tmp][i]==1&&!visited[i]) {
					q.add(i);
					visited[i]=true;
					nums[i]=nums[tmp]+1; //nums[i]++ �ƴ�!!
					//tmp= �θ�
				}
			}
		}
	}
}
