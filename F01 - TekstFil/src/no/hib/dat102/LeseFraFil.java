package no.hib.dat102;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeseFraFil {
    
    public static void main(String[] args) {
        
        final String SKILLE = "#";                // kan være parameter når vi lager metode
        //OBS! Du kan ikke bruke alle tegn i skillestrengen!
        // //http://stackoverflow.com/questions/3481828/how-to-split-a-string-in-java
        
        final String ANSATT_FIL = "ansatte.txt";  // parameter når vi lager metode
        
        FileReader ansFil = null;        
        BufferedReader innfil = null;
           
    try{
        // // 1 - FileReader
       ansFil = new FileReader(ANSATT_FIL);
    }
    
    catch(FileNotFoundException unntak){
        System.err.println("Finner ikke filen " + ANSATT_FIL);
        //http://stackoverflow.com/questions/3163399/difference-between-system-out-println-and-system-err-println
        // http://docs.oracle.com/javase/8/docs/api/java/util/logging/ConsoleHandler.html
        System.exit(1); // System-kall for å avslutte siden programmet er helt avhengig av data på fil
        //http://stackoverflow.com/questions/2434592/difference-in-system-exit0-system-exit-1-system-exit1-in-java
    }
        
        try {          
            // 2 - BufferedReader
            innfil = new BufferedReader(ansFil);
            
            // 3 - Leser den første linjen som er antall info-poster
            String linje = innfil.readLine();
            int n = Integer.parseInt(linje);
           
            // 4 - Les postene, en hel post om gangen
          
            for (int i = 0; i < n; i++) {
            	String post = innfil.readLine();
                String[] felt = post.split(SKILLE);
                // http://docs.oracle.com/javase/8/docs/api/java/lang/String.html#split(java.lang.String, int)
                String fornavn   = felt[0];
                String etternavn = felt[1];
              
                double timeloenn  = Double.parseDouble(felt[2]);
                boolean kjoenn    = Boolean.parseBoolean(felt[3]);
                
                Ansatt a = new Ansatt(fornavn, etternavn, timeloenn, kjoenn);
                System.out.println(a); // toString()-metoden i Ansatt blir kalt
                
            }
            
            // 4 - Lukk filen
            innfil.close();
            
        } catch (IOException e) {
            System.err.println("Feil ved lesing av fil: " + e);
            System.exit(1);
        }
    }
}