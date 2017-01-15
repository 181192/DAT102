package no.hib.dat102;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class SkriveTilFil {
    
    public static void main(String[] args) {
        
        final String SKILLE = "#";               // kan v�re parameter n�r vi lager metode
        final String ANSATT_FIL = "ansatte.txt"; // parameter n�r vi lager metode
        
        Ansatt anne = new Ansatt("Anne", "Dahl", 220, Ansatt.KVINNE);
        Ansatt knut = new Ansatt("Knut", "Olsen", 180, Ansatt.MANN);
        int antall = 2; 
        
        try {
            // 1 - FileWriter
            FileWriter ansFil = new FileWriter(ANSATT_FIL, false);
            
            // 2 - PrintWriter
            PrintWriter utfil = new PrintWriter(ansFil);
            
            //3 - Skriver f�rst ut antall ansatt-info-er p� f�rste linje            
            utfil.println(antall);
            
            // Hvis vi tar mot en tabell av ansatte ville vi her lage en l�kke der
            // vi for hver ansatt plukker ut feltvariablevariable og skriver de ut p� samme linje
            
            // 3 - Skriv postene, felt for felt
            utfil.print(anne.getFornavn()); utfil.print(SKILLE);
            utfil.print(anne.getEtternavn()); utfil.print(SKILLE);
            utfil.print(anne.getTimeloenn()); utfil.print(SKILLE);
            utfil.print(anne.isKjoenn()); utfil.println();
            
            utfil.print(knut.getFornavn()); utfil.print(SKILLE);
            utfil.print(knut.getEtternavn()); utfil.print(SKILLE);
            utfil.print(knut.getTimeloenn()); utfil.print(SKILLE);
            utfil.print(knut.isKjoenn()); utfil.println();
            
            // 4 - Lukk filen
            utfil.close();
            
        } catch (IOException e) {
            System.err.println("Feil! : " + e);
            System.exit(1);
        }
    }
}