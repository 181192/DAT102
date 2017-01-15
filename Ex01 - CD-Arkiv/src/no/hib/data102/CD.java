package no.hib.data102;

public class CD {
	private int CDnr;
	private String artist;
	private String tittel;
	private int lanserings�r;
	private Sjanger sjanger;
	private String plateselskap;

	public CD(int cDnr, String artist, String tittel, int lanserings�r, Sjanger sjanger, String plateselskap) {
		CDnr = cDnr;
		this.artist = artist;
		this.tittel = tittel;
		this.lanserings�r = lanserings�r;
		this.sjanger = sjanger;
		this.plateselskap = plateselskap;
	}

	public CD() {
		this(0, "", "", 0, null, "");
	}

	public int getCDnr() {
		return CDnr;
	}

	public void setCDnr(int cDnr) {
		CDnr = cDnr;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public int getLanserings�r() {
		return lanserings�r;
	}

	public void setLanserings�r(int lanserings�r) {
		this.lanserings�r = lanserings�r;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public String getPlateselskap() {
		return plateselskap;
	}

	public void setPlateselskap(String plateselskap) {
		this.plateselskap = plateselskap;
	}

	@Override
	public String toString() {
		return "CDnr=" + CDnr + ", artist=" + artist + ", tittel=" + tittel + ", lanserings�r=" + lanserings�r
				+ ", sjanger=" + sjanger + ", plateselskap=" + plateselskap;
	}
} // class
