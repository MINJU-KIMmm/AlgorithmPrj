package 그리디알고리즘;

import java.util.Scanner;
public class No1541_잃어버린괄호 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int sum=Integer.MAX_VALUE;
		String [] splitArr=sc.next().split("-");
		
		for(int i=0;i<splitArr.length;i++) {
			int temp=0;
			// \\+ 인 이유 : +가 메타문자이기때문에 이스케이프처리를 해야하는데
			// 백슬래시도 단독으로 출력할 수 없기 때문에 \\+
			String[] add=splitArr[i].split("\\+");
			
			for(int j=0;j<add.length;j++)
				temp+=Integer.parseInt(add[j]);
			
			//가장 처음 수인 경우 항상 양수이기 때문에 sum이 초기값이라면 temp값 그대
			if(sum==Integer.MAX_VALUE)
				sum=temp;
			else
				sum-=temp;
		}
		
		System.out.println(sum);
	}

}
