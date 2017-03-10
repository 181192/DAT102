package no.hib.dat102;

public class SummenAvN {
	public static void main(String[] args) {
		int n = 100;
		System.out.println("Summen av " + n + " er : " + sum(n));
	}
	
	public static int sum(int n) {
		if (n > 1) {
			return n + sum(n -1);
		} else {
			return 1;
		}
	}
}
