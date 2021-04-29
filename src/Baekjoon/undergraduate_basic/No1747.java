import java.util.Scanner;
//소수&팰린드롬

public class No1747 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		while(true) {
			if(isPrime(n)&&isPal(Integer.toString(n))) {
				System.out.println(n);
				break;
			}
			n++;
		}
	}
	
	public static boolean isPal(String s) {
		int start=0;
		int end=s.length()-1;
		
		while(start<=end) {
			if(s.charAt(start)!=s.charAt(end))
				return false;
			start++;
			end--;
		}
		
		return true;
		
	}
	
	public static boolean isPrime(int n) {
		if(n<2)return false;
		for(int i=2;i*i<=n;i++) {
			if(n%i==0) return false;
		}
		
		return true;
	}
}
