package no.hib.data102;

/**
 * Klasse for CD
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class CD {
	private int cdNr;
	private String artist;
	private String tittel;
	private int lanseringsaar;
	private Sjanger sjanger;
	private String plateselskap;

	/**
	 * Konstruktoer
	 * 
	 * @param cdNr
	 *            Nummer på CD
	 * @param artist
	 *            Artist
	 * @param tittel
	 *            Tittel
	 * @param lanseringsaar
	 *            Lanseringsaar
	 * @param sjanger
	 *            Sjanger
	 * @param plateselskap
	 *            Plateselskap
	 */
	public CD(int cdNr, String artist, String tittel, int lanseringsaar, Sjanger sjanger, String plateselskap) {
		this.cdNr = cdNr;
		this.artist = artist;
		this.tittel = tittel;
		this.lanseringsaar = lanseringsaar;
		this.sjanger = sjanger;
		this.plateselskap = plateselskap;
	}

	/**
	 * Tom konstruktoer
	 * 
	 */
	public CD() {
		this(0, "", "", 0, null, "");
	}

	/**
	 * Hent metode
	 *
	 * @return cdNr
	 */
	public int getCdNr() {
		return cdNr;
	}

	/**
	 * Sett metode
	 *
	 * @param cdNr
	 *            setter cdNr
	 */
	public void setCdNr(int cdNr) {
		this.cdNr = cdNr;
	}

	/**
	 * Hent metode
	 *
	 * @return artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * Sett metode
	 *
	 * @param artist
	 *            setter artist
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * Hent metode
	 *
	 * @return tittel
	 */
	public String getTittel() {
		return tittel;
	}

	/**
	 * Sett metode
	 *
	 * @param tittel
	 *            setter tittel
	 */
	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	/**
	 * Hent metode
	 *
	 * @return lanseringsaar
	 */
	public int getLanseringsaar() {
		return lanseringsaar;
	}

	/**
	 * Sett metode
	 *
	 * @param lanseringsaar
	 *            setter lanseringsaar
	 */
	public void setLanseringsaar(int lanseringsaar) {
		this.lanseringsaar = lanseringsaar;
	}

	/**
	 * Hent metode
	 *
	 * @return sjanger
	 */
	public Sjanger getSjanger() {
		return sjanger;
	}

	/**
	 * Sett metode
	 *
	 * @param sjanger
	 *            setter sjanger
	 */
	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	/**
	 * Hent metode
	 *
	 * @return plateselskap
	 */
	public String getPlateselskap() {
		return plateselskap;
	}

	/**
	 * Sett metode
	 *
	 * @param plateselskap
	 *            setter plateselskap
	 */
	public void setPlateselskap(String plateselskap) {
		this.plateselskap = plateselskap;
	}

	@Override
	public String toString() {
		return "CDnr=" + cdNr + ", artist=" + artist + ", tittel=" + tittel + ", lanseringsår=" + lanseringsaar
				+ ", sjanger=" + sjanger + ", plateselskap=" + plateselskap;
	}
} // class
