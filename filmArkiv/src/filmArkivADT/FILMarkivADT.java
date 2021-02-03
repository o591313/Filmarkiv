package filmArkivADT;

import filmArkiv.Film;
import filmArkiv.Sjanger;

public interface FILMarkivADT {

	// Returnere en tabell av Filmer
	Film[] hentFilmTabell();

	// Legger til en ny Film
	void leggTilFilm(Film nyFilm);

	// Sletter en Film hvis den fins
	boolean slettFilm(int filmnr);

	// Søker og henter Filmer med en gitt delstreng Film[] soekTittel(String
	// delstreng);
	Film[] soekTittel(String delstreng);

	// Søker og henter produsenter med en gitt delstreng Film[] soekProdusent(String
	// delstreng);
	Film[] soekProdusent(String delstreng);

	// Henter antall Filmer for en gitt sjanger int antall (Sjanger sjanger);
	int antall(Sjanger sjanger);

	// Returnerer antall Filmer
	int antall();
}// interface
