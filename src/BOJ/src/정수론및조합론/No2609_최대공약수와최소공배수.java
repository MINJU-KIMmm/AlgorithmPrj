package 정수론및조합론;
import java.util.Scanner;
public class No2609_최대공약수와최소공배수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		
		int gcd=gcd(a,b);
		System.out.println(gcd);
		System.out.println(a*b/gcd);
	}
	
	public static int gcd(int a, int b) {
		if(b==0)return a;
		else return gcd(b, a%b);
	}
	
	
}
