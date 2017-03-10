package no.hib.dat102;

public class CommonDivisor {
	public static void main(String[] args) {
		System.out.println(GreatestCommonDivisor(20, 4));
		System.out.println(LeastCommonMultiple(3, 4));	
	}
	
	public static int GreatestCommonDivisor(int foerste, int andre) {
		if (andre == 0) {
			return foerste;
		}
		return GreatestCommonDivisor(andre, foerste%andre);
	}
	
	public static int LeastCommonMultiple(int foerste, int andre) {
		return Math.abs((foerste * andre)) / GreatestCommonDivisor(foerste, andre);
	}
}
