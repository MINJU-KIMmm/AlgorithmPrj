package Level2;

public class 멀쩡한사각형 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(8,12));
	}
	
	public static long solution(int w, int h) {
		long wl=Long.parseLong(String.valueOf(w));
		long hl=Long.parseLong(String.valueOf(h));
		
		return (wl*hl)-(wl+hl-gcd(wl, hl));
	}
	public static long gcd(long w, long h) {
		long small, big;
		big=Math.max(w, h);
		small=Math.min(w, h);
		
		while(small!=0) {
			long r=big%small;
			big=small;
			small=r;
		}
		
		return big;
	}
}
