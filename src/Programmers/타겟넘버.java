package Level2;

public class 타겟넘버 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] {1,1,1,1,1}, 3));
	}
	
	public static int solution(int [] numbers, int target) {
		return dfs(numbers, target, 0,0);
	}
	
	public static int dfs(int[]numbers, int target, int index, int sum) {
		if(index==numbers.length)
			return sum==target?1:0;
		else
			return dfs(numbers, target, index+1, sum+numbers[index])+dfs(numbers, target, index+1, sum-numbers[index]);
	}
	
}
