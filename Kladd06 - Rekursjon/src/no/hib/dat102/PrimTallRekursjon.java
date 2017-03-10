package no.hib.dat102;

public class PrimTallRekursjon {
	public static boolean primtall(long tall) {
		boolean funnet = true;
		if(tall <= 1) {
			funnet = false;
		} else {
			funnet = primtall(tall, tall-1);
		}
		return funnet;
	}
	
	private static boolean primtall(long tall, long itterator) {
		if(itterator <= 1) {
			return true;
		} else {
			if(tall % itterator == 0) {
				return false;
			} else {
				return primtall(tall, itterator - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(primtall(7927));
	}
}
