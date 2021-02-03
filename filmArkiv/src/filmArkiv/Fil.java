package filmArkiv;

import filmArkivADT.FILMarkivADT;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Fil {

	final static String SKILLE = "#";

	public static void lesFraFil(FILMarkivADT filmarkiv, String filnavn) {
		
		try {
		      File myObj = new File(filnavn);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("Kunne ikke lese fil");
		      e.printStackTrace();
		    }
	}

	public static void skrivTilFil(FILMarkivADT filmarkiv, String filnavn) {

		int antall = filmarkiv.antall();
		Film[] alleFilmer = new Film[antall];
		alleFilmer = filmarkiv.hentFilmTabell();

		try {
			FileWriter filewriter = new FileWriter(filnavn);
			filewriter.write(antall + "\n");
			for (int i = 0; i < alleFilmer.length; i++) {
				filewriter.write(alleFilmer[i].getFilmnr() + SKILLE + alleFilmer[i].getProdusent() + SKILLE
						+ alleFilmer[i].getTittel() + SKILLE + alleFilmer[i].getLansering() + SKILLE
						+ alleFilmer[i].getFilmselskap() + SKILLE + alleFilmer[i].getSjanger() + "\n");
			}
			filewriter.close();
			System.out.println("Filmarkiv lagret :)");
		} catch (IOException e) {
			System.out.println("Det skjedde en feil ved lagring av filmarkiv");
			e.printStackTrace();
		}
	}

}
