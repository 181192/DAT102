package no.hib.dat102;

public class Ansatt {
	
	// Konstanter
	  final static boolean MANN   = false;
	  final static boolean KVINNE = true;

	  // Feltvariable
	  private String  fornavn;
	  private String  etternavn;
	  private double  timeloenn;
	  private boolean kjoenn;

	  // Konstruktører
	  Ansatt() {
		  this("","",0.0,false);
	  }

	  Ansatt(String fornavn, String etternavn, double timeloenn, boolean kjoenn) {
	    this.fornavn = fornavn;
	    this.etternavn = etternavn;
	    this.timeloenn = timeloenn;
	    this.kjoenn = kjoenn;
	  }
	  
	  // get- og setmetoder
	  public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public double getTimeloenn() {
		return timeloenn;
	}

	public void setTimelønn(double timeloenn) {
		this.timeloenn = timeloenn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public boolean isKjoenn() {
		return kjoenn;
	}

	public void setKjønn(boolean kjoenn) {
		this.kjoenn = kjoenn;
	}

	public static boolean isMann() {
		return MANN;
	}

	public static boolean isKvinne() {
		return KVINNE;
	}

	public String toString(){
		String streng = fornavn + " " + etternavn + " " + timeloenn + " " + kjoenn;
	return streng;
	}

	  //.. .

}

