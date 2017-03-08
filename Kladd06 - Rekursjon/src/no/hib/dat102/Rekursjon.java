package no.hib.dat102;

public class Rekursjon {
	public static void main(String[] args) {
		System.out.println(paalindrom("aacbbaa"));
	}

	public static boolean palindrom(String ord) {
		int n = 0;
		int m = ord.length() - 1;
		return palindromRek(ord, n, m);
	}

	private static boolean palindromRek(String ord, int n, int m) {
		System.out.println(ord.charAt(n) + " " + ord.charAt(m));
		if (n > m) {
			return false;
		} else {
			if (ord.charAt(n) == ord.charAt(m)) {
				return palindromRek(ord, (n + 1), (m - 1));
			} else {
				return true;
			}
		}
	}

	public static boolean paalindrom(String ord) {
		int lengde = ord.length();
		if (lengde < 2) {
			return true;
		}
		if (ord.charAt(0) == ord.charAt(lengde - 1)) {
			return paalindrom(ord.substring(1, lengde - 1));
		}
		return false;
	}
}
