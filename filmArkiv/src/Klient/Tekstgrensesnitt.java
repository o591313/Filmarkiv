package Klient;

import java.util.Scanner;

import filmArkiv.Film;

import filmArkiv.Sjanger;
import filmArkivADT.FILMarkivADT;

public class Tekstgrensesnitt {

	Scanner input = new Scanner(System.in);

	public Film lesFilm() {

		Film nyFilm = new Film();

		// Leser inn filmnummer
		System.out.println("Filmnummer:");

		String tekst1 = input.nextLine();

		int filmnummer = Integer.valueOf(tekst1);

		nyFilm.setFilmnr(filmnummer);

		// Leser inn produsent
		System.out.println("Produsent:");

		String tekst2 = input.nextLine();

		nyFilm.setProdusent(tekst2);

		// Leser inn tittel
		System.out.println("Tittel:");

		String tekst3 = input.nextLine();

		nyFilm.setTittel(tekst3);

		// Leser inn Lansering
		System.out.println("Lanseringsår:");

		String tekst4 = input.nextLine();

		int lansering = Integer.valueOf(tekst4);

		nyFilm.setLansering(lansering);

		// Leser inn filmselskap
		System.out.println("Filmselskap:");

		String tekst5 = input.nextLine();

		nyFilm.setFilmselskap(tekst5);

		// Leser inn sjanger
		System.out.println("Sjanger:");

		Sjanger sjanger = Sjanger.valueOf(input.nextLine().toUpperCase());

		nyFilm.setSjanger(sjanger);

		

		return nyFilm;
	}

	public void visFilm(Film film) {

		System.out.println("Ingen filmer matcher søket");

		System.out.println(film.getFilmnr() + "#" + film.getProdusent() + "#" + film.getTittel() + "#"
				+ film.getLansering() + "#" + film.getFilmselskap() + "#" + film.getSjanger());

	}

	public void skrivUtFilmDelstrengITittel(FILMarkivADT filma, String delstreng) {

		Film[] resultat = new Film[filma.antall()];

		resultat = filma.soekTittel(delstreng);

		for (int i = 0; i < resultat.length; i++) {
			visFilm(resultat[i]);
		}

	}

	public void skrivUtFilmProdusent(FILMarkivADT filma, String delstreng) {
		Film[] resultat = new Film[filma.antall()];

		resultat = filma.soekProdusent(delstreng);

		for (int i = 0; i < resultat.length; i++) {
			visFilm(resultat[i]);
		}
	}

	public void skrivUtStatistikk(FILMarkivADT filma) {
		System.out
				.println("Antall Filmer i Arkivet: " + filma.antall() + "\n Komedier: " + filma.antall(Sjanger.KOMEDIE)
						+ "\n Actionfilmer: " + filma.antall(Sjanger.ACTION) + "\n Fantasyfilmer: "
						+ filma.antall(Sjanger.FANTASY) + "\n Dramafilmer: " + filma.antall(Sjanger.DRAMA) + "\n");
	}

}
