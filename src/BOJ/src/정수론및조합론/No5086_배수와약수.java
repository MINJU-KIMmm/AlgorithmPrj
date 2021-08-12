package 정수론및조합론;
import java.util.Scanner;
public class No5086_배수와약수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     Scanner sc=new Scanner(System.in);
	     int a=sc.nextInt();
	     int b=sc.nextInt();
	     
	     while(true) {
	    	 if(a==0&&b==0)
	    		 break;
	    	 
	    	 if(b%a==0)
	    		 System.out.println("factor");
	    	 else if(a%b==0)
	    		 System.out.println("multiple");
	    	 else
	    		 System.out.println("neither");
	    	 
	    	 a=sc.nextInt();
	    	 b=sc.nextInt();
	     }
	     
	}

}
