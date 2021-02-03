package Klient;

import filmArkiv.Filmarkiv;
import filmArkivADT.FILMarkivADT;
import java.util.Scanner;

public class Meny {

	Tekstgrensesnitt tekstgr;
	FILMarkivADT filma;
	
	final static String MENY = "MENY\n" + "1: les inn en ny film\n" + "2: vis en film\n" + "3: Skriv ut statistikk\n"
			+ "4: Avslutt\n";

	public Meny() {
		tekstgr = new Tekstgrensesnitt();
	}

	public void start() {
		Scanner input = new Scanner(System.in);
		filma = new Filmarkiv(10);

		while (true) {
			System.out.println(MENY);

			Filmarkiv filmer = new Filmarkiv(10);

			String valg = input.nextLine();

			switch (valg) {
			case "1": {
				filma.leggTilFilm(tekstgr.lesFilm());
			}
				break;
			case "2": {
				System.out.println("Tittel: ");
				tekstgr.skrivUtFilmDelstrengITittel(filmer, input.nextLine());
			}
				break;
			case "3": {
				tekstgr.skrivUtStatistikk(filmer);
			}
			case "4": {
				input.close();
				System.exit(0);
			}
				break;
			default: {

			}
				System.out.println("Ugyldig kommando");
			}

		}
	}

}
